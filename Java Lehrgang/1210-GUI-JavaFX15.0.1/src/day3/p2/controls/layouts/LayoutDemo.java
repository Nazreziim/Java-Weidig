package day3.p2.controls.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This layout example class has been adapted from
 * https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm It shows the use of different JavaFX
 * Layout Panes in an easy-to-play-around-way.
 * 
 * @author lgerhard
 *
 */
public class LayoutDemo extends Application {

  /**
   * @param args the command line arguments
   */
  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage stage ) {

    // 1. BorderPane with its regions: top, bottom, left, right, center
    BorderPane border = new BorderPane();

    // 2. HBox and VBox
    HBox hbox = addHBox();
    border.setTop( hbox );
    border.setLeft( addVBox() );

    // 3. StackPane: Each node is added on top of the previous one.
    addStackPane( hbox );

    // 4. GridPane: A (potentially invisible) grid where you can address all single cells and add
    // your nodes
    border.setCenter( addGridPane() );

    // 5. FlowPane and TilePane
    border.setRight( addFlowPane() );
    // border.setRight(addTilePane());

    // 6. AnchorPane: "Glue" Elements to a certain (or even multiple) positions.
    // Here two buttons are anchored to the bottom right side
    border.setCenter( addAnchorPane( addGridPane() ) );

    Scene scene = new Scene( border );
    stage.setScene( scene );
    stage.setTitle( "Layout Sample" );
    stage.show();
  }

  /**
   * Creates an HBox with two buttons for the top region
   */
  private HBox addHBox() {

    HBox hbox = new HBox();
    hbox.setPadding( new Insets( 15, 12, 15, 12 ) ); // gaps to the border of the window
    hbox.setSpacing( 10 ); // Gap between nodes

    hbox.setBackground( new Background( new BackgroundFill( Color.RED, new CornerRadii( 20 ), new Insets( 3 ) ) ) );
    // hbox.setStyle("-fx-background-color: #336699;");

    Button buttonCurrent = new Button( "Current" );
    buttonCurrent.setPrefSize( 100, 20 );

    Button buttonProjected = new Button( "Projected" );
    buttonProjected.setPrefSize( 100, 20 );

    hbox.getChildren().addAll( buttonCurrent, buttonProjected );

    return hbox;
  }

  /**
   * Creates a VBox with a list of links for the left region
   */
  private VBox addVBox() {

    VBox vbox = new VBox();
    vbox.setPadding( new Insets( 10 ) ); // Set all sides to 10
    vbox.setSpacing( 8 ); // Gap between nodes

    Text title = new Text( "Data" );
    title.setFont( Font.font( "Arial", FontWeight.BOLD, 14 ) );
    vbox.getChildren().add( title );

    Hyperlink options[] = new Hyperlink[]{ new Hyperlink( "Sales" ), new Hyperlink( "Marketing" ),
            new Hyperlink( "Distribution" ), new Hyperlink( "Costs" ) };

    vbox.getChildren().addAll( options );

    return vbox;
  }

  /**
   * Uses a stack pane to create a help icon and adds it to the right side of an HBox
   * 
   * @param hb HBox to add the stack to
   */
  private void addStackPane( HBox hb ) {

    StackPane stack = new StackPane();
    Rectangle helpIcon = new Rectangle( 30.0, 25.0 );
    helpIcon.setFill(
            new LinearGradient( 0, 0, 0, 1, true, CycleMethod.NO_CYCLE, new Stop[]{ new Stop( 0, Color.web( "#4977A3" ) ),
                    new Stop( 0.5, Color.web( "#B0C6DA" ) ), new Stop( 1, Color.web( "#9CB6CF" ) ), } ) );
    helpIcon.setStroke( Color.web( "#D0E6FA" ) );
    helpIcon.setArcHeight( 3.5 );
    helpIcon.setArcWidth( 3.5 );

    Text helpText = new Text( "?" );
    helpText.setFont( Font.font( "Verdana", FontWeight.BOLD, 18 ) );
    helpText.setFill( Color.WHITE );
    helpText.setStroke( Color.web( "#7080A0" ) );

    stack.getChildren().addAll( helpIcon, helpText );
    stack.setAlignment( Pos.CENTER_RIGHT );
    // Add offset to right for question mark to compensate for RIGHT
    // alignment of all nodes
    StackPane.setMargin( helpText, new Insets( 0, 10, 0, 0 ) );

    hb.getChildren().add( stack );
    HBox.setHgrow( stack, Priority.ALWAYS );

  }

  /**
   * Creates a grid for the center region with four columns and three rows
   */
  private GridPane addGridPane() {

    GridPane grid = new GridPane();
    grid.setHgap( 10 );
    grid.setVgap( 10 );
    grid.setPadding( new Insets( 0, 10, 0, 10 ) );

    // Category in column 2, row 1
    Text category = new Text( "Sales:" );
    category.setFont( Font.font( "Arial", FontWeight.BOLD, 20 ) );
    grid.add( category, 1, 0 );

    // Title in column 3, row 1
    Text chartTitle = new Text( "Current Year" );
    chartTitle.setFont( Font.font( "Arial", FontWeight.BOLD, 20 ) );
    grid.add( chartTitle, 2, 0 );

    // Subtitle in columns 2-3, row 2
    Text chartSubtitle = new Text( "Goods and Services" );
    grid.add( chartSubtitle, 1, 1, 2, 1 );

    // House icon in column 1, rows 1-2
    ImageView imageHouse = new ImageView( new Image( LayoutDemo.class.getResourceAsStream( "graphics/house.png" ) ) );
    grid.add( imageHouse, 0, 0, 1, 2 );

    // Left label in column 1 (bottom), row 3
    Text goodsPercent = new Text( "Goods\n80%" );
    GridPane.setValignment( goodsPercent, VPos.BOTTOM );
    grid.add( goodsPercent, 0, 2 );

    // Chart in columns 2-3, row 3
    ImageView imageChart = new ImageView( new Image( LayoutDemo.class.getResourceAsStream( "graphics/piechart.png" ) ) );
    grid.add( imageChart, 1, 2, 2, 1 );

    // Right label in column 4 (top), row 3
    Text servicesPercent = new Text( "Services\n20%" );
    GridPane.setValignment( servicesPercent, VPos.TOP );
    grid.add( servicesPercent, 3, 2 );

    grid.setGridLinesVisible( true );
    return grid;
  }

  /**
   * Creates a horizontal flow pane with eight icons in four rows
   */
  private FlowPane addFlowPane() {

    FlowPane flow = new FlowPane();
    flow.setPadding( new Insets( 5, 0, 5, 0 ) );
    flow.setVgap( 4 );
    flow.setHgap( 4 );
    flow.setPrefWrapLength( 170 ); // preferred width allows for two columns
    flow.setStyle( "-fx-background-color: DAE6F3;" );

    ImageView pages[] = new ImageView[ 8 ];
    for ( int i = 0; i < 8; i++ ) {
      pages[ i ] = new ImageView( new Image( LayoutDemo.class.getResourceAsStream( "graphics/chart_" + ( i + 1 ) + ".png" ) ) );
      flow.getChildren().add( pages[ i ] );
    }

    return flow;
  }

  /**
   * Creates a horizontal (default) tile pane with eight icons in four rows
   */
  private TilePane addTilePane() {

    TilePane tile = new TilePane();
    tile.setPadding( new Insets( 5, 0, 5, 0 ) );
    tile.setVgap( 4 );
    tile.setHgap( 4 );
    tile.setPrefColumns( 2 );
    tile.setStyle( "-fx-background-color: DAE6F3;" );

    ImageView pages[] = new ImageView[ 8 ];
    for ( int i = 0; i < 8; i++ ) {
      pages[ i ] = new ImageView( new Image( LayoutDemo.class.getResourceAsStream( "graphics/chart_" + ( i + 1 ) + ".png" ) ) );
      tile.getChildren().add( pages[ i ] );
    }

    return tile;
  }

  /**
   * Creates an anchor pane using the provided grid and an HBox with buttons
   * 
   * @param grid Grid to anchor to the top of the anchor pane
   */
  private AnchorPane addAnchorPane( GridPane grid ) {

    AnchorPane anchorpane = new AnchorPane();

    Button buttonSave = new Button( "Save" );
    Button buttonCancel = new Button( "Cancel" );

    HBox hb = new HBox();
    hb.setPadding( new Insets( 0, 10, 10, 10 ) );
    hb.setSpacing( 10 );
    hb.getChildren().addAll( buttonSave, buttonCancel );

    anchorpane.getChildren().addAll( grid, hb );
    // Anchor buttons to bottom right, anchor grid to top
    AnchorPane.setBottomAnchor( hb, 8.0 );
    AnchorPane.setRightAnchor( hb, 5.0 );
    AnchorPane.setTopAnchor( grid, 10.0 );

    return anchorpane;
  }
}
