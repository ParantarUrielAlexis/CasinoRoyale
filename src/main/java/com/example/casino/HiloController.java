package com.example.casino;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
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

    @FXML
    public Button betID;

    @FXML
    public Button btnSkip, btnCollect;

    @FXML
    public Text balanceID;
    @FXML
    public TextField inputBalance;

    @FXML
    public Text oddsHigh, oddsLow, balancePayout;

    public int cardNumber1;
    private double currentMultiplier;
    public int totalWinnings = 0;
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

        // Get the image file name for cardNumber1
        String imagePath1 = "/cards/" + cardImages[cardNumber1];
        // Get the image file name for cardNumber2
        String imagePath2 = "/cards/" + cardImages[cardNumber2];

        // Load images for each ImageView based on the card numbers
        try {
            // Load and set the image for cardRandomizer
            Image image1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath1)));

            cardRandomizer.setImage(image1);

            getMultiplier();
        } catch (NullPointerException e) {
            System.err.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void updateBalance() {
        // Get the user input from the inputBalance field
        String userInput = inputBalance.getText();

        // Parse the user input and deduct it from the current balanceID
        try {
            int deduction = Integer.parseInt(userInput);
            int currentBalance = Integer.parseInt(balanceID.getText());
            int newBalance = currentBalance - deduction;
            if (newBalance >= 0) {
                // Update the balanceID with the new balance
                balanceID.setText(String.valueOf(newBalance));
            } else {
                // Display an error message if the deduction exceeds the current balance
                System.out.println("Insufficient balance.");
            }
        } catch (NumberFormatException e) {
            // Handle invalid input
            System.err.println("Invalid input: " + userInput);
        }
    }



    public int playGame() {
        // Deduct the bet amount from the balance
        int betAmount = Integer.parseInt(inputBalance.getText()); // Get the bet amount from the input
        int currentBalance = Integer.parseInt(balanceID.getText()); // Get the current balance
        int newBalance = currentBalance - betAmount; // Calculate the new balance after deducting the bet
        if (newBalance >= 0) { // Ensure the balance is not negative
            balanceID.setText(String.valueOf(newBalance)); // Update the balance text
        } else {
            System.out.println("Insufficient balance."); // Display an error message if balance is insufficient
            return -1; // Return -1 to indicate insufficient balance
        }

        // Initialize the game
        initialized();
        // Enable/disable buttons as needed
        btnHigh.setDisable(false);
        btnLow.setDisable(false);
        btnSkip.setDisable(false);
        btnCollect.setDisable(false);

        betID.setDisable(true);
        getMultiplier();
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
            getMultiplier();
            showMultiplier();
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
            getMultiplier();
            showMultiplier();
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
            if ((isHigh && cardValue2 >= cardValue1) || (!isHigh && cardValue2 <= cardValue1)) {
                System.out.println("You win!");

                updateCardRandomizer();
                resetCard2AfterDelay();
            } else {
                System.out.println("You lose!");
                showCardForAMoment();
            }
        } else {
            System.err.println("Error: Card values not found for one or both cards.");
        }

        // Pause for 2 seconds before resetting cardRandomizer2
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1));
        pauseTransition.setOnFinished(event -> {

        });
        pauseTransition.play();
    }
    private void resetCard2AfterDelay() {
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1));
        pauseTransition.setOnFinished(event -> {
            resetCard2(); // Reset card 2 after 2 seconds
        });
        pauseTransition.play();
    }

    private void showCardForAMoment() {
        // Pause for 1 second before resetting the game
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1));
        pauseTransition.setOnFinished(event -> {
            resetCard2();
            resetGame();
        });
        pauseTransition.play();
        btnHigh.setDisable(true);
        btnLow.setDisable(true);
        btnSkip.setDisable(true);
        btnCollect.setDisable(true);
        betID.setDisable(false);
        resetBalancePayout();
    }
    public void updateCardRandomizer() {
        // Generate a new random card number for cardRandomizer (cardNumber1)
        cardNumber1 = new Random().nextInt(52);
        String imagePath1 = "/cards/" + cardImages[cardNumber1];

        // Load and set the image for cardRandomizer
        try {
            Image newImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath1)));
            cardRandomizer.setImage(newImage);
        } catch (NullPointerException e) {
            System.err.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }
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
    public void resetGame() {
        // Reset cardRandomizer to "back.jpg"
        try {
            InputStream inputStream = getClass().getResourceAsStream("/cards/back.jpg");
            if (inputStream != null) {
                Image backImage = new Image(inputStream);
                cardRandomizer.setImage(backImage);
            } else {
                System.err.println("Error: InputStream for back image is null.");
            }
        } catch (Exception e) {
            System.err.println("Error loading back image: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void skipCard(ActionEvent actionEvent) {
        initialized();
    }

    // Define instance variables to store current odds
    private double currentOddsHigh;
    private double currentOddsLow;

    public void getMultiplier(){
        int totalCards = 52;
        int currentCardVal = cardValuesMap.get(cardImages[cardNumber1]);

        int higherCards = 13 - currentCardVal; // Number of cards higher
        int lowerCards = currentCardVal - 1; // Number of cards lower

        // Calculate the probability of winning for High and Low bets
        double probabilityHigh = (double) higherCards / totalCards;
        double probabilityLow = (double) lowerCards / totalCards;

        // Adjust probabilities if the current card is an Ace
        if (currentCardVal == 1) {
            if (!btnLow.isDisabled()) {
                oddsLow.setText("0.89");
            }
            if (!btnHigh.isDisabled()) {
                oddsHigh.setText("13.21");
            }
        } else if(currentCardVal == 2){
            if(!btnLow.isDisabled()){
                oddsLow.setText("6.21");
            }
            if(!btnHigh.isDisabled()){
                oddsHigh.setText("1.01");
            }
        } else if(currentCardVal == 3){
            if(!btnLow.isDisabled()){
                oddsLow.setText("3.32");
            }
            if(!btnHigh.isDisabled()){
                oddsHigh.setText("1.01");
            }
        }else if(currentCardVal == 4){
            if(!btnLow.isDisabled()){
                oddsLow.setText("2.81");
            }
            if(!btnHigh.isDisabled()){
                oddsHigh.setText("1.31");
            }
        }else if(currentCardVal == 5){
            if(!btnLow.isDisabled()){
                oddsLow.setText("2.21");
            }
            if(!btnHigh.isDisabled()){
                oddsHigh.setText("1.42");
            }
        }else if(currentCardVal == 6){
            if(!btnLow.isDisabled()){
                oddsLow.setText("1.86");
            }
            if(!btnHigh.isDisabled()){
                oddsHigh.setText("1.91");
            }
        } else if(currentCardVal == 7){
            if(!btnLow.isDisabled()){
                oddsLow.setText("1.92");
            }
            if(!btnHigh.isDisabled()){
                oddsHigh.setText("2.03");
            }
        }else if(currentCardVal == 8){
            if(!btnLow.isDisabled()){
                oddsLow.setText("1.73");
            }
            if(!btnHigh.isDisabled()){
                oddsHigh.setText("2.26");
            }
        } else if(currentCardVal == 9){
            if(!btnLow.isDisabled()){
                oddsLow.setText("1.56");
            }
            if(!btnHigh.isDisabled()){
                oddsHigh.setText("2.53");
            }
        } else if(currentCardVal == 10){
            if(!btnLow.isDisabled()){
                oddsLow.setText("1.33");
            }
            if(!btnHigh.isDisabled()){
                oddsHigh.setText("2.72");
            }
        } else if(currentCardVal == 11){
            if(!btnLow.isDisabled()){
                oddsLow.setText("1.21");
            }
            if(!btnHigh.isDisabled()){
                oddsHigh.setText("3.32");
            }
        } else if(currentCardVal == 12){
            if(!btnLow.isDisabled()){
                oddsLow.setText("1.01");
            }
            if(!btnHigh.isDisabled()){
                oddsHigh.setText("6.31");
            }
        } else if(currentCardVal == 13){
            if(!btnLow.isDisabled()){
                oddsLow.setText("0.89");
            }
            if(!btnHigh.isDisabled()){
                oddsHigh.setText("13.31");
            }
        }
    }

    public void showMultiplier() {
        double multiplier;
        if (!btnHigh.isDisabled()) {
            multiplier = Double.parseDouble(oddsLow.getText()); // Use currentOddsLow for btnHigh
        } else {
            multiplier = Double.parseDouble(oddsHigh.getText()); // Use currentOddsHigh for btnLow
        }
        System.out.println(multiplier);
    }

    public void collectPayOut(MouseEvent actionEvent) {
        setPayout();

        showCardForAMoment();
        resetBalancePayout();
    }

    public void setPayout() {
        // Get the initial bet amount from the input field
        int betAmount = Integer.parseInt(inputBalance.getText());
        balancePayout.setText(String.valueOf(betAmount));

        int currentWin = Integer.parseInt(balancePayout.getText());
        System.out.println(currentWin);

        double multiplier;
        if(!btnHigh.isDisabled()){
            multiplier = Double.parseDouble(oddsHigh.getText());
        } else{
            multiplier = Double.parseDouble(oddsLow.getText());
        }
        int newCurrentWin = (int) (currentWin * multiplier);
        int payout = newCurrentWin - currentWin;

        System.out.println(payout);

    }
    public void updatePayout(){

    }




    public void resetBalancePayout(){
        balancePayout.setText(String.valueOf(0));
    }
}
