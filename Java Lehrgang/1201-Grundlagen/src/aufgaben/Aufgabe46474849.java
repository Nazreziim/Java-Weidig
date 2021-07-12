package aufgaben;

public class Aufgabe46474849 {

  public static void main( String[] args ) {

    // 46
    System.out.println( getAnzahlZiffern( 2542 ) );
    System.out.println( getZiffernWert( 27381, 3 ) );
    System.out.println( ersetzeZiffer( 24135, 3, 7 ) );

    // 47
    System.out.println( ggT( 18, 12 ) );

    // 48 b)
    for ( int i = 0; i < 9; ++i ) {
      System.out.print( reihe( i ) + ", " );
    }
    System.out.println();
    // 48 c)
    for ( int i = 0; i < 9; ++i ) {
      System.out.print( reiheIt( i ) + ", " );
    }

    // 49
    System.out.println();
    for ( int i = 0; i < 9; ++i ) {
      System.out.print( fib( i ) + ", " );
    }
  }

  public static int getAnzahlZiffern( int zahl ) {
    int anzahl = 1;
    if ( zahl >= 10 ) {
      anzahl += getAnzahlZiffern( zahl / 10 );
    }
    return anzahl;
  }

  public static int getZiffernWert( int zahl, int stelle ) {
    int ziffer = 0;
    if ( zahl == 0 ) {
      ziffer = 0;
    } else if ( stelle == 0 ) {
      ziffer = zahl % 10;
    } else {
      ziffer = getZiffernWert( zahl / 10, stelle - 1 );
    }
    return ziffer;
  }

  public static int ersetzeZiffer( int zahl, int stelle, int wert ) {
    int ergebnis = 0;
    if ( stelle == 0 ) {
      ergebnis = ( zahl / 10 ) * 10 + wert;
    } else {
      ergebnis = ersetzeZiffer( zahl / 10, stelle - 1, wert );
      ergebnis = ergebnis * 10 + zahl % 10;
    }
    return ergebnis;
  }

  public static int ggT( int a, int b ) {
    int ggt = 0;
    if ( a == 0 ) {
      ggt = b;
    } else if ( b == 0 ) {
      ggt = a;
    } else {
      ggt = ggT( b, a % b );
    }
    return ggt;
  }

  public static int reihe( int n ) {
    int ergebnis = 0;
    if ( n == 0 ) {
      ergebnis = 0;
    } else if ( n == 1 ) {
      ergebnis = 1;
    } else {
      ergebnis = 2 * reihe( n - 1 ) + reihe( n - 2 ) + 1;
    }
    return ergebnis;
  }

  public static int reiheIt( int n ) {
    int ergebnis = 0;
    int letzte = 1;
    int vorletzte = 0;
    if ( n == 0 ) {
      ergebnis = vorletzte;
    } else if ( n == 1 ) {
      ergebnis = letzte;
    } else {
      for ( int i = 2; i <= n; ++i ) {
        ergebnis = 2 * letzte + vorletzte + 1;
        vorletzte = letzte;
        letzte = ergebnis;
      }
    }
    return ergebnis;
  }

  public static int fib( int n ) {
    int ergebnis = 0;
    if ( n == 0 ) {
      ergebnis = 0;
    } else if ( n == 1 ) {
      ergebnis = 1;
    } else {
      ergebnis = fib( n - 1 ) + fib( n - 2 );
    }
    return ergebnis;
  }
}
