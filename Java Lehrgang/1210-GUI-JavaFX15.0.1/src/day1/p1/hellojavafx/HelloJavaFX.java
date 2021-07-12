package day1.p1.hellojavafx;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This is a simple HelloWorld Application written in JavaFX
 * 
 * @author lgerhard
 *
 */
public class HelloJavaFX extends Application {
  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "Hello JavaFX" );

    primaryStage.show();
  }

}
