package mvc_observer.view.viewStern;

import java.util.Observable;

import mvc_observer.model.ZahlEinfach;
import mvc_observer.view.View;

public class ViewStern implements View {

  private ZahlEinfach model;

  public ViewStern( ZahlEinfach model ) {
    this.model = model;
    model.addObserver( this );
  }

  public void show() {
    StringBuilder sb = new StringBuilder( model.getZahl() );
    for ( int i = 0; i < model.getZahl(); ++i ) {
      sb.append( '*' );
    }
    System.out.println( sb );
  }

  @Override
  public void update( Observable arg0, Object arg1 ) {
    this.show();
  }

}
