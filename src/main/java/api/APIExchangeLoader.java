package api;

import interfaces.ExchangeLoader;
import interfaces.ReferenceRateLoader;
import interfaces.SymbolLoader;
import models.Currency;
import models.ExchangeRate;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class APIExchangeLoader implements ExchangeLoader {

    private final ReferenceRateLoader referenceValuesLoader;
    private final Map<String, String> symbols;

    public APIExchangeLoader(ReferenceRateLoader referenceRateLoader, SymbolLoader symbols) {
        this.referenceValuesLoader = referenceRateLoader;
        this.symbols =  symbols.load();
    }

    @Override
    public ExchangeRate load(String from, String to, String date) {
        return new ExchangeRate(
                symbolToCurrency(from, date),
                symbolToCurrency(to, date),
                date
        );
    }

    @Override
    public void log(ExchangeRate exchangeRate) {
        try {
              writeFile(exchangeRate,false);
        } catch (IOException e) {
            try {
                writeFile(exchangeRate, true);
            } catch (IOException ignored) {
            }
        }
    }

    private void writeFile(ExchangeRate exchangeRate, boolean bool) throws IOException {
        FileWriter fileWriter = new FileWriter("src/main/ExchangeRates.log",bool);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(exchangeRate.toString());
    }

    private Currency symbolToCurrency(String symbol, String date){
        Map<String, Double> values = referenceValuesLoader.load(date);

        return new Currency(symbol, symbols.get(symbol), values.get(symbol));
    }
}
