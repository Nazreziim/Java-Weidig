package uebung1;

import uebung1.controller.Controller;
import uebung1.model.Ganzzahl;
import uebung1.view.View;
import uebung1.view.ViewDezimal;
import uebung1.view.ViewSternchen;

public class Main {
  public static void main( String[] args ) {
    Ganzzahl model = new Ganzzahl();
    View view = new ViewSternchen();
    View view2 = new ViewDezimal();
    Controller c = new Controller( model, view, view2 );

    c.start();
  }
}
