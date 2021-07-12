package day8.p3abc.dialogs;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class AlertDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "AlertDemo" );

    // create a button
    Button b = new Button( "Confirmation alert" );
    Button b1 = new Button( "error alert" );
    Button b2 = new Button( "Information alert" );
    Button b3 = new Button( "Warning alert" );
    Button b4 = new Button( "Exception Dialog" );

    // create a tile pane
    TilePane r = new TilePane();

    // create a alert
    Alert a = new Alert( AlertType.NONE );

    // action event
    EventHandler< ActionEvent > event = new EventHandler< ActionEvent >() {
      public void handle( ActionEvent e ) {
        // set alert type
        a.setAlertType( AlertType.CONFIRMATION );

        // show the dialog
        a.show();
      }
    };

    // action event
    EventHandler< ActionEvent > event1 = new EventHandler< ActionEvent >() {
      public void handle( ActionEvent e ) {
        // set alert type
        a.setAlertType( AlertType.ERROR );

        // show the dialog
        a.show();
      }
    };

    // action event
    EventHandler< ActionEvent > event2 = new EventHandler< ActionEvent >() {
      public void handle( ActionEvent e ) {
        // set alert type
        a.setAlertType( AlertType.INFORMATION );

        // show the dialog
        a.show();
      }
    };

    // action event
    EventHandler< ActionEvent > event3 = new EventHandler< ActionEvent >() {
      public void handle( ActionEvent e ) {
        // set alert type
        a.setAlertType( AlertType.WARNING );

        // show the dialog
        a.show();
      }
    };

    // action event
    EventHandler< ActionEvent > event4 = new EventHandler< ActionEvent >() {
      public void handle( ActionEvent event ) {
        // set alert type
        a.setAlertType( AlertType.ERROR );
        Label label = new Label( "The exception stacktrace was:" );

        Exception e = new FileNotFoundException( "Could not find file \"blabla.txt\"" );
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter( sw );
        e.printStackTrace( pw );

        TextArea textArea = new TextArea( sw.toString() );
        textArea.setEditable( false );
        textArea.setWrapText( true );
        textArea.setMaxWidth( Double.MAX_VALUE );
        textArea.setMaxHeight( Double.MAX_VALUE );
        GridPane.setVgrow( textArea, Priority.ALWAYS );
        GridPane.setHgrow( textArea, Priority.ALWAYS );

        GridPane expContent = new GridPane();
        expContent.setMaxWidth( Double.MAX_VALUE );
        expContent.add( label, 0, 0 );
        expContent.add( textArea, 0, 1 );

        a.getDialogPane().setExpandableContent( expContent );

        // show the dialog
        a.showAndWait();
      }
    };

    // when button is pressed
    b.setOnAction( event );
    b1.setOnAction( event1 );
    b2.setOnAction( event2 );
    b3.setOnAction( event3 );
    b4.setOnAction( event4 );

    // add button
    r.getChildren().add( b );
    r.getChildren().add( b1 );
    r.getChildren().add( b2 );
    r.getChildren().add( b3 );
    r.getChildren().add( b4 );

    // create a scene
    Scene sc = new Scene( r, 600, 200 );
    primaryStage.setScene( sc );
    primaryStage.show();
  }

}
