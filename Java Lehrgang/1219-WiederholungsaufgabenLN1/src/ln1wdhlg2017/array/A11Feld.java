package ln1wdhlg2017.array;

import java.awt.Point;

import ln1wdhlg2017.gdlg.a2.HilfsMeth;

enum ChessSymbol {
  KING, QUEEN, ROOK, KNIGHT, BISHOP, PAWN;
}

public class A11Feld {

  public static void main( String[] args ) {
    char[][] carr = new char[ 8 ][ 8 ];
    fill( carr );
    print( carr );
    System.out.println();
    // manip( carr, 3, 4, 'X' );
    // print( carr );
    // System.out.println();
    // manip( carr, 3, 6, 'X' );
    // print( carr );
    // System.out.println();
    // manip( carr, 2, 4, 'X' );

    String manipulationen = HilfsMeth.readString(
            "Geben Sie ein, welche Felder auf 'x' gesetzt werden sollen. Syntax (x1 y1 x2 y2 ... -z)." );
    String[] maniparr = manipulationen.split( " " );
    Point[] points = new Point[ maniparr.length / 2 ];
    int pointsCounter = 0;
    for ( int i = 0; i < maniparr.length - 1; i += 2 ) {
      try {
        int x = Integer.parseInt( maniparr[ i ] );
        int y = Integer.parseInt( maniparr[ i + 1 ] );
        if ( x > 0 && y > 0 ) {
          points[ pointsCounter++ ] = new Point( x, y );
        }
      } catch ( NumberFormatException e ) {
        System.err.println( "Die Koordinate ( " + maniparr[ i ] + " / " + maniparr[ i + 1 ]
                + " ) ist ungültig." );
      }
    }
    for ( int i = 0; i < pointsCounter; ++i ) {
      manip( carr, (int) points[ i ].getX(), (int) points[ i ].getY(), '\u265c' );
    }
    print( carr );
    System.out.println();
    printPossible( carr, 2, 5, ChessSymbol.ROOK );
    print( carr );
  }

  public static void manip( char[][] carr, int zeile, int spalte, char zeichen ) {
    if ( carr != null && zeile < carr.length && carr[ 0 ] != null && spalte < carr[ 0 ].length ) {
      carr[ zeile ][ spalte ] = zeichen;
    }
  }

  public static void print( char[][] carr ) {
    for ( int i = 0; i < carr.length; ++i ) {
      for ( int j = 0; j < carr[ 0 ].length; ++j ) {
        System.out.print( "  " + carr[ i ][ j ] );
      }
      System.out.println();
    }

  }

  public static void fill( char[][] carr ) {
    for ( int i = 0; i < carr.length; ++i ) {
      for ( int j = 0; j < carr[ 0 ].length; ++j ) {
        carr[ i ][ j ] = '.';
      }
    }
  }

  public static void printPossible( char[][] carr, int zeile, int spalte, ChessSymbol cs ) {
    if ( cs.equals( ChessSymbol.ROOK ) ) {
      for ( int z = 0; z < carr.length; ++z ) {
        for ( int s = 0; s < carr[ 0 ].length; ++s ) {
          if ( z == zeile && s != spalte || z != zeile && s == spalte ) {
            carr[ z ][ s ] = 'O';
          }
        }
      }
    }
  }
}
