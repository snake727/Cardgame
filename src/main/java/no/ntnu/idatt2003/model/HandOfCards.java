package no.ntnu.idatt2003.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a hand of cards. A hand of cards can have any number of cards.
 *
 * @version 0.1.0
 * @author Snake727
 */
public class HandOfCards {
  private final List<PlayingCard> hand;

  public HandOfCards() {
    hand = new ArrayList<>();
  }

  public void addCard(PlayingCard card) {
    hand.add(card);
  }

  public void removeCard(PlayingCard card) {
    hand.remove(card);
  }

  public List<PlayingCard> getHand() {
    return hand;
  }
}