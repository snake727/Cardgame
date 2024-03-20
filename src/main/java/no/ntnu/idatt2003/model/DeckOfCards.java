package no.ntnu.idatt2003.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * This class represents a deck of cards.
 *
 * @version 1.0.0
 * @author Snake727
 */

public class DeckOfCards {
  private static final char[] SUITS = {'S', 'H', 'D', 'C'};

  public static char[] getSuits() {
    return SUITS.clone();
  }

  private final List<PlayingCard> deck;
  private final Random random;

  /**
   * Constructor for the DeckOfCards class.
   * It initializes the deck with 52 cards, one of each suit and face value.
   */

  public DeckOfCards() {
    deck = new ArrayList<>();
    random = new Random();
    for (char suit : SUITS) {
      for (int j = 1; j <= 13; j++) {
        PlayingCard card = new PlayingCard(suit, j);
        deck.add(card);
      }
    }
  }

  /**
   * Returns the deck of cards.
   */
  public List<PlayingCard> getDeck() {
    return Collections.unmodifiableList(deck);
  }

  /**
   * Deals a new hand of cards with a minimum of 5 cards.
   * The number of cards in the hand is specified by the parameter n.
   *
   * @param n the number of cards in the hand
   *          Must be a number between 5 and 52
   * @return a hand of cards with n cards
   * @throws IllegalArgumentException if n is not between 5 and 52
   * @throws IllegalStateException if the deck is empty
   */
  public HandOfCards dealHand(int n) {
    if (n < 5 || n > 52) {
      throw new IllegalArgumentException("Parameter n must be a number between 5 to 52");
    }

    if (deck.isEmpty()) {
      throw new IllegalStateException("Deck is empty, cannot deal card");
    }

    HandOfCards hand = new HandOfCards();

    for (int i = n - 1; i >= 0; i--) {
      int index = random.nextInt(deck.size());
      PlayingCard card = deck.remove(index);
      hand.addCard(card);
    }

    return hand;
  }
}