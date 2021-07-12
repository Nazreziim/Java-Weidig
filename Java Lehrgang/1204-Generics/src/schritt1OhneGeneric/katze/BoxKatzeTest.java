package schritt1OhneGeneric.katze;

public class BoxKatzeTest {
  public static void main( String[] args ) {

    BoxKatze katzenBox = new BoxKatze( new Katze() );

    System.out.println( katzenBox.getInhalt() );
    katzenBox.getInhalt().miau();
  }

}
