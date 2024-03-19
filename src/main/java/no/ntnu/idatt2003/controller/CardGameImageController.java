package no.ntnu.idatt2003.controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import no.ntnu.idatt2003.model.CardImageMapper;
import no.ntnu.idatt2003.model.HandOfCards;
import no.ntnu.idatt2003.model.PlayingCard;

import java.util.Objects;

/**
 * This class is responsible for handling the images in the card game
 *
 * @version 0.3.0
 * @author Snake727
 */
public class CardGameImageController {
  private CardImageMapper mapper;

  public CardGameImageController() {
    this.mapper = new CardImageMapper();
  }

  public ImageView getCardImageView(PlayingCard card) {
    String imagePath = mapper.getImagePath(card);
    Image image = new Image(Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm());

    ImageView imageView = new ImageView(image);
    // Set the initial size of the card images
    imageView.setFitWidth(100);
    imageView.setFitHeight(150);

    return new ImageView(image);
  }

  public ImageView[] getHandImageViews(HandOfCards hand) {
    ImageView[] views = new ImageView[hand.size()];
    for (int i = 0; i < hand.size(); i++) {
      views[i] = getCardImageView(hand.getCard(i));
    }
    return views;
  }
}