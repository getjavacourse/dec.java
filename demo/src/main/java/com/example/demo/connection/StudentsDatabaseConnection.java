package com.example.demo.connection;
import com.example.demo.user.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import java.io.FileNotFoundException;

public class StudentsDatabaseConnection {

    public ObservableList<Person> observableStudentsListDatabase = FXCollections.observableArrayList();
    private static String url = "jdbc:mysql://localhost:3306/test";
    private static String admin = "my_root";
    private static String password = "0000";
    private Connection connection;
    String preparedStatementSqlToAddStudent ="INSERT INTO `students`(`ID`, `Name`, `Last Name`, `Phone Number`, `Email`) VALUES (?,?,?,?,?)";

    String preparedStatementSqlToDeleteStudent = "DELETE FROM `students` WHERE `ID` = ?";
    public Person person ;

    public StudentsDatabaseConnection() throws FileNotFoundException, ClassNotFoundException ,SQLException{
    }
    //to connect to the students database then get the database and add it to the studentsListDatabase ObservableList<Person> ...

    public void getStudentsDatabase() throws FileNotFoundException, ClassNotFoundException,SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url,admin,password);
            System.out.println("it is connected to the database ..");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from students");

            while (resultSet.next()){
                Integer getIDFromStudentsDatabase = resultSet.getInt(1);
                String getNameFromStudentsDatabase = resultSet.getString("Name");
                String getLastNameFromStudentsDatabase =resultSet.getString("Last Name");
                Long getPhoneNumberFromStudentsDatabase =resultSet.getLong(4);
                String getEmailFromStudentsDatabase =resultSet.getString("Email");

                    observableStudentsListDatabase.add(person = new Person(getIDFromStudentsDatabase
                            ,getNameFromStudentsDatabase,getLastNameFromStudentsDatabase
                            ,getPhoneNumberFromStudentsDatabase,getEmailFromStudentsDatabase));
                    System.out.println("it is working inside the while condition ... ");
                }

            statement.close();
            connection.close();
            System.out.println("inside while");
        }catch (Exception e){
        }

    }

    public void addNewToStudentsDatabase(Integer preparedID,String preparedName,String preparedLastName ,Long preparedPhoneNumber,String preparedEmail) throws FileNotFoundException, ClassNotFoundException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,admin,password);
            PreparedStatement preparedStatement = connection.prepareStatement(preparedStatementSqlToAddStudent);
            System.out.println("it is connected to the database preparedStatement ...");
            preparedStatement.setInt(1,preparedID);
            preparedStatement.setString(2,preparedName);
            preparedStatement.setString(3,preparedLastName);
            preparedStatement.setLong(4,preparedPhoneNumber);
            preparedStatement.setString(5,preparedEmail);
            preparedStatement.executeUpdate();

            System.out.println("it is executed ...");

            preparedStatement.close();
            connection.close();


        }catch (Exception e){
            System.out.println("you hava a problem in the preparedStatement method !... ");
        }


    }

    public void deleteStudentsFromDatabase(int preparedID) throws FileNotFoundException, ClassNotFoundException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,admin,password);
            PreparedStatement preparedStatement = connection.prepareStatement(preparedStatementSqlToDeleteStudent);
            System.out.println("it is connected to the database preparedStatement ...");
            preparedStatement.setInt(1,preparedID);
            preparedStatement.executeUpdate();

            System.out.println("it is executed ...");

            preparedStatement.close();
            connection.close();


        }catch (Exception e){
            System.out.println("you hava a problem in the preparedStatement method !... ");
        }


    }

}
