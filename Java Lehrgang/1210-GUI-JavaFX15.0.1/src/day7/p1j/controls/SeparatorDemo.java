package day7.p1j.controls;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SeparatorDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "SeparatorDemo" );

    TextField textField = new TextField();

    Label label = new Label();

    Button button = new Button( "Click to get text" );
    button.setOnAction( action -> {
      label.setText( textField.getText() );
    } );

    Button clearBtn = new Button( "Clear" );
    clearBtn.setOnAction( event -> textField.clear() );

    Separator separator = new Separator( Orientation.VERTICAL );

    HBox btnHBox = new HBox( 5, button, separator, clearBtn );
    btnHBox.setAlignment( Pos.CENTER );

    VBox vbox = new VBox( 5, textField, new Separator(), btnHBox, new Separator(), label );

    Scene scene = new Scene( vbox, 200, 100 );
    primaryStage.setScene( scene );
    primaryStage.show();
  }

}
