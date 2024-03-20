package no.ntnu.idatt2003.controller;

import java.util.Random;
import no.ntnu.idatt2003.model.DeckOfCards;
import no.ntnu.idatt2003.model.HandOfCards;

/**
 * This class is the controller for the card game.
 * It handles the required operations for the GUI to function properly.
 *
 * @version 0.6.0
 * @author Snake727
 */

public class CardGameController {
  private DeckOfCards deck;
  Random random = new Random();

  public CardGameController() {
    this.deck = new DeckOfCards();
  }

  /**
   * Method for dealing a hand of cards anywhere between 5 and 52 cards.
   * Here the random class is used with additional logic in the randomValue
   * variable in order to ensure there are always at least 5 cards in a hand.
   *
   * @return a hand of cards from 5 to 52 cards
   */
  public HandOfCards dealHand() {
    deck = new DeckOfCards();
    int randomValue = random.nextInt(52 - 5 + 1) + 5;
    return deck.dealHand(randomValue);
  }

  // Method for calculating sum
  public int calculateSum(HandOfCards hand) {
    return hand.calculateSum();
  }

  // Method for getting hearts
  public String getHearts(HandOfCards hand) {
    return hand.getHearts();
  }

  // Method for checking if the hand has the queen of spades
  public boolean hasQueenOfSpades(HandOfCards hand) {
    return hand.hasQueenOfSpades();
  }

  // Method for checking if the hand has a flush
  public boolean hasFlush(HandOfCards hand) {
    return hand.hasFiveFlush();
  }

}
