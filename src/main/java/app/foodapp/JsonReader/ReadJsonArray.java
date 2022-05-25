package app.foodapp.JsonReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@SuppressWarnings("All") // ©Enlever ce code quand vous modifier le projet !
public class ReadJsonArray {
    JSONObject adress;
    JSONArray jsonArray;
    String path;

    @SuppressWarnings("All")
    public ReadJsonArray(String path) throws IOException, ParseException {
        this.path = path;
        JSONParser parser = new JSONParser();
        Reader fileReader = new FileReader(path);
        JSONArray jsonArray = (JSONArray) parser.parse(fileReader);
        this.jsonArray = jsonArray;
    }

    @SuppressWarnings("All")
    public Object ReadJsonListObject(String parameter) {
        int i = 0;
        while (i <= jsonArray.size() - 1) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            System.out.println(jsonObject.get(parameter));
            i = i + 1;
        }
        return null;
    }
    @SuppressWarnings("All")
    public String getListMissedIngredient(String parameter, int j) {
        String Ingredients = "";
        JSONObject Object = (JSONObject) jsonArray.get(j);
        JSONArray jsonArray = (JSONArray) Object.get("missedIngredients");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject Object2 = (JSONObject) jsonArray.get(i);
            Ingredients = (String) Ingredients + '\n' + Object2.get(parameter);
        }
        return Ingredients;
    }

    @SuppressWarnings("All")
    public Object ReadJsonObject1(String parameter) {
        this.adress = (JSONObject) jsonArray.get(0);
        return adress.get(parameter);
    }

    @SuppressWarnings("All")
    public Object ReadJsonObject2(String parameter) {
        this.adress = (JSONObject) jsonArray.get(1);
        return adress.get(parameter);
    }

    @SuppressWarnings("All")
    public Object ReadJsonObject3(String parameter) {
        this.adress = (JSONObject) jsonArray.get(2);
        return adress.get(parameter);
    }

    @SuppressWarnings("All")
    public Object ReadJsonObject4(String parameter) {
        this.adress = (JSONObject) jsonArray.get(3);
        return adress.get(parameter);
    }

    @SuppressWarnings("All")
    public Object ReadJsonObject5(String parameter) {
        this.adress = (JSONObject) jsonArray.get(4);
        return adress.get(parameter);
    }

    @SuppressWarnings("All")
    public Object ReadJsonObject6(String parameter) {
        this.adress = (JSONObject) jsonArray.get(5);
        return adress.get(parameter);
    }

    @SuppressWarnings("All")
    public Object ReadJsonObject7(String parameter) {
        this.adress = (JSONObject) jsonArray.get(6);
        return adress.get(parameter);
    }

    @SuppressWarnings("All")
    public Object ReadJsonObject8(String parameter) {
        this.adress = (JSONObject) jsonArray.get(7);
        return adress.get(parameter);
    }
}