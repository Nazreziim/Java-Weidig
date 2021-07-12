package uebung2;

import uebung2.model.Ganzzahl;
import uebung2.controller.Controller;
import uebung2.view.View;
import uebung2.view.ViewDezimal;
import uebung2.view.ViewSternchen;

public class Main {
  public static void main( String[] args ) {
    Ganzzahl model = new Ganzzahl();
    View view = new ViewSternchen();
    View view2 = new ViewDezimal();
    Controller c = new Controller( model, view, view2 );

    c.start();
  }
}
