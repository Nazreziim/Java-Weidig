package unterricht.controls.basics;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * In this class we want to show some simple paint effects which can be used in combination to
 * create beautiful pictures
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
    // 1. Paint a simple line
    Line l = new Line( 10, 20, 50, 150 );

    // 2. Paint a rectangle
    // Color c = new Color(0.3, 0.6, 0.8, 0.1);
    Color c2 = Color.FIREBRICK;
    Rectangle r = new Rectangle( 200, 100, c2 );
    r.setOpacity( 0.4 );
    r.setArcHeight( 30 );
    r.setArcWidth( 30 );
    r.setEffect( new Reflection() );
    // r.setEffect(new BoxBlur());

    // 3. Paint a circle
    Circle circ = new Circle( 20, Color.AQUAMARINE );

    // 4. Paint an arc
    Arc a = new Arc( 30, 30, 40, 80, 90, 180 );
    // a.setType(ArcType.ROUND);
    a.setFill( Color.PERU );

    // 5. Cubic Curve
    CubicCurve curve = new CubicCurve( 0, 0, 100, 0, 0, 100, 100, 100 );
    curve.setFill( Color.DEEPPINK );

    // 6. Text
    Text t = new Text( "Das ist ein Text" );
    t.setEffect( new Reflection() );

    // Create a stackpane (= container) and add the nodes to it
    Group sp = new Group();
    // sp.setEffect(new BoxBlur());
    // sp.getChildren().add(l);
    // sp.getChildren().add(r);
    // sp.getChildren().add(circ);
    sp.getChildren().addAll( l, r, a, circ, curve, t );
    // sp.getChildren().add(curve);

    Scene scene = new Scene( sp );
    primaryStage.setScene( scene );
    primaryStage.show();
  }

}
