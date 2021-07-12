package uebung2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import uebung2.model.Ganzzahl;
import uebung2.view.View;

public class Controller implements Observer {

  private Ganzzahl model;
  private List< View > views;

  public Controller( Ganzzahl model, View... views ) {
    this.model = model;
    this.views = new ArrayList< View >( views.length );
    for ( View v : views ) {
      this.views.add( v );
    }
    this.model.addObserver( this );
  }

  public void start() {
    model.add( 35 );
    model.sub( 25 );
    model.add( 100 );
    model.decrement();
  }

  private void ausgabeZahl( Integer zahl ) {
    for ( View v : this.views ) {
      v.ausgabeZahl( zahl );
    }
  }

  @Override
  public void update( Observable arg0, Object arg1 ) {
    this.ausgabeZahl( model.getZahl() );
  }

}
