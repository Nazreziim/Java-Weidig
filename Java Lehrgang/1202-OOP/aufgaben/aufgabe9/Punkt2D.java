package aufgabe9;

public class Punkt2D {
  // Koordinaten
  public int xKoord;
  public int yKoord;
  public double d;
  public long l;

  public Punkt2D( int xKoord, int yKoord ) {
    this.xKoord = xKoord;
    this.yKoord = yKoord;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits( d );
    result = prime * result + (int) ( temp ^ ( temp >>> 32 ) );
    result = prime * result + (int) ( l ^ ( l >>> 32 ) );
    result = prime * result + xKoord;
    result = prime * result + yKoord;
    return result;
  }

  @Override
  public boolean equals( Object obj ) {
    if ( this == obj )
      return true;
    if ( obj == null )
      return false;
    if ( getClass() != obj.getClass() ) // Symmetrie sichergestellt (siehe unten)
      return false;
    Punkt2D other = (Punkt2D) obj;
    if ( Double.doubleToLongBits( d ) != Double.doubleToLongBits( other.d ) )
      return false;
    if ( l != other.l )
      return false;
    if ( xKoord != other.xKoord )
      return false;
    if ( yKoord != other.yKoord )
      return false;
    return true;
  }

  // @Override
  // public boolean equals( Object obj ) {
  // if ( this == obj ) {
  // return true;
  // }
  // if ( !( obj instanceof Punkt2D ) ) { // Instance of führt zu Problemen mit der Symmetrie
  // // https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#equals-java.lang.Object-
  // return false;
  // }
  // Punkt2D other = (Punkt2D) obj;
  // if ( xKoord != other.xKoord ) {
  // return false;
  // }
  // if ( yKoord != other.yKoord ) {
  // return false;
  // }
  // return true;
  // }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "[ xKoord = " + this.xKoord + ", yKoord = " + this.yKoord + " ]";
  }

}
