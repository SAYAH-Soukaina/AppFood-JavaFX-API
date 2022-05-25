package app.foodapp.JsonReader;

import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

@SuppressWarnings("All") // ©Enlever ce code quand vous modifier le projet !
public class ReadApi {
    public static void readJSON(String ingredient) throws IOException, ParseException {
        URL url = new URL("https://api.spoonacular.com/recipes/findByIngredients?ingredients=" + ingredient.toUpperCase() + "&apiKey=c896f7166e684175b22da49f453d4739");
        URLConnection connection = url.openConnection();
        InputStream stream = connection.getInputStream();
        BufferedReader scanner = new BufferedReader(new InputStreamReader(stream));
        StringBuilder sb = new StringBuilder();
        String line = scanner.readLine();
        while (line != null) {
            sb.append(line);
            line = scanner.readLine();
        }
        BufferedWriter b = new BufferedWriter(new FileWriter("src/main/java/app/foodapp/JsonReader/stockRecette/" + ingredient.toUpperCase() + ".json"));
        b.append(sb.toString());
        b.close();
    }
}