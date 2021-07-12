package day9.p3.chat.view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class StatusBar extends HBox {

  private Text statusText;

  public StatusBar() {
    super( 5 );
    this.setPadding( new Insets( 2, 2, 2, 2 ) );
    Label statusLabel = new Label( "Status:" );
    this.statusText = new Text( "" );
    this.getChildren().addAll( statusLabel, this.statusText );
    this.setBorder( //
            new Border( //
                    new BorderStroke( //
                            Color.LIGHTGRAY, //
                            BorderStrokeStyle.SOLID, //
                            CornerRadii.EMPTY, //
                            BorderWidths.DEFAULT//
                    )//
            )//
    );
  }

  public void setStatus( String status ) {
    this.statusText.setText( status );
  }
}
