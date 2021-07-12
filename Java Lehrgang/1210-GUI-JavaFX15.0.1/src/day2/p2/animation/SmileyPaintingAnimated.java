package day2.p2.animation;

import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * This class is meant as an excercise to get in touch with the simple drawing methods of JavaFX.
 * The task is to draw a smiley on the screen which consists at least of the following elements:
 * <p>
 * <ul>
 * <li>face (circle)
 * <li>eyes (ellipses) with pupils (circles)
 * <li>mouth consisting of two lips (arcs)
 * </ul>
 * <p>
 * Additional elements are voluntary. The drawing should be done once in a static way (200x200 pixel
 * smiley) and once in a dynamic way (which adapts to the given size of the used canvas object)
 * 
 * @author lgerhard
 *
 */
public class SmileyPaintingAnimated extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    Group root = new Group();
    Canvas canvas = new Canvas( 800, 600 );
    GraphicsContext gc = canvas.getGraphicsContext2D();
    drawSmileyStatic( gc );

    // Now lets animate the eyes...
    Circle leftEye = new Circle( 265, 255, 5, Color.WHITESMOKE );
    Circle rightEye = new Circle( 335, 255, 5, Color.WHITESMOKE );
    animateEyes( leftEye, rightEye );

    // canvas.setEffect(new GaussianBlur());
    root.getChildren().addAll( canvas, leftEye, rightEye );
    primaryStage.setScene( new Scene( root ) );
    primaryStage.show();

  }

  /**
   * This method generates the Transitions which are needed to animate the pupils of the smiley's
   * eyes
   * 
   * @param leftEye
   * @param rightEye
   */
  private void animateEyes( Circle leftEye, Circle rightEye ) {
    TranslateTransition leftEyeMovement = new TranslateTransition( Duration.millis( 1000 ), leftEye );
    leftEyeMovement.setFromX( -20 );
    leftEyeMovement.setToX( 20 );
    leftEyeMovement.setCycleCount( 1 );
    leftEyeMovement.setAutoReverse( true );
    TranslateTransition rightEyeMovement = new TranslateTransition( Duration.millis( 1000 ), rightEye );
    rightEyeMovement.setFromX( -20 );
    rightEyeMovement.setToX( 20 );
    rightEyeMovement.setCycleCount( 1 );
    rightEyeMovement.setAutoReverse( true );
    // leftEyeMovement.play();
    // rightEyeMovement.play();
    SequentialTransition eyeSequence = new SequentialTransition( leftEyeMovement, rightEyeMovement );
    eyeSequence.setAutoReverse( true );
    eyeSequence.setCycleCount( Timeline.INDEFINITE );
    eyeSequence.play();
  }

  /**
   * This method draws a simple 200x200 pixel smiley.
   * 
   * @param gc
   */
  private void drawSmileyStatic( GraphicsContext gc ) {

    gc.setFill( Color.YELLOW );
    gc.setStroke( Color.ORANGE );
    gc.setLineWidth( 5 );

    // Face
    gc.strokeOval( 200, 200, 200, 200 );
    gc.fillOval( 200, 200, 200, 200 );

    // Eyes
    gc.setFill( Color.BLACK );
    gc.fillOval( 240, 240, 50, 30 );
    gc.fillOval( 310, 240, 50, 30 );
    gc.setFill( Color.WHITE );
    // gc.fillOval(260,250,10,10);
    // gc.fillOval(330,250,10,10);

    // Mouth
    gc.setStroke( Color.DEEPPINK );
    gc.strokeArc( 265, 330, 70, 40, 180, 180, ArcType.OPEN );
    gc.strokeArc( 265, 340, 70, 20, 180, 180, ArcType.OPEN );

    // Nose (optional) - with use of path
    gc.beginPath();
    gc.moveTo( 300, 290 );
    gc.lineTo( 300, 330 );
    gc.closePath();
    gc.stroke();

  }

  /**
   * This method calculates the drawing of a smiley depending on the canvas which has been used as
   * input for the GraphicsContent of the method. The smiley will be drawn as large as possible.
   * 
   * @param gc
   */
  private void drawSmileyDynamic( GraphicsContext gc ) {
    double canvasHeight = gc.getCanvas().getHeight();
    double canvasWidth = gc.getCanvas().getWidth();
    int width = 0;
    int height = 0;

    // Setup a virtual squared area to draw the smiley
    // Use the smaller value of the dimensions of the original canvas
    if ( canvasHeight > canvasWidth ) {
      height = (int) canvasWidth;
      width = (int) canvasWidth;
    }
    if ( canvasHeight <= canvasWidth ) {
      height = (int) canvasHeight;
      width = (int) canvasHeight;
    }

    gc.setFill( Color.YELLOW );
    gc.setStroke( Color.ORANGE );
    gc.setLineWidth( 5 );

    // Face
    gc.strokeOval( 0, 0, width, height );
    gc.fillOval( 0, 0, width, height );

    // Eyes
    int eyeWidth = width / 4;
    int eyeHeight = height / 10;
    int xEye1 = (int) ( 0.2 * width );
    int yEye1 = (int) ( 0.2 * height );
    int xEye2 = (int) ( 0.8 * width - eyeWidth );
    int yEye2 = yEye1;

    gc.setFill( Color.BLACK );
    gc.fillOval( xEye1, yEye1, eyeWidth, eyeHeight );
    gc.fillOval( xEye2, yEye2, eyeWidth, eyeHeight );

    // Pupils (in the middle of the eyes)
    int pupilHeight = eyeHeight / 2;
    int pupilWidth = pupilHeight;
    int xPupil1 = (int) ( xEye1 + 0.5 * eyeWidth - 0.5 * pupilWidth );
    int yPupil1 = (int) ( yEye1 + 0.5 * eyeHeight - 0.5 * pupilHeight );
    int xPupil2 = (int) ( xEye2 + 0.5 * eyeWidth - 0.5 * pupilWidth );
    int yPupil2 = (int) ( yEye2 + 0.5 * eyeHeight - 0.5 * pupilHeight );

    gc.setFill( Color.WHITE );
    gc.fillOval( xPupil1, yPupil1, pupilWidth, pupilHeight );
    gc.fillOval( xPupil2, yPupil2, pupilWidth, pupilHeight );

    // Mouth (centered under the pupils)
    int xLowerLip = (int) ( xPupil1 + 0.5 * pupilWidth );
    int yLowerLip = (int) ( 0.8 * height );
    int xUpperLip = xLowerLip;
    int yUpperLip = yLowerLip + 10; // manual downshift to set the arc-starts on approx. the same
                                    // coordinate
    int lipWidth = xPupil2 - xPupil1;

    gc.setStroke( Color.DEEPPINK );
    gc.strokeArc( xLowerLip, yLowerLip, lipWidth, 40, 180, 180, ArcType.OPEN );
    gc.strokeArc( xUpperLip, yUpperLip, lipWidth, 20, 180, 180, ArcType.OPEN );

  }

}
