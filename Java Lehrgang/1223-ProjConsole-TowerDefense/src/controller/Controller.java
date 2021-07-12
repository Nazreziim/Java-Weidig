package controller;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import model.Coord2D;
import model.CreepEnum;
import model.Spiel;
import model.Wave;
import model.board.exceptions.BoardInconsistentException;
import model.board.exceptions.IllegalPathException;
import view.View;

public class Controller {

  private static final long STEP_DURATION = 500;

  private Spiel model;
  private View view;

  public Controller( Spiel model, View view ) {
    this.model = model;
    this.view = view;
  }

  public void start() {
    try {
      // Example Waves in list
      LinkedList< Wave > waveList = new LinkedList<>();
      waveList.add( new Wave( CreepEnum.NORMAL ) );
      waveList.add( new Wave( CreepEnum.NORMAL, 2 ) );
      waveList.add( new Wave( CreepEnum.NORMAL, 3 ) );
      Wave complexWave = new Wave();
      complexWave.addCreeps( CreepEnum.HEAVY, 1 );
      complexWave.addCreeps( CreepEnum.NORMAL, 4 );
      complexWave.addCreeps( CreepEnum.FAST, 1 );
      waveList.add( complexWave );
      // waveList.add( new Wave( CreepEnum.HEAVY, CreepEnum.NORMAL ) );

      LinkedList< String > inputList = new LinkedList<>();

      // TODO example Data
      model.setPath( generatePathCoordList() );

      view.drawBanner();
      String playerName = view.getPlayerName();
      this.model.setPlayerName( playerName );

      ExecutorService svc = Executors.newSingleThreadExecutor();
      long t1 = 0L;

      InputRunnable ir = new InputRunnable( inputList );
      svc.execute( ir );

      while ( !model.isLost() && !waveList.isEmpty() ) {
        model.addCreeps( waveList.removeFirst().getWaveCreepList() );

        view.drawGrid();
        view.drawMenu();
        view.drawFields();

        while ( model.isRunning() ) {
          t1 = System.currentTimeMillis();
          while ( System.currentTimeMillis() - t1 < Controller.STEP_DURATION ) {
            TimeUnit.MILLISECONDS.sleep( 50 );
            while ( !inputList.isEmpty() ) {
              process( inputList.removeFirst() );
            }
          }
          this.model.step();
          view.drawFields();
        }
      }
      ir.stop();
      TimeUnit.MILLISECONDS.sleep( 100 );
      svc.shutdown();
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    } catch ( IllegalPathException e ) {
      System.err.println( "Pfad ist ungültig:" );
      e.printStackTrace();
    } catch ( BoardInconsistentException e ) {
      System.err.println( e );
      e.printStackTrace();
    }
  }

  private void process( String input ) {
    input = input.toUpperCase();
    if ( input.startsWith( "T" ) ) {
      String[] inputArr = input.split( " " );
      if ( inputArr.length == 3 ) {
        int row = Integer.parseInt( inputArr[ 1 ], 16 );
        int column = Integer.parseInt( inputArr[ 2 ] );

        model.buildTower( new Coord2D( row, column ) );
      }
    }
  }

  private static LinkedList< Coord2D > generatePathCoordList() {
    LinkedList< Coord2D > path = new LinkedList<>();
    path.add( new Coord2D( 1, 0 ) );
    path.add( new Coord2D( 1, 1 ) );
    path.add( new Coord2D( 2, 1 ) );
    path.add( new Coord2D( 3, 1 ) );
    path.add( new Coord2D( 4, 1 ) );
    path.add( new Coord2D( 5, 1 ) );
    path.add( new Coord2D( 6, 1 ) );
    path.add( new Coord2D( 7, 1 ) );
    path.add( new Coord2D( 8, 1 ) );
    path.add( new Coord2D( 8, 2 ) );
    path.add( new Coord2D( 8, 3 ) );
    path.add( new Coord2D( 8, 4 ) );
    path.add( new Coord2D( 8, 5 ) );
    path.add( new Coord2D( 8, 6 ) );
    path.add( new Coord2D( 8, 7 ) );
    path.add( new Coord2D( 7, 7 ) );
    path.add( new Coord2D( 6, 7 ) );
    path.add( new Coord2D( 5, 7 ) );
    path.add( new Coord2D( 4, 7 ) );
    path.add( new Coord2D( 3, 7 ) );
    path.add( new Coord2D( 2, 7 ) );
    path.add( new Coord2D( 1, 7 ) );
    path.add( new Coord2D( 1, 6 ) );
    path.add( new Coord2D( 1, 5 ) );
    path.add( new Coord2D( 1, 4 ) );
    path.add( new Coord2D( 1, 3 ) );
    path.add( new Coord2D( 0, 3 ) );
    path.add( new Coord2D( 0, 2 ) );
    return path;
  }

  // private static void buildTowers( Spiel model ) {
  // List< Coord2D > towerCoords = new LinkedList<>();
  // towerCoords.add( new Coord2D( 0, 1 ) );
  // towerCoords.add( new Coord2D( 1, 2 ) );
  // towerCoords.add( new Coord2D( 2, 2 ) );
  // towerCoords.add( new Coord2D( 2, 6 ) );
  // towerCoords.add( new Coord2D( 3, 6 ) );
  // towerCoords.add( new Coord2D( 4, 2 ) );
  // towerCoords.add( new Coord2D( 4, 6 ) );
  // boolean built = true;
  // Iterator< Coord2D > coordIt = towerCoords.iterator();
  // while ( built && coordIt.hasNext() ) {
  // Coord2D coord = coordIt.next();
  // built = model.buildTower( coord );
  // if ( !built ) {
  // System.err.println( "Tower at " + coord + " konnte nicht gebaut werden." );
  // }
  // }
  // }

}
