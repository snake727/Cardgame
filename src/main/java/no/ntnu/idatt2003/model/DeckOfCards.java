package no.ntnu.idatt2003.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a deck of cards. A deck of cards has 52 cards, 13 of each suit.
 *
 * @version 0.1.0
 * @author Snake727
 */
public class DeckOfCards {
  private final char[] suit = {'S', 'H', 'D', 'C'};
  private final List<PlayingCard> deck;

  public DeckOfCards() {
    deck = new ArrayList<>();
    // Create 52 cards
    for (char s : suit) {
      for (int j = 1; j <= 13; j++) {
        PlayingCard card = new PlayingCard(s, j);
        deck.add(card);
      }
    }
  }

  public List<PlayingCard> getDeck() {
    return deck;
  }
}
