package api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import interfaces.CurrencyLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class APICurrencyLoader implements CurrencyLoader {

    private final Map<String,String> CurrencyMap;

    public APICurrencyLoader(){
        this.CurrencyMap = load();
    }

    @Override
    public Map<String,String> load() {
        try {
            String json = loadJson();
            return toCurrencyMap(json);
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    @Override
    public List<String> getCurrencyList() {
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, String> entry : this.CurrencyMap.entrySet()) {
            String string = entry.getKey() + ", " + entry.getValue();
            result.add(string);
        }

        Collections.sort(result);

        return result;
    }

    private String loadJson() throws IOException {
        URL url = new URL("http://api.exchangeratesapi.io/v1/symbols?access_key=51c96297a100c0fe9be7e64d682e577a");
        try (InputStream is = url.openStream()) {
            return new String(is.readAllBytes());
        }
    }

    private Map<String,String> toCurrencyMap(String json) {
        HashMap<String, String> result = new HashMap<>();
        Map<String, JsonElement> rates = new Gson().fromJson(json, JsonObject.class).get("symbols").getAsJsonObject().asMap();
        for (String rate : rates.keySet())
            result.put(rate,  rates.get(rate).getAsString());
        return result;
    }

}
