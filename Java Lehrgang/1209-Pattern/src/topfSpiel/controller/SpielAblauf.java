package topfSpiel.controller;

import topfSpiel.model.TopfSpiel;
import topfSpiel.view.UIConsole;

public class SpielAblauf {
  private TopfSpiel model;
  private UIConsole view;

  public SpielAblauf( TopfSpiel model, UIConsole view ) {
    this.model = model;
    this.view = view;
  }

  public void start() {

    while ( !this.model.istBeendet() ) {
      int zug = this.view.zugMachen( this.model.getNext(), this.model.getTauschCounter() );
      this.model.aktion( zug );
      this.view.ausgabe( zug, this.model.getSpieler()[ 0 ].getCoins(), this.model.getSpieler()[ 1 ].getCoins() );
    }
    this.view.ausgabeSieger( this.model.getSieger() );
  }

}
