package schritt3UebungStack;

public class Zeitung {
  private String name;
  private String datum;

  public Zeitung( String name, String datum ) {
    this.setName( name );
    this.setDatum( datum );
  }

  public String getName() {
    return this.name;
  }

  public void setName( String name ) {
    this.name = name;
  }

  public String getDatum() {
    return this.datum;
  }

  public void setDatum( String datum ) {
    this.datum = datum;
  }

  @Override
  public String toString() {
    return "Zeitung: " + this.name + " vom " + this.datum;
  }

}
