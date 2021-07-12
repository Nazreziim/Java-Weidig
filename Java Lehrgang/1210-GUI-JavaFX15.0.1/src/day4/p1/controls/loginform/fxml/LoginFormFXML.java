package day4.p1.controls.loginform.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginFormFXML extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "Log mich ein..." );
    // primaryStage.setFullScreen(true); //depends on the machine... not always working

    Parent root = FXMLLoader.load( getClass().getResource( "loginform.fxml" ) );

    Scene scene = new Scene( root, 300, 275 );

    primaryStage.setScene( scene );
    primaryStage.show();

  }

}
