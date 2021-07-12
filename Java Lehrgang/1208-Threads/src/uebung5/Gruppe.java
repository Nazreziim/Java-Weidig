package uebung5;

import uebung3.Soldat;

public class Gruppe extends Thread {
  private static long count = 1;

  private final long id;
  // private Soldat grpFhr;
  private Soldat[] soldaten;

  private Kueche kueche;

  public Gruppe( int anzahlSoldaten, Kueche kueche ) {
    this.id = Gruppe.count++;
    // this.grpFhr = new Soldat();
    this.soldaten = new Soldat[ anzahlSoldaten ];
    this.kueche = kueche;
  }

  @Override
  public void run() {
    for ( int i = 0; i < soldaten.length; ++i ) {
      soldaten[ i ] = new Soldat();
    }
    System.out.println( "GrpFhr: Gruppe " + this.id + " packt euer Zeug." );
    for ( int i = 0; i < soldaten.length; ++i ) {
      soldaten[ i ].start();
    }
    for ( int i = 0; i < soldaten.length; ++i ) {
      try {
        soldaten[ i ].join();
      } catch ( InterruptedException e ) {
      }
    }
    System.out.println( "GrpFhr: Gruppe " + this.id + " ist fertig mit packen." );
    System.out.println( "GrpFhr: Gruppe " + this.id + " marschiert zum Essen." );
    try {
      Thread.sleep( (long) ( 5000 * Math.random() ) );
    } catch ( InterruptedException e ) {
    }
    System.out.println( "GrpFhr: Gruppe " + this.id + " ist angekommen." );
    System.out.println( "GrpFhr: Gruppe " + this.id + " ist an der Kueche." );
    this.kueche.essen( this.id );
    System.out.println( "GrpFhr: Gruppe " + this.id + " ist zurück von der Kueche." );
  }
}
