package no.ntnu.idatt2003.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class HandOfCardsTest {
    @org.junit.jupiter.api.Test
    void addCard() {
        HandOfCards hand = new HandOfCards();
        PlayingCard card = new PlayingCard('S', 1);
        hand.addCard(card);
        assertEquals(1, hand.getHand().size());
    }

    @org.junit.jupiter.api.Test
    void removeCard() {
        HandOfCards hand = new HandOfCards();
        PlayingCard card = new PlayingCard('S', 1);
        hand.addCard(card);
        hand.removeCard(card);
        assertEquals(0, hand.getHand().size());
    }

    @org.junit.jupiter.api.Test
    void getHand() {
        HandOfCards hand = new HandOfCards();
        PlayingCard card = new PlayingCard('S', 1);
        hand.addCard(card);
        assertEquals(1, hand.getHand().size());
    }

    @org.junit.jupiter.api.Test
    void calculateSum() {
        HandOfCards hand = new HandOfCards();
        PlayingCard card1 = new PlayingCard('S', 1);
        PlayingCard card2 = new PlayingCard('H', 2);
        hand.addCard(card1);
        hand.addCard(card2);
        assertEquals(3, hand.calculateSum());
    }

    @org.junit.jupiter.api.Test
    void getHearts() {
        HandOfCards hand = new HandOfCards();
        PlayingCard card1 = new PlayingCard('S', 1);
        PlayingCard card2 = new PlayingCard('H', 2);
        hand.addCard(card1);
        hand.addCard(card2);
        assertEquals("H2", hand.getHearts());
    }

    @org.junit.jupiter.api.Test
    void hasQueenOfSpades() {
        HandOfCards hand = new HandOfCards();
        PlayingCard card1 = new PlayingCard('S', 1);
        PlayingCard card2 = new PlayingCard('S', 12);
        hand.addCard(card1);
        hand.addCard(card2);
        assertTrue(hand.hasQueenOfSpades());
    }

    @org.junit.jupiter.api.Test
    void hasFiveFlush() {
      HandOfCards hand = new HandOfCards();
      PlayingCard card1 = new PlayingCard('S', 1);
      PlayingCard card2 = new PlayingCard('S', 2);
      PlayingCard card3 = new PlayingCard('S', 3);
      PlayingCard card4 = new PlayingCard('S', 4);
      PlayingCard card5 = new PlayingCard('S', 5);
      hand.addCard(card1);
      hand.addCard(card2);
      hand.addCard(card3);
      hand.addCard(card4);
      hand.addCard(card5);
      assertTrue(hand.hasFiveFlush());
    }
}
