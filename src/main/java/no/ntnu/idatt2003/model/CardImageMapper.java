package no.ntnu.idatt2003.model;

/**
 * This class is responsible for mapping a PlayingCard to its corresponding image file.
 *
 * @version 0.2.0
 * @author Snake727
 */
public class CardImageMapper {

  /**
   * Returns the path to the image file corresponding to the given card.
   *
   * @param card the card
   * @return the path to the image file
   */
  public String getImagePath(PlayingCard card) {
    String rank = String.valueOf(card.getFace());
    String suit = String.valueOf(card.getSuit()).toUpperCase();
    return "/" + rank + "_of_" + suit + ".png";
  }
}