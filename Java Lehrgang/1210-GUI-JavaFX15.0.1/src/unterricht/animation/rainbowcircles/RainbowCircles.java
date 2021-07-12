package unterricht.animation.rainbowcircles;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RainbowCircles extends Application {

  final static int WIDTH = 800;
  final static int HEIGHT = 600;

  public static void main( String[] args ) {
    launch( args );

  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setScene( new Scene( createContent( WIDTH, HEIGHT ), WIDTH, HEIGHT ) );
    primaryStage.show();
  }

  private Parent createContent( int w, int h ) {
    Group root = new Group();

    // 1.) Create a group with 30 white circles with radius = 150
    Group circles = new Group();
    for ( int i = 0; i < 30; i++ ) {
      Circle circle = new Circle( 150, Color.web( "white", 0.05 ) );
      // circle.setStrokeType(StrokeType.OUTSIDE);
      circle.setStroke( Color.web( "white", 0.16 ) );
      circle.setStrokeWidth( 4 );
      circles.getChildren().add( circle );
      circle.setCenterX( Math.random() * 800 );
      circle.setCenterY( Math.random() * 600 );
    }

    // 2.) add a BoxBlur effect to the circles group
    circles.setEffect( new BoxBlur( 10, 10, 3 ) );

    // 3.) Create a fancy rainbow rectangle background
    // We use LinearGradients for that
    // Stop[] stops = new Stop[] {new Stop(0, Color.BLACK), new Stop(0.5, Color.BLUE), new Stop(1,
    // Color.CRIMSON)};
    Stop[] stops = { new Stop( 0, Color.web( "#f8bd55" ) ), new Stop( 0.14, Color.web( "#c0fe56" ) ),
            new Stop( 0.28, Color.web( "#5dfbc1" ) ), new Stop( 0.43, Color.web( "#64c2f8" ) ),
            new Stop( 0.57, Color.web( "#be4af7" ) ), new Stop( 0.71, Color.web( "#ed5fc2" ) ),
            new Stop( 0.85, Color.web( "#ef504c" ) ), new Stop( 1, Color.web( "#f2660f" ) ), };
    LinearGradient paintGradient = new LinearGradient( 0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops );
    Rectangle rainbowBackground = new Rectangle( w, h, paintGradient );

    // 4.) Blend mode
    Group blendModeGroup = new Group( new Rectangle( w, h, Color.BLACK ), circles, rainbowBackground );
    rainbowBackground.setBlendMode( BlendMode.BLUE ); // This line is good to play around with!
    root.getChildren().add( blendModeGroup );

    // 5.) Animation of the circles
    // Move them somewhere in between (0,0) and (w,h)
    for ( Node c : circles.getChildren() ) {
      TranslateTransition t = new TranslateTransition( Duration.millis( 4000 ), c );
      t.setByX( Math.random() * w );
      t.setByY( Math.random() * h );
      t.setCycleCount( Timeline.INDEFINITE );
      t.play();
    }

    return root;
  }

}
