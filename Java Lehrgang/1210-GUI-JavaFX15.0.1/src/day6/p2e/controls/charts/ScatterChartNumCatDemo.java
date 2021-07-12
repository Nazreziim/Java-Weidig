package day6.p2e.controls.charts;

/* ....Show License.... */
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * A chart that displays information 2-dimensional with symbols indicating data values for
 * categories for every series. Used for displaying information of numerical and or categorial
 * scales.
 */
public class ScatterChartNumCatDemo extends Application {

  private ScatterChart chart;
  private CategoryAxis xAxis;
  private NumberAxis yAxis;

  @SuppressWarnings( "unchecked" )
  public Parent createContent() {
    String[] grades = { "1", "2", "3", "4", "5", "6" };
    xAxis = new CategoryAxis();
    xAxis.setLabel( "Noten" );
    yAxis = new NumberAxis();
    yAxis.setLabel( "Anzahl" );

    ObservableList< XYChart.Series > scatterChartData = FXCollections.observableArrayList( //
            new XYChart.Series( "Java", //
                    FXCollections.observableArrayList( //
                            new XYChart.Data< String, Integer >( grades[ 0 ], 2 ), //
                            new XYChart.Data< String, Integer >( grades[ 1 ], 4 ), //
                            new XYChart.Data< String, Integer >( grades[ 2 ], 6 ), //
                            new XYChart.Data< String, Integer >( grades[ 3 ], 5 ), //
                            new XYChart.Data< String, Integer >( grades[ 4 ], 2 ), //
                            new XYChart.Data< String, Integer >( grades[ 5 ], 1 ) //
                    ) ), //
            new XYChart.Series( "Ada", //
                    FXCollections.observableArrayList( //
                            new XYChart.Data< String, Integer >( grades[ 0 ], 1 ), //
                            new XYChart.Data< String, Integer >( grades[ 1 ], 3 ), //
                            new XYChart.Data< String, Integer >( grades[ 2 ], 5 ), //
                            new XYChart.Data< String, Integer >( grades[ 3 ], 1 ), //
                            new XYChart.Data< String, Integer >( grades[ 4 ], 0 ), //
                            new XYChart.Data< String, Integer >( grades[ 5 ], 2 ) //
                    ) ), //
            new XYChart.Series( "C++", //
                    FXCollections.observableArrayList( //
                            new XYChart.Data< String, Integer >( grades[ 0 ], 0 ), //
                            new XYChart.Data< String, Integer >( grades[ 1 ], 2 ), //
                            new XYChart.Data< String, Integer >( grades[ 2 ], 3 ), //
                            new XYChart.Data< String, Integer >( grades[ 3 ], 0 ), //
                            new XYChart.Data< String, Integer >( grades[ 4 ], 0 ), //
                            new XYChart.Data< String, Integer >( grades[ 5 ], 0 ) //
                    ) ) //
    );

    chart = new ScatterChart( xAxis, yAxis, scatterChartData );
    // chart.setAnimated( true ); // The Charts are animated by default

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
