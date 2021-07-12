package uebung6.thread;

public class Gruppe extends Thread {
  private static long count = 1;

  private final long id;
  private Soldat grpFhr;
  private Soldat[] soldaten;

  private Kueche kueche;

  public Gruppe( int anzahlSoldaten, Kueche kueche ) {
    this.id = Gruppe.count++;
    this.grpFhr = new Soldat();
    this.soldaten = new Soldat[ anzahlSoldaten ];
    this.kueche = kueche;
  }

  @Override
  public void run() {
    for ( int i = 0; i < this.soldaten.length; ++i ) {
      this.soldaten[ i ] = new Soldat();
    }
    System.out.println( "GrpFhr: Gruppe " + this.id + " packt euer Zeug." );
    for ( int i = 0; i < this.soldaten.length; ++i ) {
      this.soldaten[ i ].start();
    }
    this.grpFhr.start();
    try {
      for ( int i = 0; i < this.soldaten.length; ++i ) {
        this.soldaten[ i ].join();
      }
      this.grpFhr.join();
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
    for ( int i = 0; i < soldaten.length; ++i ) {
      this.soldaten[ i ] = new Soldat( this.soldaten[ i ].getId(), true );
    }
    this.grpFhr = new Soldat( this.grpFhr.getId(), true );
    this.kueche.essen( this );
    System.out.println( "GrpFhr: Gruppe " + this.id + " ist zurück von der Kueche." );
  }

  public long getId() {
    return this.id;
  }

  public Soldat[] getSoldaten() {
    return this.soldaten;
  }

  public Soldat getGrpFhr() {
    return this.grpFhr;
  }
}
