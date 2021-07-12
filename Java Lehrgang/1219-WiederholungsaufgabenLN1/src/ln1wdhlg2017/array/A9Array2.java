package ln1wdhlg2017.array;

import java.util.Arrays;

public class A9Array2 {

  public static void main( String[] args ) {
    int[] iarr = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    boolean[] barr = new boolean[]{ true, false, true, false, false, false, true, true, true };
    System.out.println( Arrays.toString( iarr ) );
    System.out.println( Arrays.toString( barr ) );
    switchSign( iarr, barr );
    System.out.println( Arrays.toString( iarr ) );

  }

  public static void switchSign( int[] iarr, boolean[] barr ) {
    if ( iarr.length == barr.length ) {
      for ( int i = 0; i < iarr.length; ++i ) {
        if ( !barr[ i ] ) {
          iarr[ i ] *= -1;
        }
      }
    }
  }

}
