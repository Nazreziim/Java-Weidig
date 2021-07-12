package ln1wdhlg2017.array;

import java.util.Arrays;

public class A8ArraySort {

  public static void main( String... strings ) {
    int[] test = new int[]{ 1, 9, 7, 6, 5, 4, 3, 1 };

    System.out.println( Arrays.toString( test ) );
    setFirstMax( test );
    System.out.println( Arrays.toString( insertSort( test ) ) );
    reverseArray( test );
    System.out.println( Arrays.toString( test ) );
    sortArray( test );
    System.out.println( Arrays.toString( test ) );

  }

  public static void setFirstMax( int[] iarr ) {
    int max = Integer.MIN_VALUE;
    int maxIdx = -1;
    for ( int i = 0; i < iarr.length; ++i ) {
      if ( iarr[ i ] > max ) {
        max = iarr[ i ];
        maxIdx = i;
      }
    }
    if ( maxIdx > 0 ) {
      int tmp = iarr[ 0 ];
      iarr[ 0 ] = iarr[ maxIdx ];
      iarr[ maxIdx ] = tmp;
    }
  }

  public static void reverseArray( int[] iarr ) {
    for ( int i = 0; i < iarr.length / 2; ++i ) {
      int tmp = iarr[ i ];
      iarr[ i ] = iarr[ iarr.length - i - 1 ];
      iarr[ iarr.length - i - 1 ] = tmp;
    }
  }

  public static void sortArray( int[] iarr ) {
    for ( int sorted = 0; sorted < iarr.length; ++sorted ) {
      int min = Integer.MAX_VALUE;
      int minIdx = sorted;
      for ( int i = sorted; i < iarr.length; ++i ) {
        if ( iarr[ i ] < min ) {
          min = iarr[ i ];
          minIdx = i;
        }
      }
      if ( minIdx > sorted ) {
        int tmp = iarr[ sorted ];
        iarr[ sorted ] = iarr[ minIdx ];
        iarr[ minIdx ] = tmp;
      }
    }
  }

  public static int[] insertSort( int[] iarr ) {
    int[] result = new int[ iarr.length ];
    for ( int i = 0; i < iarr.length; ++i ) {
      int insertIdx = 0;
      while ( insertIdx < result.length && iarr[ i ] < result[ insertIdx ] ) {
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
}
