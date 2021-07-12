package nichtGenutzt;

public class MethodsExceptions {
  public static void main( String... args ) {
    try {
      // Integer[] iarr = new Integer[ 3 ];
      // System.out.println( iarr[ 3 ].toString() );
      anfangMethode();
    } catch ( NullPointerException | IndexOutOfBoundsException e ) {

      // Den Grund der Exception erfahren
      String cause = ( e.getCause() == null )
              ? "Die Exception ist selbst der Grund: " + e.getClass().getSimpleName()
              : e.getCause().toString(); // In diesem Fall wäre die Exception ausgelöst worden und
                                         // ihr ein Objekt vom Typ Throwable (eine andere Exception)
                                         // übergeben worden.

      System.err.println( "Grund: " + cause ); // Grund ausgeben.

      System.err.println( "Nachricht: " + e.getLocalizedMessage() ); // Eine eventuell vorhandene
                                                                     // Nachricht ausgaben.

      e.printStackTrace(); // Den StackTrace ausgeben. Dieser zeigt, welche Methoden beteiligt
                           // waren, als die Exception geworfen wurde.
    }

    System.out.println( "Hier endet das Programm." );
  }

  public static void exceptionMethode() throws NullPointerException {
//    String exception = null;
//    exception.toString();
    
    int[] arr = new int[1];
    for(int i = 0; i < 2; i++) {
    	System.out.println(arr[i]);
    }
  }

  public static void anfangMethode() {
    zwischenMethode();
  }

  public static void zwischenMethode() {
    zwischenMethode2();
  }

  public static void zwischenMethode2() {
    exceptionMethode();
  }
}
