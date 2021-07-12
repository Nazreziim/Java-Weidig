package uebung1.controller;

import java.util.ArrayList;
import java.util.List;

import uebung1.model.Ganzzahl;
import uebung1.view.View;

public class Controller {

  private Ganzzahl model;
  private List< View > views;

  public Controller( Ganzzahl model, View... views ) {
    this.model = model;
    this.views = new ArrayList< View >( views.length );
    for ( View v : views ) {
      this.views.add( v );
    }
  }

  public void start() {
    this.ausgabeZahl( model.getZahl() );

    model.add( 35 );
    this.ausgabeZahl( model.getZahl() );

    model.sub( 25 );
    this.ausgabeZahl( model.getZahl() );

    model.add( 100 );
    this.ausgabeZahl( model.getZahl() );

    model.decrement();
    this.ausgabeZahl( model.getZahl() );
  }

  private void ausgabeZahl( Integer zahl ) {
    for ( View v : this.views ) {
      v.ausgabeZahl( zahl );
    }
  }

}
