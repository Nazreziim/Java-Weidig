package day8.p3h.dialogs;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class DirectoryChooserDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  private String listDir( File file ) {
    StringBuilder sb = new StringBuilder();
    if ( file == null ) {
      sb.append( "null" );
    } else if ( !file.isDirectory() ) {
      sb.append( "Not a directory." );
    } else {
      File[] files = file.listFiles();
      if ( files != null ) {
        for ( File f : files ) {
          sb.append( f.getName() );
          if ( f.isDirectory() ) {
            sb.append( " : Directory" );
          } else {
            sb.append( " : File" );
          }
          sb.append( "\n" );
        }
      }
    }
    return sb.toString();
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "DirectoryChooserDemo" );

    DirectoryChooser directoryChooser = new DirectoryChooser();
    directoryChooser.setInitialDirectory( new File( System.getProperty( "user.dir" ) ) );
    directoryChooser.setTitle( "Load Directory" );

    TextArea textArea = new TextArea();
    textArea.setPrefRowCount( 10 );
    textArea.setPrefColumnCount( 50 );

    HBox statusBar = new HBox( 5 );
    statusBar.setPadding( new Insets( 5 ) );
    Label statusLabel = new Label( "Status:" );
    Text statusText = new Text();
    statusBar.getChildren().addAll( statusLabel, statusText );

    Button directoryChooserButton = new Button( "Load Directory..." );
    directoryChooserButton.setOnAction( event -> {
      File selectedDirectory = directoryChooser.showDialog( primaryStage );
      if ( selectedDirectory != null ) {
        textArea.setText( listDir( selectedDirectory ) );
        statusText.setText( selectedDirectory.getAbsolutePath() + " loaded." );
      } else {
        statusText.setText( "Selection aborted." );
      }
    } );

    HBox hbox = new HBox( 5 );
    hbox.setPadding( new Insets( 5 ) );
    hbox.getChildren().addAll( directoryChooserButton );

    HBox centerBox = new HBox( 5 );
    centerBox.setPadding( new Insets( 0, 5, 0, 5 ) );
    centerBox.getChildren().add( textArea );
    BorderPane borderPane = new BorderPane( centerBox );
    borderPane.setTop( hbox );
    borderPane.setBottom( statusBar );

    // create a scene
    Scene sc = new Scene( borderPane );
    primaryStage.setScene( sc );
    primaryStage.show();
  }

}
