package day7.p1n.controls;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ToolBarDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "ToolBarDemo" );

    Rectangle rect = new Rectangle( 200, 200 );
    rect.setFill( Color.ORANGE );

    StackPane stackPane = new StackPane( rect );

    BorderPane borderPane = new BorderPane();

    Button buttonWhite = new Button( "white" );
    Button buttonRed = new Button( "red" );
    Button buttonGreen = new Button( "green" );
    Button buttonBlue = new Button( "blue" );
    Button buttonBlack = new Button( "black" );

    buttonWhite.setOnAction( event -> rect.setFill( Color.WHITE ) );
    buttonRed.setOnAction( event -> rect.setFill( Color.RED ) );
    buttonGreen.setOnAction( event -> rect.setFill( Color.GREEN ) );
    buttonBlue.setOnAction( event -> rect.setFill( Color.BLUE ) );
    buttonBlack.setOnAction( event -> rect.setFill( Color.BLACK ) );

    ToolBar toolBar = new ToolBar();
    toolBar.setOrientation( Orientation.VERTICAL );
    toolBar.getItems().addAll( buttonWhite, buttonRed, buttonGreen, buttonBlue, buttonBlack );

    borderPane.setCenter( stackPane );
    borderPane.setLeft( toolBar );

    Scene scene = new Scene( borderPane );
    primaryStage.setScene( scene );
    primaryStage.show();
  }

}
