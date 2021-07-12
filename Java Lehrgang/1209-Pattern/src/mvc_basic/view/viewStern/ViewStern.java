package mvc_basic.view.viewStern;

import mvc_basic.model.ZahlEinfach;
import mvc_basic.view.View;

public class ViewStern implements View {

  private ZahlEinfach model;

  public ViewStern( ZahlEinfach model ) {
    this.model = model;
  }

  public void show() {
    StringBuilder sb = new StringBuilder( model.getZahl() );
    for ( int i = 0; i < model.getZahl(); ++i ) {
      sb.append( '*' );
    }
    System.out.println( sb );
  }

}
