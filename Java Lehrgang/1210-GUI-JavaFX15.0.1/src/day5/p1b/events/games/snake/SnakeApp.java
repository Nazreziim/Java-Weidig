package day5.p1b.events.games.snake;

import day5.p1b.events.games.snake.controller.GameTask;
import day5.p1b.events.games.snake.model.Game;
import day5.p1b.events.games.snake.view.model.GameVM;
import day5.p1b.events.games.snake.view.model.KeyPressedInformation;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class SnakeApp extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {

    // Snake: Game
    final int WIDTH = 16;
    final int HEIGHT = 16;
    Game game = new Game( HEIGHT, WIDTH );
    // Snake: GameViewModel
    GameVM vm = new GameVM( game );
    // View
    Group grid = new Group();
    grid.minHeight( 800 );
    grid.maxHeight( 800 );
    grid.minWidth( 800 );
    grid.maxWidth( 800 );

    StackPane stackPane = new StackPane();
    stackPane.getChildren().add( grid );

    BorderPane borderPane = new BorderPane();
    borderPane.setCenter( stackPane );

    Scene scene = new Scene( borderPane, 800, 1_000 );

    vm.generateGrid( grid );

    primaryStage.setScene( scene );
    primaryStage.show();

    final KeyPressedInformation kpi = new KeyPressedInformation();
    scene.setOnKeyPressed( new EventHandler< KeyEvent >() {
      @Override
      public void handle( KeyEvent event ) {
        kpi.setKeyCode( event.getCode() );
      }
    } );

    GameTask gameTask = new GameTask( vm, kpi, grid );
    Thread gameThread = new Thread( gameTask );
    gameThread.start();

    primaryStage.setOnCloseRequest( new EventHandler< WindowEvent >() {
      @Override
      public void handle( WindowEvent event ) {
        if ( event.getEventType() == WindowEvent.WINDOW_CLOSE_REQUEST ) {
          gameThread.interrupt();
        }
      }
    } );
  }
}
