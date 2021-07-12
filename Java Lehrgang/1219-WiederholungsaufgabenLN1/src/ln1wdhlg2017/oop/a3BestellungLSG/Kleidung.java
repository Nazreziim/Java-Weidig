package ln1wdhlg2017.oop.a3BestellungLSG;

public abstract class Kleidung extends Artikel {

  private String farbe;
  private int groesse;

  public Kleidung( String farbe, int groesse ) {
    this.farbe = farbe;
    this.groesse = groesse;
  }

  public String getFarbe() {
    return this.farbe;
  }

  public int getGroesse() {
    return this.groesse;
  }

}
