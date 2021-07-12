package day7.p1d.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Example usage of a ListView
 */
public class ComboBoxDemo extends Application {

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
    primaryStage.setTitle( "ComboBoxDemo" );

    ComboBox< String > comboBox = new ComboBox<>();

    // ComboBox cant be editable (caution in case of non-String datatypes
    // comboBox.setEditable( true );

    comboBox.getItems().add( "Choice 1" );
    comboBox.getItems().add( "Choice 2" );
    comboBox.getItems().add( "Choice 3" );

    Button btn = new Button( "read" );
    btn.setOnAction( event -> {
      System.out.println( comboBox.getSelectionModel().getSelectedItem() );
    } );

    HBox hbox = new HBox( 5, comboBox, btn );

    Scene scene = new Scene( hbox, 250, 120 );
    primaryStage.setScene( scene );
    primaryStage.show();

  }

}
