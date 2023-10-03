module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.control;
    opens com.example.demo.control to javafx.fxml;
    exports com.example.demo.user;
    opens com.example.demo.user to javafx.fxml;
    exports com.example.demo.connection;
    opens com.example.demo.connection to javafx.fxml;
//    exports com.example.demo.connection;
//    opens com.example.demo.connection to javafx.fxml;
}