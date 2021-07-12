package day8.p3f.dialogs;

import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Pair;

public class DialogDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "DialogDemo" );

    // Create the custom dialog.
    Dialog< Pair< String, String > > dialog = new Dialog<>();
    dialog.setTitle( "Login Dialog" );
    dialog.setHeaderText( "Look, a Custom Login Dialog" );

    // Set the icon (must be included in the project).
    ImageView image = new ImageView( this.getClass().getResource( "../res/lock.png" ).toString() );
    dialog.setGraphic( image );

    // Set the button types.
    ButtonType loginButtonType = new ButtonType( "Login", ButtonData.OK_DONE );
    dialog.getDialogPane().getButtonTypes().addAll( loginButtonType, ButtonType.CANCEL );

    // Create the username and password labels and fields.
    GridPane grid = new GridPane();
    grid.setHgap( 10 );
    grid.setVgap( 10 );
    grid.setPadding( new Insets( 20, 150, 10, 10 ) );

    TextField username = new TextField();
    username.setPromptText( "Username" );
    PasswordField password = new PasswordField();
    password.setPromptText( "Password" );

    grid.add( new Label( "Username:" ), 0, 0 );
    grid.add( username, 1, 0 );
    grid.add( new Label( "Password:" ), 0, 1 );
    grid.add( password, 1, 1 );

    // Enable/Disable login button depending on whether a username was entered.
    Node loginButton = dialog.getDialogPane().lookupButton( loginButtonType );
    loginButton.setDisable( true );

    // Do some validation (using the Java 8 lambda syntax).
    username.textProperty().addListener( ( observable, oldValue, newValue ) -> {
      loginButton.setDisable( newValue.trim().isEmpty() );
    } );

    dialog.getDialogPane().setContent( grid );

    // Request focus on the username field by default.
    Platform.runLater( () -> username.requestFocus() );

    // Convert the result to a username-password-pair when the login button is clicked.
    dialog.setResultConverter( dialogButton -> {
      if ( dialogButton == loginButtonType ) {
        return new Pair<>( username.getText(), password.getText() );
      }
      return null;
    } );

    HBox hbox = new HBox( 5 );
    hbox.setPadding( new Insets( 5 ) );
    Button loginBtn = new Button( "Login" );
    Label usrLabel = new Label( "user" );
    Label pwLabel = new Label( "***" );
    loginBtn.setOnAction( event -> {
      Optional< Pair< String, String > > result = dialog.showAndWait();
      result.ifPresent( usernamePassword -> {
        System.out.println( "Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue() );
        usrLabel.setText( usernamePassword.getKey() );
        pwLabel.setText( usernamePassword.getValue() );
      } );
    } );
    hbox.getChildren().addAll( loginBtn, usrLabel, pwLabel );

    // create a scene
    Scene sc = new Scene( hbox, 600, 200 );
    primaryStage.setScene( sc );
    primaryStage.show();
  }

}
