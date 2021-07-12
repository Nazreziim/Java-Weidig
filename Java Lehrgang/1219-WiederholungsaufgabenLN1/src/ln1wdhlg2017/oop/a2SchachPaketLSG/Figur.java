package ln1wdhlg2017.oop.a2SchachPaketLSG;

public abstract class Figur {
  private final char farbe;
  private Koordinate pos;

  public Figur( char farbe ) {
    this.farbe = farbe;
    this.setPos( new Koordinate( 0, 0 ) );
  }

  public abstract boolean bedroht( Koordinate ziel );

  public abstract ZugListe getZuege();

  public char getFarbe() {
    return this.farbe;
  }

  public Koordinate getPos() {
    return this.pos;
  }

  public void setPos( Koordinate pos ) {
    this.pos = pos;
  }

  @Override
  public String toString() {
    return " '" + this.getFarbe() + "' (" + this.getPos().getZeile() + ", "
            + this.getPos().getSpalte() + ")";
  }
}
