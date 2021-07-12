package ln1wdhlg2017.oop.a3BestellungLSG;

public class KleidungM extends Kleidung {

  public KleidungM( String farbe, int groesse ) {
    super( farbe, groesse );
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + " " + this.getFarbe() + " " + this.getGroesse();
  }

}
