package unterricht.controls.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LayoutDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {

    primaryStage.setScene( new Scene( createContent(), 800, 600 ) );
    primaryStage.show();
  }

  private Parent createContent() {
    // 1. BorderLayout (BorderPane) with regions
    BorderPane root = new BorderPane();

    // 2. HBox (and VBox)
    HBox hbox = createHBox();
    root.setTop( hbox );
    root.setLeft( createVBox() );

    // 3. GridPane:
    root.setCenter( createGridPane() );

    // 4. FlowPane (TilePane)
    root.setRight( createFlowPane() );

    // 5. AnchorPane
    root.setCenter( createAnchorPane( createGridPane() ) );

    return root;
  }

  private Node createAnchorPane( Node grid ) {
    AnchorPane ap = new AnchorPane();
    Button buttonSave = new Button( "Save" );
    Button buttonRemove = new Button( "Remove" );
    HBox hbox = new HBox( 10.0, buttonSave, buttonRemove );

    AnchorPane.setBottomAnchor( hbox, 10.0 );
    AnchorPane.setRightAnchor( hbox, 10.0 );
    AnchorPane.setTopAnchor( grid, 10.0 );
    ap.getChildren().addAll( grid, hbox );
    return ap;
  }

  private Node createFlowPane() {
    FlowPane fp = new FlowPane();
    fp.setPadding( new Insets( 5 ) );
    fp.setStyle( "-fx-background-color: DAEDF3;" );
    for ( int i = 0; i < 200; i++ ) {
      ToggleButton tb = new ToggleButton( i + "" );
      fp.getChildren().add( tb );

    }
    return fp;
  }

  private Node createGridPane() {
    GridPane grid = new GridPane();
    grid.setPadding( new Insets( 10 ) );
    grid.setHgap( 10 );
    grid.setVgap( 5 );

    // Text at 2,1
    Text cat = new Text( "Vegan:" );
    grid.add( cat, 2, 1 );

    // Heading 1: in 3,1
    Text heading1 = new Text( "Beyond Meat Pattie" );
    grid.add( heading1, 3, 1 );

    // Heading 2: in 5,1
    Text heading2 = new Text( "Nooddles with some undefinable green stuff" );
    grid.add( heading2, 5, 1 );

    // Image in 3, 2-3
    ImageView imagePattie = new ImageView( new Image( LayoutDemo.class.getResourceAsStream( "res/BeyondBurger.jpg" ) ) );
    grid.add( imagePattie, 3, 2, 1, 2 );

    // Image in 5, 2-3
    // ImageView imageNoodles = new ImageView(new
    // Image(LayoutDemo.class.getResourceAsStream("res/gruenenudeln.jpg")));
    // grid.add(imageNoodles, 5, 2, 1, 2);

    // grid.setGridLinesVisible(true); // Nice for debugging
    return grid;
  }

  private VBox createVBox() {
    VBox vbox = new VBox();
    vbox.setPadding( new Insets( 10 ) );
    vbox.setSpacing( 8 );
    Text title = new Text( "Menu" );
    vbox.getChildren().add( title );
    title.setFont( Font.font( "Arial", FontPosture.ITALIC, 14 ) );
    Hyperlink[] options = new Hyperlink[]{ new Hyperlink( "Food" ), new Hyperlink( "Drinks" ), new Hyperlink( "Dessert" ),
            new Hyperlink( "Hard Alcohol" ) };
    vbox.getChildren().addAll( options );
    return vbox;
  }

  private HBox createHBox() {
    HBox hbox = new HBox();
    hbox.setPadding( new Insets( 15, 12, 10, 20 ) );
    hbox.setSpacing( 10 );

    Button buttonOk = new Button( "Ok" );
    Button buttonCancel = new Button( "Cancel" );

    hbox.getChildren().addAll( buttonOk, buttonCancel );
    return hbox;
  }

}
