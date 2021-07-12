package day8.p1b.extendedcontrols.properties;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TableViewDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "TableViewDemo" );

    BorderPane borderPane = new BorderPane();

    ObservableList< Person > personList = FXCollections.observableArrayList( //
            new Person( "Max", "Mustermann", "max.mustermann@firma.de", LocalDate.of( 1990, 5, 12 ), true ), //
            new Person( "Maria", "Musterfrau", "maria.musterfrau@bla.com", LocalDate.of( 1995, 6, 11 ), true ), //
            new Person( "M.", "Musterdivers", "m.musterdivers@ungewi.ss", LocalDate.of( 1960, 1, 31 ), false ) //
    );

    TableColumn< Person, Long > idCol = new TableColumn<>( "ID" );
    idCol.setCellValueFactory( new PropertyValueFactory< Person, Long >( "ID" ) );
    TableColumn< Person, String > vornameCol = new TableColumn<>( "Vorname" );
    vornameCol.setCellValueFactory( new PropertyValueFactory< Person, String >( "firstName" ) );
    TableColumn< Person, String > nameCol = new TableColumn<>( "Name" );
    nameCol.setCellValueFactory( new PropertyValueFactory< Person, String >( "familyName" ) );
    TableColumn< Person, String > emailCol = new TableColumn<>( "eMail" );
    emailCol.setCellValueFactory( new PropertyValueFactory< Person, String >( "email" ) );
    TableColumn< Person, LocalDate > gebCol = new TableColumn<>( "Geburtsdatum" );
    gebCol.setCellValueFactory( new PropertyValueFactory< Person, LocalDate >( "birthday" ) );
    TableColumn< Person, Boolean > verheiratetCol = new TableColumn<>( "verheiratet" );
    verheiratetCol.setCellValueFactory( new PropertyValueFactory< Person, Boolean >( "married" ) );

    TableView< Person > tableView = new TableView<>();
    tableView.getColumns().add( idCol );
    tableView.getColumns().add( vornameCol );
    tableView.getColumns().add( nameCol );
    tableView.getColumns().add( emailCol );
    tableView.getColumns().add( gebCol );
    tableView.getColumns().add( verheiratetCol );
    tableView.setItems( personList );

    Thread t = new Thread( new Runnable() {
      @Override
      public void run() {
        try {
          TimeUnit.SECONDS.sleep( 5 );
        } catch ( InterruptedException e ) {
          e.printStackTrace();
        }
        personList.add( new Person( "Test", "Person", "t@p.blub", LocalDate.now(), false ) );
        try {
          TimeUnit.SECONDS.sleep( 2 );
        } catch ( InterruptedException e ) {
          e.printStackTrace();
        }
        personList.get( 0 ).setFamilyName( "SUPER" );
      }
    } );
    t.start();

    borderPane.setCenter( tableView );

    Scene scene = new Scene( borderPane );
    primaryStage.setScene( scene );
    primaryStage.show();
  }

}
