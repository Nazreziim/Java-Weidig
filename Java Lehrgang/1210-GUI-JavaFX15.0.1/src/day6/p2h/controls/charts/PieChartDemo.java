package day6.p2h.controls.charts;

/* ....Show License.... */
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

/**
 * A chart that displays circular pie-slices with angels indicating data values for categories. Used
 * for displaying relational differences in numerical values.
 */
public class PieChartDemo extends Application {

  private PieChart chart;

  public Parent createContent() {
    String[] lang = { "Ada", "Java", "C++" };

    ObservableList< PieChart.Data > pieChartData = FXCollections.observableArrayList( //
            new PieChart.Data( lang[ 0 ], 21 ), //
            new PieChart.Data( lang[ 1 ], 59 ), //
            new PieChart.Data( lang[ 2 ], 9 ) //
    );

    chart = new PieChart( pieChartData );
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
