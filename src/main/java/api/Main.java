package api;

import interfaces.CurrencyLoader;
import interfaces.ExchangeLoader;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ExchangeLoader exchangeLoader = new APIExchangeLoader();
        APICurrencyLoader currencyLoader = new APICurrencyLoader();
        System.out.println(currencyLoader.load());
        System.out.println(exchangeLoader.updateExchangeMap("latest"));
    }
}
