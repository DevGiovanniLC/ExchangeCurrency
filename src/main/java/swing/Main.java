package swing;

import Commands.Controller;
import api.*;
import interfaces.*;

public class Main {

    public static void main(String[] args) {
        String key = "a2bd8db987c966afbcd788690c55b0b8";
        SymbolLoader symbolLoader = new APISymbolLoader(key);
        CommandWindow mainWindow = new MainWindow(symbolLoader.loadCurrencyNames());
        ReferenceRateLoader referenceRateLoader = new APIReferenceRateLoader(key);
        CurrencyLoader currencyLoader = new APICurrencyLoader(referenceRateLoader,symbolLoader);
        ExchangeLoader exchangeLoader = new APIExchangeLoader(referenceRateLoader,symbolLoader);
        Controller controller = new Controller(mainWindow, exchangeLoader);
        mainWindow.setController(controller);
    }
}
