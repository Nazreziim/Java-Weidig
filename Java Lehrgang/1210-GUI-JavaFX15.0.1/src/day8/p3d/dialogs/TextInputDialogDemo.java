package day8.p3d.dialogs;

import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextInputDialogDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "TextInputDialogDemo" );

    Button btn = new Button( "Text input" );
    Label lbl = new Label( "Name: " );
    Text txt = new Text( "Default Name" );

    btn.setOnAction( event -> {
      TextInputDialog tid = new TextInputDialog();
      tid.setContentText( "user name:" );
      tid.setHeaderText( "Enter your user name" );
      Optional< String > result = tid.showAndWait();
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
