package ln1wdhlg2017.array;

public class A16McCarthy {

  public static void main( String[] args ) {
    System.out.printf( "%20s%20s%n", "Zahl", "mac( Zahl )" );
    for ( int i = 1; i < 121; ++i ) {
      System.out.printf( "%20d%20d%n", i, mac( i ) );
    }

  }

  public static int mac( int n ) {
    int result = 0;
    if ( n > 100 ) {
      result = n - 10;
    } else {
      result = mac( mac( n + 11 ) );
    }
    return result;
  }
}
