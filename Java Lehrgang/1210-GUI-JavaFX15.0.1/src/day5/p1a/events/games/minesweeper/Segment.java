package day5.p1a.events.games.minesweeper;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Representation of one single "minesweeper"-segment. Extends a StackPane to easily enable
 * overlaying effects. Segments do have x and y coordinates to position them on the game grid. There
 * is also a boolean value (isBomb), and a contained Text element (for the number of the neighbors).
 * 
 * @author lgerhard
 *
 */
public class Segment extends StackPane {

  private int x, y;
  private boolean hasBomb;

  private Rectangle border;
  private Text text;

  /**
   * Constructor of a segments instance
   * 
   * @param x x-position
   * @param y y-position
   * @param hasBomb boolean value if the segment is a bomb or not
   */
  public Segment( int x, int y, boolean hasBomb ) {
    super();
    this.x = x;
    this.y = y;
    this.hasBomb = hasBomb;
    this.text = new Text();
    this.border = new Rectangle( GameParams.SEGMENT_SIZE - 2, GameParams.SEGMENT_SIZE - 2 );

    border.setStroke( Color.LIGHTGRAY );

    text.setFont( Font.font( 18 ) );
    text.setText( hasBomb ? "X" : "" );
    text.setVisible( false );

    getChildren().addAll( border, text );

    setTranslateX( x * GameParams.SEGMENT_SIZE );
    setTranslateY( y * GameParams.SEGMENT_SIZE );

    setOnMouseClicked( new MouseClickedHandler( x, y ) );
  }

  /**
   * Opens the segment. This should be done when the segment is clicked by the player
   */
  public void open() {
    text.setVisible( true );
    border.setFill( null );
  }

  public String getText() {
    return this.text.getText();
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setText( String text ) {
    this.text.setText( text );
  }

  public boolean isBomb() {
    return hasBomb;
  }

}
