package aufgabe5;

import hilfsmeth.HilfsMeth;

public class MitarbeiterTest {

  public static void main( String[] args ) {

    Mitarbeiter[] mitarbeiter = new Mitarbeiter[ 50 ];

    for ( int i = 0; i < mitarbeiter.length / 2; ++i ) {
      mitarbeiter[ i ] = new Mitarbeiter( i + ".", "Soldat", "Streife " + i, "2020-05-" + ( i % 32 ), i + 1_500.0 );

    }
    for ( int i = mitarbeiter.length / 2; i < mitarbeiter.length; ++i ) {
      mitarbeiter[ i ] = new Mitarbeiter( i + ".", "Posten", "Posten " + i, "2020-05-" + ( i % 32 ), i + 1_300.0 );
    }

    char auswahl = ' ';
    while ( auswahl != 'P' & auswahl != 'N' ) {
      auswahl = HilfsMeth.readChar( "Suche nach (N)ame oder (P)ersonalnummer?" );
      auswahl = Character.toUpperCase( auswahl );
    }

    Mitarbeiter[] gefunden = new Mitarbeiter[ 0 ];
    switch ( auswahl ) {
      case 'N' :
        String name = HilfsMeth.readString( "Name:" );
        gefunden = searchByName( mitarbeiter, name );
        break;
      case 'P' :
        long nummer = HilfsMeth.readLong( "Personalnummer:" );
        gefunden = new Mitarbeiter[ 1 ];
        gefunden[ 0 ] = searchByPersonalnummer( mitarbeiter, nummer );
        break;
      default :
        // empty
    }

    int index = 0;
    System.out.println( "Gefundene Einträge:" );
    for ( int i = 0; i < gefunden.length; ++i ) {
      if ( gefunden[ i ] != null ) {
        ++index;
        System.out.println( index + ". " + gefunden[ i ] );
      }
    }
  }

  public static Mitarbeiter[] searchByName( Mitarbeiter[] mitarbeiter, String name ) {
    int anzahl = 0;
    for ( int i = 0; i < mitarbeiter.length; ++i ) {
      if ( mitarbeiter[ i ] != null && mitarbeiter[ i ].getName().equals( name ) ) {
        ++anzahl;
      }
    }
    Mitarbeiter[] erg = new Mitarbeiter[ anzahl ];
    int index = 0;
    for ( int i = 0; i < mitarbeiter.length; ++i ) {
      if ( mitarbeiter[ i ] != null && mitarbeiter[ i ].getName().equals( name ) ) {
        erg[ index ] = mitarbeiter[ i ];
        ++index;
      }
    }
    return erg;
  }

  public static Mitarbeiter searchByPersonalnummer( Mitarbeiter[] mitarbeiter, long personalnummer ) {
    Mitarbeiter erg = null;
    for ( int i = 0; i < mitarbeiter.length && erg == null; ++i ) {
      if ( mitarbeiter[ i ] != null && mitarbeiter[ i ].getPersonalnummer() == personalnummer ) {
        erg = mitarbeiter[ i ];
      }
    }
    return erg;
  }

}
