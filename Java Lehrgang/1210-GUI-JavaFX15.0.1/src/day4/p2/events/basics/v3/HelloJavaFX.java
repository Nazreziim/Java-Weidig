package day4.p2.events.basics.v3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * An extended version of a HelloWorld program in JavaFX which includes a simple event handling
 * mechanism
 * 
 * @author lgerhard
 *
 */
public class HelloJavaFX extends Application {

  private class ButtonEventHandler implements EventHandler< ActionEvent > {
    @Override
    public void handle( ActionEvent event ) {
      System.out.println( "Hello private inner class!" );
    }
  }

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) {
    primaryStage.setTitle( "Hello World!" );
    Button btn = new Button();
    btn.setText( "Say 'Hello World'" );
    btn.setOnAction( new ButtonEventHandler() );

    Group root = new Group();
    root.getChildren().add( btn );
    primaryStage.setScene( new Scene( root, 300, 250 ) );
    primaryStage.show();
  }

}
