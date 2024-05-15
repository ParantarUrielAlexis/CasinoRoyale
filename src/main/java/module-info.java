module com.example.casino {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.media;
    requires java.smartcardio;
    requires java.sql;
    requires mysql.connector.j;
    requires java.desktop;


    opens com.example.casino to javafx.fxml;
    exports com.example.casino;
}