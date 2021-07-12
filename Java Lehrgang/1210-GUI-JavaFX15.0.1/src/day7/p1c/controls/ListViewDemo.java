package day7.p1c.controls;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Example usage of a ListView
 */
public class ListViewDemo extends Application {

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
    primaryStage.setTitle( "ListViewDemo" );

    // Create a ListView object
    ListView< String > listView = new ListView<>();

    // Change the Selection model to MULTIPLE selections
    // default: SINGLE selection
    listView.getSelectionModel().setSelectionMode( SelectionMode.MULTIPLE );

    // add Items to the internal list
    listView.getItems().add( "Item 1" );
    listView.getItems().add( "Item 2" );
    listView.getItems().add( "Item 3" );

    // Button to interact with the listView
    Button button = new Button( "Read Selected Value" );
    button.setOnAction( event -> {
      ObservableList< Integer > selectedIndices = listView.getSelectionModel().getSelectedIndices();
      for ( Integer i : selectedIndices ) {
        System.out.println( "i = " + i );
      }
    } );

    // add listView and button to the scene
    VBox vBox = new VBox( listView, button );

    Scene scene = new Scene( vBox, 300, 120 );
    primaryStage.setScene( scene );
    primaryStage.show();

  }

}
