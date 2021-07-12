package mvc_observer;

import mvc_observer.controller.Controller;
import mvc_observer.model.ZahlEinfach;
import mvc_observer.view.viewStern.ViewStern;
import mvc_observer.view.viewSternviewDezimal.ViewDezimal;

public class Main {

  public static void main( String[] args ) {
    ZahlEinfach model = new ZahlEinfach();
    ViewDezimal view1 = new ViewDezimal( model );
    ViewStern view2 = new ViewStern( model );

    Controller c = new Controller( model );
    c.start();
  }

}
