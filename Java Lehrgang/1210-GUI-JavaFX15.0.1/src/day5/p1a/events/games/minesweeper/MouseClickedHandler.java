package day5.p1a.events.games.minesweeper;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * This class handles MouseEvents. It can receive coordinates of a potential segment in its
 * constructor
 * 
 * @author lgerhard
 *
 */
public class MouseClickedHandler implements EventHandler< MouseEvent > {

  private int y;
  private int x;

  MouseClickedHandler( int x, int y ) {
    this.x = x;
    this.y = y;
  }

  @Override
  public void handle( MouseEvent event ) {
    System.out.println( event.getSource().toString() + "(" + x + ", " + y + ")" );
    if ( event.getSource() instanceof Segment ) {
      Segment s = (Segment) event.getSource();
      s.open();

      // 1. if bomb than game is over!
      if ( s.isBomb() ) {
        System.out.println( "Game Over" );

        // TODO: Reset grid
      }

      // 2. if empty than open all empty neighbors
      if ( s.getText().isEmpty() ) {
        // TODO: Open neighbors
      }
    }

  }

}
