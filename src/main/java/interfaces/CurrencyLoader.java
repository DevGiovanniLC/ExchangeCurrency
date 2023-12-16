package interfaces;

import models.Currency;
import models.ExchangeRate;

import java.util.List;

public interface CurrencyLoader {
    List<Currency> loadCurrencies();

    List<Currency> loadCurrencies(String date);


}
