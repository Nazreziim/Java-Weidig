package unterricht.events.v3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloEvent extends Application implements EventHandler< ActionEvent > {

  private class OwnEventHandler implements EventHandler< ActionEvent > {
    private Label lbl;

    @Override
    public void handle( ActionEvent event ) {
      if ( event.getSource() instanceof Button ) {
        Button btn = (Button) event.getSource();
        btn.setText( btn.getText() + " Hallo" );
        lbl = new Label( btn.getText() );
      }
    }

    public Label getLbl() {
      if ( lbl == null ) {
        lbl = new Label( "" );
      }
      return lbl;
    }
  }

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    Button btn = new Button( "Say hello..." );

    OwnEventHandler oeh = new OwnEventHandler();
    Label lbl = oeh.getLbl();
    btn.addEventHandler( ActionEvent.ANY, this );
    btn.addEventHandler( ActionEvent.ANY, oeh );

    // btn.setOnAction(this);
    // btn.setOnAction(new OwnEventHandler());

    VBox root = new VBox();
    root.getChildren().addAll( btn, lbl );
    primaryStage.setScene( new Scene( root, 300, 200 ) );
    primaryStage.show();
  }

  @Override
  public void handle( ActionEvent event ) {
    System.out.println( "Hallo" );

  }

}
