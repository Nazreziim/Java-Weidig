package day4.p4.events.keyevents.flyingletters;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * An example of animation generated from key events. Click the grey area to give it focus and try
 * typing letters.
 */
public class FlyingLetters extends Application {

  private LettersPane lettersPane;

  public Parent createContent() {
    lettersPane = new LettersPane();
    return lettersPane;
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setResizable( false );
    primaryStage.setScene( new Scene( createContent() ) );
    primaryStage.show();
  }

  /**
   * Java main for when running without JavaFX launcher
   */
  public static void main( String[] args ) {
    launch( args );
  }
}
