package unterricht.controls.loginform.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class LoginFormButtonHandler {

  @FXML
  private Text actiontarget;

  @FXML
  void doSomething( ActionEvent ev ) {
    actiontarget.setText( "Sign in button pressed" );
  }

}
