package no.ntnu.idatt2003.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import no.ntnu.idatt2003.controller.CardGameController;
import no.ntnu.idatt2003.model.HandOfCards;

/**
 * This class creates and handles the GUI components of the game
 *
 * @version 0.1.0
 * @author Snake727
 */
public class CardGameView extends Application {
  private CardGameController controller;
  private HandOfCards hand;

  @Override
  public void start(Stage primaryStage) {
    controller = new CardGameController(this);
    hand = new HandOfCards(); // Initialize the hand of cards

    VBox root = new VBox(10);
    root.setPadding(new Insets(15, 20, 10, 10));

    // Reserved area for displaying card images
    HBox cardsDisplayArea = new HBox(5);
    cardsDisplayArea.setStyle("-fx-border-color: black; -fx-background-color: grey;");
    cardsDisplayArea.setPadding(new Insets(5));
    cardsDisplayArea.setPrefSize(300, 120); // Set the preferred size for the display area

    Button dealHandButton = new Button("Deal Hand");
    Button checkHandButton = new Button("Check Hand");

    // Add event handlers to the buttons
    dealHandButton.setOnAction(e -> controller.dealHand());
    checkHandButton.setOnAction(e -> controller.checkHand());

    // Display-only fields
    Label sumOfFacesLabel = new Label("Sum of the faces:");
    Label sumOfFacesValue = new Label(String.valueOf(controller.calculateSum(hand))); // Use the calculateSum method
    sumOfFacesValue.setMinWidth(50);
    sumOfFacesValue.setStyle("-fx-border-color: black; -fx-padding: 5;");

    Label cardsOfHeartsLabel = new Label("Cards of hearts:");
    Label cardsOfHeartsValue = new Label(controller.getHearts(hand)); // Use the getHearts method
    cardsOfHeartsValue.setMinWidth(120);
    cardsOfHeartsValue.setStyle("-fx-border-color: black; -fx-padding: 5;");

    Label flushLabel = new Label("Flush:");
    Label flushValue = new Label(controller.hasFlush(hand) ? "Yes" : "No"); // Use the hasFlush method
    flushValue.setMinWidth(50);
    flushValue.setStyle("-fx-border-color: black; -fx-padding: 5;");

    Label queenOfSpadesLabel = new Label("Queen of spades:");
    Label queenOfSpadesValue = new Label(controller.hasQueenOfSpades(hand) ? "Yes" : "No"); // Use the hasQueenOfSpades method
    queenOfSpadesValue.setMinWidth(50);
    queenOfSpadesValue.setStyle("-fx-border-color: black; -fx-padding: 5;");

    // Layout for status fields
    VBox statusFields = new VBox(5);
    statusFields.getChildren().addAll(
          new HBox(5, sumOfFacesLabel, sumOfFacesValue),
          new HBox(5, cardsOfHeartsLabel, cardsOfHeartsValue),
          new HBox(5, flushLabel, flushValue),
          new HBox(5, queenOfSpadesLabel, queenOfSpadesValue)
    );

    // Add all components to the root container
    root.getChildren().addAll(cardsDisplayArea, dealHandButton, checkHandButton, statusFields);

    Scene scene = new Scene(root);
    primaryStage.setTitle("Cardgame");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
