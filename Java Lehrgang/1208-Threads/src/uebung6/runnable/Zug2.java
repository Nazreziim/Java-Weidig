package uebung6.runnable;

public class Zug2 extends Thread {
  private Gruppe2[] gruppen;
  private Kueche2 kueche;

  public Zug2( int anzahlGruppen, Kueche2 kueche ) {
    this.gruppen = new Gruppe2[ anzahlGruppen ];
    this.kueche = kueche;
  }

  @Override
  public void run() {
    for ( int i = 0; i < gruppen.length; ++i ) {
      this.gruppen[ i ] = new Gruppe2( 8, kueche );
    }
    for ( int i = 0; i < gruppen.length; ++i ) {
      this.gruppen[ i ].start();
    }
    try {
      for ( int i = 0; i < gruppen.length; ++i ) {
        this.gruppen[ i ].join();
      }
    } catch ( InterruptedException e ) {
    }
  }
}
