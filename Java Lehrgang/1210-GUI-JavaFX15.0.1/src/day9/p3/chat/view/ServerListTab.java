package day9.p3.chat.view;

import chat.model.ServerInformation;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ServerListTab extends Tab {

  private ObservableList< ServerInformation > serverList;
  private TableView< ServerInformation > tableView;

  public ServerListTab( StatusBar statusBar ) {
    super( "Server" );

    // Tabelle
    this.tableView = new TableView< ServerInformation >();
    this.tableView.setPrefWidth( 400 );
    this.tableView.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );

    // Spalten
    TableColumn< ServerInformation, String > nameCol = new TableColumn<>( "Server Name" );
    TableColumn< ServerInformation, Void > addressCol = new TableColumn<>( "Server-Address" );
    TableColumn< ServerInformation, String > ipCol = new TableColumn<>( "IP" );
    TableColumn< ServerInformation, String > portCol = new TableColumn<>( "Port" );
    TableColumn< ServerInformation, Integer > userCol = new TableColumn<>( "User" );
    //// Woher kommen die Werte
    nameCol.setCellValueFactory( new PropertyValueFactory<>( "serverName" ) );
    ipCol.setCellValueFactory( new PropertyValueFactory<>( "ip" ) );
    portCol.setCellValueFactory( new PropertyValueFactory<>( "port" ) );
    userCol.setCellValueFactory( new PropertyValueFactory<>( "userCount" ) );
    //// Sortierung
    nameCol.setSortType( TableColumn.SortType.ASCENDING );

    // Spalten zur Tabelle hinzufügen
    this.tableView.getColumns().add( nameCol );
    addressCol.getColumns().add( ipCol );
    addressCol.getColumns().add( portCol );
    this.tableView.getColumns().add( addressCol );
    this.tableView.getColumns().add( userCol );

    // Liste der Table in Attribut packen.
    this.serverList = this.tableView.getItems();

    // Buttons
    Button betretenBtn = new Button( "Betreten" );
    betretenBtn.setOnAction( x -> {
      if ( tableView.getSelectionModel().isEmpty() ) {
        statusBar.setStatus( "Betreten geklickt. (kein Server gewählt)" );
      } else {
        ServerInformation selectedServer = tableView.getSelectionModel().getSelectedItem();
        statusBar.setStatus( "Betreten geklickt. (" + selectedServer.getServerName() + ")" );
      }
    } );

    Button aktualisierenBtn = new Button( "Aktualisieren" );
    aktualisierenBtn.setOnAction( x -> statusBar.setStatus( "Aktualisieren geklickt." ) );

    VBox tableVBox = new VBox( 5, this.tableView );
    tableVBox.setPadding( new Insets( 5 ) );

    BorderPane serverTabBorderPane = new BorderPane();
    serverTabBorderPane.setCenter( tableVBox );

    VBox buttonVBox = new VBox( 5 );
    buttonVBox.setPadding( new Insets( 0, 5, 5, 5 ) );

    AnchorPane buttonAnchorPane = new AnchorPane();
    buttonAnchorPane.getChildren().add( betretenBtn );
    buttonAnchorPane.getChildren().add( aktualisierenBtn );
    AnchorPane.setLeftAnchor( aktualisierenBtn, 0.0 );
    AnchorPane.setRightAnchor( betretenBtn, 0.0 );

    buttonVBox.getChildren().add( buttonAnchorPane );

    serverTabBorderPane.setBottom( buttonVBox );

    this.setClosable( false );
    this.setContent( serverTabBorderPane );
  }

  public ObservableList< ServerInformation > getServerList() {
    return this.serverList;
  }

  public void setServerList( ObservableList< ServerInformation > list ) {
    if ( list != null ) {
      this.serverList = list;
      this.tableView.setItems( this.serverList );
    }
  }

}
