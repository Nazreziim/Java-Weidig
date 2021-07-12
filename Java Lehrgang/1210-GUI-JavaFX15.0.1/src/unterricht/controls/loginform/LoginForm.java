package unterricht.controls.loginform;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginForm extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "Log mich ein..." );
    primaryStage.setFullScreen( true ); // depends on the machine... not always working

    GridPane grid = new GridPane();
    grid.setAlignment( Pos.CENTER );
    grid.setHgap( 10 );
    grid.setVgap( 10 );
    grid.setPadding( new Insets( 25, 25, 25, 25 ) );
    Scene scene = new Scene( grid );

    addPassiveUIElements( grid );

    addUIControls( grid );

    // grid.setGridLinesVisible(true); //Helpful for Debugging
    primaryStage.setScene( scene );
    primaryStage.show();

  }

  // Step 1:
  private void addPassiveUIElements( GridPane grid ) {
    Text scenetitle = new Text( "Welcome" );
    scenetitle.setFont( Font.font( "Tahoma", FontWeight.NORMAL, 20 ) );
    grid.add( scenetitle, 0, 0, 2, 1 );

    Label userName = new Label( "User Name:" );
    grid.add( userName, 0, 1 );

    TextField userTextField = new TextField();
    grid.add( userTextField, 1, 1 );

    Label pw = new Label( "Password:" );
    grid.add( pw, 0, 2 );

    PasswordField pwBox = new PasswordField();
    grid.add( pwBox, 1, 2 );

  }

  // Step 2:
  private void addUIControls( GridPane grid ) {
    Button btn = new Button( "Sign in" );
    HBox hbBtn = new HBox( 10 );
    hbBtn.setAlignment( Pos.BOTTOM_RIGHT );
    hbBtn.getChildren().add( btn );
    grid.add( hbBtn, 1, 4 );
    final Text actiontarget = new Text();
    grid.add( actiontarget, 1, 6 );

  }

}
