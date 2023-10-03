package com.example.demo;

import com.example.demo.connection.StudentsDatabaseConnection;
import com.example.demo.control.Controller_1;
import com.example.demo.control.SwitchScene;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
public class HelloApplication extends Application {
    @Override
    public void start(Stage mainStage) throws IOException, SQLException, ClassNotFoundException {

        SwitchScene.stageTwo=mainStage;
        SwitchScene.setScene("controller_log_in.fxml");
        Controller_1 controller_1 = new Controller_1();

    }

    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException , SQLException {

        StudentsDatabaseConnection studentsDatabaseConnection = new StudentsDatabaseConnection();
        studentsDatabaseConnection.getStudentsDatabase();
        launch();
    }
}