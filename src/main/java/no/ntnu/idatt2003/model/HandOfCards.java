package no.ntnu.idatt2003.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Represents a hand of cards. A hand of cards can have any number of cards.
 *
 * @version 1.0.0
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

  /**
   * Method for getting the number of cards in the hand.
   *
   * @return the number of cards in the hand
   */
  public int size() {
    return hand.size();
  }

  /**
   * Method for getting a card from the hand at a specific index.
   *
   * @param index the index of the card to get
   * @return the card at the specified index
   */
  public PlayingCard getCard(int index) {
    return hand.get(index);
  }

  /**
   * Method for calculating the sum of the face values of the cards in the hand.
   * It does this by using the mapToInt method to get the face value of each card
   * and then summing them up.
   *
   * @return the sum of the face values of the cards in the hand
   */
  public int calculateSum() {
    return hand.stream()
          .mapToInt(PlayingCard::getFace)
          .sum();
  }

  /**
   * Method for getting all the hearts in the hand.
   * It does this by filtering out all the hearts and then joining them together
   * in a single string.
   * If there are no hearts in the hand, it returns "No Hearts".
   *
   * @return a string containing all the hearts in the hand, separated with a space.
   */
  public String getHearts() {
    String hearts = hand.stream()
          .filter(card -> card.getSuit() == 'H')
          .map(PlayingCard::getAsString)
          .collect(Collectors.joining(" "));
    return hearts.isEmpty() ? "No Hearts" : hearts;
  }

  /**
   * Method for checking if the hand has the queen of spades.
   * It does this by using the anyMatch method to check if any of the cards
   * in the hand is the queen of spades.
   *
   * @return true if the hand has the queen of spades, false otherwise
   */
  public boolean hasQueenOfSpades() {
    return hand.stream()
          .anyMatch(card -> card.getSuit() == 'S' && card.getFace() == 12);
  }

  /**
   * Method for checking if the hand has a flush.
   * It does this by using the Collectors.groupingBy method to group the cards by suit
   * and then checking if any of the groups have 5 or more cards.
   *
   * @return true if the hand has a flush, false otherwise
   */
  public boolean hasFiveFlush() {
    Map<Character, Long> suitCounts = hand.stream()
          .collect(Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()));
    return suitCounts.values().stream()
          .anyMatch(count -> count >= 5L);
  }
}