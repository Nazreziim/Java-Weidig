package mvc_propertychange.controller;

import mvc_propertychange.model.ZahlEinfach;

public class Controller {

  ZahlEinfach model;

  public Controller( ZahlEinfach model ) {
    this.model = model;
  }

  public void start() {
    for ( int i = 0; i < 5; ++i ) {
      this.model.increment();
    }

    this.model.sub( 3 );

    this.model.add( 100 );

  }

}
