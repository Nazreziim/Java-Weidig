package day5.p1a.events.games.minesweeper;

import java.util.List;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * This is the main class of the Minesweeper game. It extends JavaFX.Application and contains mainly
 * the common known methods start() and createContent(). A grid object is instantiated in here with
 * the pre-set GameParams and also the segments which are needed for the game are built here
 * (randomly) and added to the grid
 * 
 * @author lgerhard
 *
 */
public class MinesweeperApp extends Application {

  /**
   * A grid to contain the single segments
   */
  private Grid grid = new Grid( GameParams.X_SEGMENTS, GameParams.Y_SEGMENTS );
  /**
   * A scene to display everything
   */
  private Scene scene;

  /**
   * Helpermethod to create the root element to be displayed on the screen
   * 
   * @return Parent the root Parent element
   */
  private Parent createContent() {
    Pane root = new Pane();

    root.setPrefSize( GameParams.WIDTH, GameParams.HEIGHT );

    createSegmentsAndAddToGrid( root );

    calculateTextValuesForSurroundingBombs();

    root.setOnMouseClicked( new MouseClickedHandler( 0, 0 ) );
    return root;
  }

  /**
   * Helper method to create the appropriate number of segments and add them to the grid object.
   * 
   * @param root
   */
  private void createSegmentsAndAddToGrid( Pane root ) {
    // Create the appropriate number of Segments and add them to the grid
    for ( int y = 0; y < GameParams.Y_SEGMENTS; y++ ) {
      for ( int x = 0; x < GameParams.X_SEGMENTS; x++ ) {
        Segment segment = new Segment( x, y, Math.random() < 0.1 );
        grid.addSegment( segment, x, y );
        root.getChildren().add( segment );
      }
    }
  }

  /**
   * Calculate the number values for all segments: If the segment is a bomb then do nothing,
   * otherwise count all neighbor-segments which contain bombs
   */
  private void calculateTextValuesForSurroundingBombs() {

    for ( int y = 0; y < GameParams.Y_SEGMENTS; y++ ) {
      for ( int x = 0; x < GameParams.X_SEGMENTS; x++ ) {
        Segment seg = grid.getSegmentAt( x, y );

        // Following lines are there to set the right text for the single segments
        // - if the current segment itself is a bomb, then do nothing
        // - otherwise count the segments surrounding the current segment which contain
        // bombs
        if ( !seg.isBomb() ) {
          List< Segment > neighbors = grid.getNeighbors( seg );
          int bombNo = 0;
          for ( Segment s : neighbors ) {
            if ( s.isBomb() ) {
              bombNo++;
            }
          }

          if ( bombNo > 0 )
            seg.setText( String.valueOf( bombNo ) );
        }
      }
    }
  }

  /**
   * standard override of start method
   */
  @Override
  public void start( Stage primaryStage ) throws Exception {
    scene = new Scene( createContent() );
    primaryStage.setTitle( "Minesweeper" );
    primaryStage.setScene( scene );
    primaryStage.show();
  }

  /**
   * only call launch(args)
   * 
   * @param args
   */
  public static void main( String[] args ) {
    launch( args );
  }
}
