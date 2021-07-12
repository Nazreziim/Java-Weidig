package ln1wdhlg2018.aufgabe02passwortchecker;

public class PasswortChecker {

  public static boolean pwCheck( char[] passwort ) {
    boolean ok = true;
    // a
    if ( passwort.length < 8 ) {
      ok = false;
    }
    // b
    int anzBuchstaben = 0;
    // c
    int anzZiffern = 0;
    // d
    boolean gBuchstabe = false;
    boolean kBuchstabe = false;
    // e
    boolean sonderZeichen = false;
    // f
    boolean innerhalb = false;
    for ( int i = 0; i < passwort.length; ++i ) {
      if ( passwort[ i ] >= 'a' && passwort[ i ] <= 'z' ) {
        kBuchstabe = true;
        ++anzBuchstaben;
      } else if ( passwort[ i ] >= 'A' && passwort[ i ] <= 'Z' ) {
        gBuchstabe = true;
        ++anzBuchstaben;
      } else if ( passwort[ i ] >= '0' && passwort[ i ] <= '9' ) {
        if ( i > 0 && i < passwort.length - 1 ) {
          innerhalb = true;
        }
        ++anzZiffern;
      } else if ( passwort[ i ] == '!' || passwort[ i ] == '§' || passwort[ i ] == '$'
              || passwort[ i ] == '%' || passwort[ i ] == '&' || passwort[ i ] == '('
              || passwort[ i ] == ')' || passwort[ i ] == '+' || passwort[ i ] == '-' ) {
        if ( i > 0 && i < passwort.length - 1 ) {
          innerhalb = true;
        }
        sonderZeichen = true;
      }
    }
    if ( anzBuchstaben < 2 || anzZiffern < 2 || !kBuchstabe || !gBuchstabe || !sonderZeichen
            || !innerhalb ) {
      ok = false;
    }
    return ok;
  }

  public static void main( String[] args ) {
    System.out.println( pwCheck( "AxB1&a8c".toCharArray() ) );
    System.out.println( pwCheck( "1passw0rt".toCharArray() ) );
  }
  
}
