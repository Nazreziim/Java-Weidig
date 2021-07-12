package ln1wdhlg2017.array;

import java.util.Arrays;

public class A6ArrayConcat {

  public static void main( String[] args ) {
    int[] a = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    int[] b = new int[]{ 3, 4, 5, 5, 4, 3 };
    System.out.println( Arrays.toString( a ) );
    System.out.println( Arrays.toString( b ) );
    System.out.println( Arrays.toString( concatArray( a, b ) ) );
  }

  public static int[] concatArray( int[] a, int[] b ) {
    int[] result = new int[ a.length + b.length ];
    for ( int i = 0; i < a.length; ++i ) {
      result[ i ] = a[ i ];
    }
    for ( int i = 0; i < b.length; ++i ) {
      result[ a.length + i ] = b[ i ];
    }
    return result;
  }

}
