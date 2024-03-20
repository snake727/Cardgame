package no.ntnu.idatt2003;

import javafx.application.Application;
import no.ntnu.idatt2003.view.CardGameView;

/**
 * The main class of the program.
 * This class is responsible for starting GUI and the game.
 *
 * @version 1.0.0
 * @author Snake727
 */
public class Main {
  public static void main(String[] args) {
    // Start the program
    Application.launch(CardGameView.class, args);
  }
}