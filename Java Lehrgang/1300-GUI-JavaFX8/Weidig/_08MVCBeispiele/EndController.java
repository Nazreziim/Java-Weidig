package _08MVCBeispiele;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.control.Alert.AlertType;

public class EndController {
	@FXML
	private LineChart fxLineChart;
	@FXML
	private NumberAxis fxZeitAchse;
	@FXML
	private NumberAxis fxDmgAchse;
	@FXML
	private Button fxEndeButton;
	@FXML
	private ListView<String> fxStatistik;

	private Statistik statistik;

	// Event Listener on Button[#fxEndeButton].onAction
	@FXML
	public void spielBeenden(ActionEvent event) {
		endMessage();
	}

	private void endMessage() {
		WritableImage screenshot = this.fxStatistik.getScene().snapshot(null);
		//Temporäre Bilddatei (leer) erstellen die später überschrieben wird
		File speicherOrt = new File("Weidig/_08MVCBeispiele/statistik.png");
		try {
			if(speicherOrt.exists()) {
				speicherOrt.delete();
			} else {
				speicherOrt.createNewFile();
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setAlertType(AlertType.CONFIRMATION);

		// Zusätzliche Eigenschaften
		alert.setTitle("SpielEnde");
		alert.setHeaderText("Möchten sie ihre Statistik speichern?");

		// Return von showAndWait beachten
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			
			PixelReader pixelBild = screenshot.getPixelReader();
			WritableImage fertigesBild = new WritableImage(pixelBild, (int) screenshot.getWidth(),
					(int) screenshot.getHeight());

			try {
				ImageIO.write(SwingFXUtils.fromFXImage(fertigesBild, null), "png", speicherOrt);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.exit(0);
		} else if (result.get() == ButtonType.CANCEL) {
			speicherOrt.delete();
			System.exit(0);
		}

	}

	public void loadEnd(Statistik statistik) {
		this.statistik = statistik;
		loadStatistik();
	}

	public void loadStatistik() {
		fxZeitAchse.setAutoRanging(false);
		fxZeitAchse.setLowerBound(1);
		fxZeitAchse.setUpperBound(this.statistik.getZeitinsgesamt());
		fxZeitAchse.setTickUnit(1.0);

		fxStatistik.getItems().add("Getötete Monster: " + statistik.getBesiegteMonster());
		fxStatistik.getItems().add("Verursachter Schaden: " + statistik.getVerursachterSchaden());
		fxStatistik.getItems().add("Benötigte Zeit (In Sekunden): " + statistik.getZeitinsgesamt());
		// Das erste Entfernen, da der erste Wert beim ersten Mal run immer 0 ist
		Series<Number, Number> werte = new Series<>();
		werte.setName("DPS");
		for (int i = 1; i < this.statistik.getClicksInSecond().size(); i++) {
			werte.getData().add(new Data<Number, Number>(i, this.statistik.getClicksInSecond().get(i)));
		}

		fxLineChart.getData().add(werte);
	}

}
