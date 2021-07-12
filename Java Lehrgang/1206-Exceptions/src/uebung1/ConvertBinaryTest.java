package uebung1;

import java.util.Scanner;

public class ConvertBinaryTest {

  public static void main( String[] args ) {
    // Test der Methode und Exception:
    // System.out.println( "0 = " + ConvertBinary.convert( "0" ) );
    // System.out.println( "1 = " + ConvertBinary.convert( "1" ) );
    // System.out.println( "10 = " + ConvertBinary.convert( "10" ) );
    // System.out.println( "11 = " + ConvertBinary.convert( "11" ) );
    // System.out.println( "100 = " + ConvertBinary.convert( "100" ) );
    // System.out.println( "101 = " + ConvertBinary.convert( "101" ) );
    // System.out.println( "1000000000 = " + ConvertBinary.convert( "1000000000" ) );
    // System.out.println( "1000b00000 = " + ConvertBinary.convert( "1000b000020" ) );

    // Nutzer Eingabe:
    Scanner sc = new Scanner( System.in );
    System.out.print( "Geben Sie hier eine Bin‰rzahl ein: " );
    try {
      String binary = sc.next();
      System.out.println( binary + " = " + ConvertBinary.convert2( binary ) );
    } catch ( NoBinaryNumberException e ) {
      System.err.println( "Ihre Eingabe lieﬂ sich nicht in eine Zahl umwandeln. Fehlermeldung: "
              + e.getMessage() );
    } finally {
      sc.close();
    }
  }

}
