package day7.p1g.controls;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DatePickerDemo extends Application {

  public static void main( String[] args ) {
    Application.launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "DatePickerDemo" );

    // create a DatePicker object
    DatePicker datePicker = new DatePicker( LocalDate.now() );

    // disable the week numbers
    // datePicker.setShowWeekNumbers( false );

    Button button = new Button( "Read Date" );

    button.setOnAction( action -> {
      LocalDate value = datePicker.getValue();
      System.out.println( value.format( DateTimeFormatter.ofPattern( "dd.MM.yyyy" ) ) );
    } );

    HBox hbox = new HBox( 5, datePicker, button );

    Scene scene = new Scene( hbox, 300, 240 );
    primaryStage.setScene( scene );
    primaryStage.show();

  }

}
