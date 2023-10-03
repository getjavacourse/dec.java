package com.example.demo1.control;

import com.example.demo1.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SwitchScene {
    HelloApplication helloApplication;
    public Stage rootStage;
    public void switchScene2(){

        FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader1.load());
            rootStage.setTitle("scene_2!");
            rootStage.setScene(scene);
//            rootStage.setFullScreen(true);
//            rootStage.setResizable(true);
            rootStage.show();

        }catch (Exception e){
            System.out.println("we have a problem ...!");
        }

    }

}
