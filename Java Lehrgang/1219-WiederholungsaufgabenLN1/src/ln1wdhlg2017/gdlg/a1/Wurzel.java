package ln1wdhlg2017.gdlg.a1;

public class Wurzel {

  public static void main( String... strings ) {
    for ( int i = 0; i < 26; ++i ) {
      System.out.printf( "sqrt(%d) = %f = %f%n", i, Math.sqrt( i ),
              sqrtApproximation( i, 0.000001 ) );
    }
  }

  public static double sqrtApproximation( double a, double eps ) {
    double sqrt = 0;
    double sqrt_1;
    if ( a < 1 ) {
      sqrt = 1;
    } else {
      sqrt = a;
    }
    do {
      sqrt_1 = sqrt;
      sqrt = sqrt_1 - ( Math.pow( sqrt_1, 2 ) - a ) / ( 2 * sqrt_1 );
    } while ( Math.abs( sqrt - sqrt_1 ) > eps );

    return sqrt;
  }

}
