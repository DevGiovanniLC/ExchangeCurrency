import Commands.Controller;
import api.*;
import interfaces.*;
import swing.MainWindow;

public class Main {

    public static void main(String[] args) {
        String key = "a2bd8db987c966afbcd788690c55b0b8";
        SymbolLoader symbolLoader = new APISymbolLoader(key);
        ReferenceRateLoader referenceRateLoader = new APIReferenceRateLoader(key);
        CommandWindow mainWindow = new MainWindow(symbolLoader.loadCurrencyNames());
        ExchangeLoader exchangeLoader = new APIExchangeLoader(referenceRateLoader,symbolLoader);
        Controller controller = new Controller(mainWindow, exchangeLoader);
        mainWindow.setController(controller);
    }
}
