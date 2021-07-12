package mvc_observer.view.viewSternviewDezimal;

import java.util.Observable;

import mvc_observer.model.ZahlEinfach;
import mvc_observer.view.View;

public class ViewDezimal implements View {

  private ZahlEinfach model;

  public ViewDezimal( ZahlEinfach model ) {
    this.model = model;
    this.model.addObserver( this );
  }

  public void show() {
    System.out.println( "Die Zahl ist: " + model.getZahl() );
  }

  @Override
  public void update( Observable o, Object arg ) {
    this.show();
  }

}
