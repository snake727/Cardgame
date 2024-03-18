package no.ntnu.idatt2003.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a deck of cards. A deck of cards has 52 cards, 13 of each suit.
 *
 * @version 0.2.0
 * @author Snake727
 */
public class DeckOfCards {
  private final char[] suit = {'S', 'H', 'D', 'C'};
  private final List<PlayingCard> deck;
  private final Random random;

  public DeckOfCards() {
    deck = new ArrayList<>();
    random = new Random();
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

  public HandOfCards dealHand(int n) {
    if (n < 1 || n > 52) {
      throw new IllegalArgumentException("Parameter n must be a number between 1 to 52");
    }

    HandOfCards hand = new HandOfCards();

    for (int i = 0; i < n; i++) {
      if (!deck.isEmpty()) {
        int index = random.nextInt(deck.size());
        PlayingCard card = deck.remove(index);
        hand.addCard(card);
      } else {
        throw new IllegalStateException("Deck is empty, cannot deal card");
      }
    }

    return hand;
  }
}