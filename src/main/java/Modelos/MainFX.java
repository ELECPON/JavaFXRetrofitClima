package Modelos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class MainFX extends Application {

    public static void main(String[] args) {
        launch(args); // Llamar interface grafica

    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CLIMA");
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/Modelos/MainFX.fxml"));
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }






}

