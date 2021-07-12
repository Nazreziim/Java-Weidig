package vererbung;

public class Bmw3 extends Pkw {

  public Bmw3( String marke, int alter ) {
    super( marke, alter );
    System.out.println( "BMW3 Konstruktor" );
  }

  public void hupen() {
    System.out.println( "hupen" );
  }

  @Override
  public String fahren() {
    return super.fahren() + " (drengeln und blinken)";
  }

}
