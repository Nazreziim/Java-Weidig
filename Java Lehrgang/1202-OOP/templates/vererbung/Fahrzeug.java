package vererbung;

public class Fahrzeug {



  public Fahrzeug( String marke ) {
    this( marke, 0 );
  }

  public Fahrzeug() {
    this(  "", 0 );
  }
  
  public Fahrzeug( String marke, int alter ) {
    System.out.println( "Fahrzeug Konstruktor" );
    this.marke = marke;
    this.alter = alter;
  }

  public String fahren() {
    return "fahren (" + this.marke + ")";
  }

  public String getMarke() {
    return this.marke;
  }
  
  private String marke = "audi";
  private int alter = 0;

  
  
}
