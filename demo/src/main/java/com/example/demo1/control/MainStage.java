package com.example.demo1.control;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainStage {
SwitchScene switchScene;
TextField name;
PasswordField password;
Button login;
    public Stage setMainStage(Stage stageOne){
        switchScene= new SwitchScene();
        switchScene.rootStage = stageOne;

        Label labelName = new Label();
        labelName.setText("Enter Admin Name");
        labelName.setAlignment(Pos.CENTER);
        labelName.setPrefSize(200,30);

        Label labelPassword = new Label();
        labelPassword.setText("Enter Admin Password");
        labelPassword.setAlignment(Pos.CENTER);
        labelPassword.setPrefSize(200,30);

        name = new TextField();
        name.setPrefSize(200,30);
        name.alignmentProperty().setValue(Pos.CENTER);
        name.promptTextProperty().set("Admin Name ...");

        password = new PasswordField();
        password.setPrefSize(200,30);
        password.alignmentProperty().setValue(Pos.CENTER);
        password.promptTextProperty().set("Password ...");

        login = new Button();
        login.setText("login");

        HBox hBox = new HBox();
        hBox.setPrefSize(450,30);
        hBox.maxHeight(30);
        hBox.alignmentProperty().setValue(Pos.TOP_CENTER);
        hBox.getChildren().add(name);
        hBox.setSpacing(10);

        HBox hBox1 = new HBox();
        hBox1.setPrefSize(450,50);
        hBox1.maxHeight(30);
        hBox1.alignmentProperty().setValue(Pos.TOP_CENTER);
        hBox1.getChildren().add(password);
        hBox1.setSpacing(10);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(2);
        vBox.setPrefSize(800,400);

//        ImageView selectedImage = new ImageView();
//        Image image1 = new Image("file:sup.png");
//
//        selectedImage.setImage(image1);

        vBox.getChildren().addAll(labelName,hBox,labelPassword,hBox1,login);

        Pane pane = new Pane();
        pane.prefWidth(800);
        pane.prefHeight(500);
        pane.getChildren().add(vBox);

        Scene sceneConnection = new Scene(pane);
//            ImageView selectedIcon = new ImageView();
//            Image icon = new Image("file:sup.png");

//        selectedImage.setImage(image1);

        stageOne.setScene(sceneConnection);
//        stageOne.setTitle("LOGIN");
        stageOne.setResizable(false);
        stageOne.getIcons().add(new Image("file:sup.png"));
        stageOne.show();
        setSwitchScene();

        return stageOne;
    }
    public void setSwitchScene(){
        login.setOnAction(actionEvent -> {
            if (name.getText().equals("")&&password.getText().equals("")) {

                try {
                    System.out.println("you are inside the try now ...");
                    switchScene.switchScene2();
                }catch (Exception e){
                    System.out.println("Problem inside the Exception set switch scene ...");
                }

                System.out.println("it is okkkkk!");
            }else {
                System.out.println("you hava a problem ...");
            }
        });
    }
    }

