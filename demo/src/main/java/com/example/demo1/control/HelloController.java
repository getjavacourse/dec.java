package com.example.demo1.control;

import com.example.demo1.user.Person;
import com.example.demo1.user.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    public TableView <Person> tableView;
    @FXML
    public TableColumn<Person,Integer> id;
    @FXML
    public TableColumn<Person,String> name;
    @FXML
    public TableColumn <Person,String> lastName;
    @FXML
    public TableColumn <Person,Integer> phoneNumber;
    @FXML
    public TableColumn <Person,String> email;
    @FXML
    public Button getStudentsPage;

    @FXML
    public Button getTeachersPage;


    ObservableList<Person> studentsList = FXCollections.observableArrayList(
            new Person(1,"student1","last name 1",12312,"@yahoo"),
            new Person(2,"student2","last name 2",12312,"@yahoo")
    );

    ObservableList<Person> teachersList = FXCollections.observableArrayList(
            new Person(1,"teacher1","last name 1",12312,"@yahoo"),
            new Person(2,"teacher2","last name 2",12312,"@yahoo")
    );


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      getStudentsPage.setOnAction(actionEvent -> {
          try {
              id.setCellValueFactory(new PropertyValueFactory<Person,Integer>("id"));
              name.setCellValueFactory(new PropertyValueFactory<Person,String>("name"));
              lastName.setCellValueFactory(new PropertyValueFactory<Person,String>("lastName"));
              phoneNumber.setCellValueFactory(new PropertyValueFactory<Person,Integer>("phoneNumber"));
              email.setCellValueFactory(new PropertyValueFactory<Person,String>("email"));

              tableView.setItems(studentsList);
          }catch (Exception e){
              System.out.println("we have error in the initialize method students ...");
          }
      });
        getTeachersPage.setOnAction(actionEvent -> {
            try {
                id.setCellValueFactory(new PropertyValueFactory<Person,Integer>("id"));
                name.setCellValueFactory(new PropertyValueFactory<Person,String>("name"));
                lastName.setCellValueFactory(new PropertyValueFactory<Person,String>("lastName"));
                phoneNumber.setCellValueFactory(new PropertyValueFactory<Person,Integer>("phoneNumber"));
                email.setCellValueFactory(new PropertyValueFactory<Person,String>("email"));

                tableView.setItems(teachersList);
            }catch (Exception e){
                System.out.println("we have error in the initialize method teacher ...");
            }
        });


    }

}