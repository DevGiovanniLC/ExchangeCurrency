package interfaces;

import model.ExchangeRate;

import java.util.Map;

public interface ExchangeLoader
{
     Map<String,Double> updateExchangeMap(String date);

     ExchangeRate load(String from, String to);
}
