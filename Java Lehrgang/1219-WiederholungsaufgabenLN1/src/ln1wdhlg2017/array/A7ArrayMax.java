package ln1wdhlg2017.array;

public class A7ArrayMax {

  public static void main( String... strings ) {
    int[][][] test = new int[][][]{ { { 1, 2, 3, 4 }, { 1, 2, 3, 4, 5 } },
            { { 9, 8, 7, 6, 5 }, { 5, 4, 5, 6, 3 } }, { { 22, 123, 94 }, { -110, -70 } } };
    System.out.println( max( test ) );
  }

  public static int max( int[][][] iarr ) {
    int max = Integer.MIN_VALUE;
    for ( int[][] iar : iarr ) {
      for ( int[] ia : iar ) {
        for ( int i : ia ) {
          if ( i > max ) {
            max = i;
          }
        }
      }
    }
    return max;
  }
}
