package basic.version7.view.viewStern;

import basic.version7.model.ZahlEinfach;
import basic.version7.view.View;

public class ViewStern  implements View {

  private ZahlEinfach model;

  public ViewStern( ZahlEinfach model ) {
    this.model = model;
  }

  public void ausgabe() {
    StringBuilder sb = new StringBuilder( model.getZahl() );
    for ( int i = 0; i < model.getZahl(); ++i ) {
      sb.append( '*' );
    }
    System.out.println( sb );
  }

}
