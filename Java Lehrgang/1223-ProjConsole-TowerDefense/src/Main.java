import controller.Controller;
import model.Spiel;
import view.View;
import view.console.ConsoleView;

public class Main {

  public static void main( String[] args ) {

    final int HOEHE = 10;
    final int BREITE = 10;

    Spiel model = new Spiel( HOEHE, BREITE );

    View view = new ConsoleView( model.getBoard() );

    Controller controller = new Controller( model, view );
    controller.start();

  }

}
