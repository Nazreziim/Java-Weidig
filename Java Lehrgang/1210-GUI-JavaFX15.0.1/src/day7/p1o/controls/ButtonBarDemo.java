package day7.p1o.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ButtonBarDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "ButtonBarDemo" );

    BorderPane borderPane = new BorderPane();

    ButtonBar buttonBar = new ButtonBar();

    Button left = new Button( "Left 1" );
    ButtonBar.setButtonData( left, ButtonData.LEFT );
    Button help_2 = new Button( "Help_2" );
    ButtonBar.setButtonData( help_2, ButtonData.HELP_2 );
    Button unknown1 = new Button( "Unknown 1" );
    ButtonBar.setButtonData( unknown1, ButtonData.OTHER );
    Button unknown2 = new Button( "Unknown 2" );
    ButtonBar.setButtonData( unknown2, ButtonData.OTHER );
    Button back = new Button( "Back" );
    ButtonBar.setButtonData( back, ButtonData.BACK_PREVIOUS );
    Button next = new Button( "Next" );
    ButtonBar.setButtonData( next, ButtonData.NEXT_FORWARD );
    Button finish = new Button( "Finish" );
    ButtonBar.setButtonData( finish, ButtonData.FINISH );
    Button yes = new Button( "Yes" );
    ButtonBar.setButtonData( yes, ButtonData.YES );
    Button no = new Button( "No" );
    ButtonBar.setButtonData( no, ButtonData.NO );
    Button ok = new Button( "OK" );
    ButtonBar.setButtonData( ok, ButtonData.OK_DONE );
    Button cancel = new Button( "Cancel" );
    ButtonBar.setButtonData( cancel, ButtonData.CANCEL_CLOSE );
    Button apply = new Button( "Apply" );
    ButtonBar.setButtonData( apply, ButtonData.APPLY );
    Button help = new Button( "Help" );
    ButtonBar.setButtonData( help, ButtonData.HELP );
    Button right = new Button( "Right 1" );
    ButtonBar.setButtonData( right, ButtonData.RIGHT );

    buttonBar.getButtons().addAll( left, right, help, help_2, unknown1, unknown2, back, next, finish, yes, no, ok, cancel,
            apply );

    TextArea textArea = new TextArea();
    textArea.setPrefColumnCount( 80 );
    textArea.setPrefRowCount( 10 );
    textArea.setWrapText( true );
    textArea.setEditable( false );

    textArea.setText( buttonBar.getButtonOrder() );

    ButtonBar buttonBar2 = new ButtonBar();
    Button windows = new Button( "Windows" );
    windows.setOnAction( event -> {
      buttonBar.setButtonOrder( "L_E+U+FBXI_YNOCAH_R" );
      textArea.setText( buttonBar.getButtonOrder() );
    } );
    ButtonBar.setButtonData( windows, ButtonData.LEFT );
    Button linux = new Button( "Linux" );
    linux.setOnAction( event -> {
      buttonBar.setButtonOrder( "L_HE+U+FBIX_NCYOA_R" );
      textArea.setText( buttonBar.getButtonOrder() );
    } );
    ButtonBar.setButtonData( linux, ButtonData.RIGHT );
    Button mac = new Button( "Mac" );
    mac.setOnAction( event -> {
      buttonBar.setButtonOrder( "L_HE+UNYACBXIO_R" );
      textArea.setText( buttonBar.getButtonOrder() );
    } );
    ButtonBar.setButtonData( mac, ButtonData.OTHER );

    buttonBar2.getButtons().addAll( windows, linux, mac );

    borderPane.setTop( buttonBar2 );

    borderPane.setCenter( textArea );

    borderPane.setBottom( buttonBar );

    Scene scene = new Scene( borderPane );
    primaryStage.setScene( scene );
    primaryStage.show();
  }

}
