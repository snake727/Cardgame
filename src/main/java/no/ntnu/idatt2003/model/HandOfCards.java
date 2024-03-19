package no.ntnu.idatt2003.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Represents a hand of cards. A hand of cards can have any number of cards.
 *
 * @version 0.3.0
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

  public int size() {
    return hand.size();
  }

  public PlayingCard getCard(int index) {
    return hand.get(index);
  }

  public int calculateSum() {
    return hand.stream()
          .mapToInt(PlayingCard::getFace)
          .sum();
  }

  public String getHearts() {
    String hearts = hand.stream()
          .filter(card -> card.getSuit() == 'H')
          .map(PlayingCard::getAsString)
          .collect(Collectors.joining(" "));
    return hearts.isEmpty() ? "No Hearts" : hearts;
  }

  public boolean hasQueenOfSpades() {
    return hand.stream()
          .anyMatch(card -> card.getSuit() == 'S' && card.getFace() == 12);
  }

  public boolean hasFiveFlush() {
    Map<Character, Long> suitCounts = hand.stream()
          .collect(Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()));
    return suitCounts.values().stream()
          .anyMatch(count -> count >= 5L);
  }
}