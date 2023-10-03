package com.example.demo.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

//Controller_1
public class Controller_1 {

    @FXML
    public ImageView ImageViewId;
    @FXML
    public Label labelName;
    @FXML
    public TextField textFiledAdmin;
    @FXML
    public PasswordField textFiledPassword;
    @FXML
    public Button logInButton;

    //Log_in method to connect to the controller_2 ...
    @FXML
    public void logInOnMouseClicked(){

        if (textFiledAdmin.getText().equals("admin")&& textFiledPassword.getText().equals("0000")) {
            System.out.println("you are inside the try catch changeScene now ...");
            try {
                SwitchScene.setScene("main_controller.fxml");

            }catch (Exception e){
                System.out.println("Problem inside the Exception set changeScene ...");
            }

            System.out.println("it is okkkkk!");
        }else {
            System.out.println("you hava a problem ...");
        }
    }

    @FXML
    public void mouseEnteredTextFiledAdmin(){
        textFiledAdmin.setPrefWidth(400);
    }

    @FXML
    public void mouseExitedTextFiledAdmin(){
        textFiledAdmin.setPrefWidth(350);
    }

    @FXML
    public void mouseEnteredPasswordFiled(){
        textFiledPassword.setPrefWidth(400);
    }

    @FXML
    public void mouseExitedPasswordFiled(){
        textFiledPassword.setPrefWidth(350);
    }

    @FXML
    public void logInOnMouseEntered(){
        logInButton.prefWidth(400);
        logInButton.setOpacity(1);
    }

    @FXML
    public void logInOnMouseExited(){
        logInButton.prefWidth(350);
        logInButton.setOpacity(0.8);
    }
}
