package day4.p2.events.basics.v2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OwnButtonEventHandler implements EventHandler< ActionEvent > {

  @Override
  public void handle( ActionEvent event ) {
    System.out.println( "Hello World" );

  }

}
