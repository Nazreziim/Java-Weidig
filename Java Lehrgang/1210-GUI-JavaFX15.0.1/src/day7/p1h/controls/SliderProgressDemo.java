package day7.p1h.controls;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SliderProgressDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) {
    primaryStage.setTitle( "Slider + Progress Demo" );

    // create the Slider object
    Slider slider = new Slider( 0, 100, 0 );
    // set the major tick unit (= this value units between 2 major ticks)
    slider.setMajorTickUnit( 10 );
    // set the minor tick count (= this value tick counts between 2 major ticks)
    slider.setMinorTickCount( 9 );
    // snap to the selected ticks. Disable to use values between.
    slider.setSnapToTicks( true );
    // show the tick lines (little ones for minor ticks, big ones for major ticks)
    slider.setShowTickMarks( true );
    // show the numbers for the lines (ticks)
    slider.setShowTickLabels( true );

    Label sliderLabel = new Label();

    ProgressBar progressBar = new ProgressBar( 0 );
    // with undefined progress
    // ProgressBar progressBar = new ProgressBar();
    ProgressIndicator progressIndicator = new ProgressIndicator( 0 );
    // with undefined progress
    // ProgressIndicator progressIndicator = new ProgressIndicator();

    slider.valueProperty().addListener( new ChangeListener< Number >() {
      @Override
      public void changed( ObservableValue< ? extends Number > observable, Number oldValue, Number newValue ) {
        sliderLabel.setText( newValue.toString() );
        progressBar.setProgress( newValue.doubleValue() / 100 );
        progressIndicator.setProgress( newValue.doubleValue() / 100 );
      }
    } );

    VBox vBox = new VBox( 2, slider, sliderLabel, progressBar, progressIndicator );
    Scene scene = new Scene( vBox, 960, 300 );
    progressBar.setPrefWidth( scene.getWidth() );

    primaryStage.setScene( scene );
    primaryStage.show();
  }

}
