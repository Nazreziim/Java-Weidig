package _1aufzeigen;

//NullPointerException geh�rt zu den RunTimeExceptions --> Diese sind unchecked und bedeutet, dass diese "einfach" passieren und nicht behandelt werden m�ssen
public class BeispielNullPointerException {

  public static void main( String[] args ) {
    
	 
	String testString = null;
    testString.toString();

    System.out.println( "Nach der Ausnahme... hier kommt niemand hin." );
    
    

  }

}
