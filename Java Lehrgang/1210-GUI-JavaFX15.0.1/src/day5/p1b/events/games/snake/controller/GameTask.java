package day5.p1b.events.games.snake.controller;

import java.util.concurrent.TimeUnit;

import day5.p1b.events.games.snake.model.Game;
import day5.p1b.events.games.snake.view.model.GameVM;
import day5.p1b.events.games.snake.view.model.KeyPressedInformation;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;

public class GameTask extends Task< Void > {

  private final GameVM VM;
  private final Group GRID;
  private final KeyPressedInformation KPI;

  private boolean running;

  public GameTask( GameVM vm, KeyPressedInformation kpi, Group grid ) {
    this.VM = vm;
    this.KPI = kpi;
    this.GRID = grid;
    this.running = true;
  }

  @Override
  protected Void call() throws Exception {
    KeyCode keyCode;
    while ( running && !VM.getModel().isGameOver() ) {
      try {
        TimeUnit.MILLISECONDS.sleep( 500 );
      } catch ( InterruptedException e ) {
        running = false;
      }
      // Has a key been pressed?
      if ( KPI.hasNewInformation() ) {
        keyCode = KPI.getKeyCode();
        switch ( keyCode ) {
          case UP :
            VM.getModel().move( Game.Direction.UP );
            break;
          case RIGHT :
            VM.getModel().move( Game.Direction.RIGHT );
            break;
          case DOWN :
            VM.getModel().move( Game.Direction.DOWN );
            break;
          case LEFT :
            VM.getModel().move( Game.Direction.LEFT );
            break;
          default :
            // Wrong Key pressed
            VM.getModel().move();
        }
      } else {
        // no key pressed
        VM.getModel().move();
      }
      // Let the JavaFX Thread update the UI.
      Platform.runLater( new Runnable() {
        @Override
        public void run() {
          VM.generateGrid( GRID );
        }
      } );
    }
    if ( VM.getModel().isGameOver() ) {

    }
    return null;
  }
}
