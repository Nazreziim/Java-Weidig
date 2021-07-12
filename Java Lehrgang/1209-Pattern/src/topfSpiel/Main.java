package topfSpiel;

import topfSpiel.controller.SpielAblauf;
import topfSpiel.model.TopfSpiel;
import topfSpiel.view.UIConsole;

public class Main {
  public static void main( String... strings ) {
    TopfSpiel model = new TopfSpiel();
    UIConsole view = new UIConsole();

    SpielAblauf spielAblauf = new SpielAblauf( model, view );
    spielAblauf.start();
  }
}
