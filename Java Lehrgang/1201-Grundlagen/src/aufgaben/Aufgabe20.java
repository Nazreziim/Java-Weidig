package aufgaben;
import java.util.Random;


public class Aufgabe20 {

  public static void main( String[] args ) {

    Random r = new Random();
    
    int zahl = r.nextInt( 11 ); // => 0 - 10

    int eingabe = HilfsMeth.readInt( "Bitte raten Sie:" );

    if ( eingabe != zahl ) {
      eingabe = HilfsMeth.readInt( "Bitte raten Sie erneut:" );
      if ( eingabe != zahl ) {
        eingabe = HilfsMeth.readInt( "Bitte raten Sie ein letztes Mal:" );
        if ( eingabe != zahl ) {
          System.out.println( "Leider nicht gewonnen" );
        }
      }
    }

    if ( eingabe == zahl ) {
      System.out.println( "Sie haben richtig geraten." );
    }
  }

}
