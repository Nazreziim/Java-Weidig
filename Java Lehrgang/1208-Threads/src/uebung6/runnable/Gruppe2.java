package uebung6.runnable;

public class Gruppe2 extends Thread {
  private static long count = 1;

  private final long id;
  private SoldatRunnable grpFhr;
  private SoldatRunnable[] soldaten;

  private Kueche2 kueche;

  public Gruppe2( int anzahlSoldaten, Kueche2 kueche ) {
    this.id = Gruppe2.count++;
    this.grpFhr = new SoldatRunnable();
    this.soldaten = new SoldatRunnable[ anzahlSoldaten ];
    this.kueche = kueche;
  }

  @Override
  public void run() {
    Thread[] threads = new Thread[ this.soldaten.length ];
    Thread grpFhrThread = null;

    for ( int i = 0; i < this.soldaten.length; ++i ) {
      this.soldaten[ i ] = new SoldatRunnable();
      threads[ i ] = new Thread( this.soldaten[ i ] );
    }
    System.out.println( "GrpFhr: Gruppe " + this.id + " packt euer Zeug." );
    for ( int i = 0; i < this.soldaten.length; ++i ) {
      threads[ i ].start();
    }
    grpFhrThread = new Thread( this.grpFhr );
    grpFhrThread.start();

    try {
      for ( int i = 0; i < this.soldaten.length; ++i ) {
        threads[ i ].join();
      }
      grpFhrThread.join();
    } catch ( InterruptedException e ) {
    }

    System.out.println( "GrpFhr: Gruppe " + this.id + " ist fertig mit packen." );
    System.out.println( "GrpFhr: Gruppe " + this.id + " marschiert zum Essen." );
    try {
      Thread.sleep( (long) ( 5000 * Math.random() ) );
    } catch ( InterruptedException e ) {
    }
    System.out.println( "GrpFhr: Gruppe " + this.id + " ist angekommen." );
    System.out.println( "GrpFhr: Gruppe " + this.id + " ist an der Kueche." );
    this.kueche.essen( this );
    System.out.println( "GrpFhr: Gruppe " + this.id + " ist zurück von der Kueche." );
  }

  public long getId() {
    return this.id;
  }

  public SoldatRunnable[] getSoldaten() {
    return this.soldaten;
  }

  public SoldatRunnable getGrpFhr() {
    return this.grpFhr;
  }

}
