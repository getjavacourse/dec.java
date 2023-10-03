package com.example.demo;

import com.example.demo.control.MainStage;
import javafx.application.Application;

import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stageOne) throws IOException {

        MainStage mainStage = new MainStage();
        mainStage.setMainStage(stageOne);

    }


    public static void main(String[] args) {
        launch();
    }
}