package ln1wdhlg2017.array;

import java.util.Arrays;

public class A15BubbleSort {

  public static void main( String[] args ) {

    int[] iarr = new int[]{ 9, 10, 1, 2, 3, 4, 6, 5, 8, 110, 109, 836, 1000, -200, 33 };
    System.out.println( Arrays.toString( iarr ) );
    bubbleSort( iarr );
    System.out.println( Arrays.toString( iarr ) );
  }

  public static void bubbleSort( int[] iarr ) {
    int vertauschungen = -1;
    int tmp;
    while ( vertauschungen != 0 ) {
      vertauschungen = 0;
      for ( int i = 0; i < iarr.length - 1; ++i ) {
        if ( iarr[ i ] > iarr[ i + 1 ] ) {
          tmp = iarr[ i ];
          iarr[ i ] = iarr[ i + 1 ];
          iarr[ i + 1 ] = tmp;
          ++vertauschungen;
        }
      }
    }
  }
}
