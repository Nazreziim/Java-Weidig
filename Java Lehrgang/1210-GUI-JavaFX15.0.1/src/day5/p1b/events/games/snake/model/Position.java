package day5.p1b.events.games.snake.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * 2-dimensional Integer Position
 * 
 * @author kmoench
 * @version 0.2
 */
public class Position {

  private IntegerProperty posX;
  private IntegerProperty posY;

  public Position( int posX, int posY ) {
    this.posX = new SimpleIntegerProperty( this, "posX", posX );
    this.posY = new SimpleIntegerProperty( this, "posY", posY );
    this.setPosX( posX );
    this.setPosY( posY );
  }

  public Position() {
    this( 0, 0 );
  }

  public Position( Position pos ) {
    this( pos.getPosX(), pos.getPosY() );
  }

  public IntegerProperty posXProperty() {
    return this.posX;
  }

  public IntegerProperty posYProperty() {
    return this.posY;
  }

  public int getPosX() {
    return this.posX.get();
  }

  public int getPosY() {
    return this.posY.get();
  }

  public void setPosX( int posX ) {
    this.posX.set( posX );
  }

  public void setPosY( int posY ) {
    this.posY.set( posY );
  }

  @Override
  public boolean equals( Object obj ) {
    boolean equal = false;
    if ( obj != null && obj instanceof Position ) {
      Position other = (Position) obj;
      if ( this.getPosX() == other.getPosX() && this.getPosY() == other.getPosY() )
        equal = true;
    }
    return equal;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append( "Position [posX=" );
    builder.append( getPosX() );
    builder.append( ", posY=" );
    builder.append( getPosY() );
    builder.append( "]" );
    return builder.toString();
  }

}
