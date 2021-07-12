package ln1wdhlg2018.aufgabe09schach.model.figuren;

import ln1wdhlg2018.aufgabe09schach.model.Farbe;
import ln1wdhlg2018.aufgabe09schach.model.koord.Koordinate;
import ln1wdhlg2018.aufgabe09schach.model.koord.PosConstraint;

public abstract class Figur {

  private Farbe farbe;
  private String name;
  private Koordinate pos;
  private PosConstraint posConstraint;

  public Figur( String name, Farbe farbe, PosConstraint posConstraint ) {
    this.name = name != null && !name.isEmpty() ? name : this.getClass().getSimpleName();
    this.farbe = farbe;
    this.posConstraint = posConstraint;
  }

  public Koordinate getPos() {
    return pos;
  }

  public void setPos( Koordinate pos ) {
    this.pos = pos;
  }

  public Farbe getFarbe() {
    return farbe;
  }

  public String getName() {
    return name;
  }

  public PosConstraint getPosConstraint() {
    return this.posConstraint;
  }

  @Override
  public String toString() {
    String pos = "";
    if ( this.getPos() != null ) {
      pos = ", Pos: " + this.getPos().getReihe() + ", " + this.getPos().getLinie();
    }
    return this.getName() + " ( " + this.getClass().getSimpleName() + ", " + this.getFarbe() + pos
            + " )";
  }
  
  public abstract char getSymbol();

}
