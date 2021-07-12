package ln1wdhlg2017.array;

public class A5Array2D {

  public static void main( String... strings ) {
    int[][] testarr = new int[ 3 ][ 4 ];
    printArray( testarr );
    fillArray( testarr );
    printArray( testarr );
    printArray( moduloArray( testarr ) );
  }

  public static int[][] moduloArray( int[][] iarr ) {
    int[][] narr = new int[ iarr.length ][ iarr[ 0 ].length ];
    for ( int z = 0; z < iarr.length; ++z ) {
      for ( int s = 0; s < iarr[ z ].length; ++s ) {
        narr[ z ][ s ] = iarr[ z ][ s ] % ( z + 1 );
      }
    }
    return narr;
  }

  public static void printArray( int[][] iarr ) {
    int max = 0;
    for ( int[] iar : iarr ) {
      for ( int i : iar ) {
        if ( i > max ) {
          max = i;
        }
      }
    }
    max = Integer.toString( max ).length();

    for ( int[] iar : iarr ) {
      System.out.print( '|' );
      for ( int i : iar ) {
        System.out.printf( " %" + max + "d|", i );
      }
      System.out.println();
    }
  }

  public static void fillArray( int[][] iarr ) {
    if ( checkRectangleArr( iarr ) ) {
      int zeilen = iarr.length;
      int spalten = iarr[ 0 ].length;
      for ( int z = 0; z < zeilen; ++z ) {
        for ( int s = 0; s < spalten; ++s ) {
          iarr[ z ][ s ] = z * spalten + s + 1;
        }
      }
    }
  }

  public static boolean checkRectangleArr( int[][] iarr ) {
    boolean rechteck = true;
    if ( iarr != null && iarr.length > 0 && iarr[ 0 ] != null ) {
      int zeilen = iarr.length;
      int spalten = iarr[ 0 ].length;
      for ( int i = 1; rechteck && i < zeilen; ++i ) {
        if ( iarr[ i ] == null || iarr[ i ].length != spalten ) {
          rechteck = false;
        }
      }
    } else {
      rechteck = false;
    }
    return rechteck;
  }

}
