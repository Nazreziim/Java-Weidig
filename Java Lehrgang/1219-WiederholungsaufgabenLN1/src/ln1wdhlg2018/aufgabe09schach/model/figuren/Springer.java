package ln1wdhlg2018.aufgabe09schach.model.figuren;

import ln1wdhlg2018.aufgabe09schach.model.Farbe;
import ln1wdhlg2018.aufgabe09schach.model.koord.PosConstraint;

public class Springer extends Figur {
  public Springer( String name, Farbe farbe ) {
    super( name, farbe, PosConstraint.SPRINGER );
  }

  public Springer( Farbe farbe ) {
    this( "", farbe );
  }

  @Override
  public char getSymbol() {
    return 'S';
  }

}
