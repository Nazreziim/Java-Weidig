package day8.p3g.dialogs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class FileChooserDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  private String peekInFile( File file, int lines, int columns ) {
    StringBuilder sb = new StringBuilder();
    if ( file == null ) {
      sb.append( "null\n" );
    } else {
      try ( FileReader fr = new FileReader( file ); BufferedReader br = new BufferedReader( fr ); ) {
        String line = null;
        for ( int i = 0; i < lines; ++i ) {
          line = br.readLine();
          sb.append( line.substring( 0, columns < line.length() ? columns : line.length() ) + "\n" );
        }
      } catch ( EOFException e ) {
        // Dateiende erreicht.
      } catch ( FileNotFoundException e ) {
        sb.append( "File not found: " + file.getAbsolutePath() + "\n" );
      } catch ( IOException e ) {
        e.printStackTrace();
      }
    }
    return sb.toString();
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "FileChooserDemo" );

    FileChooser loadFileChooser = new FileChooser();
    loadFileChooser.setInitialDirectory( new File( System.getProperty( "user.dir" ) ) );
    loadFileChooser.setTitle( "Load File" );
    loadFileChooser.getExtensionFilters().add( new ExtensionFilter( "Txt-Files", "*.txt", "*.text" ) );
    loadFileChooser.getExtensionFilters().add( new ExtensionFilter( "JPG", "*.jpg", "*.jpeg" ) );
    loadFileChooser.setSelectedExtensionFilter( loadFileChooser.getExtensionFilters().get( 0 ) );

    FileChooser loadFilesChooser = new FileChooser();
    loadFilesChooser.setInitialDirectory( new File( System.getProperty( "user.dir" ) ) );
    loadFilesChooser.setTitle( "Load Files" );
    loadFilesChooser.getExtensionFilters().add( new ExtensionFilter( "Txt-Files", "*.txt", "*.text" ) );
    loadFilesChooser.getExtensionFilters().add( new ExtensionFilter( "JPG", "*.jpg", "*.jpeg" ) );
    loadFilesChooser.setSelectedExtensionFilter( loadFilesChooser.getExtensionFilters().get( 0 ) );

    FileChooser saveFileChooser = new FileChooser();
    saveFileChooser.setInitialDirectory( new File( System.getProperty( "user.dir" ) ) );
    saveFileChooser.setTitle( "Save File" );
    saveFileChooser.getExtensionFilters().add( new ExtensionFilter( "Text", "*.txt" ) );
    saveFileChooser.setSelectedExtensionFilter( saveFileChooser.getExtensionFilters().get( 0 ) );

    TextArea textArea = new TextArea();
    textArea.setPrefRowCount( 10 );
    textArea.setPrefColumnCount( 50 );

    HBox statusBar = new HBox( 5 );
    statusBar.setPadding( new Insets( 5 ) );
    Label statusLabel = new Label( "Status:" );
    Text statusText = new Text();
    statusBar.getChildren().addAll( statusLabel, statusText );

    Button loadFileChooserButton = new Button( "Load File..." );
    loadFileChooserButton.setOnAction( event -> {
      File selectedFile = loadFileChooser.showOpenDialog( primaryStage );
      if ( selectedFile != null ) {
        textArea.setText( peekInFile( selectedFile, 5, 50 ) );
        statusText.setText( selectedFile.getAbsolutePath() + " loaded." );
      } else {
        statusText.setText( "Selection aborted." );
      }
    } );

    Button loadFilesChooserButton = new Button( "Load Files..." );
    loadFilesChooserButton.setOnAction( event -> {
      List< File > fileList = loadFilesChooser.showOpenMultipleDialog( primaryStage );
      textArea.clear();
      if ( fileList != null ) {
        for ( File file : fileList ) {
          textArea.appendText( peekInFile( file, 1, 50 ) );
        }
        statusText.setText( fileList.size() + " Files loaded." );
      } else {
        statusText.setText( "Selection aborted." );
      }
    } );

    Button saveFileChooserButton = new Button( "Save File..." );
    saveFileChooserButton.setOnAction( event -> {
      saveFileChooser.setInitialFileName( "default.txt" );
      File savedFile = saveFileChooser.showSaveDialog( primaryStage );
      if ( savedFile != null ) {
        saveToFile( savedFile, textArea.getText() );
        statusText.setText( "Saved to file: " + savedFile.getAbsolutePath() );
      } else {
        statusText.setText( "Aborted." );
      }
    } );

    HBox hbox = new HBox( 5 );
    hbox.setPadding( new Insets( 5 ) );
    hbox.getChildren().addAll( loadFileChooserButton, loadFilesChooserButton, saveFileChooserButton );

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

  private void saveToFile( File savedFile, String text ) {
    if ( savedFile.exists() ) {
      savedFile.delete();
    }
    try ( FileWriter fw = new FileWriter( savedFile ); BufferedWriter bw = new BufferedWriter( fw ); ) {
      bw.write( text );
    } catch ( IOException e ) {
      e.printStackTrace();
    }
  }

}
