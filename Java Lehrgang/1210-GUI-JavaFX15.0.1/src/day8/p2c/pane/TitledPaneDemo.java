package day8.p2c.pane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TitledPaneDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "TitledPaneDemo" );

    Label label = new Label( "The content inside the TitledPane" );
    TitledPane titledPane = new TitledPane( "The Title", label );

    // titledPane.setExpanded( true );
    // titledPane.setCollapsible( false );

    VBox vBox = new VBox( titledPane );
    Scene scene = new Scene( vBox, 250, 300 );
    primaryStage.setScene( scene );
    primaryStage.show();
  }

}
