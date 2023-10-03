package com.example.demo.control;

import com.example.demo.HelloApplication;
import com.example.demo.connection.StudentsDatabaseConnection;
import com.example.demo.connection.TeachersDatabaseConnection;
import com.example.demo.user.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

//Controller class HelloController using Fxml to build the JavaFX user interface ...
public class Controller_2 implements Initializable {

    @FXML
    public MenuItem close;
    @FXML
    public MenuItem about;

    //External classes ...
    StudentsDatabaseConnection studentsDatabaseConnection;

    TeachersDatabaseConnection teachersDatabaseConnection;

    //ImageView SUP_DEC ...
    @FXML
    public ImageView imageViewSUP_DEC;

    //ImageView student1 ...
    @FXML
    public ImageView imageViewDatabase;

    // Label SUP_DECDatabase ...
    @FXML
    public Label labelSUP_DECDatabase;

    //TableView to display the person information from the database ...
    @FXML
    public TableView <Person> tableView;

    //Each column contain some information of the person ...
    @FXML
    public TableColumn<Person,Integer> idColumn;
    @FXML
    public TableColumn<Person,String> nameColumn;
    @FXML
    public TableColumn <Person,String> lastNameColumn;
    @FXML
    public TableColumn <Person,Integer> phoneNumberColumn;
    @FXML
    public TableColumn <Person,String> emailColumn;

    @FXML
    public Button getStudentsPageButton;
    @FXML
    public Button getTeachersPageButton;

    //Bottom to add new ...
    @FXML
    public Button actionButton;

    //Save the inputs from the user to the students field ...
    @FXML
    public Button saveToStudentsButton;

    //Save the inputs from the user to the teachers field ...
    @FXML
    public Button saveToTeachersButton ;

    //Delete button to delete the row from the database ...
    @FXML
    public Button deleteDataBaseButton ;

    //Cancel button to cancel the operation ...
    @FXML
    public Button cancelAddingButton ;

    //HBox to add new person...
    @FXML
    public HBox addNewBox ;

    //VBox to add new person to the table ...
    @FXML
    public Label labelNewPerson ;

    //New person elements ...
    @FXML
    public TextField newIdTextFiled ;
    @FXML
    public TextField newNameTextFiled ;
    @FXML
    public TextField newLastNameTextFile ;
    @FXML
    public TextField newPhoneNumberTextFile;
    @FXML
    public TextField newEmailTextFiled;

    //Get the inputs from the textFiled "from the user"...

    public Integer getNewId ;
    public String getNewName ;
    public String getNewLastName ;
    public Long getNewPhoneNumber ;
    public String getNewEmail ;

    //Constructor ...
    public Controller_2() throws FileNotFoundException, ClassNotFoundException ,SQLException{
        studentsDatabaseConnection =new StudentsDatabaseConnection();
        teachersDatabaseConnection = new TeachersDatabaseConnection();
    }

    // Some methods to give the effects ...

    //Defaults methods ...
    @FXML
    public void closeMainPage() throws IOException {
        SwitchScene.setScene("controller_log_in.fxml");
    }
    public void defaults(){
        imageViewDatabase.setImage(new Image("file:sql.png"));
    }
    @FXML
    public void onMouseEnteredTableView(){
        tableView.setOpacity(1);
        tableView.setPrefSize(540,270);
    }
    @FXML
    public void onMouseExitedTableView(){
        tableView.setOpacity(0.8);
        tableView.setPrefSize(500,250);
    }
    @FXML
    public void teachersOnClick(){
        getTeachersPageButton.setOpacity(1);
        getStudentsPageButton.setOpacity(0.4);
        imageViewDatabase.setImage(new Image("file:teacher2.png"));
        labelSUP_DECDatabase.setText("You are in the Teachers Database");
    }
    @FXML
    public void teachersMouseEntered(){
        getTeachersPageButton.setPrefWidth(100.0);
    }
    @FXML
    public void teachersMouseExited(){
        getTeachersPageButton.setPrefWidth(80.0);
    }
    @FXML
    public void studentsOnClick() throws SQLException, FileNotFoundException, ClassNotFoundException {

        getStudentsPageButton.setOpacity(1);
        getTeachersPageButton.setOpacity(0.4);
        imageViewDatabase.setImage(new Image("file:student1.png"));
        labelSUP_DECDatabase.setText("You are in the Students Database");

        studentsDatabaseConnection.getStudentsDatabase();
        if (studentsDatabaseConnection.observableStudentsListDatabase.size()==0) {
            studentsDatabaseConnection.getStudentsDatabase();
            tableView.setItems(studentsDatabaseConnection.observableStudentsListDatabase);
        }
        else {
            studentsDatabaseConnection.observableStudentsListDatabase.clear();
            studentsDatabaseConnection.getStudentsDatabase();
            tableView.setItems(studentsDatabaseConnection.observableStudentsListDatabase);
        }
    }
    @FXML
    public void studentsMouseEntered(){
        getStudentsPageButton.setPrefWidth(100.0);
    }
    @FXML
    public void studentsMouseExited(){
        getStudentsPageButton.setPrefWidth(80.0);
    }

    @FXML
    public void actionButtonMouseEntered(){
        actionButton.setPrefSize(100,30);
        actionButton.setOpacity(1);
        labelNewPerson.setText("Click on Action Button");
    }

    @FXML
    public void actionButtonMouseExited(){
        actionButton.setPrefSize(80,30);
        actionButton.setOpacity(0.8);
        labelNewPerson.setText("Click on Action Button to Modify SUP_DEC Database");
    }

    @FXML
    public void saveToStudentsButtonMouseEntered(){
        saveToStudentsButton.setPrefSize(100,30);
        saveToStudentsButton.setOpacity(1);
        labelNewPerson.setText("Click on to Save into Students Database");
    }
    @FXML
    public void saveToStudentsButtonMouseExited(){
        saveToStudentsButton.setPrefSize(80,30);
        saveToStudentsButton.setOpacity(0.8);
        labelNewPerson.setText("SUP_DEC Database");
    }

    @FXML
    public void saveToTeachersButtonMouseEntered(){
        saveToTeachersButton.setPrefSize(100,30);
        saveToTeachersButton.setOpacity(1);
        labelNewPerson.setText("Click on to Save into Teachers Database");
    }
    @FXML
    public void saveToTeachersButtonMouseExited(){
        saveToTeachersButton.setPrefSize(80,30);
        saveToTeachersButton.setOpacity(0.8);
        labelNewPerson.setText("SUP_DEC Database");
    }

    @FXML
    public void deleteButtonMouseEntered(){
        deleteDataBaseButton.setPrefSize(100,30);
        deleteDataBaseButton.setOpacity(1);
        labelNewPerson.setText("Click on to Delete from Database");
    }
    @FXML
    public void deleteButtonMouseExited(){
        deleteDataBaseButton.setPrefSize(80,30);
        deleteDataBaseButton.setOpacity(0.8);
        labelNewPerson.setText("SUP_DEC Database");
    }

    @FXML
    public void cancelButtonMouseEntered(){
        cancelAddingButton.setPrefSize(100,30);
        cancelAddingButton.setOpacity(1);
        labelNewPerson.setText("Click on to Cancel");
    }
    @FXML
    public void cancelButtonMouseExited(){
        if (cancelAddingButton.isDisable()){
            cancelAddingButton.setOpacity(0);
        }else {
            cancelAddingButton.setPrefSize(80,30);
            cancelAddingButton.setOpacity(0.8);
            labelNewPerson.setText("SUP_DEC Database");
        }
    }

    //Some interactive methods ...

    @FXML
    public void aboutAction() throws IOException {
        openPopUp("about_controller.fxml");
    }

    private void openPopUp(String xmlResource) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(xmlResource));
        Parent newContentFxmlLoader = fxmlLoader.load();
        try {
            Image icon = new Image("file:dec.png");
            StackPane root = new StackPane();
            root.getChildren().addAll(newContentFxmlLoader);
            Scene popUpScene = new Scene(root, 500, 800);
            // Create a new stage for the pop-up...
            Stage popUpStage = new Stage();
            // Block input events in the parent stage...
            popUpStage.initModality(Modality.APPLICATION_MODAL);
            popUpStage.setTitle("About");
            popUpStage.setScene(popUpScene);
            popUpStage.getIcons().add(icon);
            popUpStage.setResizable(false);
            // Show the pop-up...
            popUpStage.showAndWait();
        }catch (Exception e){
            System.out.println("we have a problem in the about page ...");
        }

    }
    @FXML
    public void actions(){
        actionButton.setOpacity(0);
        actionButton.setDisable(true);
        saveToStudentsButton.setOpacity(0.8);
        saveToStudentsButton.setDisable(false);
        saveToTeachersButton.setOpacity(0.8);
        saveToTeachersButton.setDisable(false);
        cancelAddingButton.setOpacity(0.8);
        cancelAddingButton.setDisable(false);
        deleteDataBaseButton.setOpacity(0.8);
        deleteDataBaseButton.setDisable(false);
        addNewBox.setOpacity(1);
        addNewBox.setDisable(false);
    }
    @FXML
    public void saveToStudentsAction()throws FileNotFoundException,ClassNotFoundException, SQLException {
        try {
            getNewId = Integer.valueOf(newIdTextFiled.getText());
            getNewName = newNameTextFiled.getText();
            getNewLastName = newLastNameTextFile.getText();
            getNewPhoneNumber = Long.valueOf(newPhoneNumberTextFile.getText());
            getNewEmail = newEmailTextFiled.getText();
            if (studentsDatabaseConnection.observableStudentsListDatabase.stream().anyMatch(person->person.getId()==getNewId)) {
                labelNewPerson.setText("This ID is Already Exists ! ");
            }
            else {
                studentsDatabaseConnection.addNewToStudentsDatabase(getNewId,getNewName,getNewLastName,getNewPhoneNumber,getNewEmail);
            }
            System.out.println("the button students is pressed ");

        }catch (Exception e){
            System.out.println("save to student problem !...");
        }
    }

    @FXML
    public void saveToTeachersAction() throws FileNotFoundException,ClassNotFoundException,SQLException{
        try {

            getNewId = Integer.valueOf(newIdTextFiled.getText());
            getNewName = newNameTextFiled.getText();
            getNewLastName = newLastNameTextFile.getText();
            getNewPhoneNumber = Long.valueOf(newPhoneNumberTextFile.getText());
            getNewEmail = newEmailTextFiled.getText();
            if (teachersDatabaseConnection.observableTeachersListDatabase.stream().anyMatch(person->person.getId()==getNewId)) {
                labelNewPerson.setText("This ID is Already Exists ! ");
            }
            else {
                teachersDatabaseConnection.addNewToTeachersDatabase(getNewId,getNewName,getNewLastName,getNewPhoneNumber,getNewEmail);
            }
            System.out.println("the button teacher is pressed ");
        }catch (Exception e){
            System.out.println("save to teacher problem !...");
        }
    }


    @FXML
    public void deleteDataBaseButtonOperation(){
        try {

            if (getTeachersPageButton.getOpacity()==1) {
                int selectedIdTeachers = tableView.getSelectionModel().getSelectedItem().getId();
                teachersDatabaseConnection.deleteTeachersFromDatabase(selectedIdTeachers);

                int selectedInd = tableView.getSelectionModel().getSelectedIndex();
                tableView.getItems().remove(selectedInd);

                System.out.println("the id is : " + selectedIdTeachers);
                labelNewPerson.setText("The Elements is Deleted ...");
            }

            else if (getStudentsPageButton.getOpacity()==1) {
                int selectedIdStudents = tableView.getSelectionModel().getSelectedItem().getId();
                studentsDatabaseConnection.deleteStudentsFromDatabase(selectedIdStudents);

                int selectedInd = tableView.getSelectionModel().getSelectedIndex();
                tableView.getItems().remove(selectedInd);

                System.out.println("the id is : " + selectedIdStudents);
                labelNewPerson.setText("The Elements is Deleted ...");
            } {

            }


        }catch (Exception e){
            System.out.println("delete button problem ...");
        }
    }

    @FXML
    public void cancelAction() throws IOException {
        actionButton.setOpacity(1);
        actionButton.setDisable(false);
        saveToStudentsButton.setOpacity(0);
        saveToStudentsButton.setDisable(true);
        saveToTeachersButton.setOpacity(0);
        saveToTeachersButton.setDisable(true);
        cancelAddingButton.setOpacity(0);
        cancelAddingButton.setDisable(true);
        deleteDataBaseButton.setOpacity(0);
        deleteDataBaseButton.setDisable(true);
        addNewBox.setOpacity(0);
        addNewBox.setDisable(true);

    }

    //Initialize method which allow us to add elements to the table ...
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        getTeachersPageButton.setOnAction(actionEvent -> {
            tableView.setStyle(" -fx-text-fill: white;");
            try {
                System.out.println("it is working1");
                idColumn.setCellValueFactory(new PropertyValueFactory<Person,Integer>("id"));
                nameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("name"));
                lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("lastName"));
                phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Person,Integer>("phoneNumber"));
                emailColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("email"));

                System.out.println("it is working2");
                teachersDatabaseConnection.getTeachersDatabase();
                if (teachersDatabaseConnection.observableTeachersListDatabase.size()==0) {
                    teachersDatabaseConnection.getTeachersDatabase();
                    tableView.setItems(teachersDatabaseConnection.observableTeachersListDatabase);
                }
                else {
                    teachersDatabaseConnection.observableTeachersListDatabase.clear();
                    teachersDatabaseConnection.getTeachersDatabase();
                    tableView.setItems( teachersDatabaseConnection.observableTeachersListDatabase);
                }
                System.out.println("it is working3");
            } catch (Exception e) {
                e.printStackTrace(); // Print the stack trace for debugging
                System.out.println("An error occurred: " + e.getMessage());
            }
        });

        getStudentsPageButton.setOnAction(actionEvent -> {
            tableView.setStyle("-fx-text-fill: white;");
            try {
                System.out.println("it is working1");
                idColumn.setCellValueFactory(new PropertyValueFactory<Person,Integer>("id"));
                nameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("name"));
                lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("lastName"));
                phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Person,Integer>("phoneNumber"));
                emailColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("email"));

                System.out.println("it is working2");
                studentsDatabaseConnection.getStudentsDatabase();
                if (studentsDatabaseConnection.observableStudentsListDatabase.size()==0) {
                    studentsDatabaseConnection.getStudentsDatabase();
                    tableView.setItems(studentsDatabaseConnection.observableStudentsListDatabase);
                }
                else {
                    studentsDatabaseConnection.observableStudentsListDatabase.clear();
                    studentsDatabaseConnection.getStudentsDatabase();
                    tableView.setItems(studentsDatabaseConnection.observableStudentsListDatabase);
                }
                System.out.println("it is working3");
            } catch (Exception e) {
                e.printStackTrace(); // Print the stack trace for debugging
                System.out.println("An error occurred: " + e.getMessage());
            }
        });
        }
    }



