package vererbung;

public class Pkw extends Fahrzeug {

  public void tanken() {
    System.out.println( "durstig" );
  }
  
  @Override
  public String fahren() {
    return "Pkws " + super.fahren() + " anders." + this.getMarke();
  }

  public Pkw( String marke ) {
    this( marke, 0 );
  }
  
  public Pkw( String marke, int alter ) {
    super( marke, alter );
    System.out.println( "PKW Konstruktor" );
  }

}
