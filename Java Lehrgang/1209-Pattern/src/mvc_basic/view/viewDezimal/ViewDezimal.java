package mvc_basic.view.viewDezimal;

import mvc_basic.model.ZahlEinfach;
import mvc_basic.view.View;

public class ViewDezimal implements View {

  private ZahlEinfach model;

  public ViewDezimal( ZahlEinfach model ) {
    this.model = model;
  }

  public void show() {
    System.out.println( "Die Zahl ist: " + model.getZahl() );
  }

}
