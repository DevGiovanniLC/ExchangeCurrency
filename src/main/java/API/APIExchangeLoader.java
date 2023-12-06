package API;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import Interfaces.ExchangeLoader;
import model.Currency;
import model.ExchangeRate;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;



public class APIExchangeLoader implements ExchangeLoader {
    private Map<String,Double> currencyMap;

    public APIExchangeLoader(){
        updateCurrencyMap();
    }

    public Map<String,Double> updateCurrencyMap() {
        this.currencyMap = loadCurrencyMap();
        return this.currencyMap;
    }


    private Map<String,Double> loadCurrencyMap() {
        try {
            String json = loadJson();
            return toCurrencyMap(json);
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    private String loadJson() throws IOException {
        URL url = new URL("http://api.exchangeratesapi.io/v1/2013-12-24?access_key=51c96297a100c0fe9be7e64d682e577a&base=EUR");
        try (InputStream is = url.openStream()) {
            return new String(is.readAllBytes());
        }
    }

    private Map<String,Double> toCurrencyMap(String json) {
        HashMap<String, Double> result = new HashMap<>();
        Map<String, JsonElement> rates = new Gson().fromJson(json, JsonObject.class).get("rates").getAsJsonObject().asMap();
        for (String rate : rates.keySet())
            result.put(rate,  rates.get(rate).getAsDouble());
        return result;
    }

    @Override
    public ExchangeRate load(String from, String to) {
        return new ExchangeRate(
           new Currency(from,currencyMap.get(from)),
           new Currency(to, currencyMap.get(to))
        );
    }
}
