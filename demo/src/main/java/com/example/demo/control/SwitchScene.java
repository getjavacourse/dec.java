package com.example.demo.control;

import com.example.demo.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
public class SwitchScene {
    private static StackPane root;
    public static Stage stageTwo;
    public SwitchScene(){

    }
    public static void setScene(String xmlResource) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(xmlResource));
        Parent newContentFxmlLoader = fxmlLoader.load();
        try {
            root = new StackPane();
            root.getChildren().addAll(newContentFxmlLoader);
            Scene scene = new Scene(root);
            Image icon = new Image("file:dec.png");
            stageTwo.getIcons().add(icon);
            stageTwo.setTitle("Welcome");
            stageTwo.setScene(scene);
            stageTwo.setResizable(false);
            stageTwo.show();

        }catch (Exception e){
            System.out.println("we have a problem in setScene ...!");
        }
    }

    public static void setScene2(String xmlResource) throws IOException {

        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource(xmlResource));
        Parent newContentFxmlLoader2 = fxmlLoader2.load();
        try {
            root = new StackPane();
            root.getChildren().clear();
            root.getChildren().add(newContentFxmlLoader2);
            Scene scene = new Scene(root);
            stageTwo.setTitle("Welcome");
            stageTwo.setScene(scene);
            stageTwo.setResizable(false);
            stageTwo.show();

        }catch (Exception e){
            System.out.println("we have a problem in setScene 2 ...!");
        }
    }

    public Stage getStageTwo() {
        return stageTwo;
    }
}
