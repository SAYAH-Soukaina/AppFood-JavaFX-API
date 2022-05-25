package app.foodapp.controller;

import app.foodapp.JsonReader.ReadApi;
import app.foodapp.JsonReader.ReadJsonArray;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

@SuppressWarnings("All")
public class FoodAppController implements Initializable {
    @FXML
    public ChoiceBox listeOfFavorite;
    @FXML
    public Button Findfavorite;
    @FXML
    public Button addFavoris;
    @FXML
    public Button UpdateFavoris;
    @FXML
    public Button deleteFavoris;

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    @FXML
    private Button switchToScene1;
    @FXML
    private Button switchToScene2;
    @FXML
    private TextField RechercheIngredients;
    @FXML
    public Label AffichageIngredients1;
    @FXML
    public Label AffichageIngredients2;
    @FXML
    public Label AffichageIngredients3;
    @FXML
    public Label AffichageIngredients4;
    @FXML
    public Label AffichageIngredients5;
    @FXML
    public Label AffichageIngredients6;
    @FXML
    public Label AffichageIngredients7;
    @FXML
    public Label AffichageIngredients8;

    @FXML
    public Button ChercherIngredients;

    @FXML
    public ImageView AffichageImageIngredients1;
    @FXML
    public ImageView AffichageImageIngredients2;
    @FXML
    public ImageView AffichageImageIngredients3;
    @FXML
    public ImageView AffichageImageIngredients4;
    @FXML
    public ImageView AffichageImageIngredients5;
    @FXML
    public ImageView AffichageImageIngredients6;
    @FXML
    public ImageView AffichageImageIngredients7;
    @FXML
    public ImageView AffichageImageIngredients8;

    @FXML
    public AnchorPane Recette1;
    @FXML
    public AnchorPane Recette2;
    @FXML
    public AnchorPane Recette3;
    @FXML
    public AnchorPane Recette4;
    @FXML
    public AnchorPane Recette5;
    @FXML
    public AnchorPane Recette6;
    @FXML
    public AnchorPane Recette7;
    @FXML
    public AnchorPane Recette8;

    @FXML
    public Label Ingredients1;
    @FXML
    public Label Ingredients2;
    @FXML
    public Label Ingredients3;
    @FXML
    public Label Ingredients4;
    @FXML
    public Label Ingredients5;
    @FXML
    public Label Ingredients6;
    @FXML
    public Label Ingredients7;
    @FXML
    public Label Ingredients8;



    @FXML
    public Label MessageERREUR;


    File fileContainsAllFavorites = new File("src/main/java/app/foodapp/controller/Favoris/favoris.txt");
    File file2UpdatesAllFavorites = File.createTempFile("favoris2", ".txt");
    FileWriter writer2 = new FileWriter(file2UpdatesAllFavorites, true);
    Scanner scanner = new Scanner(fileContainsAllFavorites);

    public FoodAppController() throws IOException {
    }

    public void initialize(URL location, ResourceBundle resourceBundle) {

    }

    @SuppressWarnings("All")
    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("app/foodapp/view/Scene1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @SuppressWarnings("All")
    @FXML
    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("app/foodapp/view/Scene2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SetGraphiqueRecette(MouseEvent mouseEvent){

    }
    @SuppressWarnings("All")
    public void SetGraphicContent(MouseEvent mouseEvent) throws IOException {
        try {
            String entree = RechercheIngredients.getText();

            ReadApi.readJSON(entree.toUpperCase());

            String filename = "src/main/java/app/foodapp/JsonReader/stockRecette/" + entree.toUpperCase() + ".json";
            System.out.println("Ingredient : " + entree.toUpperCase());

            ReadJsonArray readJsonArray = new ReadJsonArray(filename);

            RechercheIngredients.setText(entree);

            AffichageIngredients1.setText((String) readJsonArray.ReadJsonObject1("title"));
            AffichageIngredients2.setText((String) readJsonArray.ReadJsonObject2("title"));
            AffichageIngredients3.setText((String) readJsonArray.ReadJsonObject3("title"));
            AffichageIngredients4.setText((String) readJsonArray.ReadJsonObject4("title"));
            AffichageIngredients5.setText((String) readJsonArray.ReadJsonObject5("title"));
            AffichageIngredients6.setText((String) readJsonArray.ReadJsonObject6("title"));
            AffichageIngredients7.setText((String) readJsonArray.ReadJsonObject7("title"));
            AffichageIngredients8.setText((String) readJsonArray.ReadJsonObject8("title"));

            AffichageImageIngredients1.setImage(new Image((String) readJsonArray.ReadJsonObject1("image")));
            AffichageImageIngredients2.setImage(new Image((String) readJsonArray.ReadJsonObject2("image")));
            AffichageImageIngredients3.setImage(new Image((String) readJsonArray.ReadJsonObject3("image")));
            AffichageImageIngredients4.setImage(new Image((String) readJsonArray.ReadJsonObject4("image")));
            AffichageImageIngredients5.setImage(new Image((String) readJsonArray.ReadJsonObject5("image")));
            AffichageImageIngredients6.setImage(new Image((String) readJsonArray.ReadJsonObject6("image")));
            AffichageImageIngredients7.setImage(new Image((String) readJsonArray.ReadJsonObject7("image")));
            AffichageImageIngredients8.setImage(new Image((String) readJsonArray.ReadJsonObject8("image")));

            Ingredients1.setText((String) readJsonArray.getListMissedIngredient("name", 0));
            Ingredients2.setText((String) readJsonArray.getListMissedIngredient("name", 1));
            Ingredients3.setText((String) readJsonArray.getListMissedIngredient("name", 2));
            Ingredients4.setText((String) readJsonArray.getListMissedIngredient("name", 3));
            Ingredients5.setText((String) readJsonArray.getListMissedIngredient("name", 4));
            Ingredients6.setText((String) readJsonArray.getListMissedIngredient("name", 5));
            Ingredients7.setText((String) readJsonArray.getListMissedIngredient("name", 6));
            Ingredients8.setText((String) readJsonArray.getListMissedIngredient("name", 7));

        } catch (FileNotFoundException | org.json.simple.parser.ParseException e) {
            RechercheIngredients.setText("ERROR!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Ingredient introuvable");
            alert.setHeaderText(null);
            alert.setContentText("Message d'erreur : Veuillez saisir un ingredient correctement. ");
            alert.showAndWait();

        }
    }

    @SuppressWarnings("All")
    public void add_favorite(MouseEvent keyEvent) throws IOException {
        FileWriter fileWriter = new FileWriter(fileContainsAllFavorites, true);
        if (!listeOfFavorite.getItems().contains(RechercheIngredients.getText().toUpperCase()) && !RechercheIngredients.getText().isEmpty()) {
            listeOfFavorite.getItems().add(RechercheIngredients.getText().toUpperCase());
            fileWriter.write(RechercheIngredients.getText().toUpperCase() + "\n");
        }
        fileWriter.close();
    }

    @SuppressWarnings("All")
    public void delete_favoris(MouseEvent mouseEvent) throws IOException {
        String Deleted_String = listeOfFavorite.getSelectionModel().getSelectedItem().toString();
        listeOfFavorite.getItems().remove(Deleted_String);
        ArrayList<String> fileContent = new ArrayList<>(Files.readAllLines(Path.of("src/main/java/app/foodapp/controller/Favoris/favoris.txt"), StandardCharsets.UTF_8));
        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).equals(Deleted_String)) {
                fileContent.remove(Deleted_String);
                break;
            }
        }
        Files.write(Path.of("src/main/java/app/foodapp/controller/Favoris/favoris.txt"), fileContent, StandardCharsets.UTF_8);
    }

    @SuppressWarnings("All")
    public void FavoriteFinder(MouseEvent mouseEvent) throws IOException, ParseException, org.json.simple.parser.ParseException {
        String String_Value = listeOfFavorite.getSelectionModel().getSelectedItem().toString();

        ReadApi.readJSON(String_Value.toUpperCase());

        String filename = "src/main/java/app/foodapp/JsonReader/stockRecette/" + String_Value.toUpperCase() + ".json";
        System.out.println("Ingredient : " + String_Value.toUpperCase());

        ReadJsonArray readJsonArray = new ReadJsonArray(filename);

        RechercheIngredients.setText(String_Value);

        AffichageIngredients1.setText((String) readJsonArray.ReadJsonObject1("title"));
        AffichageIngredients2.setText((String) readJsonArray.ReadJsonObject2("title"));
        AffichageIngredients3.setText((String) readJsonArray.ReadJsonObject3("title"));
        AffichageIngredients4.setText((String) readJsonArray.ReadJsonObject4("title"));
        AffichageIngredients5.setText((String) readJsonArray.ReadJsonObject5("title"));
        AffichageIngredients6.setText((String) readJsonArray.ReadJsonObject6("title"));
        AffichageIngredients7.setText((String) readJsonArray.ReadJsonObject7("title"));
        AffichageIngredients8.setText((String) readJsonArray.ReadJsonObject8("title"));

        AffichageImageIngredients1.setImage(new Image((String) readJsonArray.ReadJsonObject1("image")));
        AffichageImageIngredients2.setImage(new Image((String) readJsonArray.ReadJsonObject2("image")));
        AffichageImageIngredients3.setImage(new Image((String) readJsonArray.ReadJsonObject3("image")));
        AffichageImageIngredients4.setImage(new Image((String) readJsonArray.ReadJsonObject4("image")));
        AffichageImageIngredients5.setImage(new Image((String) readJsonArray.ReadJsonObject5("image")));
        AffichageImageIngredients6.setImage(new Image((String) readJsonArray.ReadJsonObject6("image")));
        AffichageImageIngredients7.setImage(new Image((String) readJsonArray.ReadJsonObject7("image")));
        AffichageImageIngredients8.setImage(new Image((String) readJsonArray.ReadJsonObject8("image")));

        Ingredients1.setText((String) readJsonArray.getListMissedIngredient("name", 0));
        Ingredients2.setText((String) readJsonArray.getListMissedIngredient("name", 1));
        Ingredients3.setText((String) readJsonArray.getListMissedIngredient("name", 2));
        Ingredients4.setText((String) readJsonArray.getListMissedIngredient("name", 3));
        Ingredients5.setText((String) readJsonArray.getListMissedIngredient("name", 4));
        Ingredients6.setText((String) readJsonArray.getListMissedIngredient("name", 5));
        Ingredients7.setText((String) readJsonArray.getListMissedIngredient("name", 6));
        Ingredients8.setText((String) readJsonArray.getListMissedIngredient("name", 7));
    }

    @SuppressWarnings("All")
    public void updateFavoris(MouseEvent mouseEvent) throws IOException {
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(fileContainsAllFavorites));
        if (listeOfFavorite.getItems().isEmpty()) {
            while ((line = reader.readLine()) != null && !listeOfFavorite.getItems().contains(line.toUpperCase())) {
                listeOfFavorite.getItems().add(line.toUpperCase());
            }
        }
    }
}
