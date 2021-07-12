package day1.p3a.paint.simple;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * In this class we want to show some simple paint effects which can be used in combination to
 * create your own beautiful pictures.
 * 
 * @author lgerhard
 *
 */
public class MyFirstDrawing extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    StackPane sp = new StackPane();
    Scene s = new Scene( sp );

    // 1. Paint a simple line
    Line l = new Line( 0, 0, 100, 100 );

    // 2. Paint a Rectangle
    Rectangle rectangle = new Rectangle();
    rectangle.setX( 100 );
    rectangle.setY( 100 );
    rectangle.setWidth( 200 );
    rectangle.setHeight( 150 );
    rectangle.setFill( Color.CADETBLUE );
    rectangle.setArcHeight( 105 );
    rectangle.setArcWidth( 50 );

    // 3. Paint an arc ("Kreisbogen")
    // Kreisbogen mit Beleuchtung
    Arc arc = new Arc( 10, 10, 50, 50, 45, 270 );
    arc.setType( ArcType.ROUND );
    arc.setFill( Color.BLANCHEDALMOND );
    arc.setEffect( new Lighting() );

    // 4. Cubic Curve
    CubicCurve curve = new CubicCurve( 30, 30, 40, 40, 200, 200, 90, 40 );
    curve.setFill( Color.PINK );
    curve.setEffect( new Reflection() );

    // 5. Text
    Text t = new Text( 90, 180, "Hallihallo..." );

    sp.getChildren().addAll( rectangle, arc, l, curve, t );
    // Looks nice..... but what if we want to combine different shapes to generate
    // something more complex?

    primaryStage.setScene( s );
    primaryStage.show();
  }

}
