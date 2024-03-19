package no.ntnu.idatt2003.model;

/**
 * This class is responsible for mapping a PlayingCard to its corresponding image file.
 *
 * @version 0.1.0
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
    String rank;
    switch (card.getRank()) {
      case 1:
        rank = "ace";
        break;
      case 11:
        rank = "jack";
        break;
      case 12:
        rank = "queen";
        break;
      case 13:
        rank = "king";
        break;
      default:
        rank = String.valueOf(card.getRank());
    }
    return "/" + rank + "_of_" + card.getSuit().toLowerCase() + ".png";
  }
}