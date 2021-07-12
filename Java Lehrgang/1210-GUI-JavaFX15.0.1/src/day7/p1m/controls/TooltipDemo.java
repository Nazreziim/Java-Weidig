package day7.p1m.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TooltipDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    TextArea textArea = new TextArea();

    ContextMenu contextMenu = new ContextMenu();
    MenuItem menuItem1 = new MenuItem( "Choice 1" );
    MenuItem menuItem2 = new MenuItem( "Choice 2" );
    MenuItem menuItem3 = new MenuItem( "Choice 3" );

    menuItem1.setOnAction( ( event ) -> textArea.setText( textArea.getText() + "\nClicked 'Choice 1'" ) );
    menuItem2.setOnAction( ( event ) -> textArea.setText( textArea.getText() + "\nClicked 'Choice 2'" ) );
    menuItem3.setOnAction( ( event ) -> textArea.setText( textArea.getText() + "\nClicked 'Choice 3'" ) );

    contextMenu.getItems().addAll( menuItem1, menuItem2, menuItem3 );

    textArea.setContextMenu( contextMenu );

    Button clearBtn = new Button( "Clear" );
    clearBtn.setOnAction( event -> textArea.clear() );
    
    // Create the Tooltip
    Tooltip btnTooltip = new Tooltip( "Clears the TextArea" );
    // install the Tooltip to the Control
    clearBtn.setTooltip( btnTooltip );

    VBox vBox = new VBox( 3, textArea, clearBtn );
    vBox.setPadding( new Insets( 3 ) );
    Scene scene = new Scene( vBox );

    primaryStage.setScene( scene );
    primaryStage.setTitle( "TooltipDemo" );

    primaryStage.show();
  }

}
