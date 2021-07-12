package wrsv2018schritt1.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {
  public static int auswahl( int anzahlAuswahl ) {
    int auswahl = -1;
    while ( auswahl < 0 || auswahl > anzahlAuswahl ) {
      try {
        System.out.print( "Ihre Auswahl (mit Enter bestätigen): " );
        String line = leseString();
        auswahl = Integer.parseInt( line.trim() );
      } catch ( NumberFormatException e ) {
        System.err.println( "Das war keine Zahl." );
      }
    }
    return auswahl;
  }

  public static String leseString() {
    String line = "";
    BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
    try {
      line = br.readLine();
    } catch ( IOException e ) {
      System.err.println( "Beim Zugriff auf die Konsole ist etwas schief gelaufen:" );
      e.printStackTrace();
    }
    return line.trim();
  }

  public static int leseInt() {
    return leseInt( false );
  }

  public static int leseInt( boolean still ) {
    String line = leseString();
    int zahl = 0;
    try {
      zahl = Integer.parseInt( line );
    } catch ( NumberFormatException e ) {
      if ( !still ) {
        System.err.println( "Das war keine Zahl." );
      }
    }
    return zahl;
  }

  public static double leseDouble() {
    return leseDouble( false );
  }

  public static double leseDouble( boolean still ) {
    double eingabe = 0.0;
    try {
      String line = leseString();
      eingabe = Double.parseDouble( line.trim() );
    } catch ( NumberFormatException e ) {
      if ( !still ) {
        System.err.println( "Das war keine Zahl." );
      }
    }
    return eingabe;
  }

  public static boolean leseBooleanDeuEng() {
    String eingabe = leseString();
    return string2Boolean( eingabe );
  }

  public static boolean string2Boolean( String string ) {
    boolean ergebnis = false;
    String zeichen = string.substring( 0, 1 );
    if ( zeichen.equalsIgnoreCase( "J" ) || zeichen.equalsIgnoreCase( "Y" ) ) {
      ergebnis = true;
    }
    return ergebnis;
  }
}
