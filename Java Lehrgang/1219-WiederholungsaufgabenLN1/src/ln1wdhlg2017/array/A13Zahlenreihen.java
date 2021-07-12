package ln1wdhlg2017.array;

import ln1wdhlg2017.gdlg.a2.HilfsMeth;

public class A13Zahlenreihen {

  public static void main( String[] args ) {
    // String eingabe = HilfsMeth.readString( "Geben Sie Ganzzahlen ein mit Leerstelle getrennt." );
    // String[] zahlenstr = eingabe.split( " " );
    // int[] zahlen = new int[ zahlenstr.length ];
    // for ( int i = 0; i < zahlen.length; ++i ) {
    // zahlen[ i ] = Integer.parseInt( zahlenstr[ i ] );
    // }
    // zahlen = insertSort( zahlen );

    int anzahl = HilfsMeth.readInt( "Wie viele Zahlen wollen Sie eingeben?" );
    int[] zahlen = new int[ anzahl ];
    printIntArray( zahlen );
    System.out.println();
    for ( int i = 0; i < anzahl; ++i ) {
      int zahl = 0;
      do {
        zahl = HilfsMeth.readInt( "Zahl " + ( i + 1 ) + ": " );
      } while ( contains( zahlen, zahl ) );
      insertSort( zahlen, zahl, i );
      printIntArray( zahlen );
      System.out.println();
    }

    System.out.print( "Ausgabe 1: " );
    printIntArray( zahlen );

    System.out.print( "\nAusgabe 2: " );
    printIntArrayShort( zahlen );
  }

  public static int[] insertSort( int[] iarr ) {
    int[] result = new int[ iarr.length ];
    for ( int i = 0; i < result.length; ++i ) {
      result[ i ] = Integer.MAX_VALUE;
    }
    for ( int i = 0; i < iarr.length; ++i ) {
      int insertIdx = 0;
      while ( insertIdx < result.length && iarr[ i ] > result[ insertIdx ] ) {
        ++insertIdx;
      }
      for ( int j = 0; j < result.length - insertIdx - 1; ++j ) {
        result[ result.length - j - 1 ] = result[ result.length - j - 2 ];
      }
      if ( insertIdx < result.length ) {
        result[ insertIdx ] = iarr[ i ];
      }
    }
    return result;
  }

  public static void insertSort( int[] iarr, int neu, int grenze ) {
    int insertIdx = 0;
    // Einfügestelle suchen
    while ( insertIdx < grenze && insertIdx < iarr.length && neu >= iarr[ insertIdx ] ) {
      if ( neu == iarr[ insertIdx ] ) {
        insertIdx = iarr.length;
      } else {
        ++insertIdx;
      }
    }
    // Andere Zahlen nach hinten verschieben
    for ( int j = 0; j < iarr.length - insertIdx - 1; ++j ) {
      iarr[ iarr.length - j - 1 ] = iarr[ iarr.length - j - 2 ];
    }
    // Neue Zahl einfügen
    if ( insertIdx < iarr.length ) {
      iarr[ insertIdx ] = neu;
    }
  }

  public static boolean contains( int[] iarr, int test ) {
    boolean contains = false;
    for ( int i = 0; !contains && i < iarr.length; ++i ) {
      if ( iarr[ i ] == test ) {
        contains = true;
      }
    }
    return contains;
  }

  public static void printIntArray( int[] iarr ) {
    for ( int i = 0; i < iarr.length; ++i ) {
      System.out.print( iarr[ i ] );
      if ( i < iarr.length - 1 ) {
        System.out.print( ", " );
      }
    }
  }

  public static void printIntArrayShort( int[] iarr ) {
    int berStart = 0;
    int berEnde = 0;
    // Achtung i wird in der Schleife modifiziert
    for ( int i = 0; i < iarr.length; ++i ) {
      berStart = i;
      berEnde = i;
      while ( berEnde + 1 < iarr.length && iarr[ berEnde ] + 1 == iarr[ berEnde + 1 ] ) {
        berEnde++;
      }
      if ( berStart != berEnde ) {
        System.out.print( iarr[ berStart ] + "-" + iarr[ berEnde ] );
        i = berEnde;
      } else {
        System.out.print( iarr[ berStart ] );
      }
      if ( i < iarr.length - 1 ) {
        System.out.print( ", " );
      }
    }
  }
}
