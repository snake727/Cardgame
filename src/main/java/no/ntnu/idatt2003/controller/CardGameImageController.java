package no.ntnu.idatt2003.controller;

import java.util.Objects;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import no.ntnu.idatt2003.model.CardImageMapper;
import no.ntnu.idatt2003.model.HandOfCards;
import no.ntnu.idatt2003.model.PlayingCard;

/**
 * This class is responsible for enabling the usage of card images in the frontend.
 *
 * @version 1.0.0
 * @author Snake727
 */
public class CardGameImageController {
  private final CardImageMapper mapper;

  public CardGameImageController() {
    this.mapper = new CardImageMapper();
  }

  /**.
   * This method returns an ImageView of the given card.
   * It does so by using the CardImageMapper to get the path to the image file
   * and then creating an ImageView object with the image.
   *
   * @param card the card to get the ImageView of
   * @return the ImageView of the card
   */
  public ImageView getCardImageView(PlayingCard card) {
    String imagePath = mapper.getImagePath(card);
    Image image =
        new Image(Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm());

    ImageView imageView = new ImageView(image);
    // Set the initial size of the card images
    imageView.setFitWidth(70);
    imageView.setFitHeight(100);

    return new ImageView(image);
  }

  /**.
   * This method returns an array of ImageViews of the given hand.
   * It does so by using the getCardImageView
   * method to get the ImageView of each card in the hand.
   *
   * @param hand the hand to get the ImageViews of
   * @return the ImageViews for the hand
   */
  public ImageView[] getHandImageViews(HandOfCards hand) {
    ImageView[] views = new ImageView[hand.size()];
    for (int i = 0; i < hand.size(); i++) {
      views[i] = getCardImageView(hand.getCard(i));
    }
    return views;
  }
}