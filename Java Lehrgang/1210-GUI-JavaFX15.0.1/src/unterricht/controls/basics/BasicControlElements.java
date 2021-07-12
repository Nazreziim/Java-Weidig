package unterricht.controls.basics;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BasicControlElements extends Application {

  public static void main( String[] args ) {
    launch( args );

  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    // 1.) Stage
    Stage newStage = new Stage();
    newStage.setTitle( "Basic Controls" );

    // Dimensions and position settings
    newStage.setWidth( 400 );
    newStage.setHeight( 280 );
    newStage.setX( 50 );
    newStage.setY( 50 );

    // stage styles
    // newStage.initStyle(StageStyle.UNDECORATED);
    // newStage.initStyle(StageStyle.UNIFIED);
    // newStage.initStyle(StageStyle.TRANSPARENT);

    // 2.) Scene
    Label lbl = new Label( "Blabla" );
    lbl.setCursor( Cursor.HAND );
    Scene scene = new Scene( lbl );
    newStage.setScene( scene );

    // fullscreen mode
    newStage.setFullScreen( true );

    newStage.show();
    System.out.println( "End of show..." );
  }

}
