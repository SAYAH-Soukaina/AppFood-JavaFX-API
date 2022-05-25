package app.foodapp.JsonReader;

import griffon.core.formatters.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.URLConnection;
@SuppressWarnings("All")
public class ReadJsonObject {
    String path;
    JSONObject jsonObject;

    @SuppressWarnings("All")
    public ReadJsonObject(URLConnection path) throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONParser parser = new JSONParser();
        Reader fileReader = new BufferedReader(new InputStreamReader(path.getInputStream()));
        Object obj = parser.parse(fileReader);
    }
    @SuppressWarnings("All")
    public Object ReadJsonObj(String parameter) {
        return jsonObject.get(parameter);
    }
}
