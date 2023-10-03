package com.example.demo.connection;
import java.sql.*;
import java.io.FileNotFoundException;

public class MainConnection {

    private static String url = "jdbc:mysql://localhost:3306/test";
    private static String admin = "admin";
    private static String password = "0000";

    public void connectionToStudentsDatabase() throws FileNotFoundException, ClassNotFoundException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url,admin,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from students");//you can set this method before the statement method...
            while (resultSet.next()){
                System.out.println(resultSet.getString(2));
                connection.close();
                statement.close();
            }

        }catch (Exception e){
            System.out.println("you hava a problem in the connection method !... ");
        }


    }

    public static String getAdminMain() {
        return admin;
    }

    public static String getPassword() {
        return password;
    }
}
