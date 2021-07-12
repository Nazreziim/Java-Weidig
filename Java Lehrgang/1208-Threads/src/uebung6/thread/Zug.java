package uebung6.thread;

public class Zug extends Thread {
  private Gruppe[] gruppen;
  private Kueche kueche;

  public Zug( int anzahlGruppen, Kueche kueche ) {
    this.gruppen = new Gruppe[ anzahlGruppen ];
    this.kueche = kueche;
  }

  @Override
  public void run() {
    for ( int i = 0; i < gruppen.length; ++i ) {
      this.gruppen[ i ] = new Gruppe( 8, kueche );
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
