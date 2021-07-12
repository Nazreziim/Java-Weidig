package day7.p1l.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ContextMenuDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    TextArea textArea = new TextArea();

    // Create the ContextMenu
    ContextMenu contextMenu = new ContextMenu();
    // Create the MenuItems for the ContextMenu
    MenuItem menuItem1 = new MenuItem( "Choice 1" );
    MenuItem menuItem2 = new MenuItem( "Choice 2" );
    MenuItem menuItem3 = new MenuItem( "Choice 3" );

    Slider slider = new Slider( 0.0, 10.0, 1.0 );
    slider.setMajorTickUnit( 1.0 );
    slider.setSnapToTicks( true );
    slider.valueProperty().addListener( ( event, oldValue, newValue ) -> {
      textArea.setBackground( new Background(
              new BackgroundFill( Color.web( "black", newValue.doubleValue() / 10 ), CornerRadii.EMPTY, new Insets( 0 ) ) ) );
    } );

    CustomMenuItem customMenuItem = new CustomMenuItem( slider );
    customMenuItem.setHideOnClick( false );

    // add behavior
    menuItem1.setOnAction( ( event ) -> textArea.setText( textArea.getText() + "\nClicked 'Choice 1'" ) );
    menuItem2.setOnAction( ( event ) -> textArea.setText( textArea.getText() + "\nClicked 'Choice 2'" ) );
    menuItem3.setOnAction( ( event ) -> textArea.setText( textArea.getText() + "\nClicked 'Choice 3'" ) );

    // Add the MenuItems to the ContextMenu
    contextMenu.getItems().addAll( menuItem1, menuItem2, menuItem3, new SeparatorMenuItem(), customMenuItem );

    // Add the ContextMenu to the Control
    textArea.setContextMenu( contextMenu );

    VBox vBox = new VBox( textArea );
    Scene scene = new Scene( vBox );

    primaryStage.setScene( scene );
    primaryStage.setTitle( "ContextMenuDemo" );

    primaryStage.show();
  }

}
