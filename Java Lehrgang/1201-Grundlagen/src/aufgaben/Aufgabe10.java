package aufgaben;


public class Aufgabe10 {

  public static void main( String[] args ) {

    final byte SEC_PER_MIN = 60;
    final byte MIN_PER_HOUR = 60;
    final byte HOURS_PER_DAY = 24;

    long sekunden = HilfsMeth.readLong( "Geben Sie eine Sekundenanzahl ein: " );

    byte s = (byte) ( sekunden % SEC_PER_MIN );
    byte m = (byte) ( ( sekunden / SEC_PER_MIN ) % MIN_PER_HOUR );
    byte h = (byte) ( ( sekunden / SEC_PER_MIN / MIN_PER_HOUR ) % HOURS_PER_DAY );
    long d = sekunden / SEC_PER_MIN / MIN_PER_HOUR / HOURS_PER_DAY;

    System.out.println( d + " " + h + " " + m + " " + s );

  }

}
