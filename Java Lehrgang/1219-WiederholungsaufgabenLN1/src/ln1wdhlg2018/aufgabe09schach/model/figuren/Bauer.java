package ln1wdhlg2018.aufgabe09schach.model.figuren;

import ln1wdhlg2018.aufgabe09schach.model.Farbe;
import ln1wdhlg2018.aufgabe09schach.model.koord.PosConstraint;

public class Bauer extends Figur {
  public Bauer( String name, Farbe farbe ) {
    super( name, farbe, PosConstraint.BAUER );
  }

  public Bauer( Farbe farbe ) {
    this( "", farbe );
  }

  @Override
  public char getSymbol() {
    return 'B';
  }

}
