package ln1wdhlg2018.aufgabe09schach.model.figuren;

import ln1wdhlg2018.aufgabe09schach.model.Farbe;
import ln1wdhlg2018.aufgabe09schach.model.koord.PosConstraint;

public class Koenig extends Figur {
  public Koenig( String name, Farbe farbe ) {
    super( name, farbe, PosConstraint.KOENIG );
  }

  public Koenig( Farbe farbe ) {
    this( "", farbe );
  }

  @Override
  public char getSymbol() {
    return 'K';
  }

}
