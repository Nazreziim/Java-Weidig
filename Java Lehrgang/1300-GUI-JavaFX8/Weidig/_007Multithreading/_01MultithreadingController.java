package _007Multithreading;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class _01MultithreadingController {
	@FXML
	private Label fxButtonLabel;
	@FXML
	private Label fxThreadLabel;

	// Event Listener on Button[#fxButton].onAction
	@FXML
	public void buttonKlick(ActionEvent event) {
		this.fxButtonLabel.setText(String.valueOf(Integer.valueOf(this.fxButtonLabel.getText()) +1));
	}

	public Label getFxButtonLabel() {
		return fxButtonLabel;
	}

	public void setFxButtonLabel(Label fxButtonLabel) {
		this.fxButtonLabel = fxButtonLabel;
	}

	public Label getFxThreadLabel() {
		return fxThreadLabel;
	}

	public void setFxThreadLabel(Label fxThreadLabel) {
		this.fxThreadLabel = fxThreadLabel;
	}
	
	
}
