package day4.p6.events.mouseevents.paint;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * This class is an adaption of an example from Oracle. It represents a simple "Paint"-program with
 * three main functions
 * <p>
 * <ul>
 * <li>painting by dragging the mouse over the screen
 * <li>resetting the screen to its original state by performing a double click
 * <li>resize the "pen" when the mousewheel is turned
 * </ul>
 * 
 * @author lgerhard
 *
 */
public class Paint extends Application {

  private double penSize = 3;

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) {
    primaryStage.setTitle( "Paint" );
    Group root = new Group();

    // draw a background rectangle
    Rectangle rect = new Rectangle( 400, 400 );
    drawBackground( rect );
    root.getChildren().add( rect );

    // Create a black Canvas
    final Canvas canvas = new Canvas( rect.getWidth(), rect.getHeight() );
    // canvas.setTranslateX(100);
    // canvas.setTranslateY(100);
    reset( canvas, Color.BLACK );
    final GraphicsContext gc = canvas.getGraphicsContext2D();

    // 1.) Clear away little fragments as the user drags the mouse
    canvas.addEventHandler( MouseEvent.MOUSE_DRAGGED, new EventHandler< MouseEvent >() {

      @Override
      public void handle( MouseEvent e ) {

        gc.clearRect( e.getX(), e.getY(), penSize, penSize );
      }
    } );

    // 2.) fill the canvas again after a double-click
    canvas.addEventHandler( MouseEvent.MOUSE_CLICKED, new EventHandler< MouseEvent >() {
      @Override
      public void handle( MouseEvent t ) {
        if ( t.getClickCount() > 1 ) {
          reset( canvas, Color.BLACK );
        }
      }
    } );

    // 3.) resize the pen when scrolling the mouse-wheel
    // canvas.setOnScroll((ScrollEvent e) -> {
    // if (e.getDeltaY() > 0) {
    // penSize++;
    // } else {
    // penSize--;
    // }
    // });
    canvas.setOnScroll( new EventHandler< ScrollEvent >() {
      @Override
      public void handle( ScrollEvent event ) {
        if ( event.getDeltaY() > 0 ) {
          penSize++;
        } else {
          penSize--;
        }
      }
    } );

    root.getChildren().add( canvas );
    primaryStage.setScene( new Scene( root, 400, 400 ) );
    primaryStage.show();
  }

  /**
   * Reset the canvas back to the original (or any other) background
   *
   * @param canvas The canvas to reset
   * @param color The color to fill
   */
  private void reset( Canvas canvas, Color color ) {
    GraphicsContext gc = canvas.getGraphicsContext2D();
    gc.setFill( color );
    gc.fillRect( 0, 0, canvas.getWidth(), canvas.getHeight() );
  }

  /**
   * Helper mehtod to draw the background of the paint program
   * 
   * @param rect the Rectangle to draw on the Canvas
   */
  private void drawBackground( Rectangle rect ) {
    rect.setFill( new LinearGradient( 0, 0, 1, 1, true, CycleMethod.REFLECT, new Stop( 0, Color.RED ),
            new Stop( 0.2, Color.ORANGE ), new Stop( 0.4, Color.YELLOW ), new Stop( 0.6, Color.GREEN ),
            new Stop( 0.8, Color.BLUE ), new Stop( 1.0, Color.PURPLE ) ) );
  }
}
