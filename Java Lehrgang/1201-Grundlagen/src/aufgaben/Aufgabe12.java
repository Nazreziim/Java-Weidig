package aufgaben;


public class Aufgabe12 {

  public static void main( String[] args ) {

    double fahrenheit = HilfsMeth.readDouble( "Geben Sie eine Temperatur in Fahrenheit ein:" );
    double celsius = ( fahrenheit - 32.0 ) * 5.0 / 9.0;
    System.out.printf( "%.2f Fahrenheit entsprechen %.2f Grad Celsius.%n%n", fahrenheit, celsius );

    celsius = HilfsMeth.readDouble( "Geben Sie eine Temperatur in Celsius ein:" );
    fahrenheit = celsius * 9.0 / 5.0 + 32.0;
    System.out.printf( "%.2f Celsius entsprechen %.2f Grad Fahrenheit.", celsius, fahrenheit );

  }

}
