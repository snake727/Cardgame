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

    // Check the getFace method for every face value for every suit
    @org.junit.jupiter.api.Test
    void getFaceAllValues() {
        for (int i = 1; i <= 13; i++) {
            PlayingCard card = new PlayingCard('S', i);
            assertEquals(i, card.getFace());
        }
        for (int i = 1; i <= 13; i++) {
            PlayingCard card = new PlayingCard('H', i);
            assertEquals(i, card.getFace());
        }
        for (int i = 1; i <= 13; i++) {
            PlayingCard card = new PlayingCard('D', i);
            assertEquals(i, card.getFace());
        }
        for (int i = 1; i <= 13; i++) {
            PlayingCard card = new PlayingCard('C', i);
            assertEquals(i, card.getFace());
        }
    }

    @org.junit.jupiter.api.Test
    void getAsString() {
        PlayingCard card = new PlayingCard('S', 1);
        assertEquals("S1", card.getAsString());
    }

    @org.junit.jupiter.api.Test
    void constructorInvalidSuit() {
        assertThrows(IllegalArgumentException.class, () -> new PlayingCard('X', 1));
    }

    @org.junit.jupiter.api.Test
    void constructorInvalidFace() {
        assertThrows(IllegalArgumentException.class, () -> new PlayingCard('S', 14));
    }

    @org.junit.jupiter.api.Test
    void equals() {
        PlayingCard card1 = new PlayingCard('S', 1);
        PlayingCard card2 = new PlayingCard('S', 1);
        PlayingCard card3 = new PlayingCard('H', 1);
        PlayingCard card4 = new PlayingCard('S', 2);

        assertEquals(card1, card2);
        assertNotEquals(card1, card3);
        assertNotEquals(card1, card4);
    }
}
