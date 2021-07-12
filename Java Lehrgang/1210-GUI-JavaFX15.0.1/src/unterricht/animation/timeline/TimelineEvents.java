package unterricht.animation.timeline;

import javafx.animation.AnimationTimer;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TimelineEvents extends Application {

  private double bounceCounter = 0;
  private Label bounceCounterLabel;
  private Text text;
  private Label fpsLabel;

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    BorderPane root = new BorderPane();
    root.setCenter( createCenter() );
    root.setBottom( createBottom() );

    AnimationTimer animationTimer = new AnimationTimer() {
      private double counter = 0;
      private long[] times = new long[ 80 ];
      private int timesIdx = 0;
      private String[] symbol = new String[]{ "/", "-", "\\", "|" };
      private boolean filled = false;
      
      @Override
      public void handle( long now ) {
        text.setText( symbol[ (int) counter ] );
        counter += 0.2;
        if ( (int) counter == symbol.length ) {
          counter = 0;
        }
        
//        long oldFrameTime = times[ timesIdx ];
//        times[ timesIdx ] = now;
//        timesIdx = ( timesIdx + 1 ) % times.length;
//        if ( timesIdx == 0 ) {
//          filled = true;
//        }
//        if ( filled ) {
//          long eNanoseconds = now - oldFrameTime;
//          long eNanosPerFrame = eNanoseconds / times.length;
//          double frameRate = 1_000_000_000.0 / eNanosPerFrame;
//          fpsLabel.setText( String.format( "FPS: %.3f", frameRate ) );
//        }
      }
    };
    animationTimer.start();

    Scene scene = new Scene( root, 500, 500 );
    primaryStage.setScene( scene );
    primaryStage.setTitle( "Bouncing Ball" );
    primaryStage.show();
  }

  private Node createCenter() {
    Circle circle = new Circle( 20, Color.FORESTGREEN );
    Lighting lighting = new Lighting();
    Reflection reflection = new Reflection();
    reflection.setInput( lighting );
    circle.setEffect( reflection );
    this.text = new Text( "O" );
    this.text.setStroke( Color.BLACK );

    StackPane stackPane = new StackPane();
    stackPane.getChildren().addAll( circle, this.text );

    ScaleTransition scaleTransition = new ScaleTransition( Duration.seconds( 2 ), stackPane );
    scaleTransition.setByX( 1.5 );
    scaleTransition.setByY( 1.5 );
    scaleTransition.setCycleCount( 1 );
    scaleTransition.setOnFinished( event -> {
      this.bounceCounterLabel.setText( "Bounce Count: " + (int) ( this.bounceCounter += 0.5 ) );
    } );

    ParallelTransition parallelTransition = new ParallelTransition( scaleTransition );
    parallelTransition.setCycleCount( Transition.INDEFINITE );
    parallelTransition.setAutoReverse( true );
    parallelTransition.play();

    return stackPane;
  }

  private Node createBottom() {
    AnchorPane anchorPane = new AnchorPane();
    this.bounceCounterLabel = new Label( "Bounce Count: 0" );
    this.bounceCounterLabel.setFont( Font.font( "Tahoma", 30 ) );
    anchorPane.getChildren().add( this.bounceCounterLabel );
    AnchorPane.setBottomAnchor( this.bounceCounterLabel, 5.0 );
    AnchorPane.setLeftAnchor( this.bounceCounterLabel, 5.0 );

    this.fpsLabel = new Label();
    this.fpsLabel.setFont( Font.font( "Tahoma", 30 ) );
    anchorPane.getChildren().add( this.fpsLabel );
    AnchorPane.setBottomAnchor( this.fpsLabel, 5.0 );
    AnchorPane.setRightAnchor( this.fpsLabel, 5.0 );

    return anchorPane;
  }

}
