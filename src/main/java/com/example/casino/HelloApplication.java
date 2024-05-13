package com.example.casino;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        music();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hi-lo.fxml"));
        Parent root = fxmlLoader.load();
        stage.setTitle("HI-LO");
        stage.setScene(new Scene(root)); // Removed setting scene here
        stage.show();
    }
    MediaPlayer mediaPlayer;
    public void music(){
        String s = "src/main/resources/background_musics/jazz.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.play();
    }
    public static void main(String[] args) {
        launch();
    }

}
