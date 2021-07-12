package uebung2;

public class PrimzahlThread extends Thread {
  private final int zahl;
  private boolean prim;

  public PrimzahlThread( int zahl ) {
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

  @Override
  public void run() {
    try {
      Thread.sleep( (long) ( 50 * Math.random()  ) );
    } catch ( InterruptedException e ) {
    }
    if ( this.isPrim() ) {
      System.out.println( "Die Zahl " + this.zahl + " ist Prim." );
    }
  }
}
