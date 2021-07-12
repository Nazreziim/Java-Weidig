package uebung6.thread;

public class Kueche {

  public synchronized void essen( Gruppe gruppe ) {
    System.out.println( "Kueche: Gruppe " + gruppe.getId() + " ist beim essen." );
    Soldat[] soldaten = gruppe.getSoldaten();
    for ( int i = 0; i < soldaten.length; ++i ) {
      soldaten[ i ].start();
    }
    gruppe.getGrpFhr().start();
    try {
      for ( int i = 0; i < soldaten.length; ++i ) {
        soldaten[ i ].join();
      }
      gruppe.getGrpFhr().join();
    } catch ( InterruptedException e ) {
    }
    System.out.println( "Kueche: Gruppe " + gruppe.getId() + " ist fertig mit essen." );
  }
}
