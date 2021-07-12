package mvc_basic.controller;

import java.util.ArrayList;
import java.util.List;

import mvc_basic.model.ZahlEinfach;
import mvc_basic.view.View;

public class Controller {

  List< View > views = new ArrayList< View >();
  ZahlEinfach model;

  public Controller( ZahlEinfach model, View... views ) {
    this.model = model;
    for ( View v : views ) {
      this.views.add( v );
    }
  }

  public void start() {
    for ( int i = 0; i < 5; ++i ) {
      this.model.increment();
      for ( View v : this.views ) {
        v.show();
      }
    }

    this.model.sub( 3 );
    for ( View v : this.views ) {
      v.show();
    }

    this.model.add( 100 );
    for ( View v : this.views ) {
      v.show();
    }

  }

}
