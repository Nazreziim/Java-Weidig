package day9.p3.chat.view;

import day9.p3.chat.view.model.User;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Callback;

public class ChatTab extends Tab {

  private ObservableList< User > clientList;

  public ChatTab( String serverName ) {
    super( serverName );

    ListView< User > clientListView = new ListView<>();
    clientListView.setCellFactory( new Callback< ListView< User >, ListCell< User > >() {
      @Override
      public ListCell< User > call( ListView< User > param ) {
        ListCell< User > cell = new ListCell< User >() {

          @Override
          protected void updateItem( User client, boolean empty ) {
            super.updateItem( client, empty );
            if ( empty || client == null ) {
              this.setText( null );
              this.setGraphic( null );
            } else {
              String role = null;
              Font defaultFont = this.getFont();
              switch ( client.getRole() ) {
                case ADMINISTRATOR :
                  role = "A - ";
                  this.setTextFill( Color.RED );
                  this.setFont( Font.font( defaultFont.getFamily(), FontWeight.BOLD, defaultFont.getSize() ) );
                  break;
                case MODERATOR :
                  role = "M - ";
                  this.setFont( Font.font( defaultFont.getFamily(), FontWeight.BOLD, defaultFont.getSize() ) );
                  break;
                default :
                  role = "U - ";
              }
              this.setText( role + client.getName() );
            }
          };
        };
        cell.prefWidthProperty().bind( clientListView.prefWidthProperty().subtract( 4 ) );
        return cell;
      }
    } );
    this.clientList = clientListView.getItems();

    AnchorPane clientListViewBox = new AnchorPane();
    Label userLabel = new Label( "Nutzer" );
    userLabel.setFont( Font.font( userLabel.getFont().getFamily(), FontWeight.BOLD, userLabel.getFont().getSize() ) );
    clientListViewBox.getChildren().add( clientListView );
    AnchorPane.setTopAnchor( clientListView, 0.0 );
    AnchorPane.setBottomAnchor( clientListView, 0.0 );
    AnchorPane.setLeftAnchor( clientListView, 0.0 );
    AnchorPane.setRightAnchor( clientListView, 0.0 );

    VBox clientListViewVBox = new VBox( 5, userLabel, clientListViewBox );
    clientListViewVBox.setPadding( new Insets( 5 ) );
    VBox.setVgrow( clientListViewBox, Priority.ALWAYS );
    clientListViewVBox.setAlignment( Pos.CENTER );

    Button sendenButton = new Button( "Senden" );
    sendenButton.setMinWidth( Button.USE_PREF_SIZE );
    sendenButton.setMinHeight( Button.USE_PREF_SIZE );
    sendenButton.setMaxHeight( Button.USE_PREF_SIZE );
    AnchorPane sendenButtonBox = new AnchorPane();
    sendenButtonBox.setPadding( new Insets( 5 ) );
    sendenButtonBox.getChildren().add( sendenButton );
    AnchorPane.setTopAnchor( sendenButton, 0.0 );
    AnchorPane.setBottomAnchor( sendenButton, 0.0 );
    AnchorPane.setLeftAnchor( sendenButton, 0.0 );
    AnchorPane.setRightAnchor( sendenButton, 0.0 );

    TextArea verlaufTextArea = new TextArea();
    verlaufTextArea.setPrefColumnCount( 1 );
    verlaufTextArea.setEditable( false );

    AnchorPane verlaufTextAreaBox = new AnchorPane();
    verlaufTextAreaBox.setPadding( new Insets( 5 ) );
    verlaufTextAreaBox.getChildren().add( verlaufTextArea );
    AnchorPane.setTopAnchor( verlaufTextArea, 0.0 );
    AnchorPane.setBottomAnchor( verlaufTextArea, 0.0 );
    AnchorPane.setLeftAnchor( verlaufTextArea, 0.0 );
    AnchorPane.setRightAnchor( verlaufTextArea, 0.0 );

    TextArea neueNachrichtTextArea = new TextArea();
    neueNachrichtTextArea.setPrefColumnCount( 1 );
    AnchorPane neueNachrichtTextAreaBox = new AnchorPane();
    neueNachrichtTextAreaBox.setPadding( new Insets( 5 ) );
    neueNachrichtTextAreaBox.getChildren().add( neueNachrichtTextArea );
    AnchorPane.setTopAnchor( neueNachrichtTextArea, 0.0 );
    AnchorPane.setBottomAnchor( neueNachrichtTextArea, 0.0 );
    AnchorPane.setLeftAnchor( neueNachrichtTextArea, 0.0 );
    AnchorPane.setRightAnchor( neueNachrichtTextArea, 0.0 );

    SplitPane rootSplitPane = new SplitPane();
    rootSplitPane.setOrientation( Orientation.HORIZONTAL );
    rootSplitPane.setDividerPositions( 0.6 );

    SplitPane leftSplitPane = new SplitPane();
    leftSplitPane.setOrientation( Orientation.VERTICAL );
    leftSplitPane.setDividerPositions( 0.8 );
    leftSplitPane.getItems().add( verlaufTextAreaBox );
    leftSplitPane.getItems().add( neueNachrichtTextAreaBox );

    SplitPane rightSplitPane = new SplitPane();
    rightSplitPane.setOrientation( Orientation.VERTICAL );
    rightSplitPane.setDividerPositions( 0.95 );
    rightSplitPane.getItems().add( clientListViewVBox );
    rightSplitPane.getItems().add( sendenButtonBox );

    rootSplitPane.getItems().add( leftSplitPane );
    rootSplitPane.getItems().add( rightSplitPane );

    this.setContent( rootSplitPane );
  }

  public ObservableList< User > getClientList() {
    return this.clientList;
  }

}
