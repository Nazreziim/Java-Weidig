package templates;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HilfsMeth {

  public static byte readByte() {
    return readByte( "Bitte geben Sie ein byte ein." );
  }

  public static byte readByte( String abfrage ) {
    // Die Funktion fordert den Nutzer dazu auf, eine ganze Zahl vom Typ byte
    // über die Kommandozeile einzugeben, liest diese ein und gibt
    // sie als Integerwert zurück.

    try {
      byte a;
      BufferedReader testin = new BufferedReader( new InputStreamReader( System.in ) );
      System.out.println( abfrage );
      a = Byte.parseByte( testin.readLine() );
      return a;
    } catch ( IOException e ) {
      return 42;
    }
  }

  public static short readShort() {
    return readShort( "Bitte geben Sie eine ganze Zahl vom Typ short ein" );
  }

  public static short readShort( String abfrage ) {
    // Die Funktion fordert den Nutzer dazu auf, eine ganze Zahl vom Typ short
    // über die Kommandozeile einzugeben, liest diese ein und gibt
    // sie als Integerwert zurück.

    try {
      short a;
      BufferedReader testin = new BufferedReader( new InputStreamReader( System.in ) );
      System.out.println( abfrage );
      a = Short.parseShort( testin.readLine() );
      return a;
    } catch ( IOException e ) {
      return 42;
    }
  }

  public static int readInt() {
    return readInt( "Bitte geben Sie eine ganze Zahl vom Typ int ein" );
  }

  public static int readInt( String abfrage ) {
    // Die Funktion fordert den Nutzer dazu auf, eine ganze Zahl vom Typ int
    // über die Kommandozeile einzugeben, liest diese ein und gibt
    // sie als Integerwert zurück.
    try {
      int a;
      BufferedReader testin = new BufferedReader( new InputStreamReader( System.in ) );
      System.out.println( abfrage );
      a = Integer.parseInt( testin.readLine() );
      return a;
    } catch ( IOException e ) {
      return 42;
    }
  }

  public static long readLong() {
    return readLong( "Bitte geben Sie eine ganze Zahl vom Typ long ein" );
  }

  public static long readLong( String abfrage ) {
    // Die Funktion fordert den Nutzer dazu auf, eine ganze Zahl vom Typ long
    // über die Kommandozeile einzugeben, liest diese ein und gibt
    // sie als long-Integerwert zurück.

    try {
      long a;
      BufferedReader testin = new BufferedReader( new InputStreamReader( System.in ) );
      System.out.println( abfrage );
      a = Long.parseLong( testin.readLine() );
      return a;
    } catch ( IOException e ) {
      return 42;
    }
  }

  public static float readFloat() {
    return readFloat( "Bitte geben Sie eine Zahl vom Typ float ein." );
  }

  public static float readFloat( String abfrage ) {
    // Die Funktion fordert den Nutzer dazu auf, eine ganze Gleitkommazahl
    // über die Kommandozeile einzugeben, liest diese ein und gibt
    // sie als Integerwert zurück.

    try {
      float a;
      BufferedReader testin = new BufferedReader( new InputStreamReader( System.in ) );
      System.out.println( abfrage );
      a = Float.parseFloat( testin.readLine() );
      return a;
    } catch ( IOException e ) {
      return 42.0f;
    }
  }

  public static double readDouble() {
    return readDouble( "Bitte geben Sie eine Zahl vom Typ double ein." );
  }

  public static double readDouble( String abfrage ) {
    // Die Funktion fordert den Nutzer dazu auf, eine ganze Gleitkommazahl
    // über die Kommandozeile einzugeben, liest diese ein und gibt
    // sie als Integerwert zurück.

    try {
      double a;
      BufferedReader testin = new BufferedReader( new InputStreamReader( System.in ) );
      System.out.println( abfrage );
      a = Double.parseDouble( testin.readLine() );
      return a;
    } catch ( IOException e ) {
      return 42.0;
    }
  }

  public static char readChar() {
    return readChar( "Bitte geben Sie ein Zeichen ein." );
  }

  public static char readChar( String abfrage ) {
    // Die Funktion fordert den Nutzer dazu auf, ein Character - Zeichen
    // über die Kommandozeile einzugeben, liest diese ein und gibt
    // sie als Integerwert zurück.

    try {
      char a;
      BufferedReader testin = new BufferedReader( new InputStreamReader( System.in ) );
      System.out.println( abfrage );
      a = testin.readLine().charAt( 0 );
      return a;
    } catch ( IOException e ) {
      return 'f';
    }
  }

  public static String readString() {
    return readString( "Bitte geben Sie eine Zeichenreihe ein." );
  }

  public static String readString( String abfrage ) {
    // Die Funktion fordert den Nutzer dazu auf, eine Zeichenreihe
    // über die Kommandozeile einzugeben, liest diese ein und gibt
    // sie als Integerwert zurück.

    try {
      String a;
      BufferedReader testin = new BufferedReader( new InputStreamReader( System.in ) );
      System.out.println( abfrage );
      a = testin.readLine();
      return a;
    } catch ( IOException e ) {
      return "IO-Fehler";
    }
  }

  public static boolean readBoolean() {
    return readBoolean( "Bitte geben Sie true oder false ein." );
  }

  public static boolean readBoolean( String abfrage ) {
    // Die Funktion fordert den Nutzer dazu auf, einen Wahrheitswert
    // über die Kommandozeile einzugeben, liest diesen ein und gibt
    // ihn als Integerwert zurück.

    try {
      boolean a;
      BufferedReader testin = new BufferedReader( new InputStreamReader( System.in ) );
      System.out.println( abfrage );
      a = Boolean.valueOf( testin.readLine() ).booleanValue();
      return a;
    } catch ( IOException e ) {
      return false;
    }
  }
}
