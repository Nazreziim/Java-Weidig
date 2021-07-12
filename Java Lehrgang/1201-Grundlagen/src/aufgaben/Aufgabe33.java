package aufgaben;
import java.util.Arrays;

public class Aufgabe33 {

  public static void main( String[] args ) {

    // a)
    int n = HilfsMeth.readInt( "Anzahl der Fibonacci Zahlen:" );

    int[] fib = new int[ n ];

    // b)
    Arrays.fill( fib, 0, 2, 1 );

    for ( int i = 2; i < fib.length; ++i ) {
      fib[ i ] = fib[ i - 2 ] + fib[ i - 1 ];
    }

    System.out.println( Arrays.toString( fib ) );

  }

}
