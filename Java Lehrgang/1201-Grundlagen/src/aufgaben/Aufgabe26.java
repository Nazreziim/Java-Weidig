package aufgaben;

public class Aufgabe26 {

  public static void main( String[] args ) {

    int n = HilfsMeth.readInt( "n = " );

    // a)
    int spalte = 1;
    int zeile = 1;
    while ( zeile <= n ) {
      spalte = 1;
      while ( spalte <= zeile ) {
        System.out.print( zeile + " " );
        ++spalte;
      }
      System.out.println( "" );
      ++zeile;
    }

    // b)
    for ( int z = 1; z <= n; ++z ) {
      for ( int s = 1; s <= z; ++s ) {
        System.out.print( z + " " );
      }
      System.out.println( "" );
    }

    // c)
    zeile = 1;
    do {
      spalte = 1;
      do {
        System.out.print( zeile + " " );
        ++spalte;
      } while ( spalte <= zeile );
      System.out.println( "" );
      ++zeile;
    } while ( zeile <= n );
  }

}
