package day4.p2.events.basics.v5;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * An extended version of a HelloWorld program in JavaFX which includes a simple event handling
 * mechanism
 * 
 * @author lgerhard
 *
 */
public class HelloJavaFX extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) {
    primaryStage.setTitle( "Hello World!" );
    Button btn = new Button();
    btn.setText( "Say 'Hello World'" );
    btn.setOnAction( e -> System.out.println( "Hello Lambda" ) ); // This looks really awesome and
                                                                  // saves a lot of unnecessary
                                                                  // code!
    // What if we want to run more than one method call within the lambda expression?

    // btn.setOnAction(e -> {
    // System.out.println("Once again lets say hello");
    // System.out.println("Now lets do something completely different");
    // });

    Group root = new Group();
    root.getChildren().add( btn );
    primaryStage.setScene( new Scene( root, 300, 250 ) );
    primaryStage.show();
  }

}
