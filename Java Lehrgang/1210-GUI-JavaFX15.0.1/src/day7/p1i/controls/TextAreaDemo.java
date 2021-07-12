package day7.p1i.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextAreaDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "TextAreaDemo" );

    TextArea textArea = new TextArea();

    Button button = new Button( "Click to get text" );
    button.setMinWidth( 50 );

    button.setOnAction( action -> {
      System.out.println( textArea.getText() );
      // textArea.setText( "Clicked!" );
    } );

    VBox vbox = new VBox( textArea, button );

    Scene scene = new Scene( vbox, 200, 100 );
    primaryStage.setScene( scene );
    primaryStage.show();
  }

}
