package ln1wdhlg2018.aufgabe09schach.model.figuren;

import ln1wdhlg2018.aufgabe09schach.model.Farbe;
import ln1wdhlg2018.aufgabe09schach.model.koord.PosConstraint;

public class Dame extends Figur {
  public Dame( String name, Farbe farbe ) {
    super( name, farbe, PosConstraint.DAME );
  }

  public Dame( Farbe farbe ) {
    this( "", farbe );
  }

  @Override
  public char getSymbol() {
    return 'D';
  }

}
