package day8.p1a.extendedcontrols;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class TreeViewDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "TreeViewDemo" );

    BorderPane borderPane = new BorderPane();

    TextArea ta = new TextArea();
    ta.setEditable( false );
    ta.setPrefColumnCount( 80 );
    ta.setPrefRowCount( 25 );

    borderPane.setCenter( ta );

    TreeItem< String > rootItem = new TreeItem<>( "ITSBw" );

    TreeItem< String > berUstg = new TreeItem<>( "Bereich Unterstützung" );
    TreeItem< String > mbs = new TreeItem<>( "Material Berteitstellung" );
    TreeItem< String > fmz = new TreeItem<>( "Fachmeedien Zentrum" );
    berUstg.getChildren().addAll( mbs, fmz );

    TreeItem< String > berLA = new TreeItem<>( "Bereich Lehre/Ausbildung" );

    TreeItem< String > lgA = new TreeItem<>( "Lehrgruppe A" );
    TreeItem< String > iIn = new TreeItem<>( "I. Inspektion" );
    TreeItem< String > iiIn = new TreeItem<>( "II. Inspektion" );
    TreeItem< String > iiiIn = new TreeItem<>( "III. Inspektion" );
    TreeItem< String > ivIn = new TreeItem<>( "IV. Inspektion" );
    TreeItem< String > vIn = new TreeItem<>( "V. Inspektion" );
    lgA.getChildren().addAll( iIn, iiIn, iiiIn, ivIn, vIn );

    TreeItem< String > lgB = new TreeItem<>( "Lehrgruppe B" );
    TreeItem< String > viIn = new TreeItem<>( "VI. Inspektion" );
    TreeItem< String > viiIn = new TreeItem<>( "VII. Inspektion" );
    TreeItem< String > viiiIn = new TreeItem<>( "VIII. Inspektion" );
    TreeItem< String > ixIn = new TreeItem<>( "IX. Inspektion" );
    TreeItem< String > xIn = new TreeItem<>( "X. Inspektion" );
    lgB.getChildren().addAll( viIn, viiIn, viiiIn, ixIn, xIn );

    berLA.getChildren().addAll( lgA, lgB );

    TreeItem< String > stab = new TreeItem<>( "Stab" );
    TreeItem< String > s1 = new TreeItem<>( "S1" );
    TreeItem< String > s2 = new TreeItem<>( "S2" );
    TreeItem< String > s3 = new TreeItem<>( "S3" );
    TreeItem< String > s4 = new TreeItem<>( "S4" );
    TreeItem< String > s6 = new TreeItem<>( "S6" );
    stab.getChildren().addAll( s1, s2, s3, s4, s6 );

    rootItem.getChildren().addAll( berLA, berUstg );

    TreeView treeView = new TreeView< String >( rootItem );
    treeView.setEditable( true );
    treeView.setCellFactory( call -> {
      return new TextFieldTreeCell< String >( new StringConverter< String >() {
        @Override
        public String toString( String object ) {
          return object;
        }

        @Override
        public String fromString( String string ) {
          return string;
        }
      } );
    } );
    treeView.setOnMouseClicked( event -> {
      if ( event.getButton() == MouseButton.PRIMARY && event.getClickCount() >= 2 ) {
        ta.setText( treeView.getSelectionModel().getSelectedItem().toString() );
      }
    } );

    borderPane.setLeft( treeView );

    Scene scene = new Scene( borderPane );
    primaryStage.setScene( scene );
    primaryStage.show();

  }

}
