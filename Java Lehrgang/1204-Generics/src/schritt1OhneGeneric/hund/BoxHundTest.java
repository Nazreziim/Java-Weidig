package schritt1OhneGeneric.hund;

public class BoxHundTest {

  public static void main( String[] args ) {

    BoxHund hundeBox = new BoxHund( new Hund() );

    System.out.println( hundeBox.getInhalt() );
    hundeBox.getInhalt().bellen();
  }

}
