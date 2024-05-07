module com.example.casino {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens com.example.casino to javafx.fxml;
    exports com.example.casino;
}