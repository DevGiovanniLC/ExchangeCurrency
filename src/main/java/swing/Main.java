package swing;

import api.APICurrencyLoader;
import api.APIExchangeLoader;
import interfaces.ExchangeLoader;

public class Main {
    public static void main(String[] args) {
        APICurrencyLoader currencyLoader = new APICurrencyLoader();
        ExchangeLoader exchangeLoader = new APIExchangeLoader();
        MainWindow mainWindow = new MainWindow(currencyLoader.getCurrencyList());
        mainWindow.setVisible(true);
    }
}
