package no.ntnu.idatt2003.model;

import static org.junit.jupiter.api.Assertions.*;

public class DeckOfCardsTest {
    @org.junit.jupiter.api.Test
    void getDeck() {
        DeckOfCards deck = new DeckOfCards();
        assertEquals(52, deck.getDeck().size());
    }

    @org.junit.jupiter.api.Test
    void dealHand() {
        DeckOfCards deck = new DeckOfCards();
        HandOfCards hand = deck.dealHand(5);
        assertEquals(5, hand.getHand().size());
        assertEquals(47, deck.getDeck().size());
    }


    @org.junit.jupiter.api.Test
    void dealHandInvalidParameter() {
        DeckOfCards deck = new DeckOfCards();
        assertThrows(IllegalArgumentException.class, () -> deck.dealHand(0));
        assertThrows(IllegalArgumentException.class, () -> deck.dealHand(53));
    }

    @org.junit.jupiter.api.Test
    void dealHandAllCards() {
        DeckOfCards deck = new DeckOfCards();
        HandOfCards hand = deck.dealHand(52);
        assertEquals(0, deck.getDeck().size());
    }

    @org.junit.jupiter.api.Test
    void dealHandUniqueCards() {
        DeckOfCards deck = new DeckOfCards();
        HandOfCards hand = deck.dealHand(5);
        assertEquals(5, hand.getHand().stream().distinct().count());
    }

    @org.junit.jupiter.api.Test
    void dealHandRandomCards() {
        DeckOfCards deck1 = new DeckOfCards();
        DeckOfCards deck2 = new DeckOfCards();
        HandOfCards hand1 = deck1.dealHand(5);
        HandOfCards hand2 = deck2.dealHand(5);
        assertNotEquals(hand1, hand2);
    }

    @org.junit.jupiter.api.Test
    void constructorCorrectDeck() {
        DeckOfCards deck = new DeckOfCards();
        for (char suit : DeckOfCards.getSuits()) {
            assertEquals(13, deck.getDeck().stream().filter(card -> card.getSuit() == suit).count());
        }
        for (int i = 1; i <= 13; i++) {
            final int face = i;
            assertEquals(4, deck.getDeck().stream().filter(card -> card.getFace() == face).count());
        }
    }
}
