package _006Controls.views;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class _05ChartsAllgemein extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FlowPane pane = new FlowPane();

		// PieChart
		pane.getChildren().add(piechart());

		// AreaChart
		pane.getChildren().add(areachart());

		// StackedAreaChart
		pane.getChildren().add(stackedareachart());

		// BubbleChart
		pane.getChildren().add(bubblechart());

		// ScatterChart
		pane.getChildren().add(scatterchart());

		// LineChart
		pane.getChildren().add(linechart());

		// BarChart
		pane.getChildren().add(barchart());

		// StackedBarChart
		pane.getChildren().add(stackedbarchart());

		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private Node stackedbarchart() {
		// Chart an sich
		CategoryAxis xAchse = new CategoryAxis();
		xAchse.setLabel("Wert1");

		NumberAxis yAchse = new NumberAxis();
		yAchse.setLabel("Wert2");

		StackedBarChart<String, Number> chart = new StackedBarChart<>(xAchse, yAchse);
		chart.setTitle("Ein BarChart");
		// Chart an sich

		// Alles was für die ersten Daten wichtig ist
		Data<String, Number> data1 = new Data<>("Montag", 20);
		Data<String, Number> data2 = new Data<>("Dienstag", 28);
		Data<String, Number> data3 = new Data<>("Mittwoch", 50);
		Data<String, Number> data4 = new Data<>("Donnerstag", 66);
		Data<String, Number> data5 = new Data<>("Freitag", 2);

		Series<String, Number> xyDaten = new Series<>();
		xyDaten.getData().addAll(data1, data2, data3, data4, data5);
		xyDaten.setName("Die ersten Daten");
		// Alles was für die ersten Daten wichtig ist

		// Alles was für Die zweiten Daten wichtig ist
		Data<String, Number> data12 = new Data<>("Montag", 5);
		Data<String, Number> data22 = new Data<>("Mittwoch", 14);
		Data<String, Number> data32 = new Data<>("Freitag", 4);
		Data<String, Number> data42 = new Data<>("Samstag", 66);
		Data<String, Number> data52 = new Data<>("Sonntag", 4);

		Series<String, Number> xyDaten2 = new Series<>();
		xyDaten2.getData().addAll(data12, data22, data32, data42, data52);
		xyDaten2.setName("Die zweiten Daten");
		// Alles was für Die zweiten Daten wichtig ist

		chart.getData().addAll(xyDaten, xyDaten2);
		return chart;
	}

	private Node barchart() {
		// Chart an sich
		CategoryAxis xAchse = new CategoryAxis();
		xAchse.setLabel("Wert1");

		NumberAxis yAchse = new NumberAxis();
		yAchse.setLabel("Wert2");

		BarChart<String, Number> chart = new BarChart<>(xAchse, yAchse);
		chart.setTitle("Ein BarChart");
		// Chart an sich

		// Alles was für die ersten Daten wichtig ist
		Data<String, Number> data1 = new Data<>("Montag", 20);
		Data<String, Number> data2 = new Data<>("Dienstag", 28);
		Data<String, Number> data3 = new Data<>("Mittwoch", 50);
		Data<String, Number> data4 = new Data<>("Donnerstag", 66);
		Data<String, Number> data5 = new Data<>("Freitag", 2);

		Series<String, Number> xyDaten = new Series<>();
		xyDaten.getData().addAll(data1, data2, data3, data4, data5);
		xyDaten.setName("Die ersten Daten");
		// Alles was für die ersten Daten wichtig ist

		// Alles was für Die zweiten Daten wichtig ist
		Data<String, Number> data12 = new Data<>("Montag", 5);
		Data<String, Number> data22 = new Data<>("Mittwoch", 14);
		Data<String, Number> data32 = new Data<>("Freitag", 4);
		Data<String, Number> data42 = new Data<>("Samstag", 66);
		Data<String, Number> data52 = new Data<>("Sonntag", 4);

		Series<String, Number> xyDaten2 = new Series<>();
		xyDaten2.getData().addAll(data12, data22, data32, data42, data52);
		xyDaten2.setName("Die zweiten Daten");
		// Alles was für Die zweiten Daten wichtig ist

		chart.getData().addAll(xyDaten, xyDaten2);
		return chart;
	}

	private Node linechart() {
		// Chart an sich
		NumberAxis xAchse = new NumberAxis();
		xAchse.setLabel("Wert1");

		NumberAxis yAchse = new NumberAxis();
		yAchse.setLabel("Wert2");

		LineChart<Number, Number> chart = new LineChart<>(xAchse, yAchse);
		chart.setTitle("Ein LineChart");
		// Chart an sich

		// Alles was für die ersten Daten wichtig ist
		Data<Number, Number> data1 = new Data<>(10, 20);
		Data<Number, Number> data2 = new Data<>(2, 28);
		Data<Number, Number> data3 = new Data<>(14, 50);
		Data<Number, Number> data4 = new Data<>(25, 66);
		Data<Number, Number> data5 = new Data<>(55, 2);

		Series<Number, Number> xyDaten = new Series<>();
		xyDaten.getData().addAll(data1, data2, data3, data4, data5);
		xyDaten.setName("Die ersten Daten");
		// Alles was für die ersten Daten wichtig ist

		// Alles was für Die zweiten Daten wichtig ist
		Data<Number, Number> data12 = new Data<>(5, 5);
		Data<Number, Number> data22 = new Data<>(2, 14);
		Data<Number, Number> data32 = new Data<>(55, 4);
		Data<Number, Number> data42 = new Data<>(40, 66);
		Data<Number, Number> data52 = new Data<>(22, 4);

		Series<Number, Number> xyDaten2 = new Series<>();
		xyDaten2.getData().addAll(data12, data22, data32, data42, data52);
		xyDaten2.setName("Die zweiten Daten");
		// Alles was für Die zweiten Daten wichtig ist

		chart.getData().addAll(xyDaten, xyDaten2);
		
		//Zusatzoption - LINECHART
		chart.setCreateSymbols(false);

		return chart;
	}

	private Node scatterchart() {
		// Chart an sich
		NumberAxis xAchse = new NumberAxis();
		xAchse.setLabel("Wert1");

		NumberAxis yAchse = new NumberAxis();
		yAchse.setLabel("Wert2");

		ScatterChart<Number, Number> chart = new ScatterChart<>(xAchse, yAchse);
		chart.setTitle("Ein ScatterChart");
		// Chart an sich

		// Alles was für die ersten Daten wichtig ist
		Data<Number, Number> data1 = new Data<>(10, 20);
		Data<Number, Number> data2 = new Data<>(2, 28);
		Data<Number, Number> data3 = new Data<>(14, 50);
		Data<Number, Number> data4 = new Data<>(25, 66);
		Data<Number, Number> data5 = new Data<>(55, 2);

		Series<Number, Number> xyDaten = new Series<>();
		xyDaten.getData().addAll(data1, data2, data3, data4, data5);
		xyDaten.setName("Die ersten Daten");
		// Alles was für die ersten Daten wichtig ist

		// Alles was für Die zweiten Daten wichtig ist
		Data<Number, Number> data12 = new Data<>(5, 5);
		Data<Number, Number> data22 = new Data<>(2, 14);
		Data<Number, Number> data32 = new Data<>(55, 4);
		Data<Number, Number> data42 = new Data<>(40, 66);
		Data<Number, Number> data52 = new Data<>(22, 4);

		Series<Number, Number> xyDaten2 = new Series<>();
		xyDaten2.getData().addAll(data12, data22, data32, data42, data52);
		xyDaten2.setName("Die zweiten Daten");
		// Alles was für Die zweiten Daten wichtig ist

		chart.getData().addAll(xyDaten, xyDaten2);

		return chart;
	}

	private Node bubblechart() {
		// Chart an sich
		NumberAxis xAchse = new NumberAxis();
		xAchse.setLabel("Wert1");

		NumberAxis yAchse = new NumberAxis();
		yAchse.setLabel("Wert2");

		BubbleChart<Number, Number> chart = new BubbleChart<>(xAchse, yAchse);
		chart.setTitle("Ein BubbleChart");
		// Chart an sich

		// Alles was für die ersten Daten wichtig ist
		
		// Der 3. Parameter wird nur in Spezialfällen wie BubbleChart gewertet
		// --> 3. Param entspricht % von 0 bis 10 [0% bis 100%] --> wert > 10 entspricht
		// also über 100%
		
		Data<Number, Number> data1 = new Data<>(10, 20, 5); 
		Data<Number, Number> data2 = new Data<>(2, 28, 9);
		Data<Number, Number> data3 = new Data<>(14, 50, 5);
		Data<Number, Number> data4 = new Data<>(25, 66, 2);
		Data<Number, Number> data5 = new Data<>(55, 2, 8);

		Series<Number, Number> xyDaten = new Series<>();
		xyDaten.getData().addAll(data1, data2, data3, data4, data5);
		xyDaten.setName("Die ersten Daten");
		// Alles was für die ersten Daten wichtig ist

		// Alles was für Die zweiten Daten wichtig ist
		Data<Number, Number> data12 = new Data<>(5, 5, 5);
		Data<Number, Number> data22 = new Data<>(2, 14, 6);
		Data<Number, Number> data32 = new Data<>(55, 4, 8);
		Data<Number, Number> data42 = new Data<>(40, 66, 7);
		Data<Number, Number> data52 = new Data<>(22, 4, 9);

		Series<Number, Number> xyDaten2 = new Series<>();
		xyDaten2.getData().addAll(data12, data22, data32, data42, data52);
		xyDaten2.setName("Die zweiten Daten");
		// Alles was für Die zweiten Daten wichtig ist

		chart.getData().addAll(xyDaten, xyDaten2);
		
		
		//Zusatzoptionen - ACHSEN
		xAchse.setTickLabelFill(Color.RED);
		yAchse.setTickLabelFill(Color.CHOCOLATE);
		xAchse.setSide(Side.TOP);
		xAchse.setTickLabelRotation(45);
		
		//Zusatzoptionen - CHART SELBST
		chart.setVerticalGridLinesVisible(false);
		chart.setVerticalZeroLineVisible(false);

		return chart;
	}

	private Node stackedareachart() {
		// Chart an sich
		NumberAxis xAchse = new NumberAxis();
		xAchse.setLabel("Wert1");

		NumberAxis yAchse = new NumberAxis();
		yAchse.setLabel("Wert2");

		StackedAreaChart<Number, Number> chart = new StackedAreaChart<>(xAchse, yAchse);
		chart.setTitle("Ein StackedAreaChart");
		// Chart an sich

		// Alles was für die ersten Daten wichtig ist
		Data<Number, Number> data1 = new Data<>(10, 20);
		Data<Number, Number> data2 = new Data<>(2, 28);
		Data<Number, Number> data3 = new Data<>(14, 50);
		Data<Number, Number> data4 = new Data<>(25, 66);
		Data<Number, Number> data5 = new Data<>(55, 2);

		Series<Number, Number> xyDaten = new Series<>();
		xyDaten.getData().addAll(data1, data2, data3, data4, data5);
		xyDaten.setName("Die ersten Daten");
		// Alles was für die ersten Daten wichtig ist

		// Alles was für Die zweiten Daten wichtig ist
		Data<Number, Number> data12 = new Data<>(5, 5);
		Data<Number, Number> data22 = new Data<>(2, 14);
		Data<Number, Number> data32 = new Data<>(55, 4);
		Data<Number, Number> data42 = new Data<>(40, 66);
		Data<Number, Number> data52 = new Data<>(22, 4);

		Series<Number, Number> xyDaten2 = new Series<>();
		xyDaten2.getData().addAll(data12, data22, data32, data42, data52);
		xyDaten2.setName("Die zweiten Daten");
		// Alles was für Die zweiten Daten wichtig ist

		chart.getData().addAll(xyDaten, xyDaten2);

		return chart;
	}

	private Node areachart() {
		// Chart an sich
		NumberAxis xAchse = new NumberAxis();
		xAchse.setLabel("Wert1");

		NumberAxis yAchse = new NumberAxis();
		yAchse.setLabel("Wert2");

		AreaChart<Number, Number> chart = new AreaChart<>(xAchse, yAchse);
		chart.setTitle("Ein AreaChart");
		// Chart an sich

		// Alles was für die ersten Daten wichtig ist
		Data<Number, Number> data1 = new Data<>(10, 20);
		Data<Number, Number> data2 = new Data<>(2, 28);
		Data<Number, Number> data3 = new Data<>(14, 50);
		Data<Number, Number> data4 = new Data<>(25, 66);
		Data<Number, Number> data5 = new Data<>(55, 2);

		Series<Number, Number> xyDaten = new Series<>();
		xyDaten.getData().addAll(data1, data2, data3, data4, data5);
		xyDaten.setName("Die ersten Daten");
		// Alles was für die ersten Daten wichtig ist

		// Alles was für Die zweiten Daten wichtig ist
		Data<Number, Number> data12 = new Data<>(5, 5);
		Data<Number, Number> data22 = new Data<>(2, 14);
		Data<Number, Number> data32 = new Data<>(55, 4);
		Data<Number, Number> data42 = new Data<>(40, 66);
		Data<Number, Number> data52 = new Data<>(22, 4);

		Series<Number, Number> xyDaten2 = new Series<>();
		xyDaten2.getData().addAll(data12, data22, data32, data42, data52);
		xyDaten2.setName("Die zweiten Daten");
		// Alles was für Die zweiten Daten wichtig ist

		chart.getData().addAll(xyDaten, xyDaten2);

		return chart;
	}

	private Node piechart() {
		PieChart chart = new PieChart();

		PieChart.Data wert1 = new PieChart.Data("Wert1", 5);
		PieChart.Data wert2 = new PieChart.Data("Wert2", 55);
		PieChart.Data wert3 = new PieChart.Data("Wert3", 24.5);
		PieChart.Data wert4 = new PieChart.Data("Wert4", 77);

		ObservableList<PieChart.Data> obLi = FXCollections.observableArrayList();
		obLi.addAll(wert1, wert2, wert3, wert4);

		chart.setData(obLi);

		chart.setTitle("Ein PieChart");

		return chart;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
