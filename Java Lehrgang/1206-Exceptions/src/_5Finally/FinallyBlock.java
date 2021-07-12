package _5Finally;

public class FinallyBlock {

  public static void main( String... strings ) {
    try {
      Integer.parseInt( "19%" );
    } catch ( NumberFormatException e ) {
      System.err.println( "[CATCHED] Exception: Hier komme ich hin." );
    } finally {
      System.out.println( "Finally: Ich werde bei einer Exception ausgeführt....." );
    }

    try {
      Integer.parseInt( "19" );
    } catch ( NumberFormatException e ) {
      System.err.println( "[Nicht gecatched] Keine Exception: Hier komme ich eh nicht hin." );
    } finally {
      System.out.println( "Finally: und auch ohne." );
    }

  }

}
