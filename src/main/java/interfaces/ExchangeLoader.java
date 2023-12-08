package interfaces;

import model.ExchangeRate;

import java.util.List;
import java.util.Map;

public interface ExchangeLoader {
     Map<String,Double> updateCurrencyMap(String date);

     ExchangeRate load(String from, String to);

     List<String> getCurrencyList();
}
