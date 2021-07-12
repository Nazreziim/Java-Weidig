package unterricht.controls.basics;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ButtonTextDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {

    primaryStage.setScene( new Scene( createContent(), 800, 600 ) );
    primaryStage.show();
  }

  private Parent createContent() {
    // 1. Buttons
    Button bt = new Button( "Clickme" );
    // bt.setMaxSize(70, 200);
    bt.setWrapText( true );
    bt.setMnemonicParsing( true );
    bt.setText( "_clickme" );

    // 2. Text, Labels, Links
    Text text = new Text( "This looks like simple plain text..." );
    text.setFont( Font.font( "Comic", FontPosture.ITALIC, 30 ) );
    Label label = new Label( "And here is a label!" );
    label.setFont( new Font( "Courier New", 20 ) );
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
    Hyperlink link = new Hyperlink( "Click me - I'm a link" );
    link.setOnMouseClicked( ( MouseEvent e ) -> {
      System.out.println( "Link clicked" );
    } );

    // 3. Radio Buttons / Checkboxes
    RadioButton rb1 = new RadioButton( "Burger" );
    RadioButton rb2 = new RadioButton( "Salat" );
    RadioButton rb3 = new RadioButton( "Steak" );
    RadioButton rb4 = new RadioButton( "Pasta" );
    ToggleButton tb1 = new ToggleButton( "Take away..." );
    ToggleGroup tg = new ToggleGroup();
    tg.getToggles().addAll( rb1, rb2, rb3, rb4, tb1 );

    CheckBox cb1 = new CheckBox( "First" );
    CheckBox cb2 = new CheckBox( "Second Checkbox" );
    cb1.setEffect( new BoxBlur() );
    cb2.setMnemonicParsing( true );
    cb2.setText( "_second" );

    // 4. TextInput
    TextField tf = new TextField( "Here you can type anything..." );
    PasswordField pf = new PasswordField();
    TextArea ta = new TextArea();
    String lorem = new String( "Lorem ipsum dolor sit amet, consectetur adipisici elit,\n"
            + " sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad\n"
            + " minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex \n"
            + "ea commodi consequat. Quis aute iure reprehenderit in voluptate velit esse\n"
            + " cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat\n"
            + " non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. " );
    ta.setText( lorem + lorem );

    // 5. Alerts
    Alert alert = new Alert( AlertType.ERROR, "Are you sure you want to format your system?" );
    alert.showAndWait();

    // Layout: VBox
    VBox root = new VBox();
    root.getChildren().addAll( bt, text, label, link, rb1, rb2, rb3, rb4, tb1, cb1, cb2, tf, pf, ta );
    return root;
  }

}
