package unterricht.controls.loginform.fxml;

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
    Parent root = FXMLLoader.load( getClass().getResource( "scenebuilder2.fxml" ) );

    Scene s = new Scene( root, 400, 300 );
    primaryStage.setScene( s );
    primaryStage.show();
  }

}
