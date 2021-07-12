package day7.p1b.controls;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Example usage of a ListView
 */
public class ChoiceBoxDemo extends Application {

  /**
   * Start the Application
   * 
   * @param args Command line arguments.
   */
  public static void main( String[] args ) {
    Application.launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "ChoiceBoxDemo" );

    Text responseText = new Text( "Auswahl:" );

    ChoiceBox< String > choiceBox = new ChoiceBox<>();
    choiceBox.getItems().add( "Auswahl 1" );
    choiceBox.getItems().add( "Auswahl 2" );
    choiceBox.getItems().add( "Auswahl 3" );

    EventHandler< ActionEvent > eventHandler = new EventHandler< ActionEvent >() {
      @Override
      public void handle( ActionEvent event ) {
        responseText.setText( "Auswahl: " + choiceBox.getSelectionModel().getSelectedItem() );
      }
    };
    choiceBox.setOnAction( eventHandler );

    HBox hbox = new HBox( 5 );
    hbox.setPadding( new Insets( 5 ) );
    hbox.getChildren().add( choiceBox );

    VBox vbox = new VBox( 5 );
    vbox.setPadding( new Insets( 5 ) );
    vbox.getChildren().add( hbox );
    vbox.getChildren().add( responseText );

    Scene scene = new Scene( vbox, 300, 120 );
    primaryStage.setScene( scene );
    primaryStage.show();

  }

}
