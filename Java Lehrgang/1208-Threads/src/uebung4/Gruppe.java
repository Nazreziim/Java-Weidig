package uebung4;

public class Gruppe extends Thread {
  private static long count = 1;

  private final long id;
  private GrpFhr grpFhr;
  private Soldat[] soldaten;

  public Gruppe( int anzahlSoldaten ) {
    this.id = Gruppe.count++;
    this.soldaten = new Soldat[ anzahlSoldaten ];
    for ( int i = 0; i < soldaten.length; ++i ) {
      soldaten[ i ] = new Soldat();
    }
    this.grpFhr = new GrpFhr( id, soldaten );
  }

  @Override
  public void run() {
    this.grpFhr.start();
    try {
      this.grpFhr.join();
    } catch ( InterruptedException e ) {
    }
  }
}
