package day7.p1f.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ColorPickerDemo extends Application {

  public static void main( String[] args ) {
    Application.launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "ColorPickerDemo" );

    // create a ColorPicker object
    ColorPicker colorPicker = new ColorPicker( Color.BLACK );

    Rectangle rect = new Rectangle( 50, 20, Color.BLACK );

    Button button = new Button( "Update Color" );
    button.setOnAction( action -> {
      Color value = colorPicker.getValue();
      rect.setFill( value );
    } );

    HBox hbox = new HBox( 5, colorPicker, button, rect );

    Scene scene = new Scene( hbox, 300, 240 );
    primaryStage.setScene( scene );
    primaryStage.show();

  }

}
