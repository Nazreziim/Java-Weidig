package work.model.test;

import work.model.Rechner;
import work.model.Rechnung;

public class RechnerTest {

  public static void main( String[] args ) {
    Rechner rechner = new Rechner();

    rechner.add( 1.5, 1.4 );
    rechner.sub( Math.PI, 0.999 );
    rechner.mult( 3.5, 40 );
    rechner.div( 100, 0 );

    for ( int i = 0; i < rechner.size(); ++i ) {
      Rechnung r = rechner.get( i );
      System.out.println( r.getTimestamp() + " " + r.getOp1() + r.getOperation() + r.getOp2() + "="
              + r.getErg() );
    }
  }

}
