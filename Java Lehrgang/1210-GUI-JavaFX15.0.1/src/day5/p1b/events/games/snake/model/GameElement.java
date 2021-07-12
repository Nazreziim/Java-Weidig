package day5.p1b.events.games.snake.model;

public class GameElement {

  private Position pos;

  public GameElement() {
    this( 0, 0 );
  }

  public GameElement( int posX, int posY ) {
    this.pos = new Position( posX, posY );
  }

  public GameElement( Position pos ) {
    this( pos.getPosX(), pos.getPosY() );
  }

  public Position getPos() {
    return this.pos;
  }

  public void setPos( Position pos ) {
    this.pos = pos;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append( this.getClass().getSimpleName() + "[pos=" );
    builder.append( pos );
    builder.append( "]" );
    return builder.toString();
  }

}
