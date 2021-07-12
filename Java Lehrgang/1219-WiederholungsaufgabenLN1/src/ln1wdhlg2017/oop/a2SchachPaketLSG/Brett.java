package ln1wdhlg2017.oop.a2SchachPaketLSG;

import ln1wdhlg2017.gdlg.a2.HilfsMeth;

public class Brett {
  private final int ZEILEN = 8;
  private final int SPALTEN = 8;
  Feld[][] felder = new Feld[ ZEILEN ][ SPALTEN ];

  public Feld getFeld( int zeile, int spalte ) {
    return this.felder[ zeile ][ spalte ];
  }

  public void bedrohungslage() {
    for ( int z = 0; z < 8; ++z ) { // Zeilen iterieren
      for ( int s = 0; s < 8; ++s ) { // Spalten iterieren
        Figur aktuelleFigur = this.felder[ z ][ s ].getFigur(); // Aktuelle Figur merken
        if ( aktuelleFigur != null ) { // Wenn es eine Figur gibt
          boolean bedroht = false; // Speicher
          for ( int z2 = 0; z2 < 8; ++z2 ) { // Weilen iterieren
            for ( int s2 = 0; s2 < 8; ++s2 ) { // Spalten iterieren
              Figur gegnerFigur = this.getFeld( z2, s2 ).getFigur(); // eventuellen Gegner Speichern
              // Wenn Gegner nciht null und farbe unterschiedlich
              if ( gegnerFigur != null && gegnerFigur.getFarbe() != aktuelleFigur.getFarbe() ) {
                // Nachsehen ob gegner mich bedroht, ergebnis zwischen speichern.
                bedroht = gegnerFigur.bedroht( aktuelleFigur.getPos() );
              }
            }
          }
          if ( bedroht ) { // Falls Gegner mich bedroht -> Ausgabe
            System.out.println( aktuelleFigur.getClass().getSimpleName() + " "
                    + aktuelleFigur.getFarbe() + " auf " + aktuelleFigur.getPos().getZeile() + ","
                    + aktuelleFigur.getPos().getSpalte() + " wird bedroht." );
          }
        }
      }
    }
  }

  public void initialisieren() {
    for ( int z = 0; z < this.felder.length; ++z ) {
      for ( int s = 0; s < this.felder[ 0 ].length; ++s ) {
        this.felder[ z ][ s ] = new Feld();
      }
    }
    System.out.println( "Folgende Figuren sind implementiert: " );
    System.out.println( "Koenig, Turm" );

    String figur;
    String farbe;
    String zeile;
    String spalte;
    String nochmal;
    do {
      System.out.println( "Figuren eingeben:" );
      figur = HilfsMeth.readString( "Welche Figur:" );
      farbe = HilfsMeth.readString( "Welche Farbe? (w)eiss oder (s)chwarz: " );
      farbe = farbe.substring( 0, 1 );
      zeile = HilfsMeth.readString( "Welche Zeile? 0 - 7: " );
      spalte = HilfsMeth.readString( "Welche Spalte? 0 - 7: " );

      try {
        int z = Integer.parseInt( zeile.trim() ) % 8;
        int s = Integer.parseInt( spalte.trim() ) % 8;

        switch ( figur.trim() ) {
          case "Koenig" :
            this.felder[ z ][ s ].setFigur( new Koenig( farbe.charAt( 0 ) ) );
            this.felder[ z ][ s ].getFigur().setPos( new Koordinate( z, s ) );
            break;
          case "Turm" :
            this.felder[ z ][ s ].setFigur( new Turm( farbe.charAt( 0 ) ) );
            this.felder[ z ][ s ].getFigur().setPos( new Koordinate( z, s ) );
            break;
          default :
            System.err.println( "Diese Figur gibt es nicht." );
        }
      } catch ( NumberFormatException e ) {
        System.err.println( "Eine Ihrer Eingaben war falsch ;)" );
      }
      nochmal = HilfsMeth.readString( "Weitere Figuren? (j)a oder (n)ein" );
    } while ( nochmal.substring( 0, 1 ).equalsIgnoreCase( "j" ) );
    System.out.println( "Eingabe beendet." );
  }

  public void print() {
    System.out.println( "+--+--+--+--+--+--+--+--+" );
    for ( int z = 0; z < 8; ++z ) {
      for ( int s = 0; s < 8; ++s ) {
        Figur f = this.felder[ z ][ s ].getFigur();
        if ( f instanceof Koenig ) {
          System.out.print( "|K" + f.getFarbe() );
        } else if ( f instanceof Turm ) {
          System.out.print( "|T" + f.getFarbe() );
        } else {
          System.out.print( "|  " );
        }
      }
      System.out.println( "|" );
      System.out.println( "+--+--+--+--+--+--+--+--+" );
    }

  }

}
