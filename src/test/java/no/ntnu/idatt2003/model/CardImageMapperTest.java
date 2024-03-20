package no.ntnu.idatt2003.model;

import static org.junit.jupiter.api.Assertions.*;

public class CardImageMapperTest {
    // Test that loops through all possible cards and checks if the image path is correct
    @org.junit.jupiter.api.Test
    void getImagePath() {
        CardImageMapper mapper = new CardImageMapper();
        for (int i = 1; i <= 13; i++) {
            PlayingCard card = new PlayingCard('S', i);
            String path = mapper.getImagePath(card);
            assertEquals("/" + i + "_of_S.png", path);
        }
        for (int i = 1; i <= 13; i++) {
            PlayingCard card = new PlayingCard('H', i);
            String path = mapper.getImagePath(card);
            assertEquals("/" + i + "_of_H.png", path);
        }
        for (int i = 1; i <= 13; i++) {
            PlayingCard card = new PlayingCard('D', i);
            String path = mapper.getImagePath(card);
            assertEquals("/" + i + "_of_D.png", path);
        }
        for (int i = 1; i <= 13; i++) {
            PlayingCard card = new PlayingCard('C', i);
            String path = mapper.getImagePath(card);
            assertEquals("/" + i + "_of_C.png", path);
        }
    }

}
