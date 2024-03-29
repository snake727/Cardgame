package no.ntnu.idatt2003.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import no.ntnu.idatt2003.controller.CardGameController;
import no.ntnu.idatt2003.controller.CardGameImageController;
import no.ntnu.idatt2003.model.HandOfCards;

/**.
 * This class creates and handles the GUI components of the game
 *
 * @version 1.0.0
 * @author Snake727
 */

public class CardGameView extends Application {
  HandOfCards hand = new HandOfCards();
  CardGameController controller = new CardGameController();
  CardGameImageController imageController = new CardGameImageController();
  @Override
  public void start(Stage primaryStage) {
    // Declare the necessary variables
    controller = new CardGameController();
    imageController = new CardGameImageController();
    hand = new HandOfCards(); // Initialize the hand of cards

    // Set the minimum size of the display area
    primaryStage.setMinWidth(1080);
    primaryStage.setMinHeight(720);

    // Create the root container
    VBox root = new VBox(10);
    root.setPadding(new Insets(15, 20, 10, 10));
    root.setStyle("-fx-background-color: black;");

    // Create the display area for the cards
    FlowPane cardsDisplayArea = new FlowPane(5, 5);
    cardsDisplayArea.setStyle("-fx-border-color: black; -fx-background-color: grey;");
    cardsDisplayArea.setPadding(new Insets(5));
    cardsDisplayArea.setPrefSize(300, 120); // Set the preferred size for the display area

    // Display style for status fields
    String statusStyle = "-fx-border-color: black; -fx-padding: 5;";

    // Display-only fields
    Label sumOfFacesValue =
        new Label(String.valueOf(controller.calculateSum(hand))); // Use the calculateSum method
    sumOfFacesValue.setMinWidth(50);
    sumOfFacesValue.setStyle(statusStyle);

    Label cardsOfHeartsValue = new Label(controller.getHearts(hand)); // Use the getHearts method
    cardsOfHeartsValue.setMinWidth(120);
    cardsOfHeartsValue.setStyle(statusStyle);

    Label flushValue =
        new Label(controller.hasFlush(hand) ? "Yes" : "No"); // Use the hasFlush method
    flushValue.setMinWidth(50);
    flushValue.setStyle(statusStyle);

    Label queenOfSpadesValue =
        new Label(controller.hasQueenOfSpades(hand) ? "Yes" : "No");
    queenOfSpadesValue.setMinWidth(50);
    queenOfSpadesValue.setStyle(statusStyle);

    // Create the status fields
    Label sumOfFacesLabel = new Label("Sum of the faces:");
    Label cardsOfHeartsLabel = new Label("Cards of hearts:");
    Label flushLabel = new Label("Flush:");
    Label queenOfSpadesLabel = new Label("Queen of spades:");

    // Layout for status fields
    VBox statusFields = new VBox(5);
    statusFields.getChildren().addAll(
          new HBox(5, sumOfFacesLabel, sumOfFacesValue),
          new HBox(5, cardsOfHeartsLabel, cardsOfHeartsValue),
          new HBox(5, flushLabel, flushValue),
          new HBox(5, queenOfSpadesLabel, queenOfSpadesValue)
    );

    // Set the text color for the status description fields
    String statusDescriptionStyle = "-fx-text-fill: white;";
    sumOfFacesLabel.setStyle(statusDescriptionStyle);
    cardsOfHeartsLabel.setStyle(statusDescriptionStyle);
    flushLabel.setStyle(statusDescriptionStyle);
    queenOfSpadesLabel.setStyle(statusDescriptionStyle);

    // Set the background color for the status info fields
    String statusInfoBackgroundStyle = "-fx-background-color: white; -fx-border-color: black; -fx-padding: 5;";
    sumOfFacesValue.setStyle(
        statusInfoBackgroundStyle);
    cardsOfHeartsValue.setStyle(
        statusInfoBackgroundStyle);
    flushValue.setStyle(statusInfoBackgroundStyle);
    queenOfSpadesValue.setStyle(
        statusInfoBackgroundStyle);

    // Initialize the status fields with default values
    sumOfFacesValue.setText("0");
    cardsOfHeartsValue.setText("No Hearts");
    flushValue.setText("No");
    queenOfSpadesValue.setText("No");

    // Creates the buttons
    Button dealHandButton = new Button("Deal Hand");
    Button checkHandButton = new Button("Check Hand");

    // Set the event handlers for the check hand button
    checkHandButton.setOnAction(e -> {
      // Call the methods on the HandOfCards object and update the labels
      sumOfFacesValue.setText(String.valueOf(controller.calculateSum(hand)));
      cardsOfHeartsValue.setText(controller.getHearts(hand));
      flushValue.setText(controller.hasFlush(hand) ? "Yes" : "No");
      queenOfSpadesValue.setText(controller.hasQueenOfSpades(hand) ? "Yes" : "No");
    });

    // Set the event handler for the deal hand button
    dealHandButton.setOnAction(e -> {
      // Clear the display area
      cardsDisplayArea.getChildren().clear();

      // Generate a new hand of cards
      hand = controller.dealHand();

      // Load and display images for each card in the hand
      ImageView[] cardImages = imageController.getHandImageViews(hand);
      for (ImageView cardImage : cardImages) {
        cardImage.setFitWidth(70);
        cardImage.setFitHeight(100);
        cardsDisplayArea.getChildren().add(cardImage);
      }

      // Reset the status fields
      sumOfFacesValue.setText("0");
      cardsOfHeartsValue.setText("");
      flushValue.setText("No");
      queenOfSpadesValue.setText("No");
    });

    // Add all components to the root container
    root.getChildren().addAll(cardsDisplayArea, dealHandButton, checkHandButton, statusFields);

    // Create the scene and set it to the stage
    Scene scene = new Scene(root);
    primaryStage.setTitle("Cardgame");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
