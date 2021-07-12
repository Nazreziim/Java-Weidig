package ln1wdhlg2017.oop.a3BestellungLSG;

public class KleidungW extends Kleidung {

  public KleidungW( String farbe, int groesse ) {
    super( farbe, groesse );
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + " " + this.getFarbe() + " " + this.getGroesse();
  }

}
