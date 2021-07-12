package methoden;

public class Template_Methoden_lang {

  /**
   * @param args
   */
  public static void main( String[] args ) {

    int zahl1 = 3;
    int zahl2 = 5;
    int zahl3 = gebeInitWert();

    ausgabeUeberschrift();

    System.out.println( "Ausgabe von Zahl1" );
    ausgabe( zahl1 );

    System.out.println( "Ausgabe von Zahl2" );
    ausgabe( zahl2 );

    System.out.println( "Vertauschen der Zahlen" );
    vertausche( zahl1, zahl2 );

    System.out.println( "Sind die Zahlen vertauscht?" );
    ausgabe( zahl1 );
    ausgabe( zahl2 );

    System.out.println( "Ausgabe von Zahl_3" );
    ausgabe( zahl3 );

    zahl3 = gebeGroessereZahl( zahl1, zahl2 );

    ausgabe( gebeGroessereZahl( zahl1, 5 ) );

    ///////////////////////////////////////////////////////
    male_ein_rechteck( 5, 3 );
    int additions_ergebnis = addiere( 5, 6 );
    System.out.println( additions_ergebnis );
    System.out.println( addiere( 7, 7 ) );
    addiere( 2, 2 ); // Was ist denn jetzt mit dem Ergebnis??? Keine Ahnung! Weg!

  }

  /***
   * Methode ohne Rueckgabeparameter (Prozedur) und ohne Übergabeparameter.
   */
  public static void ausgabeUeberschrift() {
    System.out.println( "Ueberblick - Unterprogramme -" );
    System.out.println( "=============================" );
  }

  /***
   * Methode ohne Rueckgabeparameter (Prozedur) mit einem Uebergabeparameter
   * 
   * @param a
   */
  public static void ausgabe( int a ) {
    System.out.println( "Ausgabe: " + a );
  }

  /***
   * Methode ohne Rueckgabeparameter (Prozedur) mit einem Uebergabeparameter
   * 
   * @param a
   */
  public static void ausgabe( String meldung, int a ) {
    System.out.println( meldung + a );
  }

  /***
   * Methode ohne Rueckgabeparameter (Prozedur) mit zwei Uebergabeparameter
   * 
   * @param a
   * @param b
   */
  public static void vertausche( int a, int b ) {
    // Dreieckstausch
    int temp = a;
    a = b;
    b = temp;

  }

  /***
   * Methode mit Rueckgabewert (Funktion) und ohne Uebergabeparameter.
   * 
   * @return
   */
  public static int gebeInitWert() {
    return 0;
  }

  /***
   * Methode mit Rueckgabewert (Funktion) und mit Uebergabeparameter.
   * 
   * @param a
   * @param b
   * @return
   */
  public static int gebeGroessereZahl( int a, int b ) {
    int ergebnis = 0;

    if ( a > b ) {
      ergebnis = a;
    } else {
      ergebnis = b;
    }

    return ergebnis;
  }

  // 2.) Eine Methode, die eine Zeile mit anzahl * ausgibt
  public static void male_eine_zeile( int anzahl ) {
    for ( int i = 1; i <= anzahl; i++ ) {
      System.out.print( "*" );
    }
    System.out.println();
  }

  // 3.) Eine Methode, die ein Rechteck aus * ausgibt, und dabei die Methode aus 2.) benutzt
  public static void male_ein_rechteck( int breite, int hoehe ) {
    for ( int i = 1; i <= hoehe; i++ ) {
      male_eine_zeile( breite );
    }
  }

  // 4.) Eine Methode mit return, die zwei Zahlen addiert und das Ergebnis zurückliefert
  public static int addiere( int z1, int z2 ) {
    int ergebnis = 0;
    ergebnis = z1 + z2;
    return ergebnis;
  }
}
