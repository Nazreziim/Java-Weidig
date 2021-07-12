package day4.p3b.controls.loginform.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class LoginFormFXMLController {
  // This annotation marks a protected or private class member as accessible to FXML.
  // So either leave everything public or use the annotation.
  @FXML
  private Text actiontarget;

  @FXML
  private PasswordField passwordField;

  @FXML
  protected void handleSubmitButtonAction( ActionEvent event ) {
    if ( this.passwordField.getText().equals( "P@ssw0rd" ) ) {
      this.actiontarget.setFill( Color.GREEN );
      this.actiontarget.setText( "Password correct." );
    } else {
      this.actiontarget.setFill( Color.RED );
      this.actiontarget.setText( "Password NOT correct." );
    }
  }

}
