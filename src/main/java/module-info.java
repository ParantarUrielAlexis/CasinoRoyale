module com.example.casino {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.smartcardio;


    opens com.example.casino to javafx.fxml;
    exports com.example.casino;
}