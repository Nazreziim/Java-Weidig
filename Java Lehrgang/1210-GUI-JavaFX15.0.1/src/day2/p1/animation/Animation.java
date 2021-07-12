/*
 * Copyright (c) 2008, 2011 Oracle and/or its affiliates. All rights reserved. Use is subject to
 * license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted
 * provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice, this list of conditions
 * and the following disclaimer. - Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the documentation and/or other
 * materials provided with the distribution. - Neither the name of Oracle Corporation nor the names
 * of its contributors may be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 * WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package day2.p1.animation;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * This class is an adaption of an Oracle tutorial provided here:
 * https://docs.oracle.com/javafx/2/animations/basics.htm#CJAJJAGI I added some explaining comments,
 * removed some unnecessary stuff and changed some of the original nodes to get this example more
 * interesting
 * 
 * @author lgerhard
 *
 */
public class Animation extends Application {

  public static void main( String[] args ) {
    Application.launch( args );
  }

  @Override
  public void start( Stage stage ) {
    stage.setTitle( "Animations" );
    Group root = new Group();
    final Scene scene = new Scene( root, 800, 400 );

    // Add some nodes which should be animated
    final Rectangle basicTimelineRectangle = new Rectangle( 0, 140, 70, 50 );
    basicTimelineRectangle.setFill( Color.DEEPPINK );

    final Button fadeBtn = new Button( "Knopf" );

    final Rectangle rectFadeAll = new Rectangle( 0, 0, 600, 450 );
    rectFadeAll.setFill( Color.GREY );

    final Ellipse pathEllipse = new Ellipse( 30, 30, 10, 10 );
    pathEllipse.setFill( Color.ORANGE );

    final Rectangle sequentialRectangle = new Rectangle( 10, 200, 50, 50 ); // 25,25,50, 50);
    sequentialRectangle.setArcHeight( 15 );
    sequentialRectangle.setArcWidth( 15 );
    sequentialRectangle.setFill( Color.DARKBLUE );
    sequentialRectangle.setTranslateX( 50 );
    sequentialRectangle.setTranslateY( 50 );

    root.getChildren().addAll( basicTimelineRectangle, fadeBtn, pathEllipse, sequentialRectangle );
    stage.setScene( scene );
    stage.show();

    // everything easy until here... now comes the big one new thing: Timelines and Transitions!

    /////////////////////////////////////////////////////////////////////////////////////////////////
    // 1. Basic Timeline Animations
    // Timeline = 1 or more KeyFrames
    // Keyframe = Target value (=Frame, KeyValue) for a certain timepoint (=Duration),
    final Timeline timeline = new Timeline();
    timeline.setCycleCount( 10 ); // Timeline.INDEFINITE;
    // timeline.setAutoReverse(true);

    // The following moves the rectangle from its original position to x = 300 within 500 ms
    // Interpolation defines positions of the object between the start and end points of the
    // movement.
    // Various built-in Interpolators exist, but own implementations can be provided as well.

    final KeyValue kv = new KeyValue( basicTimelineRectangle.xProperty(), 300 ); // ,
                                                                                 // Interpolator.EASE_BOTH
    final KeyFrame kf = new KeyFrame( Duration.millis( 500 ), kv );
    timeline.getKeyFrames().add( kf );
    timeline.play();

    /////////////////////////////////////////////////////////////////////////////////////////////////
    // 2. Fading Transitions
    FadeTransition ft = new FadeTransition( Duration.millis( 1000 ), fadeBtn );
    ft.setFromValue( 1.0 );
    ft.setToValue( 0.1 );
    ft.setCycleCount( Timeline.INDEFINITE );
    ft.setAutoReverse( true );
    ft.play();

    /////////////////////////////////////////////////////////////////////////////////////////////////

    // 3. Path Transitions
    // Define a funny path first, connect two bezier curve elements (check by try & error how the
    // coordinates are used)
    Path path = new Path();
    path.getElements().add( new MoveTo( 20, 20 ) );
    path.getElements().add( new CubicCurveTo( 400, 0, 400, 100, 200, 100 ) );
    path.getElements().add( new CubicCurveTo( 0, 100, 0, 200, 400, 200 ) );

    PathTransition pathTransition = new PathTransition();
    pathTransition.setDuration( Duration.millis( 5000 ) );
    pathTransition.setPath( path );
    pathTransition.setNode( pathEllipse );
    // pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    pathTransition.setCycleCount( Timeline.INDEFINITE );
    pathTransition.setAutoReverse( true );
    pathTransition.play();
    //

    /////////////////////////////////////////////////////////////////////////////////////////////////
    // 4. Sequential Transitions: Do multiple transitions one after the other

    // First we prepare four single transitions:
    FadeTransition fadeTransition = new FadeTransition( Duration.millis( 1000 ), sequentialRectangle );
    fadeTransition.setFromValue( 1.0f );
    fadeTransition.setToValue( 0.1f );
    fadeTransition.setCycleCount( 1 );
    fadeTransition.setAutoReverse( true );

    TranslateTransition translateTransition = new TranslateTransition( Duration.millis( 2000 ), sequentialRectangle );
    translateTransition.setFromX( 50 );
    translateTransition.setToX( 375 );
    translateTransition.setCycleCount( 2 );
    translateTransition.setAutoReverse( true );

    RotateTransition rotateTransition = new RotateTransition( Duration.millis( 2000 ), sequentialRectangle );
    rotateTransition.setByAngle( 160f );
    rotateTransition.setCycleCount( 3 );
    rotateTransition.setAutoReverse( true );

    ScaleTransition scaleTransition = new ScaleTransition( Duration.millis( 2000 ), sequentialRectangle );
    scaleTransition.setFromX( 1 );
    scaleTransition.setFromY( 1 );
    scaleTransition.setToX( 2 );
    scaleTransition.setToY( 2 );
    scaleTransition.setCycleCount( 1 );
    scaleTransition.setAutoReverse( true );

    // then we add the created transitions to one SequentialTransition
    SequentialTransition sequentialTransition = new SequentialTransition();
    sequentialTransition.getChildren().addAll( fadeTransition, translateTransition, rotateTransition, scaleTransition );
    sequentialTransition.setCycleCount( Timeline.INDEFINITE );
    sequentialTransition.setAutoReverse( true );
    sequentialTransition.play();

  }

}
