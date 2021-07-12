package unterricht.animation;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation extends Application {

  public static void main( String[] args ) {
    launch( args );

  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setScene( new Scene( createContent(), 800, 600 ) );
    primaryStage.show();
  }

  private Parent createContent() {
    Group root = new Group();

    // 1. Basic Timeline Animation
    Rectangle basicTimeRetangle = new Rectangle( 0, 140, 70, 50 );
    basicTimeRetangle.setFill( Color.DEEPPINK );
    basicTimeRetangle.setEffect( new GaussianBlur() );

    Timeline timeline = new Timeline();
    timeline.setCycleCount( Timeline.INDEFINITE );
    timeline.setAutoReverse( true );

    KeyValue kv = new KeyValue( basicTimeRetangle.xProperty(), 300 );
    KeyFrame kf = new KeyFrame( Duration.millis( 500 ), kv );

    timeline.getKeyFrames().add( kf );
    timeline.play();

    // 2. Fading Transition
    Button fadeBtn = new Button( "Hier ist kein Knopf" );
    FadeTransition ft = new FadeTransition( Duration.millis( 1000 ), fadeBtn );
    ft.setFromValue( 1.0 );
    ft.setToValue( 0.1 );
    ft.setCycleCount( 50 );
    ft.setAutoReverse( true );
    ft.play();

    // 3. Path transition
    // Define a path first
    Path path = new Path();
    path.getElements().add( new MoveTo( 20, 20 ) );
    path.getElements().add( new CubicCurveTo( 400, 0, 400, 100, 200, 100 ) );
    path.getElements().add( new CubicCurveTo( 0, 100, 0, 200, 400, 200 ) );

    Ellipse pathEllipse = new Ellipse( 30, 30, 30, 20 );
    pathEllipse.setFill( Color.CRIMSON );

    PathTransition pathTransition = new PathTransition();
    pathTransition.setDuration( Duration.millis( 5000 ) );
    // pathTransition.setPath(new Circle(100, 100, 50));
    // pathTransition.setPath(basicTimeRetangle);
    pathTransition.setPath( path );

    pathTransition.setNode( pathEllipse );
    pathTransition.setCycleCount( Timeline.INDEFINITE );
    pathTransition.setAutoReverse( true );
    pathTransition.play();

    // 4. Sequential transition (there is also a Parallel transition)

    // First we need several single transitions:
    Rectangle sequentialRectangle = new Rectangle( 30, 30, 70, 40 );
    sequentialRectangle.setFill( Color.LIME );

    FadeTransition fadeTransition = new FadeTransition( Duration.millis( 1000 ), sequentialRectangle );
    fadeTransition.setFromValue( 1.0 );
    fadeTransition.setToValue( 0.3 );
    fadeTransition.setCycleCount( 1 );
    fadeTransition.setAutoReverse( true );

    TranslateTransition translateTransition = new TranslateTransition( Duration.millis( 2000 ), sequentialRectangle );
    translateTransition.setFromX( 30 );
    translateTransition.setToX( 400 );
    translateTransition.setFromY( 30 );
    translateTransition.setToY( 200 );
    translateTransition.setFromZ( 0 );
    translateTransition.setToZ( 200 );
    translateTransition.setCycleCount( 2 );
    translateTransition.setAutoReverse( true );

    RotateTransition rotateTransition = new RotateTransition( Duration.millis( 2000 ), sequentialRectangle );
    rotateTransition.setByAngle( 205 );
    rotateTransition.setCycleCount( 3 );
    // rotateTransition.setAutoReverse(true);

    ScaleTransition scaleTransition = new ScaleTransition( Duration.millis( 2000 ), sequentialRectangle );
    scaleTransition.setByX( 2 );
    scaleTransition.setByY( 2 );
    scaleTransition.setCycleCount( 1 );
    scaleTransition.setAutoReverse( true );

    // Now lets put all this together in a sequential transition
    SequentialTransition seqTrans = new SequentialTransition( sequentialRectangle );
    seqTrans.getChildren().addAll( fadeTransition, translateTransition, rotateTransition );
    seqTrans.setCycleCount( Timeline.INDEFINITE );
    seqTrans.setAutoReverse( true );
    seqTrans.play();

    // 5. Parallel transition
    ParallelTransition parTrans = new ParallelTransition( sequentialRectangle, fadeTransition, translateTransition,
            rotateTransition, scaleTransition );
    parTrans.setCycleCount( Timeline.INDEFINITE );
    parTrans.setAutoReverse( true );
    // parTrans.play();

    root.getChildren().addAll( basicTimeRetangle, fadeBtn, path, pathEllipse, sequentialRectangle );
    return root;
  }

}
