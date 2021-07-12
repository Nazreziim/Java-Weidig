package unterricht.events.keyevents;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KeyEventDemo extends Application {

  public static void main( String[] args ) {
    launch( args );

  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setScene( new Scene( createContent() ) );
    primaryStage.show();
  }

  private Parent createContent() {
    VBox root = new VBox( 5 );
    TextField tf = new TextField();

    ListView< String > list = new ListView< String >();
    list.setMinHeight( 200 );
    list.setMaxHeight( 500 );

    // Now lets use some key-events
    tf.setOnKeyReleased( ( KeyEvent e ) -> {
      // if (e.getCode() == KeyCode.UP) {
      //
      // }
      String result = "Key typed: " + e.getCode();

      if ( e.isShiftDown() ) {
        result += ", Shift pressed";
      }

      if ( e.isAltDown() ) {
        result += ", Alt pressed";
      }

      if ( e.isControlDown() ) {
        result += ", Ctrl pressed";
      }

      list.getItems().add( result );
    } );

    root.getChildren().addAll( tf, list );
    return root;
  }

}
