package schneckenrennen.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UIConsole {

  public String eingabeRennenName() {
    Scanner sc = new Scanner( System.in );
    System.out.println( "Wie heißt das heutige Rennen?" );
    String name = sc.nextLine();
    return name.trim();
  }

  public String[] eingabeTeilnehmer( String nameRennen ) {
    Scanner sc = new Scanner( System.in );
    System.out.println( "Willkommen zum \"" + nameRennen + "\"..." );
    Integer anzahl = 0;
    while ( anzahl < 1 ) {
      System.out.println( "Wie viele Teilnehmer gibt es heute? (Es müssen mehr als 0 sein.)" );
      try {
        anzahl = sc.nextInt();
      } catch ( InputMismatchException e ) {
        sc.next();
      }
    }
    String[] result = new String[ anzahl ];
    System.out.println( "Geben Sie nun die Details der Teilnehmer ein." );
    System.out.println(
            "Das Eingabeformat ist: Name, Rasse. Zum Beispiel: Rudi Renner, Weinbergschnecke" );
    System.out.println( "Die Teilnehmer werden durch einen Zeilenumbruch getrennt." );
    sc.nextLine();
    for ( int i = 0; i < anzahl; ++i ) {
      System.out.print( "Rennschnecke " + ( i + 1 ) + ": " );
      result[ i ] = sc.nextLine();
    }
    System.out.println( "Danke..." );
    return result;
  }

  public List< String > eingabeWetten() {
    Scanner sc = new Scanner( System.in );
    List< String > result = new ArrayList< String >();
    System.out.println( "Hallo, hier ist das Wettbüro." );
    System.out.println( "Die aktuellen Quoten sehen Sie hier:" );
    System.out.println( "Schnecke # Name: ### vMax: #.### Quote: #.##" );
    System.out.println( "..." );
    System.out.print( "Wollen Sie Wetten abgeben? (Ja/Nein)" );
    String wetten = sc.nextLine();
    if ( wetten.substring( 0, 1 ).equalsIgnoreCase( "J" ) ) {
      System.out.println(
              "Geben Sie Ihre Wetten in folgendem Format ein: [SchneckenNr.];[WettEinsatz];[Ihr Name]" );
      System.out.println( "Ohne die Klammern und getrennt durch Semikola." );
      String weiter = "";
      do {
        String wette = sc.nextLine();
        String[] arrWette = wette.split( ";" );
        if ( arrWette.length != 3 ) {
          System.out.println( "FEHLER: Ungültige Eingabe!" );
        } else {
          System.out.println( arrWette[ 2 ] + " setzt " + arrWette[ 1 ] + " EURO auf Schnecke "
                  + arrWette[ 0 ] + "." );
          result.add( wette );
        }
        System.out.print( "Weitere Wette? (Ja/Nein)" );
        weiter = sc.nextLine();
      } while ( weiter.substring( 0, 1 ).equalsIgnoreCase( "J" ) );
    }
    return result;
  }

  public void ausgabeRennenBeschreibung( String s ) {
    System.out.println( s );
  }

  public void ausgabeRennsituation( int time, double streckenLaenge,
          Map< String, Double > mapSchneckenNamenPositionen, int darstellungsBreite ) {
    // Über die Schnecken iterieren
    System.out.println( "Rennsituation nach Zeiteinheit " + time + "." );
    for ( Iterator< String > it = mapSchneckenNamenPositionen.keySet().iterator(); it.hasNext(); ) {
      String name = it.next();
      // Name ausgeben (maximal 20 Zeichen) rechtsbündig.
      System.out.format( "%20s: ", name.substring( 0, Math.min( 20, name.length() ) ) );
      // Start
      System.out.print( "[" );
      // Berechnen der Position
      int position = (int) ( darstellungsBreite * mapSchneckenNamenPositionen.get( name )
              / streckenLaenge );
      // Ausgabe der Position
      for ( int j = 0; j < darstellungsBreite * 1.1; ++j ) {
        if ( j == position ) {
          System.out.print( '~' );
        } else if ( j == darstellungsBreite ) {
          System.out.print( '|' );
        } else {
          System.out.print( '-' );
        }
      }
      System.out.println( "]" );
    }
  }

  public void ausgabeSieger( String sieger ) {
    System.out.println( "Gewinner: " + sieger + "!" );
  }

}
