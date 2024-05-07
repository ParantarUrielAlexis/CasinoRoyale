package com.example.casino;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hi-lo.fxml"));
        Parent root = fxmlLoader.load();
        stage.setTitle("Hello!");
        stage.setScene(new Scene(root)); // Removed setting scene here
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
