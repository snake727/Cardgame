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
}
