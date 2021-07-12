package basic.version7;

import java.util.LinkedList;
import java.util.List;

import basic.version7.controller.Controller;
import basic.version7.model.ZahlEinfach;
import basic.version7.view.View;
import basic.version7.view.viewDezimal.ViewDezimal;
import basic.version7.view.viewStern.ViewStern;

public class Main {

  public static void main( String[] args ) {

    ZahlEinfach model = new ZahlEinfach();
    ViewDezimal viewDezimal = new ViewDezimal( model );
    ViewStern viewStern = new ViewStern( model );

    List< View > views = new LinkedList< View >();
    views.add( viewDezimal );
    views.add( viewStern );

    Controller controller = new Controller( model, views );
    controller.start();

  }

}
