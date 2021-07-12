package day9.p3.chat;

import chat.client.ServerScreener;
import day9.p3.chat.view.ServerListTab;
import day9.p3.chat.view.StatusBar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClientMain extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "HslChat" );

    ServerScreener screenerRunnable = new ServerScreener( "224.0.11.60", 1002 );
    Thread screenerThread = new Thread( screenerRunnable );
    screenerThread.start();
    primaryStage.setOnCloseRequest( ( event ) -> {
      screenerRunnable.stop();
    } );

    // Root Pane
    BorderPane rootPane = new BorderPane();

    //// StatusBar
    StatusBar statusBar = new StatusBar();

    //// TabPane
    TabPane rootCenterPane = new TabPane();

    ////// ServerTab
    ServerListTab serverTab = new ServerListTab( statusBar );
    rootCenterPane.getTabs().add( serverTab );

    ////// ChatTab
    // ChatTab chatTab1 = new ChatTab( "Srv1" );
    // rootCenterPane.getTabs().add( chatTab1 );
    // Thread t = new Thread( new Runnable() {
    // @Override
    // public void run() {
    // try {
    // TimeUnit.SECONDS.sleep( 3 );
    // Platform.runLater( () -> chatTab1.getClientList().add( new User( "TestUser", Role.USER ) ) );
    // System.out.println( 1 );
    // TimeUnit.SECONDS.sleep( 3 );
    // Platform.runLater( () -> chatTab1.getClientList().add( new User( "TestMod", Role.MODERATOR )
    // ) );
    // System.out.println( 2 );
    // TimeUnit.SECONDS.sleep( 3 );
    // Platform.runLater( () -> chatTab1.getClientList().add( new User( "TestAdmin",
    // Role.ADMINISTRATOR ) ) );
    // System.out.println( 3 );
    // } catch ( InterruptedException e ) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    // } );
    // t.start();

    // add Components to RootPane
    rootPane.setCenter( rootCenterPane );
    rootPane.setBottom( statusBar );

    // set RootPane to Scene
    Scene loginScene = new Scene( rootPane );
    primaryStage.setScene( loginScene );
    primaryStage.show();

    serverTab.setServerList( screenerRunnable.getServerList() );
  }

}
