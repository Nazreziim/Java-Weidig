package ln1wdhlg2018.aufgabe09schach.view;

import ln1wdhlg2018.aufgabe09schach.model.Brett;
import ln1wdhlg2018.aufgabe09schach.model.figuren.Figur;
import ln1wdhlg2018.aufgabe09schach.model.koord.Koordinate;

public class BrettView {

  private Brett brett;

  public BrettView( Brett brett ) {
    this.brett = brett;
  }

  public Brett getBrett() {
    return this.brett;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    for ( int reihe = this.brett.getANZ_REIHEN(); reihe > 0; --reihe ) {
      sb.append( genLinie() );
      for ( int linie = 1; linie <= this.brett.getANZ_LINIEN(); ++linie ) {
        Figur f = this.brett.getFigur( new Koordinate( reihe, (char) Koordinate.koordInt2Char( linie ) ) );
        if ( f == null ) {
          sb.append( "   |" );
        } else {
          sb.append( " " + f.getSymbol() + f.getFarbe().getAbk() + "|" );
        }
      }
      sb.append( '\n' );
    }
    sb.append( genLinie() );

    return sb.toString();
  }

  public StringBuilder genLinie() {
    StringBuilder sb = new StringBuilder( "" );
    for ( int linie = 1; linie <= this.brett.getANZ_LINIEN(); ++linie ) {
      sb.append( "---|" );
    }
    sb.append( '\n' );
    return sb;
  }
}
