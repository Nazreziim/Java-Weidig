package day1.p3b.paint.simple;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

/**
 * In this class we want to show some simple paint effects which can be used in combination to
 * create your own beautiful pictures.
 * 
 * @author lgerhard
 *
 */
public class CanvasDrawings extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    StackPane sp = new StackPane();
    Scene s = new Scene( sp );

    // All the previously used shapes are either SVG graphics or they are scalable in
    // another way.
    // Use the Canvas to paint pixel by pixel.
    Canvas canvas = new Canvas( 640, 480 );
    final GraphicsContext gc = canvas.getGraphicsContext2D();

    // Canvas-Hintergrund als Rechteck löschen
    // gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

    // Oval drawing
    gc.setStroke( Color.DARKGOLDENROD );
    gc.setLineWidth( 4 );
    gc.strokeOval( 10, 20, 40, 40 );

    // Rounded Rectangle
    gc.setFill( Color.BLUEVIOLET );
    gc.fillRoundRect( 60, 20, 60, 40, 20, 20 );

    // Draw a custom path
    gc.setStroke( Color.FIREBRICK );
    gc.beginPath();
    gc.moveTo( 150, 30 );
    gc.lineTo( 190, 20 );
    gc.bezierCurveTo( 150, 110, 130, 30, 150, 40 );
    gc.closePath();

    // draw the path!
    gc.stroke();

    // draw an arc
    gc.setFill( Color.web( "dodgerblue" ) );
    gc.fillArc( 180, 30, 30, 30, 45, 270, ArcType.ROUND );

    gc.setEffect( new Lighting() );
    sp.getChildren().add( canvas );

    primaryStage.setScene( s );
    primaryStage.show();
  }

}
