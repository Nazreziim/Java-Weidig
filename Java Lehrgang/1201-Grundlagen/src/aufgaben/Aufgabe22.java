package aufgaben;


public class Aufgabe22 {

  public static void main( String[] args ) {

    int prozent = HilfsMeth.readInt( "Prozent:" );

    double note = 6.0;

    if ( prozent >= 0 && prozent <= 100 ) {
      if ( 50 <= prozent && prozent < 100 ) {
        note = 10.99 - 0.1 * prozent;
      } else {
        switch ( prozent ) {
          case 100 :
            note = 1.0;
            break;
          default :
        }
      }
    }

    if ( prozent >= 0 && prozent <= 100 ) {
      System.out.printf( "%.2f", note );
    } else {
      System.out.println( "ungültig" );
    }

  }

}
