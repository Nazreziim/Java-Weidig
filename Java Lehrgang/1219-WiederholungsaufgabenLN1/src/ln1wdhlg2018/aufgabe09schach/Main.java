package ln1wdhlg2018.aufgabe09schach;

import ln1wdhlg2018.aufgabe09schach.model.Brett;
import ln1wdhlg2018.aufgabe09schach.model.Farbe;
import ln1wdhlg2018.aufgabe09schach.model.figuren.Bauer;
import ln1wdhlg2018.aufgabe09schach.model.figuren.Dame;
import ln1wdhlg2018.aufgabe09schach.model.figuren.Koenig;
import ln1wdhlg2018.aufgabe09schach.model.figuren.Laeufer;
import ln1wdhlg2018.aufgabe09schach.model.figuren.Springer;
import ln1wdhlg2018.aufgabe09schach.model.figuren.Turm;
import ln1wdhlg2018.aufgabe09schach.model.koord.Koordinate;

public class Main {

  public static void main( String[] args ) {
    final int MIN_REIHEN = 1;
    final int MAX_REIHEN = 8;
    final char MIN_LINIEN = 'A';
    final char MAX_LINIEN = 'H';

    Brett brett = new Brett( MAX_REIHEN, MAX_LINIEN );

    Bauer b1 = new Bauer( "Fred", Farbe.WEISS );
    brett.add( b1, new Koordinate( 2, 'A' ) ); // Positioniert Figur an der Koordinate auf dem Brett

    Turm t1 = new Turm( "Tower", Farbe.SCHWARZ );
    if ( !brett.add( t1, new Koordinate( 8, 'H' ) ) ) {
      System.err.println( "Auf dem Feld steht bereits eine Figur!" );
    }

    Springer pferd = new Springer( "Pferd", Farbe.SCHWARZ );
    if ( !brett.add( pferd ) ) { // Positioniert selbstständig auf die Ausgangsposition.
      System.err.println(
              "Alle Positionen für die Aufstellung eines schwarzen Springers sind bereits belegt." );
    }

    Laeufer l1 = new Laeufer( "Bolt", Farbe.WEISS );
    brett.add( l1, new Koordinate( 1, 'C' ) );

    Koenig king = new Koenig( "Gustav", Farbe.SCHWARZ );
    brett.add( king, new Koordinate( 8, 'D' ) );

    Dame dame = new Dame( Farbe.WEISS );
    brett.add( dame, new Koordinate( 1, 'D' ) );

    // Ausgabe (die Ausgabe aller anderen Figuren analog zum Bauern):
    // Falls der Bauer auf Brett gesetzt wurde:
    // Fred ( Bauer, weiss, Pos: 2, A )
    // Falls der Bauer nicht auf dem Brett gesetzt wurde:
    // Fred ( Bauer, weiss )
    System.out.println( b1 );

    // Ausgabe (Die Figuren werden zeilen- und spaltenweise aufsteigend ausgegeben, siehe Beispiel):
    // Brett ( Anzahl Zeilen: 8, Anzahl Spalten: H )
    // Bolt ( Laeufer, weiss, Pos: 1, C )
    // Dame ( Dame, weiss, Pos: 1, D )
    // Fred ( Bauer, weiss, Pos: 2, A )
    // Pferd ( Springer, schwarz, Pos: 2, B )
    // Gustav ( Koenig, schwarz, Pos: 8, D )
    // Tower ( Turm, schwarz, Pos: 8, H )
    System.out.println( brett );

  }

}
