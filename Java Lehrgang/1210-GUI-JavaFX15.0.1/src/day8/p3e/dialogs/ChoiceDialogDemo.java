package day8.p3e.dialogs;

import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChoiceDialogDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "ChoiceDialogDemo" );

    Button btn = new Button( "Choice Dialog" );
    Label lbl = new Label( "Name: " );
    Text txt = new Text( "Default Player" );

    btn.setOnAction( event -> {
      ChoiceDialog< String > cd = new ChoiceDialog< String >();
      cd.getItems().addAll( "Spieler 1", "Spieler 2", "Spieler 3" );
      cd.setSelectedItem( cd.getItems().get( 0 ) );
      Optional< String > result = cd.showAndWait();
      if ( result.isPresent() ) {
        txt.setText( result.get() );
      }
    } );

    HBox hbox = new HBox( 5 );
    hbox.setPadding( new Insets( 5 ) );
    hbox.getChildren().addAll( btn, lbl, txt );

    // create a scene
    Scene sc = new Scene( hbox, 600, 200 );
    primaryStage.setScene( sc );
    primaryStage.show();
  }

}
