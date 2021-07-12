package topfSpiel.server;

import java.net.Socket;
import java.util.concurrent.TimeUnit;

import topfSpiel.model.TopfSpiel;
import topfSpiel.view.UIString;

public class SpielThread extends Thread {
  private SpielerThread[] spieler = new SpielerThread[ 2 ];

  private boolean running;
  private boolean eingabeVorhanden = false;
  private int eingabe;

  public SpielThread( Socket clientSocket1, Socket clientSocket2 ) {
    this.spieler[ 0 ] = new SpielerThread( clientSocket1, this );
    this.spieler[ 0 ].start();
    this.spieler[ 1 ] = new SpielerThread( clientSocket2, this );
    this.spieler[ 1 ].start();

    this.running = true;
  }

  @Override
  public void run() {

    TopfSpiel spiel = new TopfSpiel();
    UIString view = new UIString();
    int zug = 0;

    while ( this.running && !spiel.istBeendet() ) {

      // Spieler aktivieren
      this.spieler[ spiel.getNext() ].amZug( true );

      // Senden: zugMachen
      this.spieler[ spiel.getNext() ].send( view.zugMachen( spiel.getNext(), spiel.getTauschCounter() ) );

      // Eingabe abwarten
      while ( !this.eingabeVorhanden ) {
        try {
          TimeUnit.MILLISECONDS.sleep( 100 );
        } catch ( InterruptedException e ) {
        }
      }
      this.eingabeVorhanden = false;
      this.spieler[ spiel.getNext() ].amZug( false );

      // Eingabe an Model geben
      spiel.aktion( this.eingabe );

      // Spielstand an beide Senden
      for ( SpielerThread st : this.spieler ) {
        st.send( view.ausgabe( zug, spiel.getSpieler()[ 0 ].getCoins(), spiel.getSpieler()[ 1 ].getCoins() ) );
      }
    }
    for ( SpielerThread st : this.spieler ) {
      st.send( view.ausgabeSieger( spiel.getSieger() ) );
      st.shutdown();
    }

  }

  public void eingabeSenden( int eingabe ) {
    this.eingabe = eingabe;
    this.eingabeVorhanden = true;
  }

}
