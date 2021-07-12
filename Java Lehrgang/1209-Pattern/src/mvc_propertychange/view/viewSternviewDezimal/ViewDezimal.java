package mvc_propertychange.view.viewSternviewDezimal;

import java.beans.PropertyChangeEvent;

import mvc_propertychange.model.ZahlEinfach;
import mvc_propertychange.view.View;

public class ViewDezimal implements View {

  private ZahlEinfach model;

  public ViewDezimal( ZahlEinfach model ) {
    this.model = model;
    this.model.addPropertyChangeListener( this );
  }

  public void show() {
    System.out.println( "Die Zahl ist: " + model.getZahl() );
  }

  @Override
  public void propertyChange( PropertyChangeEvent evt ) {
    this.show();
  }

}
