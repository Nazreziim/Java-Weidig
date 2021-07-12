package day3.p1.controls.basics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * In this class we want to show the usage of JavaFX Buttons and some other "easy" UI-Elements like
 * Text, Label and Hyperlink
 * 
 * @author lgerhard
 *
 */
public class ButtonTextDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    // 1. Buttons
    Button bt1 = new Button( "Here is a button" );
    bt1.setMaxSize( 70, 200 );
    bt1.setWrapText( true );
    bt1.setMnemonicParsing( true );
    bt1.setText( "_here is a button" );

    // 2. Text, Labels & Links
    Text title = new Text( "This looks like plain text..." );
    title.setFont( Font.font( "Arial", FontWeight.BOLD, 14 ) );
    Label label = new Label( "And here is a label :-)" );
    label.setFont( new Font( "Arial", 24 ) );

    // Nice zoom effect for the label
    label.setOnMouseEntered( ( MouseEvent e ) -> {
      label.setScaleX( 1.5 );
      label.setScaleY( 1.5 );
      ;
    } );
    label.setOnMouseExited( ( MouseEvent e ) -> {
      label.setScaleX( 1 );
      label.setScaleY( 1 );
      ;
    } );

    Hyperlink link = new Hyperlink( "Click me - I'm a link!" );
    // Lambda expression just for simple demo reasons ;-)
    link.setOnAction( e -> {
      System.out.println( "The Hyperlink was clicked!" );
    } );

    // 3. Radio Buttons / Checkboxen
    final ToggleGroup radioGroup = new ToggleGroup();
    RadioButton rb1 = new RadioButton( "Veganer" );
    RadioButton rb2 = new RadioButton( "Vegetarier" );
    RadioButton rb3 = new RadioButton( "Fruktarier" );
    RadioButton rb4 = new RadioButton( "Ganz normal" );
    rb1.setToggleGroup( radioGroup );
    rb2.setToggleGroup( radioGroup );
    rb3.setToggleGroup( radioGroup );
    // rb4.setToggleGroup(radioGroup);
    rb1.setUserData( "Ohnealles" );
    rb4.setUserData( "Steak" );

    CheckBox cb1 = new CheckBox();
    CheckBox cb2 = new CheckBox( "Second" );

    cb1.setText( "First" );
    cb1.setSelected( true );

    // to group multiple controls ;-)
    // Group layouter = new Group(); // this is the most simple type of a layout manager, all
    // elements are positioned at 0, 0
    VBox layouter = new VBox();
    layouter.getChildren().add( bt1 );
    layouter.getChildren().add( title );
    layouter.getChildren().add( label );
    layouter.getChildren().add( link );
    layouter.getChildren().addAll( rb1, rb2, rb3, rb4 );
    layouter.getChildren().addAll( cb1, cb2 );

    Scene primaryScene = new Scene( layouter, 800, 600 );

    primaryStage.setScene( primaryScene );
    primaryStage.show();

  }

}
