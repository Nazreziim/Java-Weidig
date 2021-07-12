package unterricht.events.v5lambda;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloEvent extends Application implements EventHandler< ActionEvent > {

  private Label lbl;

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    Button btn = new Button( "Say hello..." );
    lbl = new Label( "Hier kommt was hin...." );

    // btn.addEventHandler(ActionEvent.ANY, this);
    // btn.addEventHandler(ActionEvent.ANY, new OwnEventHandler(lbl));

    btn.setOnAction( event -> {
      lbl.setText( lbl.getText() + " lambda " );
      System.out.println( "lambda" );
    } );

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
