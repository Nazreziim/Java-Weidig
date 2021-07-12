package day8.p2b.pane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TabPaneDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "TabPaneDemo" );

    TabPane tabPane = new TabPane();

    Tab tab1 = new Tab( "Planes", new Label( "Show all planes available" ) );
    Tab tab2 = new Tab( "Cars", new Label( "Show all cars available" ) );
    Tab tab3 = new Tab( "Boats", new Label( "Show all boats available" ) );

    tab1.setClosable( true );
    tab2.setClosable( false );
    tab3.setClosable( true );
    // tabPane.setTabClosingPolicy( TabClosingPolicy.ALL_TABS );
    // tabPane.setTabClosingPolicy( TabClosingPolicy.SELECTED_TAB );
    // tabPane.setTabClosingPolicy( TabClosingPolicy.UNAVAILABLE);

    HBox buttonBox = new HBox( 5 );
    buttonBox.setPadding( new Insets( 5 ) );

    Button planesBtn = new Button( "Planes" );
    Button carsBtn = new Button( "Cars" );
    Button boatsBtn = new Button( "Boats" );

    planesBtn.setOnAction( event -> {
      if ( !tabPane.getTabs().contains( tab1 ) ) {
        tabPane.getTabs().add( tab1 );
      }
    } );
    carsBtn.setOnAction( event -> {
      if ( !tabPane.getTabs().contains( tab2 ) ) {
        tabPane.getTabs().add( tab2 );
      }
    } );
    boatsBtn.setOnAction( event -> {
      if ( !tabPane.getTabs().contains( tab3 ) ) {
        tabPane.getTabs().add( tab3 );
      }
    } );

    buttonBox.getChildren().add( planesBtn );
    buttonBox.getChildren().add( carsBtn );
    buttonBox.getChildren().add( boatsBtn );

    Tab tab0 = new Tab( "Root" );
    tab0.setClosable( false );
    tab0.setContent( buttonBox );

    tabPane.getTabs().add( tab0 );

    VBox vBox = new VBox( tabPane );
    Scene scene = new Scene( vBox, 250, 300 );
    primaryStage.setScene( scene );
    primaryStage.show();
  }

}
