package ln1wdhlg2018.aufgabe08ekons;

public class Ekons {

  public static void main( String[] args ) {

    System.out.println( ekons( 34991815 ) );
    System.out.println( ekons( 19324678 ) );
  }

  public static int ekons( long l ) {
    int result = -1;
    if ( l >= (long) Math.pow( 10, 3 ) && l < (long) Math.pow( 10, 8 ) ) {
      result = 0;
      for ( int i = 1; i < Long.toString( l ).length() + 1; ++i ) {
        result += quersumme( intAt( l, i - 1 ) * ( i % 2 + 1 ) );
      }
    }
    result %= 10;
    return result;
  }

  public static int intAt( long l, int i ) {
    if ( i >= 0 && i < Long.toString( l ).length() ) {
      return Integer.parseInt( Long.toString( l ).substring( i, i + 1 ) );
    } else {
      return -1;
    }
  }

  public static int quersumme( long z ) {
    int result = 0;
    if ( z < 0 ) {
      z = -z;
    }
    for ( int i = 0; i < Long.toString( z ).length(); ++i ) {
      result += intAt( z, i );
    }
    return result;
  }

}
