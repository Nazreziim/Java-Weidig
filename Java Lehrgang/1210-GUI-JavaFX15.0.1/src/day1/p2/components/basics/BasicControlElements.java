package day1.p2.components.basics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * This class shows the most basic concepts of JavaFX: The use of stages and Scenes - not more, not
 * less
 * 
 * @author lgerhard
 *
 */
public class BasicControlElements extends Application {

  public static void main( String[] args ) {
    launch( args );

  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    /*
     * \ 1. Stage \
     */

    Stage stage = new Stage();

    // titles
    stage.setTitle( "JavaFX Stage Window Title" );

    // postions / width / height
    // stage.setX(50);
    // stage.setY(50);
    // stage.setWidth(600);
    // stage.setHeight(300);

    // stage styles
//     stage.initStyle(StageStyle.DECORATED);
//     stage.initStyle(StageStyle.UNDECORATED);
//     stage.initStyle(StageStyle.TRANSPARENT);
//     stage.initStyle(StageStyle.UNIFIED);
//     stage.initStyle(StageStyle.UTILITY);

    // fullscreen mode
    VBox vbox = new VBox();
    Scene scene = new Scene( vbox );
    primaryStage.setScene( scene );
    primaryStage.setFullScreen( true );
    primaryStage.show();

    /*
     * \ 2. Scenes \
     */
    VBox vBox = new VBox();
    Scene scene1 = new Scene( vBox );

    // mouse curser types (system specific, probably not working)
    // scene1.setCursor(Cursor.V_RESIZE);

    primaryStage.setScene( scene1 );
    stage.show(); // vs. showAndWait()
    System.out.println( "End of show" );

  }
}
