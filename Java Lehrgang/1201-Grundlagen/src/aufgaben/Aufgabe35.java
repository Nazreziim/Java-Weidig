package aufgaben;
import java.util.Arrays;

public class Aufgabe35 {

  public static void main( String... args ) {

    int anzahl = HilfsMeth.readInt( "Anzahl Spieler:" );

    int reim = HilfsMeth.readInt( "Länge Reim:" );

    boolean[] spieler = new boolean[ anzahl ];

    Arrays.fill( spieler, true );

    int index = 0;
    int spielerZaehler = 0;
    int reimZaehler = 0;

    while ( spielerZaehler < spieler.length ) {

      if ( spieler[ index ] ) {
        reimZaehler++;
        if ( reimZaehler == reim ) {
          spieler[ index ] = false;
          System.out.println( "Spieler " + ( index + 1 ) + " ist raus." );
          reimZaehler = 0;
          spielerZaehler++;
        }
      }
      index++;
      if ( index == spieler.length ) {
        index = 0;
      }

    }

  }

}
