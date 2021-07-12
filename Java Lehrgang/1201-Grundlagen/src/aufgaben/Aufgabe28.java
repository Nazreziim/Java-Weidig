package aufgaben;


public class Aufgabe28 {

  public static void main( String[] args ) {

    System.out.println( "Abbruch mit n<0:" );
    int n = HilfsMeth.readInt( "n = " );

    do {

      int summe = 0;

      for ( int i = 1; i <= n; ++i ) {
        summe += (int) Math.pow( i, 2 );
      }

      System.out.println( "Summe = " + summe );

      n = HilfsMeth.readInt( "n = " );

    } while ( n > 0 );
  }

}
