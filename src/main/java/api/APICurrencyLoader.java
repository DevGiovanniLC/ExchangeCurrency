package api;

import interfaces.CurrencyLoader;
import interfaces.ReferenceRateLoader;
import interfaces.SymbolLoader;
import models.Currency;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class APICurrencyLoader implements CurrencyLoader {

    private final ReferenceRateLoader referenceValuesLoader;
    public Map<String, String> symbols;

    public APICurrencyLoader(ReferenceRateLoader referenceValuesLoader, SymbolLoader symbols) {
        this.referenceValuesLoader = referenceValuesLoader;
        this.symbols = symbols.load();
    }

    @Override
    public List<Currency> loadCurrencies() {
        return loadCurrencies("latest");
    }

    @Override
    public List<Currency> loadCurrencies(String date) {
        Map<String, Double> values = referenceValuesLoader.load(date);

        return symbols
                .keySet()
                .stream()
                .sorted()
                .map((String symbol) -> symbolToCurrency(symbol,date))
                .collect(Collectors.toList()
                );
    }


    private Currency symbolToCurrency(String symbol,String date){
        Map<String, Double> values = referenceValuesLoader.load(date);

        return new Currency(symbol, symbols.get(symbol), values.get(symbol));
    }
}
