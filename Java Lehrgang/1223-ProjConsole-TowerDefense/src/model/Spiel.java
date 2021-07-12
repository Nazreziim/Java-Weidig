package model;

import java.util.List;

import model.board.Board;
import model.board.exceptions.BoardInconsistentException;
import model.board.exceptions.IllegalPathException;
import model.creeps.FastCreep;
import model.creeps.HeavyCreep;
import model.creeps.NormalCreep;

/**
 * Fassade für das Model des Spiels.
 * 
 * @author 11248307
 *
 */
public class Spiel {

  private Board board;
  private String playerName;

  public Spiel( int height, int width ) {
    this.playerName = "DefaultPlayer";
    this.board = new Board( height, width );
  }

  public void setPath( List< Coord2D > pathCoordList ) throws IllegalPathException {
    this.board.checkAndSetPath( pathCoordList );
  }

  public boolean buildTower( Coord2D coord ) {
    return this.board.buildTower( coord );
  }

  public void addCreeps( List< CreepEnum > waveCreepList ) {
    for ( CreepEnum ce : waveCreepList ) {
      switch ( ce ) {
        case NORMAL :
          this.board.addCreep( new NormalCreep() );
          break;
        case FAST :
          this.board.addCreep( new FastCreep() );
          break;
        case HEAVY :
          this.board.addCreep( new HeavyCreep() );
          break;
      }
    }
  }

  public boolean isLost() throws BoardInconsistentException {
    return !this.board.isLastPathEmpty();
  }

  public boolean isRunning() throws BoardInconsistentException {
    return !isLost() && this.board.remainingCreeps() > 0;
  }

  public void step() {
    this.board.move();
    this.board.fire();
    this.board.suffer();
  }

  public String getSpielerName() {
    return this.playerName;
  }

  // TODO: Temporär!
  public Board getBoard() {
    return this.board;
  }

  public void setPlayerName( String playerName ) {
    this.playerName = playerName;
  }
}
