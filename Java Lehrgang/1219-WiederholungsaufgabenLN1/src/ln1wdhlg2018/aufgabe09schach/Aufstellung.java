package ln1wdhlg2018.aufgabe09schach;

import ln1wdhlg2018.aufgabe09schach.model.Brett;
import ln1wdhlg2018.aufgabe09schach.model.Farbe;
import ln1wdhlg2018.aufgabe09schach.model.figuren.Bauer;
import ln1wdhlg2018.aufgabe09schach.model.figuren.Dame;
import ln1wdhlg2018.aufgabe09schach.model.figuren.Koenig;
import ln1wdhlg2018.aufgabe09schach.model.figuren.Laeufer;
import ln1wdhlg2018.aufgabe09schach.model.figuren.Springer;
import ln1wdhlg2018.aufgabe09schach.model.figuren.Turm;
import ln1wdhlg2018.aufgabe09schach.view.BrettView;

public class Aufstellung {
  public static void main( String[] args ) {
    final int MIN_REIHEN = 1;
    final int MAX_REIHEN = 8;
    final char MIN_LINIEN = 'A';
    final char MAX_LINIEN = 'H';

    Brett brett = new Brett( MAX_REIHEN, MAX_LINIEN );

    //@formatter:off
    while ( brett.add( new Bauer( Farbe.WEISS ) ) );
    while ( brett.add( new Bauer( Farbe.SCHWARZ ) ) );
    while ( brett.add( new Dame( Farbe.WEISS ) ) );
    while ( brett.add( new Dame( Farbe.SCHWARZ ) ) );
    while ( brett.add( new Koenig( Farbe.WEISS ) ) );
    while ( brett.add( new Koenig( Farbe.SCHWARZ ) ) );
    while ( brett.add( new Laeufer( Farbe.WEISS ) ) );
    while ( brett.add( new Laeufer( Farbe.SCHWARZ ) ) );
    while ( brett.add( new Springer( Farbe.WEISS ) ) );
    while ( brett.add( new Springer( Farbe.SCHWARZ ) ) );
    while ( brett.add( new Turm( Farbe.WEISS ) ) );
    while ( brett.add( new Turm( Farbe.SCHWARZ ) ) );
    //@formatter:on

    BrettView brettView = new BrettView( brett );

    System.out.println( brettView );
  }
}
