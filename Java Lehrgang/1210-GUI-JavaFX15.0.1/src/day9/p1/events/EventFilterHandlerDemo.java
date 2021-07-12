package day9.p1.events;

import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class EventFilterHandlerDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {

    TextArea information = new TextArea( "info" );
    information.setPrefRowCount( 3 );
    VBox infoBox = new VBox();
    infoBox.setPadding( new Insets( 3 ) );
    infoBox.getChildren().add( information );

    GridPane grid = new GridPane();
    grid.setBorder( new Border( new BorderStroke( Color.DARKRED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, null ) ) );
    grid.setGridLinesVisible( true );
    grid.setPadding( new Insets( 3 ) );
    grid.setHgap( 3 );
    grid.setVgap( 3 );

    Rectangle rectL = new Rectangle( 200, 200 );
    rectL.setFill( Color.BLUE );
    rectL.setOnMouseClicked( event -> {
      information.setText( information.getText() + "\nLeft clicked" );
      event.consume();
    } );
    GridPane.setVgrow( rectL, Priority.ALWAYS );
    GridPane.setHgrow( rectL, Priority.ALWAYS );
    grid.add( rectL, 0, 0 );

    Rectangle rectR = new Rectangle( 200, 200 );
    rectR.setFill( Color.GREEN );
    rectR.setOnMouseClicked( event -> {
      information.setText( information.getText() + "\nRight clicked" );
    } );
    GridPane.setVgrow( rectR, Priority.ALWAYS );
    GridPane.setHgrow( rectR, Priority.ALWAYS );
    grid.add( rectR, 1, 0 );

    BorderPane root = new BorderPane();
    root.setCenter( grid );
    root.setBottom( infoBox );

    grid.addEventFilter( MouseEvent.MOUSE_CLICKED, event -> {
      information.setText( "Click event filtered" );
    } );

    grid.addEventHandler( MouseEvent.MOUSE_CLICKED, event -> {
      information.setText( information.getText() + "\nClick event handler." );
    } );

    primaryStage.setOnCloseRequest( event -> {
      System.out.println( "onCloseRequest" );
//      event.consume();
      Alert conf = new Alert( AlertType.CONFIRMATION );
      conf.setContentText( "Beenden?" );
      Optional< ButtonType > optional = conf.showAndWait();
      if ( !optional.isPresent() || optional.get() != ButtonType.OK ) {
        event.consume();
      }
    } );

    primaryStage.setScene( new Scene( root, 500, 300 ) );
    primaryStage.setTitle( "EventFilterHandlerDemo" );
    primaryStage.show();

  }

}
