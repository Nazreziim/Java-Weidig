package unterricht.controls.basics;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CanvasDrawings extends Application {

  public static void main( String[] args ) {
    launch( args );

  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    Canvas canvas = new Canvas( 640, 480 );
    GraphicsContext gc = canvas.getGraphicsContext2D();

    // Draw an oval
    gc.setStroke( Color.DARKGOLDENROD );
    gc.setLineWidth( 5 );
    gc.strokeOval( 60, 20, 40, 70 );

    // Draw Rounded Rectangle
    gc.setFill( Color.BLUEVIOLET );
    gc.fillRoundRect( 60, 20, 60, 40, 20, 20 );
    gc.strokeRoundRect( 60, 20, 40, 40, 20, 20 );

    // draw a custom path
    gc.beginPath();
    gc.moveTo( 150, 30 );
    gc.lineTo( 190, 20 );
    gc.bezierCurveTo( 250, 50, 100, 80, 190, 120 );
    gc.closePath();
    gc.setStroke( Color.FIREBRICK );
    gc.stroke();

    canvas.setEffect( new Lighting() );

    Group root = new Group();
    root.getChildren().add( canvas );
    primaryStage.setScene( new Scene( root ) );
    primaryStage.show();
  }

}
