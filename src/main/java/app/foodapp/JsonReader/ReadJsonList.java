package app.foodapp.JsonReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@SuppressWarnings("All") // ©Enlever ce code quand vous modifier le projet !
public class ReadJsonList {
    String path;
    JSONObject jsonObject;

    @SuppressWarnings("All")
    public ReadJsonList(String path) throws IOException, ParseException {
        this.path = path;
        JSONParser parser = new JSONParser();
        Reader fileReader = new FileReader(path);
        JSONArray obj = (JSONArray) parser.parse(fileReader);
    }

}