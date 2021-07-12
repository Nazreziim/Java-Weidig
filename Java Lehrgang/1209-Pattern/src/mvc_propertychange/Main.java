package mvc_propertychange;

import mvc_propertychange.controller.Controller;
import mvc_propertychange.model.ZahlEinfach;
import mvc_propertychange.view.viewStern.ViewStern;
import mvc_propertychange.view.viewSternviewDezimal.ViewDezimal;

public class Main {

  public static void main( String[] args ) {
    ZahlEinfach model = new ZahlEinfach();
    ViewDezimal view1 = new ViewDezimal( model );
    ViewStern view2 = new ViewStern( model );

    Controller c = new Controller( model );
    c.start();
  }

}
