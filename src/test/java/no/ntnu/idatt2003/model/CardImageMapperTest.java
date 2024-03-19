package no.ntnu.idatt2003.model;

import static org.junit.jupiter.api.Assertions.*;
import no.ntnu.idatt2003.model.CardImageMapper;
public class CardImageMapperTest {
    @org.junit.jupiter.api.Test
    void getImagePath() {
        CardImageMapper mapper = new CardImageMapper();
        assertEquals("/2_of_C.png", mapper.getImagePath(new PlayingCard('C', 2)));
    }

    @org.junit.jupiter.api.Test
    void getImagePath2() {
        CardImageMapper mapper = new CardImageMapper();
        assertEquals("/3_of_D.png", mapper.getImagePath(new PlayingCard('D', 3)));
    }
}
