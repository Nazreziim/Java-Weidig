package ln1wdhlg2018.aufgabe09schach.model.figuren;

import ln1wdhlg2018.aufgabe09schach.model.Farbe;
import ln1wdhlg2018.aufgabe09schach.model.koord.PosConstraint;

public class Laeufer extends Figur {
  public Laeufer( String name, Farbe farbe ) {
    super( name, farbe, PosConstraint.LAEUFER );
  }

  public Laeufer( Farbe farbe ) {
    this( "", farbe );
  }

  @Override
  public char getSymbol() {
    return 'L';
  }

}
