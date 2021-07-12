package aufgaben;
import java.util.Random;

public class Aufgabe32 {

  public static void main( String[] args ) {

    Random r = new Random();

    int[] werte = new int[ 20 ];
    for ( int i = 0; i < werte.length; ++i ) {
      werte[ i ] = r.nextInt( 1001 );
    }

    int min = werte[ 0 ];
    int max = werte[ 0 ];
    int summe = werte[ 0 ];

    for ( int i = 1; i < werte.length; ++i ) {
      if ( min > werte[ i ] ) {
        min = werte[ i ];
      }
      if ( max < werte[ i ] ) {
        max = werte[ i ];
      }
      summe += werte[ i ];
    }

    double average = (double) summe / werte.length;

    System.out.printf( "Min-Wert:%6d\n", min );
    System.out.printf( "Max-Wert:%6d\n", max );
    System.out.printf( "Durchschnittswert:%7.2f\n", average );

    System.out.println( "\nMin-Wert\n" );

    for ( int i = 1000; i >= 0; i -= 100 ) {
      System.out.printf( "%5d", i );
      if ( i <= min ) {
        System.out.print( "  ***" );
      }
      System.out.println( "" );
    }

    System.out.println( "\nMax-Wert\n" );

    for ( int i = 1000; i >= 0; i -= 100 ) {
      System.out.printf( "%5d", i );
      if ( i <= max ) {
        System.out.print( "  ***" );
      }
      System.out.println( "" );
    }

    System.out.println( "\nMin-/Max-Wert\n" );

    for ( int i = 1000; i >= 0; i -= 100 ) {
      System.out.printf( "%5d", i );
      if ( i <= min ) {
        System.out.print( "  ***" );
      } else {
        System.out.print( "     " );
      }
      if ( i <= max ) {
        System.out.print( "  ***" );
      }
      System.out.println( "" );
    }

  }

}
