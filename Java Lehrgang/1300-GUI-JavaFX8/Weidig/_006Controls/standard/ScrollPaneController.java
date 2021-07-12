package _006Controls.standard;

import javafx.fxml.FXML;

import javafx.scene.control.Separator;

import javafx.scene.control.TextField;

import javafx.scene.control.ScrollPane;
import javafx.scene.Cursor;
import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class ScrollPaneController {
	@FXML
	private ScrollPane fxScrollPane;
	@FXML
	private Pane fxPane;
	@FXML
	private Label fxLabel;
	@FXML
	private TextField fxPromptText;
	@FXML
	private TextField fxTextFeld;
	@FXML
	private Separator fxSeperatorHorizotal;
	@FXML
	private Separator fxSeperatorVertical;
	
	private String text = "";
	// Event Listener on Label[#fxLabel].onMouseClicked
	
	 @FXML
	 void labelAus(MouseEvent event) {
		 	fxLabel.setVisible(false);
		 	text = fxLabel.getText();			// Fuer die Uebergabe an das Textfeld
			fxLabel.setText("Moin");
			fxLabel.setUnderline(false);
			fxLabel.setCursor(Cursor.HAND);
	 
	 }
	@FXML
	 void labelAn(MouseEvent event) {
		 fxLabel.setVisible(true);
	    }

	// Textfeld
	 @FXML
	    void textEin(MouseEvent event) {
		 fxPromptText.setText(text);
		 System.out.println(text);
	    }
	 
	 @FXML
	    void leeren(MouseEvent event) {
		fxTextFeld.clear();
		fxTextFeld.setTranslateX(250);
		System.out.println("ID. " +fxTextFeld.getId());
		System.out.println("Tooltip: " +fxTextFeld.getTooltip());
	    }
	 
	 // Pane
	   @FXML
	    void hintergrundschieben(ScrollEvent event) {
		   fxPane.setStyle("-fx-background-color: red");
	    }
	   
	   @FXML
	    void clearAll(KeyEvent event) {
		   fxPane.setStyle("-fx-background-color: blue");
		   System.out.println("Test");
	    }

}