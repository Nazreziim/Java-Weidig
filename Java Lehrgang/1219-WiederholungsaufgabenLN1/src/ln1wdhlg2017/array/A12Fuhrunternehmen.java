package ln1wdhlg2017.array;

public class A12Fuhrunternehmen {

  public static void main( String[] args ) {
    int[][] verbrauch = new int[ 10 ][ 12 ];
    fill( verbrauch );
    printQuartale( verbrauch );
  }

  public static void fill( int[][] iarr ) {
    for ( int v = 0; v < iarr.length; ++v ) {
      for ( int m = 0; m < iarr[ 0 ].length; ++m ) {
        iarr[ v ][ m ] = (int) ( Math.random() * 99 + 1 );
      }
    }
  }

  public static void printQuartale( int[][] iarr ) {
    for ( int q = 0; q < 4; ++q ) {
      System.out.println( "Quartal " + ( q + 1 ) );
      for ( int v = 0; v < iarr.length; ++v ) {
        System.out.println( " Produkt " + v + ": " + ( iarr[ v ][ q + 0 ] + iarr[ v ][ q + 1 ]
                + iarr[ v ][ q + 2 ] + iarr[ v ][ q + 3 ] ) );
      }
    }
  }
}
