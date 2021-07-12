package basic.version7.view.viewDezimal;

import basic.version7.model.ZahlEinfach;
import basic.version7.view.View;

public class ViewDezimal  implements View {

  private ZahlEinfach model;

  public ViewDezimal( ZahlEinfach model ) {
    this.model = model;
  }

  public void ausgabe() {
    System.out.println( "Die Zahl ist: " + model.getZahl() );
  }

}
