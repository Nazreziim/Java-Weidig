package mvc_propertychange.view.viewStern;

import java.beans.PropertyChangeEvent;

import mvc_propertychange.model.ZahlEinfach;
import mvc_propertychange.view.View;

public class ViewStern implements View {

  private ZahlEinfach model;

  public ViewStern( ZahlEinfach model ) {
    this.model = model;
    model.addPropertyChangeListener( this );
  }

  public void show() {
    StringBuilder sb = new StringBuilder( model.getZahl() );
    for ( int i = 0; i < model.getZahl(); ++i ) {
      sb.append( '*' );
    }
    System.out.println( sb );
  }

  @Override
  public void propertyChange( PropertyChangeEvent evt ) {
    this.show();
  }

}
