package day7.p1a.controls;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Example usage of a ListView
 */
public class MenuButtonDemo extends Application {

  /**
   * Start the Application
   * 
   * @param args Command line arguments.
   */
  public static void main( String[] args ) {
    Application.launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "(Split)MenuButtonDemo" );

    Text responseText = new Text( "Auswahl:" );

    EventHandler< ActionEvent > eventHandler = new EventHandler< ActionEvent >() {
      @Override
      public void handle( ActionEvent event ) {
        Object src = event.getSource();
        if ( src instanceof MenuItem ) {
          MenuItem item = (MenuItem) src;
          responseText.setText( "Auswahl: " + item.getText() );
        }
      }
    };

    MenuItem item1 = new MenuItem( "Auswahl 1" );
    MenuItem item2 = new MenuItem( "Auswahl 2" );
    MenuItem item3 = new MenuItem( "Auswahl 3" );

    item1.setOnAction( eventHandler );
    item2.setOnAction( eventHandler );
    item3.setOnAction( eventHandler );

    MenuButton menuButton = new MenuButton( "MenuButton" );
    menuButton.getItems().add( item1 );
    menuButton.getItems().add( item2 );
    menuButton.getItems().add( item3 );

    MenuItem splitItem1 = new MenuItem( "Auswahl 1" );
    MenuItem splitItem2 = new MenuItem( "Auswahl 2" );
    MenuItem splitItem3 = new MenuItem( "Auswahl 3" );

    splitItem1.setOnAction( eventHandler );
    splitItem2.setOnAction( eventHandler );
    splitItem3.setOnAction( eventHandler );

    SplitMenuButton splitMenuButton = new SplitMenuButton( splitItem1, splitItem2, splitItem3 );
    splitMenuButton.setText( "SplitMenuButton" );
    splitMenuButton.setOnAction( event -> {
      responseText.setText( "SplitMenuButton clicked" );
    } );

    HBox hbox = new HBox( 5 );
    hbox.setPadding( new Insets( 5 ) );
    hbox.getChildren().add( menuButton );
    hbox.getChildren().add( splitMenuButton );

    VBox vbox = new VBox( 5 );
    vbox.setPadding( new Insets( 5 ) );
    vbox.getChildren().add( hbox );
    vbox.getChildren().add( responseText );

    Scene scene = new Scene( vbox, 300, 120 );
    primaryStage.setScene( scene );
    primaryStage.show();

  }

}
