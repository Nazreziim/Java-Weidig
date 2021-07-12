package _08MVCBeispiele;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainController implements Initializable {
	@FXML
	private AnchorPane fxSpielfeld;
	@FXML
	private Pane fxStatus;
	@FXML
	private Label fxLifeLabel;
	@FXML
	private Label fxDmgLabel;
	@FXML
	private Button fxAngriffsButton;
	@FXML
	private MenuItem fxBildAendern;
	@FXML
	private MenuItem fxSpielBeenden;

	@FXML
	private ProgressBar fxProgressBar;

	private MonsterModel monster;

	private Statistik statistik = new Statistik();

	// Initialisieren des MediaPlayers
	private MediaPlayer hintergrundmusik = new MediaPlayer(
			new Media(new File("Weidig/_08MVCBeispiele/musik.mp3").toURI().toString()));
	
	private AudioClip shoot = new AudioClip(new File("Weidig/_08MVCBeispiele/swordSlash.mp3").toURI().toString());
	
	private AudioClip die = new AudioClip(new File("Weidig/_08MVCBeispiele/die.mp3").toURI().toString());
	
	private int clicks = 0;

	// Event Listener on Button[#fxAngriffsButton].onAction
	@FXML
	public void angriff(ActionEvent event) {
		int dmg = 5;
		this.monster.setLeben(this.monster.getLeben() - dmg);
		this.statistik.setVerursachterSchaden(this.statistik.getVerursachterSchaden() + dmg);
		shoot.play();
		clicks++;
	}

	// Event Listener on MenuItem[#fxBildAendern].onAction
	@FXML
	public void bildAendern(ActionEvent event) {
		FileChooser chooser = new FileChooser();
		File ausgewaehlteDatei = chooser.showOpenDialog(this.fxSpielfeld.getScene().getWindow());
		if (ausgewaehlteDatei != null) {
			Image bild = null;
			try {
				bild = new Image(ausgewaehlteDatei.toURI().toURL().toExternalForm());
				this.fxSpielfeld.setBackground(
						new Background(new BackgroundFill(new ImagePattern(bild), CornerRadii.EMPTY, Insets.EMPTY)));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	// Event Listener on Menu[#fxSpielBeenden].onAction
	@FXML
	public void spielBeenden(ActionEvent event) {
		Platform.exit();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initMonster();
		this.fxDmgLabel.textProperty().bind(statistik.getVerursachterSchadenProperty().asString());

	}

	public void gameRunning() {
		// Starte den Sound
		hintergrundmusik.play();
		initProgress();
		initDpsCounter();

	}
	
	public void initDpsCounter() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask()
		{
		        public void run()
		        {
		          statistik.getClicksInSecond().add(clicks);
		          clicks = 0;
		        }
		};
		
		timer.schedule(task, 0, 1000);
		
	}

	public void initProgress() {
		int zeitInSekunden = 20;
		this.statistik.setZeitinsgesamt(zeitInSekunden);
		Timeline timeline = new Timeline(
				// Startwert --> von 0 beginnend bezugnehmend auf die Progressbar
				new KeyFrame(Duration.ZERO, new KeyValue(this.fxProgressBar.progressProperty(), 0)),

				// Endwert mit Dauer bezugnehmend auf die Progressbar und der Value der am Ende
				// erreicht werden soll
				new KeyFrame(Duration.seconds(zeitInSekunden), event -> {
					spielBeendet();
				}, new KeyValue(this.fxProgressBar.progressProperty(), 1))

		);
		timeline.play();
		
		this.fxProgressBar.progressProperty().addListener(aktuellerWert -> {
			if (this.fxProgressBar.getProgress() > 0.75) {
				this.fxProgressBar.setStyle("-fx-accent: red");
			} else if (this.fxProgressBar.getProgress() > 0.5) {
				this.fxProgressBar.setStyle("-fx-accent: yellow");
			} else if (this.fxProgressBar.getProgress() > 0.25) {
				this.fxProgressBar.setStyle("-fx-accent: green");
			}

		});

	}

	public void spielBeendet() {
		// So erhalte ich mein Hauptfenster, dass zum AnchorPane dazugehört
		Stage mainStage = (Stage) this.fxSpielfeld.getScene().getWindow();

		// SZENENWECHSEL
		try {
			hintergrundmusik.stop();
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource("EndScreen.fxml"));
			Parent fxmlScene = loader.load();
			EndController controller = loader.getController();
			mainStage.setScene(new Scene(fxmlScene));
			
			controller.loadEnd(this.statistik);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void initMonster() {
		this.monster = new MonsterModel();
		this.fxSpielfeld.getChildren().add(monster);
		this.monster.getLebenProperty().addListener(vernichtet -> {
			if (this.monster.getLeben() <= 0) {
				this.die.play();
				this.fxSpielfeld.getChildren().remove(this.monster);
				initMonster();
				this.statistik.setBesiegteMonster(this.statistik.getBesiegteMonster() + 1);
			}
		});
		this.fxLifeLabel.textProperty().bind(monster.getLebenProperty().asString());
	}
}
