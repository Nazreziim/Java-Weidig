package day4.p4.events.keyevents;

/*
 * Copyright (c) 2008, 2016, Oracle and/or its affiliates. All rights reserved. Use is subject to
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
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * A sample that demonstrates various key events and their usage. Type in the text box to view the
 * triggered events: key pressed, key typed and key released. Pressing the Shift, Ctrl, and Alt keys
 * also trigger events. This class has been adapted form Oracles Ensemble Application (some parts
 * were removed to get it more clearer and easier to read)
 */
public class KeyEventApp extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setScene( new Scene( createContent() ) );
    primaryStage.show();
  }

  public Parent createContent() {
    // create a console for logging key events
    final ListView< String > console = new ListView< String >();
    console.setPrefHeight( 150 );
    console.setMaxHeight( ListView.USE_PREF_SIZE );

    // create text box for typing in
    final TextField textBox = new TextField();
    textBox.setPromptText( "Type something" );
    // textBox.setStyle("-fx-font-size: 34;");

    // textBox.setOnKeyPressed((KeyEvent ke) -> {
    // console.getItems().add("Key Pressed: " + ke.getText());
    // });
    //
    // textBox.setOnKeyReleased((KeyEvent ke) -> {
    // console.getItems().add("Key Released: " + ke.getText());
    // });

    textBox.setOnKeyTyped( ( KeyEvent ke ) -> {
      String text = "Key Typed: " + ke.getCharacter();
      if ( ke.isAltDown() ) {
        text += " , alt down";
      }
      if ( ke.isControlDown() ) {
        text += " , ctrl down";
      }
      if ( ke.isMetaDown() ) {
        text += " , meta down";
      }
      if ( ke.isShiftDown() ) {
        text += " , shift down";
      }
      console.getItems().add( text );
    } );

    VBox vb = new VBox( 10 );
    vb.getChildren().addAll( textBox, console );
    return vb;
  }

}
