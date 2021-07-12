package ln1wdhlg2017.array;

import ln1wdhlg2017.gdlg.a2.HilfsMeth;

public class A14Primfaktoren {

  public static void main( String[] args ) {
    int zahl = HilfsMeth.readInt( "Geben Sie eine Zahl ein:" );
    int anzahlFaktoren = 0;
    int[] faktoren = new int[ 100 ];
    System.out.print( "Primfaktorenzerlegung: " );
    int test = zahl;
    int biggestPrime = 1;
    do {
      // Größten Primfaktor finden
      biggestPrime = findBiggestPrimeFactor( test );
      // 1 ist keine Primzahl -> nicht hinzufügen
      if ( biggestPrime != 1 ) {
        faktoren[ anzahlFaktoren++ ] = biggestPrime;
      }
      // Zwischenergebnis durch den größten Primfaktor teilen
      test = test / biggestPrime;
      // Abbruch, falls 1 erreicht
    } while ( biggestPrime != 1 );
    for ( int i = anzahlFaktoren - 1; i >= 0; --i ) {
      System.out.print( faktoren[ i ] );
      if ( i != 0 ) {
        System.out.print( " * " );
      }
    }

  }

  public static int findBiggestPrimeFactor( int n ) {
    int biggestPrime = 0;
    boolean gefunden = false;
    for ( int i = n; !gefunden && i > 0; --i ) {
      if ( n % i == 0 && isPrime( i ) ) {
        biggestPrime = i;
        gefunden = true;
      }
    }
    return biggestPrime;
  }

  public static boolean isPrime( int n ) {
    boolean prime = true;
    for ( int i = 2; i <= Math.sqrt( n ); ++i ) {
      if ( n % i == 0 ) {
        prime = false;
      }
    }
    return prime;
  }
}
