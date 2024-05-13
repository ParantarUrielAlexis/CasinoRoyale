module com.example.casino {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.media;


    opens com.example.casino to javafx.fxml;
    exports com.example.casino;
}