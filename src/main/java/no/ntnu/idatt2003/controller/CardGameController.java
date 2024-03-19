package no.ntnu.idatt2003.controller;

import no.ntnu.idatt2003.model.DeckOfCards;
import no.ntnu.idatt2003.model.HandOfCards;
import no.ntnu.idatt2003.view.CardGameView;

/**
 * This class is the controller for the card game
 *
 * @version 0.2.0
 * @author Snake727
 */

public class CardGameController {
  private DeckOfCards deck;
  private CardGameView view;

  public CardGameController(CardGameView view) {
    this.view = view;
    this.deck = new DeckOfCards();
  }

  public void dealHand() {
    // Deal a hand of cards and update the view
  }

  public void checkHand() {
    // Check the hand of cards and update the view
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
