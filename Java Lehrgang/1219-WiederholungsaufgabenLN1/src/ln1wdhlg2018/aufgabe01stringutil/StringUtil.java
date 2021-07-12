package ln1wdhlg2018.aufgabe01stringutil;

public abstract class StringUtil {

  public static char toUpperCase( char buchstabe ) {
    char erg = buchstabe;
    if ( erg >= 'a' && erg <= 'z' ) {
      erg += ( 'A' - 'a' );
    }
    return erg;
  }

  public static String toUpperCase( String zeichenfolge ) {
    char[] erg = zeichenfolge.toCharArray();
    for ( int i = 0; i < erg.length; ++i ) {
      erg[ i ] = toUpperCase( erg[ i ] );
    }
    return new String( erg );
  }

  public static char toLowerCase( char buchstabe ) {
    char erg = buchstabe;
    if ( erg >= 'A' && erg <= 'Z' ) {
      erg += ( 'a' - 'A' );
    }
    return erg;
  }

  public static String toLowerCase( String zeichenfolge ) {
    char[] erg = zeichenfolge.toCharArray();
    for ( int i = 0; i < erg.length; ++i ) {
      erg[ i ] = toLowerCase( erg[ i ] );
    }
    return new String( erg );
  }

  public static void main( String... strings ) {
    System.out.println( toUpperCase( 'a' ) );
    System.out.println( toUpperCase( 'z' ) );
    System.out.println( toUpperCase( 'A' ) );
    System.out.println( toUpperCase( 'Z' ) );

    System.out.println( toUpperCase( "ab..xyz, AB...XYZ" ) );

    System.out.println( toLowerCase( 'a' ) );
    System.out.println( toLowerCase( 'z' ) );
    System.out.println( toLowerCase( 'A' ) );
    System.out.println( toLowerCase( 'Z' ) );

    System.out.println( toLowerCase( "ab..xyz, AB...XYZ" ) );

  }

}
