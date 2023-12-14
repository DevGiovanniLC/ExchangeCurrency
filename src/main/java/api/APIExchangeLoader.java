package api;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

import interfaces.ExchangeLoader;
import model.Currency;
import model.ExchangeRate;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;



public class APIExchangeLoader implements ExchangeLoader {
    private Map<String,Double> ExchangeMap;

    public APIExchangeLoader(){
        updateExchangeMap("latest");
    }

    @Override
    public Map<String,Double> updateExchangeMap(String date) {
        this.ExchangeMap = loadExchangeMap(date);
        return this.ExchangeMap;
    }

    @Override
    public ExchangeRate load(String from, String to) {
        return new ExchangeRate(
           new Currency(from, ExchangeMap.get(from)),
           new Currency(to, ExchangeMap.get(to))
        );
    }

    private Map<String,Double> loadExchangeMap(String date) {
        try {
            String json = loadJson(date
            );
            return toExchangeMap(json);
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    private String loadJson(String date) throws IOException {
        URL url = new URL(String.format("http://api.exchangeratesapi.io/v1/%s?access_key=51c96297a100c0fe9be7e64d682e577a&base=EUR",date));
        try (InputStream is = url.openStream()) {
            return new String(is.readAllBytes());
        }
    }

    private Map<String,Double> toExchangeMap(String json) {
        HashMap<String, Double> result = new HashMap<>();
        Map<String, JsonElement> rates = new Gson().fromJson(json, JsonObject.class).get("rates").getAsJsonObject().asMap();
        for (String rate : rates.keySet())
            result.put(rate,  rates.get(rate).getAsDouble());
        return result;
    }

}
