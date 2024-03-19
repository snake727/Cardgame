package no.ntnu.idatt2003.model;

import static org.junit.jupiter.api.Assertions.*;
public class PlayingCardTest {
    @org.junit.jupiter.api.Test
    void getSuit() {
        PlayingCard card = new PlayingCard('S', 1);
        assertEquals('S', card.getSuit());
    }

    @org.junit.jupiter.api.Test
    void getFace() {
        PlayingCard card = new PlayingCard('S', 1);
        assertEquals(1, card.getFace());
    }

    @org.junit.jupiter.api.Test
    void getAsString() {
        PlayingCard card = new PlayingCard('S', 1);
        assertEquals("S1", card.getAsString());
    }
}
