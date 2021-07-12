package aufgaben;


public class Aufgabe27 {

  public static void main( String[] args ) {
    char eingabe = 'n';
    do {

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
              // intentionally empty
          }
        }
      }

      if ( prozent >= 0 && prozent <= 100 ) {
        System.out.printf( "%.2f%n", note );
      } else {
        System.out.println( "ungültig" );
      }
      
      eingabe = HilfsMeth.readChar( "Weitere Noten berechnen? (J/N):" );
    } while ( eingabe == 'j' || eingabe == 'J' );
  }

}
