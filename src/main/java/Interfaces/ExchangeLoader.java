package Interfaces;

import model.ExchangeRate;

import java.util.Map;

public interface ExchangeLoader {
     Map<String,Double> updateCurrencyMap();

     ExchangeRate load(String from, String to);
}
