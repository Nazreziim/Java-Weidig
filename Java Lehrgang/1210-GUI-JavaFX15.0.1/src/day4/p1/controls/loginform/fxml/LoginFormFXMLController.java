package day4.p1.controls.loginform.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class LoginFormFXMLController {
  // This annotation marks a protected or private class member as accessible to FXML.
  // So either leave everything public or use the annotation.
  @FXML
  private Text actiontarget;

  @FXML
  protected void handleSubmitButtonAction( ActionEvent event ) {
    actiontarget.setText( "Sign in button pressed" );
  }

}
