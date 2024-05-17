package com.example.casino;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloController {
    private double originalWidth = 462.0;
    private double originalHeight = 701.0;

    @FXML
    public void onHiloBTNClick(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("hi-lo.fxml"));
        music();
        // code for userbalance
        try (Connection c = MySQLConnection.getConnection();
             Statement statement = c.createStatement()) {

            String selectQuery = "SELECT * FROM users where id = " + SignInController.getUserId();
            ResultSet result = statement.executeQuery(selectQuery);

            if (result.next()) {
                HiloController.userBalance = result.getInt("balance");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(HiloController.userBalance);
        try {

            Parent root = loader.load();
            Scene scene = new Scene(root);

            HiloController hiloController = loader.getController();

            hiloController.setForeground();

            // Set the background color of the scene to black
            scene.setFill(Color.BLACK);

            // Get the stage from the event source
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setTitle("Hilo");
            primaryStage.setScene(scene);

            // Store the original width and height of the stage
            originalWidth = primaryStage.getWidth();
            originalHeight = primaryStage.getHeight();

            // Set up a listener for stage size changes
            primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> adjustAnchorPane(primaryStage, root));
            primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> adjustAnchorPane(primaryStage, root));

            // Set up a listener for stage minimized and maximized events
            primaryStage.iconifiedProperty().addListener((obs, oldVal, newVal) -> {
                if (newVal) {
                    // Store the current position of the stage when minimized
                    primaryStage.setX(primaryStage.getX());
                    primaryStage.setY(primaryStage.getY());
                    // Restore the original size
                    primaryStage.setWidth(originalWidth);
                    primaryStage.setHeight(originalHeight);
                }
            });

            primaryStage.maximizedProperty().addListener((obs, oldVal, newVal) -> {
                if (newVal) {
                    // Restore the position of the stage when maximized
                    primaryStage.setX(0);
                    primaryStage.setY(0);
                }
            });

            // Adjust anchor pane initially
            adjustAnchorPane(primaryStage, root);

            primaryStage.show();
        } catch (IOException e) {
            // Handle any IOException that occurs during loading
            e.printStackTrace();
            // You might want to show an error message to the user here
        }
    }

    // Method to adjust the anchor pane to stay in the middle
    private void adjustAnchorPane(Stage stage, Parent root) {
        double screenWidth = stage.getWidth();
        double screenHeight = stage.getHeight();

        double anchorPaneWidth = originalWidth; // Use originalWidth instead of root.getLayoutBounds().getWidth()
        double anchorPaneHeight = originalHeight; // Use originalHeight instead of root.getLayoutBounds().getHeight()

        double layoutX = (screenWidth - anchorPaneWidth) / 2;
        double layoutY = (screenHeight - anchorPaneHeight) / 2;

        root.setLayoutX(layoutX);
        root.setLayoutY(layoutY);

        // Set the preferred size of the root node to its original size
        root.resize(originalWidth, originalHeight);
    }




    public void onSlotMachineBTNClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SlotMachine.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    MediaPlayer mediaPlayer;
    public void music() {
        String s = "src/main/resources/background_musics/jazz.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        mediaPlayer = new MediaPlayer(h);

        // Add event handler for end of media
        mediaPlayer.setOnEndOfMedia(() -> {
            // Rewind the media to the beginning
            mediaPlayer.seek(Duration.ZERO);
            // Play the media again
            mediaPlayer.play();
        });

        mediaPlayer.play();
    }
    public void goDeposit(ActionEvent event) {
        try {
            // Load the FXML file
            Parent root = FXMLLoader.load(getClass().getResource("deposit.fxml"));

            // Create a new scene with the loaded FXML file
            Scene scene = new Scene(root);

            // Get the stage from the event source
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the scene on the primary stage
            primaryStage.setTitle("Transaction");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // Handle any IOException that occurs during loading
            e.printStackTrace();
            // You might want to show an error message to the user here
        }
    }

}