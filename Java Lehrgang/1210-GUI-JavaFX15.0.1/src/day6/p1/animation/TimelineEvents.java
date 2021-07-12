package day6.p1.animation;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * This class demonstrates the use of a TimeLine event. Besides that the use of a simple
 * AnimationTimer is shown.
 * 
 * @author lgerhard
 *
 */
public class TimelineEvents extends Application {

  // variable for the BounceCount
  private int bounceCounter = 0;

  public static void main( String[] args ) {
    Application.launch( args );
  }

  @Override
  public void start( Stage stage ) {
    BorderPane root = new BorderPane();
    Scene scene = new Scene( root );
    stage.setScene( scene );
    stage.setWidth( 500 );
    stage.setHeight( 500 );

    final Circle circle = new Circle( 20, Color.FORESTGREEN );
    Lighting lighting = new Lighting();
    Reflection reflection = new Reflection();
    reflection.setInput( lighting );
    circle.setEffect( reflection );
    final Text text = new Text( "O" );
    text.setStroke( Color.BLACK );

    final StackPane stack = new StackPane();
    stack.getChildren().addAll( circle, text );
    stack.setLayoutX( 30 );
    stack.setLayoutY( 30 );

    Label bounceCountLabel = new Label( "Bounce Count: " + bounceCounter );
    bounceCountLabel.setStyle( "-fx-font: 30px Tahoma" );
    root.setCenter( stack );
    root.setBottom( bounceCountLabel );
    stage.show();

    // create a timeline for moving the circle
    Timeline timeline = new Timeline();
    timeline.setCycleCount( Timeline.INDEFINITE );
    timeline.setAutoReverse( true );

    // scale the circle 2times and move it down 200px
    KeyValue keyValueX = new KeyValue( stack.scaleXProperty(), 2 );
    KeyValue keyValueY = new KeyValue( stack.scaleYProperty(), 2 );
    KeyValue moveDown = new KeyValue( stack.layoutYProperty(), 200 );

    // Now lets define an event handler
    EventHandler< ActionEvent > onFinished = new EventHandler< ActionEvent >() {
      @Override
      public void handle( ActionEvent t ) {
        // stack.setTranslateX( java.lang.Math.random() * 200 - 100 );
        // bounceCountLabel.setText( "Bounce Count: " + ++bounceCounter );
      }
    };

    // Here our EventHandler comes into play: onFinished!
    KeyFrame keyFrame = new KeyFrame( Duration.millis( 2000 ), onFinished, keyValueX, keyValueY, moveDown );

    // add the keyframe to the timeline
    timeline.getKeyFrames().add( keyFrame );
    timeline.play();

    // add an animationtimer which performs an action for every frame
    // (here the set of strings will be used to set a new value for the text element)
    AnimationTimer timer = new AnimationTimer() {
      String[] set = { "\\", "|", "/", "-" };
      int i = 0;

      @Override
      public void handle( long l ) {
        if ( i == set.length ) {
          i = 0;
        }
        text.setText( set[ i++ ] );

      }

    };
    // timer.start();
  }

}
