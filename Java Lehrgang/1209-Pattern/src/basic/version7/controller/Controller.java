package basic.version7.controller;

import java.util.List;

import basic.version7.model.ZahlEinfach;
import basic.version7.view.View;

public class Controller {

  private ZahlEinfach model;
  private List< View > views;

  public Controller( ZahlEinfach model, List< View > views ) {
    this.model = model;
    this.views = views;
  }

  public void start() {

    for ( int i = 0; i < 5; ++i ) {
      // Daten werden aktualisiert
      model.increment();

      // Ausgaben generieren in unterschiedlicher Form
      ausgabe();

    }

    // Daten werden aktualisiert
    model.sub( 3 );

    // Ausgaben generieren in unterschiedlicher Form
    ausgabe();

    // Daten werden aktualisiert
    model.add( 100 );

    // Ausgaben generieren in unterschiedlicher Form
    ausgabe();
  }

  private void ausgabe() {
    for ( View view : views ) {
      view.ausgabe();
    }
  }

}
