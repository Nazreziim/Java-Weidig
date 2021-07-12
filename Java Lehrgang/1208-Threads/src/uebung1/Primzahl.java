package uebung1;

public class Primzahl {
  private final int zahl;
  private boolean prim;

  public Primzahl( int zahl ) {
    this.zahl = zahl < 0 ? -zahl : zahl;
  }

  public boolean isPrim() {
    boolean result = true;
    if ( this.zahl < 2 || this.zahl > 2 && this.zahl % 2 == 0 ) {
      result = false;
    }
    for ( int i = 3; result && i <= Math.sqrt( this.zahl ); i += 2 ) {
      if ( this.zahl % i == 0 ) {
        result = false;
      }
    }
    this.prim = result;
    return result;
  }

  public boolean getPrim() {
    return this.prim;
  }

}
