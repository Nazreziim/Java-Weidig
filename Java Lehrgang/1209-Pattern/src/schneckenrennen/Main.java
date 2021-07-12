package schneckenrennen;

import schneckenrennen.controller.SchneckenRennenController;
import schneckenrennen.model.Wettbuero;
import schneckenrennen.view.UIConsole;

/**
 * 
 * @author kmoench
 *
 */
public class Main {

  public static void main( String[] args ) {
    Wettbuero wettbuero = new Wettbuero();
    UIConsole view = new UIConsole();

    SchneckenRennenController src = new SchneckenRennenController( wettbuero, view );
    src.start();
  }

}
