package com.example.casino;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class HiloController {

    @FXML
    public ImageView cardRandomizer;
    @FXML
    public ImageView cardRandomizer2;
    @FXML
    public Button btnHigh;
    @FXML
    public Button btnLow;

    public int cardNumber1;

    public static final String[] cardImages = {
            "ace_of_spades.png", "ace_of_hearts.png", "ace_of_clubs.png", "ace_of_diamonds.png",
            "2_of_clubs.png", "2_of_diamonds.png", "2_of_spades.png", "2_of_hearts.png",
            "3_of_clubs.png", "3_of_diamonds.png", "3_of_spades.png", "3_of_hearts.png",
            "4_of_clubs.png", "4_of_diamonds.png", "4_of_spades.png", "4_of_hearts.png",
            "5_of_clubs.png", "5_of_diamonds.png", "5_of_spades.png", "5_of_hearts.png",
            "6_of_clubs.png", "6_of_diamonds.png", "6_of_spades.png", "6_of_hearts.png",
            "7_of_clubs.png", "7_of_diamonds.png", "7_of_spades.png", "7_of_hearts.png",
            "8_of_clubs.png", "8_of_diamonds.png", "8_of_spades.png", "8_of_hearts.png",
            "9_of_clubs.png", "9_of_diamonds.png", "9_of_spades.png", "9_of_hearts.png",
            "10_of_clubs.png", "10_of_diamonds.png", "10_of_spades.png", "10_of_hearts.png",
            "jack_of_clubs.png", "jack_of_diamonds.png", "jack_of_spades.png", "jack_of_hearts.png",
            "queen_of_clubs.png", "queen_of_diamonds.png", "queen_of_spades.png", "queen_of_hearts.png",
            "king_of_clubs.png", "king_of_diamonds.png", "king_of_spades.png", "king_of_hearts.png",
    };

    // Map to store card values
    public static final Map<String, Integer> cardValuesMap = new HashMap<>();

    static {
        cardValuesMap.put("ace_of_spades.png", 1);
        cardValuesMap.put("ace_of_hearts.png", 1);
        cardValuesMap.put("ace_of_clubs.png", 1);
        cardValuesMap.put("ace_of_diamonds.png", 1);

        cardValuesMap.put("2_of_clubs.png", 2);
        cardValuesMap.put("2_of_diamonds.png", 2);
        cardValuesMap.put("2_of_spades.png", 2);
        cardValuesMap.put("2_of_hearts.png", 2);

        cardValuesMap.put("3_of_clubs.png", 3);
        cardValuesMap.put("3_of_diamonds.png", 3);
        cardValuesMap.put("3_of_spades.png", 3);
        cardValuesMap.put("3_of_hearts.png", 3);

        cardValuesMap.put("4_of_clubs.png", 4);
        cardValuesMap.put("4_of_diamonds.png", 4);
        cardValuesMap.put("4_of_spades.png", 4);
        cardValuesMap.put("4_of_hearts.png", 4);

        cardValuesMap.put("5_of_clubs.png", 5);
        cardValuesMap.put("5_of_diamonds.png", 5);
        cardValuesMap.put("5_of_spades.png", 5);
        cardValuesMap.put("5_of_hearts.png", 5);

        cardValuesMap.put("6_of_clubs.png", 6);
        cardValuesMap.put("6_of_diamonds.png", 6);
        cardValuesMap.put("6_of_spades.png", 6);
        cardValuesMap.put("6_of_hearts.png", 6);

        cardValuesMap.put("7_of_clubs.png", 7);
        cardValuesMap.put("7_of_diamonds.png", 7);
        cardValuesMap.put("7_of_spades.png", 7);
        cardValuesMap.put("7_of_hearts.png", 7);

        cardValuesMap.put("8_of_clubs.png", 8);
        cardValuesMap.put("8_of_diamonds.png", 8);
        cardValuesMap.put("8_of_spades.png", 8);
        cardValuesMap.put("8_of_hearts.png", 8);

        cardValuesMap.put("9_of_clubs.png", 9);
        cardValuesMap.put("9_of_diamonds.png", 9);
        cardValuesMap.put("9_of_spades.png", 9);
        cardValuesMap.put("9_of_hearts.png", 9);

        cardValuesMap.put("10_of_clubs.png", 10);
        cardValuesMap.put("10_of_diamonds.png", 10);
        cardValuesMap.put("10_of_spades.png", 10);
        cardValuesMap.put("10_of_hearts.png", 10);


        // Add mappings for other numeric cards
        // ...
        cardValuesMap.put("jack_of_clubs.png", 11);
        cardValuesMap.put("jack_of_diamonds.png", 11);
        cardValuesMap.put("jack_of_spades.png", 11);
        cardValuesMap.put("jack_of_hearts.png", 11);
        cardValuesMap.put("queen_of_clubs.png", 12);
        cardValuesMap.put("queen_of_diamonds.png", 12);
        cardValuesMap.put("queen_of_spades.png", 12);
        cardValuesMap.put("queen_of_hearts.png", 12);
        cardValuesMap.put("king_of_clubs.png", 13);
        cardValuesMap.put("king_of_diamonds.png", 13);
        cardValuesMap.put("king_of_spades.png", 13);
        cardValuesMap.put("king_of_hearts.png", 13);
    }



    // Your existing code...

    public void initialized() {
        // Generate random card numbers for each ImageView
        cardNumber1 = new Random().nextInt(52); // 0 to 51
        int cardNumber2 = new Random().nextInt(52);

        // Load images for each ImageView based on the card numbers
        String imagePath1 = "/cards/" + cardImages[cardNumber1];
        String imagePath2 = "/cards/" + cardImages[cardNumber2];

        // Load images and set them to the ImageViews
        try {
            cardRandomizer.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath1))));
        } catch (NullPointerException e) {
            System.err.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public int playGame() {
        // Return the stored card number
        initialized();
        return cardNumber1;
    }

    public void btnHighClicked(MouseEvent actionEvent) {
        // Generate random card number for cardNumber2
        int cardNumber2 = new Random().nextInt(52); // 0 to 51

        // Load image for cardRandomizer2 based on the card number
        String imagePath2 = "/cards/" + cardImages[cardNumber2];

        // Load image and set it to cardRandomizer2
        try {
            Image image2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath2)));
            cardRandomizer2.setImage(image2);

            // Compare the cards and print the result based on user's guess (High)
            compareCards(cardNumber1, cardNumber2, true); // Pass cardNumber2 and the guess (High)
        } catch (NullPointerException e) {
            System.err.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void btnLowClicked(MouseEvent actionEvent) {
        // Generate random card number for cardNumber2
        int cardNumber2 = new Random().nextInt(52); // 0 to 51

        // Load image for cardRandomizer2 based on the card number
        String imagePath2 = "/cards/" + cardImages[cardNumber2];

        // Load image and set it to cardRandomizer2
        try {
            Image image2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath2)));
            cardRandomizer2.setImage(image2);

            // Compare the cards and print the result based on user's guess (Low)
            compareCards(cardNumber1, cardNumber2, false); // Pass cardNumber2 and the guess (Low)
        } catch (NullPointerException e) {
            System.err.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }
    }





    public void compareCards(int cardNumber1, int cardNumber2, boolean isHigh) {
        // Get the image file name for cardNumber2
        String imageFileName2 = cardImages[cardNumber2];
        // Get the image file name for cardNumber1
        String imageFileName1 = cardImages[cardNumber1];

        // Get the card value from the map for cardNumber2
        Integer cardValue2 = cardValuesMap.get(imageFileName2);
        // Get the card value from the map for cardNumber1
        Integer cardValue1 = cardValuesMap.get(imageFileName1);

        // Check if the card values are null
        if (cardValue1 != null && cardValue2 != null) {
            // Print the result based on user's guess (High or Low)
            if ((isHigh && cardValue2 > cardValue1) || (!isHigh && cardValue2 < cardValue1)) {
                System.out.println("You win!");
            } else {
                System.out.println("You lose!");
            }
        } else {
            System.err.println("Error: Card values not found for one or both cards.");
        }

        // Pause for 2 seconds before resetting cardRandomizer2
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(2));
        pauseTransition.setOnFinished(event -> {
            resetCard2();
            flipCardRandomizer();
        });
        pauseTransition.play();
    }




    public void resetCard2() {
        try {
            // Load the back image for cardRandomizer2
            InputStream inputStream = getClass().getResourceAsStream("/cards/back.jpg");
            if (inputStream != null) {
                Image backImage = new Image(inputStream);
                cardRandomizer2.setImage(backImage);
            } else {
                System.err.println("Error: InputStream for back image is null.");
            }
        } catch (Exception e) {
            System.err.println("Error loading back image: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void flipCardRandomizer() {
        try {
            // Pause for 1 second before flipping cardRandomizer
            PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1));
            pauseTransition.setOnFinished(event -> {
                // Generate a new random card number for cardRandomizer
                int newCardNumber = new Random().nextInt(52);
                String newImagePath = "/cards/" + cardImages[newCardNumber];

                // Load and set the image for cardRandomizer
                try {
                    Image newImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(newImagePath)));
                    cardRandomizer.setImage(newImage);
                } catch (NullPointerException e) {
                    System.err.println("Error loading image: " + e.getMessage());
                    e.printStackTrace();
                }
            });
            pauseTransition.play();
        } catch (Exception e) {
            System.err.println("Error flipping cardRandomizer: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
