package aufgaben;


public class Aufgabe16 {

  public static void main( String[] args ) {

    char buchstabe = HilfsMeth.readChar( "Buchstabe:" );

    // @formatter:off
      if ( buchstabe == 'a' || buchstabe == 'A' || 
           buchstabe == 'e' || buchstabe == 'E' || 
           buchstabe == 'i' || buchstabe == 'I' || 
           buchstabe == 'o' || buchstabe == 'O' || 
           buchstabe == 'u' || buchstabe == 'U' ) {
        // @formatter:on
      System.out.println( "Eingabe war ein Vokal: " + Character.toUpperCase( buchstabe ) );
    } else {
      System.out.println( "Einagbe war kein Vokal." );
    }
     
    switch ( buchstabe ) {
      case 'a' : 
      case 'A' :
      case 'e' :
      case 'E' :
      case 'i' :
      case 'I' :
      case 'o' :
      case 'O' :
      case 'u' :
      case 'U' :
        System.out.println( "Eingabe war ein Vokal: " + Character.toUpperCase( buchstabe ) );
        break;
      default :
        System.out.println( "Einagbe war kein Vokal." );
    }

    buchstabe = Character.toUpperCase( buchstabe );

    // @formatter:off
      if ( buchstabe == 'A' || 
           buchstabe == 'E' || 
           buchstabe == 'I' || 
           buchstabe == 'O' || 
           buchstabe == 'U' ) {
        // @formatter:on
      System.out.println( "Eingabe war ein Vokal: " + Character.toUpperCase( buchstabe ) );
    } else {
      System.out.println( "Einagbe war kein Vokal." );
    }

    switch ( buchstabe ) {
      case 'A' :
      case 'E' :
      case 'I' :
      case 'O' :
      case 'U' :
        System.out.println( "Eingabe war ein Vokal: " + Character.toUpperCase( buchstabe ) );
        break;
      default :
        System.out.println( "Einagbe war kein Vokal." );
    }

  }

}
