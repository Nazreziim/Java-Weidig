package oracletut.step4loginfxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginFXML extends Application {
  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    Parent root = FXMLLoader.load( getClass().getResource( "LoginFXML.fxml" ) );

    Scene scene = new Scene( root, 300, 275 );

    primaryStage.setTitle( "FXML Login" );
    primaryStage.setScene( scene );
    primaryStage.show();
  }

}
