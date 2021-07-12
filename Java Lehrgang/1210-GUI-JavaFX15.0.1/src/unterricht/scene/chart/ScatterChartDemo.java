package unterricht.scene.chart;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ScatterChartDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setScene( new Scene( createContent() ) );
    primaryStage.setTitle( "ScatterChartDemo" );
    primaryStage.show();
  }

  private Parent createContent() {
    String[] noten = new String[]{ "1", "2", "3", "4", "5", "6" };
    CategoryAxis xAxis = new CategoryAxis( FXCollections.observableArrayList( noten ) );
    xAxis.setLabel( "Noten" );

    NumberAxis yAxis = new NumberAxis();
    yAxis.setLabel( "Anzahl" );

    ArrayList< XYChart.Data< String, Number > > listeJava = new ArrayList<>();
    listeJava.add( new XYChart.Data< String, Number >( noten[ 0 ], 2 ) );
    listeJava.add( new XYChart.Data< String, Number >( noten[ 1 ], 3 ) );
    listeJava.add( new XYChart.Data< String, Number >( noten[ 3 ], 6 ) );
    listeJava.add( new XYChart.Data< String, Number >( noten[ 2 ], 5 ) );
    listeJava.add( new XYChart.Data< String, Number >( noten[ 5 ], 1 ) );
    listeJava.add( new XYChart.Data< String, Number >( noten[ 4 ], 2 ) );
    ObservableList< XYChart.Data< String, Number > > listJava = FXCollections.observableList( listeJava );
    XYChart.Series< String, Number > serieJava = new XYChart.Series< String, Number >( "Java", listJava );

    ArrayList< XYChart.Data< String, Number > > listeAda = new ArrayList<>();
    listeAda.add( new XYChart.Data< String, Number >( noten[ 0 ], 1 ) );
    listeAda.add( new XYChart.Data< String, Number >( noten[ 1 ], 2 ) );
    listeAda.add( new XYChart.Data< String, Number >( noten[ 2 ], 4 ) );
    listeAda.add( new XYChart.Data< String, Number >( noten[ 3 ], 3 ) );
    listeAda.add( new XYChart.Data< String, Number >( noten[ 4 ], 1 ) );
    listeAda.add( new XYChart.Data< String, Number >( noten[ 5 ], 2 ) );
    ObservableList< XYChart.Data< String, Number > > listAda = FXCollections.observableList( listeAda );
    XYChart.Series< String, Number > serieAda = new XYChart.Series< String, Number >( "Ada", listAda );

    ArrayList< XYChart.Data< String, Number > > listeCpp = new ArrayList<>();
    listeCpp.add( new XYChart.Data< String, Number >( noten[ 0 ], 1 ) );
    listeCpp.add( new XYChart.Data< String, Number >( noten[ 1 ], 0 ) );
    listeCpp.add( new XYChart.Data< String, Number >( noten[ 2 ], 3 ) );
    listeCpp.add( new XYChart.Data< String, Number >( noten[ 3 ], 2 ) );
    listeCpp.add( new XYChart.Data< String, Number >( noten[ 4 ], 0 ) );
    listeCpp.add( new XYChart.Data< String, Number >( noten[ 5 ], 0 ) );
    ObservableList< XYChart.Data< String, Number > > listCpp = FXCollections.observableList( listeCpp );
    XYChart.Series< String, Number > serieCpp = new XYChart.Series< String, Number >( "C++", listCpp );

    ScatterChart< String, Number > chart = new ScatterChart< String, Number >( xAxis, yAxis );
    chart.getData().add( serieJava );
    chart.getData().add( serieAda );
    chart.getData().add( serieCpp );
    chart.setTitle( "Titel" );
    chart.setTitleSide( Side.BOTTOM );

    return chart;
  }

}
