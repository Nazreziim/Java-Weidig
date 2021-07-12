package uebung3;

public class GrpFhr {

  public static void main( String[] args ) {
    int anzahlSoldaten = 8;
    Soldat[] soldaten = new Soldat[ anzahlSoldaten ];
    for ( int i = 0; i < soldaten.length; ++i ) {
      soldaten[ i ] = new Soldat();
      soldaten[ i ].start();
    }

    for ( int i = 0; i < soldaten.length; ++i ) {
      try {
        soldaten[ i ].join();
      } catch ( InterruptedException e ) {
      }
    }

    System.out.println( "Gruppe ist fertig mit packen." );
  }

}
