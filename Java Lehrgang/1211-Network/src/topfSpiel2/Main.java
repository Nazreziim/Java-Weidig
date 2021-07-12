package topfSpiel2;

import topfSpiel2.controller.SpielAblauf;
import topfSpiel2.model.TopfSpiel;
import topfSpiel2.view.UIConsole;

public class Main {
  public static void main( String... strings ) {
    TopfSpiel model = new TopfSpiel();
    UIConsole view = new UIConsole();

    SpielAblauf spielAblauf = new SpielAblauf( model, view );
    spielAblauf.start();
  }
}
