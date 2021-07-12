package day8.p2d.pane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccordionDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "AccordionDemo" );

    Accordion accordion = new Accordion();

    TitledPane pane1 = new TitledPane( "Boats", new Label( "Show all boats available" ) );
    TitledPane pane2 = new TitledPane( "Cars", new Label( "Show all cars available" ) );
    TitledPane pane3 = new TitledPane( "Planes", new Label( "Show all planes available" ) );

    accordion.getPanes().add( pane1 );
    accordion.getPanes().add( pane2 );
    accordion.getPanes().add( pane3 );
    
    VBox vBox = new VBox( accordion );
    Scene scene = new Scene( vBox, 250, 300 );
    primaryStage.setScene( scene );
    primaryStage.show();
  }

}
