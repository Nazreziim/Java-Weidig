package day8.p2e.pane;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SplitPaneDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "SplitPaneDemo" );

    SplitPane splitPane = new SplitPane();

    VBox leftControl = new VBox( new Label( "Left Control" ) );
    VBox midControl = new VBox( new Label( "Mid Control" ) );
    VBox rightControl = new VBox( new Label( "Right Control" ) );

    splitPane.getItems().addAll( leftControl, midControl, rightControl );
    splitPane.setDividerPositions( 0.33, 0.66 );
    splitPane.setOrientation( Orientation.VERTICAL );

    Scene scene = new Scene( splitPane, 500, 300 );
    primaryStage.setScene( scene );
    primaryStage.show();
  }

}
