package aufgaben;


public class Aufgabe15 {

  public static void main( String[] args ) {

    char auswahl = HilfsMeth.readChar( "Wollen Sie den Umfang (u) oder den Flächeninhalt (A) berechnen: " );

    double radius = 0.0;

    if ( auswahl == 'A' || auswahl == 'u' ) {

      radius = HilfsMeth.readDouble( "Radius:" );

    }

    if ( auswahl == 'u' ) {

      double umfang = 2 * Math.PI * radius;

      System.out.printf( "Umfang: u = 2 * PI * r = 2 * PI * %f = %.2f%n", radius, umfang );

    } else if ( auswahl == 'A' ) {

      double flaeche = Math.PI * radius * radius;

      System.out.printf( "Flächeninhalt: A = PI * r^2 = PI * %f^2 = %.2f%n", radius, flaeche );

    } else {

      System.out.println( "Ungültige Eingabe." );

    }

  }

}
