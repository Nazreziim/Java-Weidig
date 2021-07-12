package ln1wdhlg2017.array;

public class A2ArrayVergleich {

  public static void main( String[] args ) {
    System.out.println( compareIntArrays( new int[]{ 1, 2, 3 }, new int[]{ 1, 2, 3 } ) );
    System.out.println( compareIntArrays( new int[]{ 1, 2, 3 }, new int[]{ 1, 2 } ) );
    System.out.println( compareIntArrays( new int[]{ 1, 2, 3 }, new int[]{ 1, 2, 4 } ) );
  }

  public static boolean compareIntArrays( int[] a, int[] b ) {
    boolean result = true;
    if ( a.length != b.length ) {
      result = false;
    } else {
      for ( int i = 0; i < a.length; ++i ) {
        if ( a[ i ] != b[ i ] ) {
          result = false;
        }
      }
    }
    return result;
  }
}
