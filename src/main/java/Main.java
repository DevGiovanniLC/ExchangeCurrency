import controller.Controller;
import view.ExchangeLoader;
import view.ReferenceRateLoader;
import view.SymbolLoader;
import view.api.*;
import view.swing.MainWindow;

public class Main {

    public static void main(String[] args) {
        String key = "57e4db41ff0c56098b9af86b6d8bb354";
        SymbolLoader symbolLoader = new APISymbolLoader(key);
        ReferenceRateLoader referenceRateLoader = new APIReferenceRateLoader(key);
        MainWindow mainWindow = new MainWindow(symbolLoader.loadCurrencyNames());
        ExchangeLoader exchangeLoader = new APIExchangeLoader(referenceRateLoader,symbolLoader);
        Controller controller = new Controller(mainWindow, exchangeLoader);
        mainWindow.setExchangeCommand(controller);
    }
}
