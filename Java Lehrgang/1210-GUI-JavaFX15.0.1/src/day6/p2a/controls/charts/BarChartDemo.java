package day6.p2a.controls.charts;

/* ....Show License.... */
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * A chart that displays rectangular bars with heights indicating data values for categories. Used
 * for displaying information when at least one axis has discontinuous or discrete data.
 */
public class BarChartDemo extends Application {

  private BarChart chart;
  private CategoryAxis xAxis;
  private NumberAxis yAxis;

  @SuppressWarnings( "unchecked" )
  public Parent createContent() {
    String[] years = { "2017", "2018", "2019" };
    xAxis = new CategoryAxis();
    xAxis.setLabel( "Jahre" );
    xAxis.setCategories( FXCollections.< String >observableArrayList( years ) );
    yAxis = new NumberAxis();
    yAxis.setLabel( "Anzahl LT mit ATN" );

    ObservableList< XYChart.Series > barChartData = FXCollections.observableArrayList( //
            new XYChart.Series( "Java", //
                    FXCollections.observableArrayList( //
                            new XYChart.Data< String, Integer >( years[ 0 ], 4 ), //
                            new XYChart.Data< String, Integer >( years[ 1 ], 12 ), //
                            new XYChart.Data< String, Integer >( years[ 2 ], 5 ) //
                    ) ), //
            new XYChart.Series( "Ada", //
                    FXCollections.observableArrayList( //
                            new XYChart.Data< String, Integer >( years[ 0 ], 19 ), //
                            new XYChart.Data< String, Integer >( years[ 1 ], 17 ), //
                            new XYChart.Data< String, Integer >( years[ 2 ], 23 ) //
                    ) ), //
            new XYChart.Series( "C++", //
                    FXCollections.observableArrayList( //
                            new XYChart.Data< String, Integer >( years[ 0 ], 3 ), //
                            new XYChart.Data< String, Integer >( years[ 1 ], 4 ), //
                            new XYChart.Data< String, Integer >( years[ 2 ], 2 ) //
                    ) )//
    );

    chart = new BarChart( xAxis, yAxis, barChartData, 25.0d );
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
