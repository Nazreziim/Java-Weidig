package model;

public class Coord2D {

  private int row;
  private int column;

  public Coord2D() {
    this( 0, 0 );
  }

  public Coord2D( int row, int column ) {
    this.row = row;
    this.column = column;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + column;
    result = prime * result + row;
    return result;
  }

  @Override
  public boolean equals( Object obj ) {
    if ( this == obj )
      return true;
    if ( obj == null )
      return false;
    if ( getClass() != obj.getClass() )
      return false;
    Coord2D other = (Coord2D) obj;
    if ( column != other.column )
      return false;
    if ( row != other.row )
      return false;
    return true;
  }

  public int getRow() {
    return this.row;
  }

  public int getColumn() {
    return this.column;
  }

  @Override
  public String toString() {
    return "Coord2D[ row=" + this.row + ", column=" + this.column + " ]";
  }

}
