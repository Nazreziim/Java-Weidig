package _006Controls.views;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.converter.NumberStringConverter;

public class _06ChartsAusViews extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// DESIGN
		HBox hbox = new HBox();

		TableView<WochenWerte> bilanz = new TableView<>();
		// Sorgt dafür, dass sich die View automatisch an das daraufliegende Element hin
		// verändert
		bilanz.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		bilanz.setEditable(true);

		CategoryAxis xAchse = new CategoryAxis();
		xAchse.setLabel("Tag");
		xAchse.setAnimated(false);

		NumberAxis yAchse = new NumberAxis();
		yAchse.setLabel("Wert");
		yAchse.setMaxHeight(0);

		BarChart<String, Number> chart = new BarChart<>(xAchse, yAchse);
		chart.setMaxHeight(0);
		chart.setOpacity(0.0);

		hbox.getChildren().addAll(bilanz, chart);
		Scene scene = new Scene(hbox);
		primaryStage.setScene(scene);
		primaryStage.show();
		// DESIGN

		WochenWerte montag = new WochenWerte("Montag", 50.0);
		WochenWerte dienstag = new WochenWerte("Dienstag", 60.0);
		WochenWerte mittwoch = new WochenWerte("Mittwoch", 5.0);
		WochenWerte donnerstag = new WochenWerte("Donnerstag", 44.0);
		WochenWerte freitag = new WochenWerte("Freitag", 28.0);
		WochenWerte samstag = new WochenWerte("Samstag", 12.0);
		WochenWerte sonntag = new WochenWerte("Sonntag", 99.0);

		ObservableList<WochenWerte> obLi = FXCollections.observableArrayList();
		obLi.addAll(montag, dienstag, mittwoch, donnerstag, freitag, samstag, sonntag);

		TableColumn<WochenWerte, String> tag = new TableColumn<>("Tag");
		// In Data.class schauen. Dann sieht man, dass xValue vorhanden ist und somit
		// gefunden werden kann.
//		tag.setCellValueFactory(new PropertyValueFactory<>("xValue")); // bzw. YValue
		tag.setCellValueFactory(zellWert -> zellWert.getValue().getTag());
		tag.setCellFactory(TextFieldTableCell.forTableColumn());

		TableColumn<WochenWerte, Number> wert = new TableColumn<>("Wert");
		wert.setCellValueFactory(zellWert -> zellWert.getValue().getWert());
		wert.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));

		Series<String, Number> xyDaten = new Series<>();

		for (WochenWerte einTag : obLi) {
			Data<String, Number> data = new Data<>();
			// BindBiDirectional ist wichtig um den gebindeten Wert auch im Nachhinein
			// änderbar zu machen bzw. setzen zu können
			data.XValueProperty().bindBidirectional(einTag.getTag());
			data.YValueProperty().bindBidirectional(einTag.getWert());
			xyDaten.getData().add(data);

		}

		// Animationsextra - SPIELEREI
		Timeline tl = new Timeline();

		// ACHTUNG: Damit ich die ForEach hierin nutzen kann muss es in einer Anonymen
		// Klasse sein
		tl.getKeyFrames().add(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				if (chart.getMaxHeight() < hbox.getHeight()) {
					chart.setMaxHeight(chart.getMaxHeight() + 1);
					if (chart.getMaxHeight() > hbox.getHeight() / 2) {
						chart.setOpacity(chart.getOpacity() + 0.01);
					}

				}

			}
		}));
		tl.setCycleCount(Animation.INDEFINITE);
		tl.setAutoReverse(true);
		tl.play();

		bilanz.getColumns().addAll(tag, wert);
		bilanz.getItems().addAll(obLi);
		chart.getData().add(xyDaten);

	}

	public static void main(String[] args) {
		launch(args);

	}

}
