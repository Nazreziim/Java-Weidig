package mvc_basic;

import mvc_basic.controller.Controller;
import mvc_basic.model.ZahlEinfach;
import mvc_basic.view.viewDezimal.ViewDezimal;
import mvc_basic.view.viewStern.ViewStern;

public class Main {

  public static void main( String[] args ) {
    ZahlEinfach model = new ZahlEinfach();
    ViewDezimal view1 = new ViewDezimal( model );
    ViewStern view2 = new ViewStern( model );

    Controller c = new Controller( model, view1, view2 );
    c.start();
  }

}
