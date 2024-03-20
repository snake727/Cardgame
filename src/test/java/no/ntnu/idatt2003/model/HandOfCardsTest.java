package no.ntnu.idatt2003.model;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

public class HandOfCardsTest {
    // ...

    @org.junit.jupiter.api.Test
    void addCard() {
        HandOfCards hand = new HandOfCards();
        PlayingCard card = new PlayingCard('S', 1);
        hand.addCard(card);
        assertTrue(hand.getHand().contains(card));
    }

    @org.junit.jupiter.api.Test
    void removeCard() {
        HandOfCards hand = new HandOfCards();
        PlayingCard card = new PlayingCard('S', 1);
        hand.addCard(card);
        hand.removeCard(card);
        assertFalse(hand.getHand().contains(card));
    }

    @org.junit.jupiter.api.Test
    void getHand() {
        HandOfCards hand = new HandOfCards();
        PlayingCard card = new PlayingCard('S', 1);
        hand.addCard(card);
        assertEquals(1, hand.getHand().size());
        assertTrue(hand.getHand().contains(card));
    }

    @org.junit.jupiter.api.Test
    void hasQueenOfSpades() {
        HandOfCards hand = new HandOfCards();
        PlayingCard card = new PlayingCard('S', 12);
        hand.addCard(card);
        assertTrue(hand.hasQueenOfSpades());
    }

    @org.junit.jupiter.api.Test
    void doesNotHaveQueenOfSpades() {
        HandOfCards hand = new HandOfCards();
        PlayingCard card = new PlayingCard('S', 1);
        hand.addCard(card);
        assertFalse(hand.hasQueenOfSpades());
    }

    // Check the hasQueenOfSpades method with every single card except the queen of spades
    @org.junit.jupiter.api.Test
    void hasQueenOfSpadesAllButOne() {
        HandOfCards hand = new HandOfCards();
        for (int i = 1; i <= 13; i++) {
            if (i != 12) {
                PlayingCard card = new PlayingCard('S', i);
                hand.addCard(card);
            }
        }
        assertFalse(hand.hasQueenOfSpades());
    }

    // Check the hasQueenOfSpades with several random hands of cards using Random class and dealHand method
    @org.junit.jupiter.api.Test
    void hasQueenOfSpadesRandom() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            DeckOfCards deck = new DeckOfCards();
            HandOfCards hand = deck.dealHand(5);
            if (hand.getHand().contains(new PlayingCard('S', 12))) {
                assertTrue(hand.hasQueenOfSpades());
            } else {
                assertFalse(hand.hasQueenOfSpades());
            }
        }
    }

    @org.junit.jupiter.api.Test
    void hasFiveFlush() {
        HandOfCards hand = new HandOfCards();
        hand.addCard(new PlayingCard('S', 1));
        hand.addCard(new PlayingCard('S', 2));
        hand.addCard(new PlayingCard('S', 3));
        hand.addCard(new PlayingCard('S', 4));
        hand.addCard(new PlayingCard('S', 5));
        assertTrue(hand.hasFiveFlush());
    }
}