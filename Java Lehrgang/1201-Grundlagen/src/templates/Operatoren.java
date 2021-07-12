package templates;

public class Operatoren {

  public static void main( String[] args ) {

    System.out.println( "Ganzzahlen:" );

    int a = -5;
    int b = 3;

    System.out.println( a + b );
    System.out.println( a - b );
    System.out.println( a * b );
    System.out.println( a / b );
    System.out.println( a % b );

    System.out.println( a < b );
    System.out.println( a <= b );
    System.out.println( a > b );
    System.out.println( a >= b );
    System.out.println( a == b );
    System.out.println( a != b );

    System.out.println( ++a ); // Prefix (Der neue Wert wird für die Berechnung genutzt.)
    System.out.println( --a ); // Prefix (Der neue Wert wird für die Berechnung genutzt.)
    System.out.println( b++ ); // Postfix (Der alte Wert wird für die Berechnung genutzt.)
    System.out.println( b-- ); // Postfix (Der alte Wert wird für die Berechnung genutzt.)

    System.out.println( a << 2 ); // Bitmuster nach links schieben = jedesmal mit 2 multiplizieren
    System.out.println( a >> 1 ); // Bitmuster nach rechts schieben = jedesmal durch 2 teilen
                                  // (Vorzeichen wird beachtet)
    System.out.println( a >>> 1 ); // Bitmuster nach rechts schieben = jedesmal durch 2 teilen
                                   // (Vorzeichen wird nicht beachtet)

    System.out.println( ~b ); // bitwise not
    System.out.println( b & 2 ); // bitwise and
    System.out.println( 5 | 2 ); // bitwise or
    System.out.println( 3 ^ 2 ); // bitwise xor ( nur 1 falls sich die Operanden unterscheiden )

    System.out.println( b = 7 );

    a += a;
    System.out.println( a );

    System.out.println( "Fließkommazahlen:" );

    double c = 3.141F; // Float Literal
    double d = 1.0;

    System.out.println( c + d );
    System.out.println( c - d );
    System.out.println( c * d );
    System.out.println( c / d );
    System.out.println( c % d );

    System.out.println( c < d );
    System.out.println( c <= d );
    System.out.println( c > d );
    System.out.println( c >= d );
    System.out.println( c == d );
    System.out.println( c != d );

    System.out.println( c++ );
    System.out.println( c-- );
    System.out.println( c );
    System.out.println( ++c );
    System.out.println( --c );

    System.out.println( "Durch null teilen?" );
    System.out.println( -1.0 / 0.0 );

    System.out.println( "Wurzel von -1:" );
    System.out.println( Math.sqrt( -1 ) );

    System.out.println( "Zeichen:" );

    char e = 'a';
    char f = 'A';
    e = '\\';

    System.out.println( e );
    System.out.println( (char) ( e + 1 ) ); // Casting / Typkonvertierung
    System.out.println( (char) ( e - 1 ) );
    System.out.println( (char) ( e * 2 ) );
    System.out.println( (char) ( e / 2 ) );
    System.out.println( (char) ( e % 32 + 32 ) );

    System.out.println( e < f );
    System.out.println( e <= f );
    System.out.println( e > f );
    System.out.println( e >= f );
    System.out.println( e == f );
    System.out.println( e != f );

    System.out.println( e << 2 );
    System.out.println( e >> 2 );
    System.out.println( (char) ( e >>> 2 ) );

    System.out.println( f++ );
    System.out.println( f-- );
    System.out.println( ++f );
    System.out.println( --f );

    System.out.println( (char) ( ~e ) );
    System.out.println( e & 2 );
    System.out.println( e | 2 );
    System.out.println( e ^ 2 );

    System.out.println( "Wahrheitswerte:" );

    boolean g = true;
    boolean h = false;

    System.out.println( g );
    System.out.println( h );

    System.out.println( g & h ); // UND
    System.out.println( g && h ); // UND (Kurzschluss-Operator)

    System.out.println( g | h ); // ODER
    System.out.println( g || h ); // ODER (Kurzschluss-Operator)

    System.out.println( g ^ h ); // XOR

    System.out.println( !g ); // NOT

    System.out.println( g ? 10 % 3 : 3.14159 ); // Ternärer Operator

    Object o = g ? a = 10 % 3 : false;

    System.out.println( o );

    System.out.println( "weitere Literale:" );
    long l = 0xCAFEBABEL; // Long Literal

    System.out.println( 0xAFFE ); // Hexadezimal Literal
    System.out.println( 0312 ); // Oktal Literal
    System.out.println( 0b110 ); // Binär Literal

  }

}
