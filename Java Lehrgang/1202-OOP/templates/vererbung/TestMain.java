package vererbung;

public class TestMain {

  public static void main( String[] args ) {
    
    Test t = new Test();
    Test t2 = t;
    
    System.out.println( t ); // Aufruf von t.toString() von Object
    
    System.out.println( t.equals( t2 ) ); // t.equals() von Object
    System.out.println( t == t2 ); // Vergleich auf Referenzen
    
    System.out.println( Integer.toHexString( t2.hashCode() ) ); 
    // HashCode von Object
    
    
  }
  
}
