package aufgabe9;

public class Punkt3D extends Punkt2D {

  private int zKoord;

  public Punkt3D() {
    this( 0, 0, 0 );
  }

  public Punkt3D( int x, int y, int z ) {
    super( x, y );
    this.zKoord = z;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + zKoord;
    return result;
  }

  @Override
  public boolean equals( Object obj ) {
    if ( this == obj )
      return true;
    if ( !super.equals( obj ) )
      return false;
    if ( getClass() != obj.getClass() )
      return false;
    Punkt3D other = (Punkt3D) obj;
    if ( zKoord != other.zKoord )
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Punkt3D[ " + super.toString() + " , zKoord = " + this.zKoord + " ]";
  }

}
