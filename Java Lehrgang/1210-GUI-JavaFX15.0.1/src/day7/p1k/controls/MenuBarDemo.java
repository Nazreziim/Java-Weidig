package day7.p1k.controls;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuBarDemo extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {

    BorderPane borderPane = new BorderPane();

    TextArea textArea = new TextArea();
    borderPane.setCenter( textArea );

    MenuItem menuFilesOpen = new MenuItem( "Open..." );
    menuFilesOpen.setOnAction( event -> textArea.setText( textArea.getText() + "Open...|" ) );
    MenuItem menuFilesClose = new MenuItem( "Close" );
    menuFilesClose.setOnAction( event -> textArea.setText( textArea.getText() + "Close|" ) );

    Menu menuFiles = new Menu( "Files" );
    menuFiles.getItems().add( menuFilesOpen );
    menuFiles.getItems().add( menuFilesClose );

    MenuItem menuMenuItem = new MenuItem( "MenuMenuItem" );
    Menu menuMenu = new Menu( "MenuMenu" );
    menuMenu.setOnAction( event -> textArea.setText( textArea.getText() + "MenuMenu|" ) );
    menuMenu.getItems().add( menuMenuItem );
    menuMenuItem.setOnAction( event -> textArea.setText( textArea.getText() + "MenuMenuItem|" ) );
    Menu menu = new Menu( "Menu" );
    menu.getItems().add( menuMenu );

    MenuItem menuHelpAbout = new MenuItem( "About" );
    MenuItem menuHelpDoc = new MenuItem( "Documentation" );

    Menu menuHelp = new Menu( "Help" );
    menuHelp.getItems().add( menuHelpDoc );
    menuHelp.getItems().add( new SeparatorMenuItem() );
    menuHelp.getItems().add( menuHelpAbout );

    CheckMenuItem checkMenuItem = new CheckMenuItem( "CheckMenuItem" );
    checkMenuItem.setOnAction(
            event -> textArea.setText( textArea.getText() + "CheckMenuItem[" + checkMenuItem.isSelected() + "]|" ) );
    menuMenu.getItems().add( checkMenuItem );

    RadioMenuItem radioMenuItem1 = new RadioMenuItem( "Auswahl 1" );
    radioMenuItem1.setOnAction( event -> textArea.setText( textArea.getText() + "Auswahl 1|" ) );
    RadioMenuItem radioMenuItem2 = new RadioMenuItem( "Auswahl 2" );
    radioMenuItem2.setOnAction( event -> textArea.setText( textArea.getText() + "Auswahl 2|" ) );
    RadioMenuItem radioMenuItem3 = new RadioMenuItem( "Auswahl 3" );
    radioMenuItem3.setOnAction( event -> textArea.setText( textArea.getText() + "Auswahl 3|" ) );
    ToggleGroup toggleGroup = new ToggleGroup();
    toggleGroup.getToggles().add( radioMenuItem1 );
    toggleGroup.getToggles().add( radioMenuItem2 );
    toggleGroup.getToggles().add( radioMenuItem3 );

    Slider slider = new Slider( 0.0, 1.0, 0.01 );
    slider.valueProperty().addListener( new ChangeListener<Number>() {
      @Override
      public void changed( ObservableValue< ? extends Number > observable, Number oldValue, Number newValue ) {
        textArea.setText( textArea.getText() + String.format( "%.3f%n", newValue ) );
      }
    });
    CustomMenuItem customMenuItem = new CustomMenuItem( slider );
    customMenuItem.setHideOnClick( false );

    menuMenu.getItems().add( new SeparatorMenuItem() );
    menuMenu.getItems().add( radioMenuItem1 );
    menuMenu.getItems().add( radioMenuItem2 );
    menuMenu.getItems().add( radioMenuItem3 );
    menuMenu.getItems().add( new SeparatorMenuItem() );
    menuMenu.getItems().add( customMenuItem );

    MenuBar menuBar = new MenuBar();
    menuBar.getMenus().add( menuFiles );
    menuBar.getMenus().add( menu );
    menuBar.getMenus().add( menuHelp );

    borderPane.setTop( menuBar );

    primaryStage.setScene( new Scene( borderPane, 300, 200 ) );
    primaryStage.setTitle( "MeuBarDemo" );

    primaryStage.show();
  }

}
