package no.ntnu.idatt2003.controller;

import no.ntnu.idatt2003.model.HandOfCards;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardGameControllerTest {

  @Test
  void dealHand() {
    CardGameController controller = new CardGameController();
    HandOfCards hand = controller.dealHand();
    assertNotNull(hand);
    assertTrue(!hand.getHand().isEmpty() && hand.getHand().size() <= 52);
  }

  @Test
  void calculateSum() {
    CardGameController controller = new CardGameController();
    HandOfCards hand = controller.dealHand();
    int sum = controller.calculateSum(hand);
    assertTrue(sum >= hand.getHand().size() && sum <= hand.getHand().size() * 14);
  }

  @Test
  void getHearts() {
    CardGameController controller = new CardGameController();
    HandOfCards hand = controller.dealHand();
    String hearts = controller.getHearts(hand);
    assertNotNull(hearts);
  }

  @Test
  void hasQueenOfSpades() {
    CardGameController controller = new CardGameController();
    HandOfCards hand = controller.dealHand();
    boolean hasQueenOfSpades = controller.hasQueenOfSpades(hand);
    assertNotNull(hasQueenOfSpades);
  }

  @Test
  void hasFlush() {
    CardGameController controller = new CardGameController();
    HandOfCards hand = controller.dealHand();
    boolean hasFlush = controller.hasFlush(hand);
    assertNotNull(hasFlush);
  }
}