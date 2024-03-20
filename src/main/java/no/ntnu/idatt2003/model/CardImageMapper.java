package no.ntnu.idatt2003.model;

/**
 * This class is responsible for mapping a PlayingCard to its corresponding image file.
 *
 * @version 1.0.0
 * @author Snake727
 */
public class CardImageMapper {

  /**
   * Returns the path to the image file corresponding to the given card.
   * It does this by using the face and suit of the card to create the path
   * to the image file represented in a string.
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