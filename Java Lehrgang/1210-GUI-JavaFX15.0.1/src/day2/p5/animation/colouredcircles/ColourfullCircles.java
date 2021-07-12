package day2.p5.animation.colouredcircles;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

public class ColourfullCircles extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    Group root = new Group();
    Scene circleScene = new Scene( root, 800, 600 );

    // 1. Create a group with white circles
    Group circles = new Group();
    for ( int i = 0; i < 30; i++ ) {
      Circle circle = new Circle( 150, Color.web( "white", 0.05 ) );
      circle.setStrokeType( StrokeType.OUTSIDE );
      circle.setStroke( Color.web( "white", 0.16 ) );
      circle.setStrokeWidth( 4 );
      circles.getChildren().add( circle );
      circle.setCenterX( Math.random() * 800 );
      circle.setCenterY( Math.random() * 600 );
    }

    // 2. add a blur effect to the circles group
    circles.setEffect( new BoxBlur( 10, 10, 3 ) );

    // 3.1 Background Rectangle
    // Paint paintColor = Color.web("orange", 0.8);
    // Rectangle colorBackground = new Rectangle(circleScene.getWidth(), circleScene.getHeight(),
    // paintColor);
    // root.getChildren().add(colorBackground);

    // 3.2 More fancy Background Rectangle with Linear Gradients
    // Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(1, Color.RED)};

    Stop[] stops = { new Stop( 0, Color.web( "#f8bd55" ) ), new Stop( 0.14, Color.web( "#c0fe56" ) ),
            new Stop( 0.28, Color.web( "#5dfbc1" ) ), new Stop( 0.43, Color.web( "#64c2f8" ) ),
            new Stop( 0.57, Color.web( "#be4af7" ) ), new Stop( 0.71, Color.web( "#ed5fc2" ) ),
            new Stop( 0.85, Color.web( "#ef504c" ) ), new Stop( 1, Color.web( "#f2660f" ) ), };

    LinearGradient paintGradient = new LinearGradient( 0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops );
    Rectangle rainbowBackground = new Rectangle( circleScene.getWidth(), circleScene.getHeight(), paintGradient );
    root.getChildren().add( rainbowBackground );
    root.getChildren().add( circles );

    // 4. Blend mode
    // The group contains two children:
    // The first child is a new (unnamed) Group containing a new (unnamed) black rectangle
    // and the previously created circles group.
    // The second child is the previously created rainbowBackground rectangle.
    // Details on Blendmodes: https://www.javatpoint.com/javafx-blend-effect
    Group blendModeGroup = new Group( 
            new Rectangle( circleScene.getWidth(), circleScene.getHeight(), Color.BLACK ), 
            circles,
            rainbowBackground 
            );
    rainbowBackground.setBlendMode( BlendMode.OVERLAY );
    root.getChildren().add( blendModeGroup );

    // 5. Animation of the circles
    // Timeline timeline = new Timeline();
    // for (Node circle : circles.getChildren()) {
    // timeline.getKeyFrames().addAll(new KeyFrame(Duration.ZERO, // set start position at 0 seconds
    // new KeyValue(circle.translateXProperty(), Math.random() * 800),
    // new KeyValue(circle.translateYProperty(), Math.random() * 600)),
    // new KeyFrame(new Duration(40000), // set end position at 40 seconds
    // new KeyValue(circle.translateXProperty(), Math.random() * 800),
    // new KeyValue(circle.translateYProperty(), Math.random() * 600)));
    // }
    // play 40s of animation
    // timeline.play();

    primaryStage.setScene( circleScene );
    primaryStage.show();
  }

}
