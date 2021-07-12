package _006Controls.standard;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WindowController implements Initializable {

	@FXML
	private Pane colorPickBg;
	@FXML
	private ColorPicker colorPick;
	@FXML
	private Pagination pageIn;
	@FXML
	private Spinner<Double> spinner;
	@FXML
	private ProgressIndicator progInd;
	@FXML
	private ProgressBar progBar;
	@FXML
	private Spinner<Integer> spinTestSpin;
	@FXML
	private Label lblSpin;
	@FXML
	private Spinner<String> spinListSpin;

	private ArrayList<String> spinList;

	private String[][] pages;

	private IntegerProperty spinnerTest;

	public WindowController() {
		pages = new String[3][2];
		pages[0][0] = "https://youtube.com";
		pages[0][1] = "Youtube";
		pages[1][0] = "https://www.google.de";
		pages[1][1] = "Google Suche";
		pages[2][0] = "https://www.isitchristmas.com/";
		pages[2][1] = "Ist es Weihnachten?";
		spinnerTest = new SimpleIntegerProperty(0);
		spinList = new ArrayList<String>();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// ---------------COLORPICKER------------------------------------------------------------------------
		colorPick.setOnAction(event -> colorPickBg
				.setBackground(new Background(new BackgroundFill(colorPick.getValue(), null, null)))); // Setze den
																										// Hintergrund
																										// auf die
																										// Farbe, die in
																										// colorPick ist
		// ---------------PAGINATION------------------------------------------------------------------------
		pageIn.setPageFactory((pageIndex) -> { // Eine pageFactory legt fest, wie/was die Pages darstellen. ohne diese
												// geht es nicht
			Label label1 = new Label("Lesezeichen " + (1 + pageIndex));

			Hyperlink hyp = new Hyperlink(pages[pageIndex][1]); // Ein Hyperlink ist dem Button ähnlich

			hyp.setOnAction(event -> {
				newWebViewWindow(pages[pageIndex][0]).show();// Simuliere das öffnen eines links
				System.out.println("Gehe zu " + pages[pageIndex][0]);
			});

			return new VBox(label1, hyp);
		});
		// ---------------SPINNER----------------------------------------------------------------------------
		// ListSpinne
		spinList.add("Hund");
		spinList.add("Katze");
		spinList.add("Maus");
		spinList.add("Hamster");
		spinList.add("Vogel");
		spinList.add("Ratte");

		ObservableList<String> observableList = FXCollections.observableList(spinList); // Umwandeln in Observable List
		observableList.addListener(new ListChangeListener<Object>() {
			@SuppressWarnings("rawtypes")
			@Override
			public void onChanged(ListChangeListener.Change change) {

				System.out.println("Detected a change! ");
			}
		});

		spinListSpin.setValueFactory(new ListSpinnerValueFactory<String>(observableList)); // ListSpinnerValueFactory
																							// mit werten der
																							// gewandelten liste

		// IntegerSpinner mit Variable
		SpinnerValueFactory<Integer> test1 = new SpinnerValueFactory<Integer>() { // Ändern einer Variable mit Spinner
			@Override
			public void increment(int steps) {
				spinnerTest.setValue(spinnerTest.get() + steps);
				this.setValue(spinnerTest.get());

			}

			@Override
			public void decrement(int steps) {
				spinnerTest.setValue(spinnerTest.get() - steps);
				this.setValue(spinnerTest.get());
			}
		};

		spinTestSpin.setValueFactory(test1);
		spinnerTest.addListener(listener -> lblSpin.setText("" + spinnerTest.get()));
		lblSpin.setText("" + spinnerTest.get());
		spinTestSpin.getValueFactory().setValue(spinnerTest.get());

		// ----------------PROGRESS---------------------------------------------------------------------------
		spinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(-1, 1, 0.1, 0.1)); // Die valuefactory
																										// "betreibt"
																										// den spinner
		progBar.progressProperty().bind(spinner.getValueFactory().valueProperty());
		progInd.progressProperty().bind(spinner.getValueFactory().valueProperty());
	}

	public Stage newWebViewWindow(String uri) {
		Pane pan = new Pane();
		WebView wbV = new WebView();
		wbV.getEngine().load(uri);

		pan.getChildren().add(wbV);

		Scene sc = new Scene(pan);
		Stage st = new Stage();
		st.setScene(sc);
		return st;
	}
}
