package ln1wdhlg2018.aufgabe09schach.model.figuren;

import ln1wdhlg2018.aufgabe09schach.model.Farbe;
import ln1wdhlg2018.aufgabe09schach.model.koord.PosConstraint;

public class Turm extends Figur {
  public Turm( String name, Farbe farbe ) {
    super( name, farbe, PosConstraint.TURM );
  }

  public Turm( Farbe farbe ) {
    this( "", farbe );
  }

  @Override
  public char getSymbol() {
    return 'T';
  }

}
