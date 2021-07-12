package day6.p2c.controls.charts;

/* ....Show License.... */
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * A chart that displays elliptical symbols indicating data values for x and y-coordinates. The
 * radius of each circle is modifiable to indicate a third dimension. Used for displaying
 * information when at least one axis has discontinuous or discrete data.
 */
public class BubbleChartDemo extends Application {

  private BubbleChart chart;
  private NumberAxis xAxis;
  private NumberAxis yAxis;

  @SuppressWarnings( "unchecked" )
  public Parent createContent() {
    int[] grades = { 1, 2, 3, 4, 5, 6 };
    xAxis = new NumberAxis();
    xAxis.setLabel( "Anzahl" );
    yAxis = new NumberAxis();
    yAxis.setLabel( "Anzahl LT mit ATN" );

    ObservableList< XYChart.Series > bubbleChartData = FXCollections.observableArrayList( //
            new XYChart.Series( "Java", //
                    FXCollections.observableArrayList( //
                            new XYChart.Data< Integer, Integer >( grades[ 0 ], 2, 0.1 ), //
                            new XYChart.Data< Integer, Integer >( grades[ 1 ], 4, 0.2 ), //
                            new XYChart.Data< Integer, Integer >( grades[ 2 ], 6, 0.3 ), //
                            new XYChart.Data< Integer, Integer >( grades[ 3 ], 5, 0.42 ), //
                            new XYChart.Data< Integer, Integer >( grades[ 4 ], 2, 0.5 ), //
                            new XYChart.Data< Integer, Integer >( grades[ 5 ], 1, 0.6 ) //
                    ) ), //
            new XYChart.Series( "Ada", //
                    FXCollections.observableArrayList( //
                            new XYChart.Data< Integer, Integer >( grades[ 0 ], 1, 0.1 ), //
                            new XYChart.Data< Integer, Integer >( grades[ 1 ], 3, 0.2 ), //
                            new XYChart.Data< Integer, Integer >( grades[ 2 ], 5, 0.3 ), //
                            new XYChart.Data< Integer, Integer >( grades[ 3 ], 1, 0.4 ), //
                            new XYChart.Data< Integer, Integer >( grades[ 4 ], 0, 0.5 ), //
                            new XYChart.Data< Integer, Integer >( grades[ 5 ], 2, 0.6 ) //
                    ) ), //
            new XYChart.Series( "C++", //
                    FXCollections.observableArrayList( //
                            new XYChart.Data< Integer, Integer >( grades[ 0 ], 0, 0.1 ), //
                            new XYChart.Data< Integer, Integer >( grades[ 1 ], 2, 0.1 ), //
                            new XYChart.Data< Integer, Integer >( grades[ 2 ], 3, 0.1 ), //
                            new XYChart.Data< Integer, Integer >( grades[ 3 ], 0, 0.1 ), //
                            new XYChart.Data< Integer, Integer >( grades[ 4 ], 0, 0.1 ), //
                            new XYChart.Data< Integer, Integer >( grades[ 5 ], 0, 0.1 ) //
                    ) ) //
    );

    chart = new BubbleChart( xAxis, yAxis, bubbleChartData );
    return chart;
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setScene( new Scene( createContent() ) );
    primaryStage.show();
  }

  /**
   * Java main for when running without JavaFX launcher
   */
  public static void main( String[] args ) {
    launch( args );
  }
}
