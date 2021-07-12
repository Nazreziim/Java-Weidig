package unterricht.events.v2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class OwnEventHandler implements EventHandler< ActionEvent > {

  private Label lbl;

  public OwnEventHandler( Label lbl ) {
    this.lbl = lbl;
  }

  @Override
  public void handle( ActionEvent event ) {
    if ( event.getSource() instanceof Button ) {
      Button btn = (Button) event.getSource();
      btn.setText( btn.getText() + " Hallo" );
      lbl.setText( lbl.getText() + " Hi " );
    }

  }

}
