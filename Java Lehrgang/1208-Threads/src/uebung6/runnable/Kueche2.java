package uebung6.runnable;

public class Kueche2 {

  public synchronized void essen( Gruppe2 gruppe ) {
    Thread[] threads = new Thread[ gruppe.getSoldaten().length ];
    Thread grpFhrThread = null;

    System.out.println( "Kueche: Gruppe " + gruppe.getId() + " ist beim essen." );
    SoldatRunnable[] soldaten = gruppe.getSoldaten();
    for ( int i = 0; i < soldaten.length; ++i ) {
      threads[ i ] = new Thread( gruppe.getSoldaten()[ i ] );
      threads[ i ].start();
    }

    grpFhrThread = new Thread( gruppe.getGrpFhr() );
    grpFhrThread.start();
    try {
      for ( int i = 0; i < soldaten.length; ++i ) {
        threads[ i ].join();
      }
      grpFhrThread.join();
    } catch ( InterruptedException e ) {
    }
    System.out.println( "Kueche: Gruppe " + gruppe.getId() + " ist fertig mit essen." );
  }
}
