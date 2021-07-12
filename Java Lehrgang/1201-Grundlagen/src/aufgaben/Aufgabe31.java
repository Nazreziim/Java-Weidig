package aufgaben;
import java.util.Arrays;

public class Aufgabe31 {

  public static void main( String[] args ) {

    // a)
    double[] gehalt = new double[ 20 ];
    Arrays.fill( gehalt, 0, 2, 3000.0 );
    System.out.println( Arrays.toString( gehalt ) );

    // b)
    int[] zahlen = new int[ 5 ];
    for ( int i = 0; i < zahlen.length; ++i ) {
      zahlen[ i ] = 2 * i;
    }
    System.out.println( Arrays.toString( zahlen ) );

    // c)
    String[] namen = { "Jody Foster", "Bon Jovi", "Frank Zappa" };
    System.out.println( Arrays.toString( namen ) );
  }

}
