package aufgaben;


public class Aufgabe21 {

  public static void main( String[] args ) {

    double size = HilfsMeth.readDouble( "Kˆrpergrˆﬂe (m) :" );
    double mass = HilfsMeth.readDouble( "Kˆpermasse (kg) :" );

    double bmi = mass / ( size * size );

    System.out.printf( "BMI = %.2f (kg/m^2) %n", bmi );

    System.out.print( "Kategorie = " );

    if ( bmi >= 40 ) {
      System.out.println( "Adipositas Grad III" );
    } else if ( bmi >= 35 ) {
      System.out.println( "Adipositas Grad II" );
    } else if ( bmi >= 30 ) {
      System.out.println( "Adipositas Grad I" );
    } else if ( bmi >= 25 ) {
      System.out.println( "Pr‰adipositas" );
    } else if ( bmi >= 18.5 ) {
      System.out.println( "Normalgewicht" );
    } else if ( bmi >= 17 ) {
      System.out.println( "leichtes Untergewicht" );
    } else if ( bmi >= 16 ) {
      System.out.println( "m‰ﬂiges Untergewicht" );
    } else {
      System.out.println( "starkes Untergewicht" );
    }

  }

}
