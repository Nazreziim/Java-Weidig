package day2.p4.animation;

import java.util.Random;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * This class should animate a various number of snowflakes which fall down on a fullscreen black
 * screen to be collected on the ground
 * 
 * @author lgerhard
 *
 */
public class Snowfall extends Application {

  private Random random = new Random();
  private Group root = new Group();
  private Scene scene;

  @Override
  public void start( Stage primaryStage ) {
    primaryStage.setTitle( "SnowFalling Animation" );
    // primaryStage.initStyle(StageStyle.TRANSPARENT);
    primaryStage.sizeToScene();
    // primaryStage.setFullScreen(true);
    scene = new Scene( root, 1280, 1024 );
    primaryStage.setScene( scene );

    // Black background
    root.getChildren().add( new Rectangle( 1280, 1024, Color.BLACK ) );

    // Lets start with 2000 snowflakes
    Circle snowflakes[] = new Circle[ 20000 ];
    for ( Circle c : snowflakes ) {
      c = new Circle( 1, 1, 1 );
      c.setRadius( random.nextDouble() * 5 );
      Color color = Color.rgb( 255, 255, 255, random.nextDouble() );
      c.setFill( color );
      root.getChildren().add( c );
      letItSnow( c );
    }
    primaryStage.show();
  }

  /**
   * This method provides the TranslateTransition for a single snowflake
   * 
   * @param c the circle which represents the snowflake
   */
  private void letItSnow( Circle c ) {
    c.setCenterX( random.nextInt( (int) scene.getWidth() ) );
    int time = 10 + random.nextInt( 50 );
    TranslateTransition fall = new TranslateTransition( Duration.seconds( time ), c );
    fall.setFromY( -200 );
    fall.setToY( scene.getHeight() - 10 );
    fall.setToX( random.nextDouble() * c.getCenterX() );
    fall.play();
  }

  /**
   * @param args the command line arguments
   */
  public static void main( String[] args ) {
    launch( args );
  }

}
