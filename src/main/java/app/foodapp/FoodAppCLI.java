package app.foodapp;

import app.foodapp.JsonReader.ReadApi;
import app.foodapp.JsonReader.ReadJsonArray;
import app.foodapp.JsonReader.ReadJsonList;
import org.json.simple.parser.ParseException;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings("All")// ©Enlever ce code quand vous modifier le projet !
public class FoodAppCLI {
    public static String getRouge() {
        return "\033[31m";
    }

    public static String getVert() {
        return "\033[32m";
    }

    public static String getJaune() {
        return "\033[33m";
    }

    public static String getBleu() {
        return "\033[34m";
    }

    public static String getPURPLE() {
        return "\u001B[35m";
    }

    public static String ResetColor() {
        return "\033[0m";
    }
    @SuppressWarnings("All")
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println(getRouge() + "----------------------------- BIENVENUE SUR ==> RECETTE & MOI -----------------------------" + getPURPLE());
        SelectMenu(args);
    }
    @SuppressWarnings("All")
    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.println("============================================");
        System.out.println("Voici ton option ! : ");
        System.out.println("============================================");
    }
    @SuppressWarnings("All")
    public static void SelectMenu(String[] args){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("----------------------------- MENU SELECTION -----------------------------");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("");
        System.out.println("----------------------------- CONSIGNES D'UTILISATION --------------------");
        System.out.println("-------------- Pour Rechercher des recettes avec plusieurs ingredients ---");
        System.out.println("-------------- Exemple :"+getBleu()+" Ingredient 1 "+getRouge()+","+getBleu()+"Ingredient 2 , ... ----------------");
        System.out.println("");


        String[] options = {"1- Rechercher une recette par ingredients", "2- Gestion de Favoris"
                ,"3- Vos Suggestions", "4- Fermer l'Application"};
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        printMenu(options);

        try {
            option = scanner.nextInt();
            switch (option) {
                case 1: CliTerminal();
                    //  userChoice();
                    break;
                case 2 :  Favoris();
                    break;
                case 3 : Suggestions();
                    break;
                case 4 : System.exit(0);
                    break;
                default:
                    System.out.println('\n'+ "Nous Sommes Navrés, Veillez Entrez Une Valeur Valable");
                    SelectMenu(args);
            }
        } catch (Exception ex) {
            System.out.println("Please enter an integer value between 1 and " + options.length);
            scanner.next();
        }
        //   userChoice();
    }
    @SuppressWarnings("All")
    public static void CliTerminal() throws IOException, ParseException {

        System.out.println("\n Entrez le(s) ingredient(s) que vous souhaitez (ingredient 1, ingredient 2, ingredient 3...) : ");

        Scanner scanner = new Scanner(System.in);
        String Ingredient = scanner.nextLine();
        ReadApi.readJSON(Ingredient.toUpperCase());
        scanner.close();

        String filename = "src/main/java/app/foodapp/JsonReader/stockRecette/" + Ingredient.toUpperCase() + ".json";
        ReadJsonList readJsonList = new ReadJsonList(filename);
        ReadJsonArray readJsonArray = new ReadJsonArray(filename);

        System.out.println("Ingredient :"+ Ingredient + getBleu());

        Object recette1 = (String) readJsonArray.ReadJsonObject1("title");
        Object recette2 = (String) readJsonArray.ReadJsonObject2("title");
        Object recette3 = (String) readJsonArray.ReadJsonObject3("title");
        Object recette4 = (String) readJsonArray.ReadJsonObject4("title");
        Object recette5 = (String) readJsonArray.ReadJsonObject5("title");
        Object recette6 = (String) readJsonArray.ReadJsonObject6("title");
        Object recette7 = (String) readJsonArray.ReadJsonObject7("title");
        Object recette8 = (String) readJsonArray.ReadJsonObject8("title");

        Object Ingredients1 = (String) readJsonArray.getListMissedIngredient("name",0);
        Object Ingredients2 = (String) readJsonArray.getListMissedIngredient("name",1);
        Object Ingredients3 = (String) readJsonArray.getListMissedIngredient("name",2);
        Object Ingredients4 = (String) readJsonArray.getListMissedIngredient("name",3);
        Object Ingredients5 = (String) readJsonArray.getListMissedIngredient("name",4);
        Object Ingredients6 = (String) readJsonArray.getListMissedIngredient("name",5);
        Object Ingredients7 = (String) readJsonArray.getListMissedIngredient("name",6);
        Object Ingredients8 = (String) readJsonArray.getListMissedIngredient("name",7);

        System.out.println(getJaune() + "---------------------------------------------");
        System.out.println(getBleu()+"Recette 1 : " + recette1);
        System.out.println(getJaune() +  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println( getRouge()+"Ingredients : " + Ingredients1 );
        System.out.println(getJaune() +  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(getJaune() + "---------------------------------------------");

        System.out.println(getJaune() + "---------------------------------------------");
        System.out.println(getBleu()+"Recette 2 : " + recette2  );
        System.out.println(getJaune() +  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(getRouge()+"Ingredients2 : " + Ingredients2 );
        System.out.println(getJaune() +  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(getJaune() + "---------------------------------------------");

        System.out.println(getJaune() + "---------------------------------------------");
        System.out.println(getBleu()+"Recette 3 : " + recette3 );
        System.out.println(getJaune() +  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println( getRouge()+"Ingredients : " + Ingredients3 );
        System.out.println(getJaune() +  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(getJaune() + "---------------------------------------------");

        System.out.println(getJaune() + "---------------------------------------------");
        System.out.println(getBleu()+"Recette 4 : " + recette4  );
        System.out.println(getJaune() +  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(getRouge()+"Ingredients : " + Ingredients4  );
        System.out.println(getJaune() +  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(getJaune() + "---------------------------------------------");

        System.out.println(getJaune() + "---------------------------------------------");
        System.out.println(getBleu()+"Recette 5 : " + recette5  );
        System.out.println(getJaune() +  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(getRouge()+"Ingredients : " + Ingredients5  );
        System.out.println(getJaune() +  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(getJaune() + "---------------------------------------------");

        System.out.println(getJaune() + "---------------------------------------------");
        System.out.println(getBleu()+"Recette 6 : " + recette6  );
        System.out.println(getJaune() +  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(getRouge()+"Ingredients : " + Ingredients6 );
        System.out.println(getJaune() +  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(getJaune() + "---------------------------------------------");

        System.out.println(getJaune() + "---------------------------------------------");
        System.out.println(getBleu()+"Recette 6 : " + recette7 );
        System.out.println(getJaune() +  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(getRouge()+"Ingredients : " + Ingredients7 );
        System.out.println(getJaune() +  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(getJaune() + "---------------------------------------------");

        System.out.println(getJaune() + "---------------------------------------------");
        System.out.println(getBleu()+"Recette 6 : " + recette8  );
        System.out.println(getJaune() +  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(getRouge()+"Ingredients : " + Ingredients8  );
        System.out.println(getJaune() +  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(getJaune() + "---------------------------------------------");
    }
    public static void Favoris() throws IOException, ParseException {
        String[] argsFav = {};
        // System.out.println('\n' + "Revenez plus tard pour voir Vos Favoris. " + '\n');

        String[] optionsFav = {"1- Ajouter Un ingredient à Vos Favoris"
                ,"2- Supprimer Un ingredient de Vos Favoris","3- Liste de Favoris", "4- Revenir au Menu"};

        Scanner scannerFavoris = new Scanner(System.in);
        int optionFav = 1;
        printMenu(optionsFav);

        try {
            optionFav = scannerFavoris.nextInt();
            switch (optionFav) {
                case 1:
                    AddRecette();
                    break;
                case 2:
                    DeleteRecette();
                    // SelectMenu(argsFav);
                    break;
                case 3:
                    displayFavoris();
                    SelectMenu(argsFav);
                    break;
                case 4:
                    SelectMenu(argsFav);
                    break;

                default:
                    System.out.println('\n'+ "Nous Sommes Navrés, Veillez Entrez Une Valeur Valable");
                    SelectMenu(argsFav);
            }
        } catch (Exception ex) {
            System.out.println("Please enter an integer value between 1 and " + optionsFav.length);
            scannerFavoris.next();
        }
        SelectMenu(argsFav);
    }



    public static void Suggestions(){
        String[] args = {};
        System.out.println('\n' + "Donnez Nous Votre Avis " + '\n');
        Scanner SuggestionsScanner = new Scanner(System.in);
        System.out.println("Merci pour ce commentaire: " + SuggestionsScanner.next().toUpperCase());
        SelectMenu(args);
    }

    public static void AddRecette(){
        String[] args = {};
        System.out.println('\n' + "Entrez l'ingredient à Ajouter " + '\n');
        Scanner AddRecetteScanner = new Scanner(System.in);
        System.out.println( AddRecetteScanner.next() + " : Ajouté avec succès");
        SelectMenu(args);
    }

    public static void DeleteRecette(){
        String[] args = {};
        System.out.println('\n' + "Entrez l'ingredient à Supprimer" + '\n');
        Scanner DeleteRecetteScanner = new Scanner(System.in);
        System.out.println( DeleteRecetteScanner.next() + " : Supprimé avec succès");
        SelectMenu(args);
    }


    public static void displayFavoris(){
        System.out.println("Liste de Favoris : ");
    }


    public  static  void userChoice(){
        System.out.println("Voulez-Vous Revenir au Menu Principal ? O/N" + '\n');
        String[] args = {};
        Scanner scanner1=new Scanner(System.in);
        if(scanner1.next() == "O"){
            SelectMenu(args);
        } System.exit(0);
    }
}


