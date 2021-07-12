package day8.p1c.extendedcontrols.properties;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TreeTableViewDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "TreeTableViewDemo" );

    BorderPane borderPane = new BorderPane();

    ObservableList< Person > personList = FXCollections.observableArrayList( //
            new Person( "Max", "Mustermann", "max.mustermann@firma.de", LocalDate.of( 1990, 5, 12 ), true ), //
            new Person( "Maria", "Musterfrau", "maria.musterfrau@bla.com", LocalDate.of( 1995, 6, 11 ), true ), //
            new Person( "M.", "Musterdivers", "m.musterdivers@ungewi.ss", LocalDate.of( 1960, 1, 31 ), false ) //
    );

    TreeTableColumn< Person, Long > idCol = new TreeTableColumn<>( "ID" );
    idCol.setCellValueFactory( new TreeItemPropertyValueFactory< Person, Long >( "ID" ) );
    TreeTableColumn< Person, String > vornameCol = new TreeTableColumn<>( "Vorname" );
    vornameCol.setCellValueFactory( new TreeItemPropertyValueFactory< Person, String >( "firstName" ) );
    TreeTableColumn< Person, String > nameCol = new TreeTableColumn<>( "Name" );
    nameCol.setCellValueFactory( new TreeItemPropertyValueFactory< Person, String >( "familyName" ) );
    TreeTableColumn< Person, String > emailCol = new TreeTableColumn<>( "eMail" );
    emailCol.setCellValueFactory( new TreeItemPropertyValueFactory< Person, String >( "email" ) );
    TreeTableColumn< Person, LocalDate > gebCol = new TreeTableColumn<>( "Geburtsdatum" );
    gebCol.setCellValueFactory( new TreeItemPropertyValueFactory< Person, LocalDate >( "birthday" ) );
    TreeTableColumn< Person, Boolean > verheiratetCol = new TreeTableColumn<>( "verheiratet" );
    verheiratetCol.setCellValueFactory( new TreeItemPropertyValueFactory< Person, Boolean >( "married" ) );

    TreeItem< Person > treeTableRoot = new TreeItem<>( personList.get( 0 ) );
    treeTableRoot.getChildren().add( new TreeItem< Person >( personList.get( 1 ) ) );
    treeTableRoot.getChildren().add( new TreeItem< Person >( personList.get( 2 ) ) );

    TreeTableView< Person > treeTableView = new TreeTableView<>();
    treeTableView.getColumns().add( idCol );
    treeTableView.getColumns().add( vornameCol );
    treeTableView.getColumns().add( nameCol );
    treeTableView.getColumns().add( emailCol );
    treeTableView.getColumns().add( gebCol );
    treeTableView.getColumns().add( verheiratetCol );
    treeTableView.setRoot( treeTableRoot );

    Thread t = new Thread( new Runnable() {
      @Override
      public void run() {
        try {
          TimeUnit.SECONDS.sleep( 5 );
        } catch ( InterruptedException e ) {
          e.printStackTrace();
        }
        personList.add( new Person( "Test", "Person", "t@p.blub", LocalDate.now(), false ) );
        treeTableRoot.getChildren().add( new TreeItem< Person >( personList.get( 3 ) ) );
        try {
          TimeUnit.SECONDS.sleep( 2 );
        } catch ( InterruptedException e ) {
          e.printStackTrace();
        }
        personList.get( 0 ).setFamilyName( "SUPER" );
      }
    } );
    t.start();

    borderPane.setCenter( treeTableView );

    Scene scene = new Scene( borderPane );
    primaryStage.setScene( scene );
    primaryStage.show();
  }

}
