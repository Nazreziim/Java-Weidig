package oracletut.step4loginfxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class LoginFXMLController {
  @FXML
  private Text actionTarget;

  @FXML
  protected void handleSubmitButtonAction( ActionEvent event ) {
    actionTarget.setText( "Sign in button pressed" );
  }
}
