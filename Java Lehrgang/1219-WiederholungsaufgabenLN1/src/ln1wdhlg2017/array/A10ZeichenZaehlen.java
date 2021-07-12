package ln1wdhlg2017.array;

import java.util.Arrays;

public class A10ZeichenZaehlen {

  public static void main( String... strings ) {
    int[] iarr = new int[]{ 1, 4, 2, 2, 1, 1 };
    System.out.println( Arrays.toString( iarr ) );
    System.out.println( Arrays.deepToString( countInts( iarr ) ) );
  }

  public static int[][] countInts( int[] iarr ) {
    int[][] result;
    int[] tmp = new int[ iarr.length ];
    for ( int i = 0; i < tmp.length; ++i ) {
      tmp[ i ] = Integer.MIN_VALUE;
    }
    int inserted = 0;
    int insertIdx = 0;
    for ( int i = 0; i < iarr.length; ++i ) {
      boolean drin = false;
      for ( int j = 0; !drin && j < inserted; ++j ) {
        if ( tmp[ j ] == iarr[ i ] ) {
          drin = true;
        }
      }
      if ( !drin ) {
        tmp[ inserted ] = iarr[ i ];
        ++inserted;
      }
    }
    result = new int[ 2 ][ inserted ];
    for ( int i = 0; i < inserted; ++i ) {
      result[ 1 ][ i ] = tmp[ i ];
      int count = 0;
      for ( int j = 0; j < iarr.length; ++j ) {
        if ( tmp[ i ] == iarr[ j ] ) {
          ++count;
        }
      }
      result[ 0 ][ i ] = count;
    }
    return result;
  }

}
