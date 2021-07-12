package oracletut.step2login;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "Login" );

    GridPane grid = new GridPane();
    grid.setAlignment( Pos.CENTER );
    grid.setVgap( 10 );
    grid.setHgap( 10 );
    grid.setPadding( new Insets( 25, 25, 25, 25 ) );

    Text sceneTitle = new Text( "Welcome" );
    sceneTitle.setFont( Font.font( "Tahoma", FontWeight.NORMAL, 20 ) );
    grid.add( sceneTitle, 0, 0, 2, 1 );

    Label username = new Label( "User Name:" );
    grid.add( username, 0, 1 );

    TextField usertf = new TextField();
    grid.add( usertf, 1, 1 );

    Label password = new Label( "Password:" );
    grid.add( password, 0, 2 );

    PasswordField passtf = new PasswordField();
    grid.add( passtf, 1, 2 );

    Button btn = new Button( "Login" );
    HBox hbBtn = new HBox( 10 );
    hbBtn.setAlignment( Pos.BOTTOM_RIGHT );
    hbBtn.getChildren().add( btn );
    grid.add( hbBtn, 1, 4 );

    Text actionText = new Text();
    actionText.setFill( Color.FIREBRICK );
    grid.add( actionText, 1, 6 );
    btn.setOnAction( new EventHandler< ActionEvent >() {

      @Override
      public void handle( ActionEvent event ) {
        actionText.setText( "Login Button pressed." );
      }

    } );

    grid.setGridLinesVisible( true );

    Scene scene = new Scene( grid, 300, 200 );
    primaryStage.setScene( scene );

    primaryStage.show();
  }

}
