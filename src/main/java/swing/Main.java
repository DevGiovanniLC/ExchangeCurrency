package swing;

import api.APIExchangeLoader;
import interfaces.ExchangeLoader;

public class Main {
    public static void main(String[] args) {
        ExchangeLoader exchangeLoader = new APIExchangeLoader();
        MainWindow mainWindow = new MainWindow(exchangeLoader.getCurrencyList());
        mainWindow.setVisible(true);
    }
}
