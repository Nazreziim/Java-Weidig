package model.board;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import model.Coord2D;
import model.board.exceptions.BoardInconsistentException;
import model.board.exceptions.IllegalPathException;
import model.creeps.Creep;
import model.tower.NormalTower;
import model.tower.Tower;

public class Board {

  private int width;
  private int height;

  private Field[][] board;
  private LinkedList< Coord2D > pathCoordList;
  private LinkedList< Creep > creepBacklog;

  public Board( int height, int width ) {
    // Werte setzen
    this.width = width;
    this.height = height;

    // Listen initialisieren
    this.pathCoordList = new LinkedList<>();
    this.creepBacklog = new LinkedList<>();

    // Board initialisieren
    this.board = new Field[ height ][ width ];
  }

  private void clearBoard() {
    for ( int row = 0; row < this.height; ++row ) {
      for ( int column = 0; column < this.width; ++column ) {
        this.board[ row ][ column ] = new Free( new Coord2D( row, column ) );
      }
    }
  }

  public void checkAndSetPath( List< Coord2D > pathCoords ) throws IllegalPathException {
    this.clearBoard();
    this.pathCoordList.clear();
    this.pathCoordList.addAll( pathCoords );

    boolean first = true;
    boolean last = false;
    for ( int index = 0; index < this.pathCoordList.size(); ++index ) {
      Coord2D c = this.pathCoordList.get( index );
      Direction dir = null;
      if ( c != null ) {
        if ( index + 1 < this.pathCoordList.size() ) {
          last = false;
          Coord2D next = this.pathCoordList.get( index + 1 );
          if ( c.getRow() == next.getRow() && c.getColumn() == next.getColumn() + 1 ) {
            dir = Direction.LEFT;
          } else if ( c.getRow() == next.getRow() && c.getColumn() == next.getColumn() - 1 ) {
            dir = Direction.RIGHT;
          } else if ( c.getColumn() == next.getColumn() && c.getRow() == next.getRow() + 1 ) {
            dir = Direction.UP;
          } else if ( c.getColumn() == next.getColumn() && c.getRow() == next.getRow() - 1 ) {
            dir = Direction.DOWN;
          } else {
            throw new IllegalPathException( "Path is not closed. Index " + index + " and " + ( index + 1 ) + "." );
          }
        } else {
          last = true;
          if ( index > 0 ) {
            if ( c.getRow() == 0 ) {
              dir = Direction.UP;
            } else if ( c.getRow() == this.height - 1 ) {
              dir = Direction.DOWN;
            } else if ( c.getColumn() == 0 ) {
              dir = Direction.LEFT;
            } else {
              dir = Direction.RIGHT;
            }
          } else {
            throw new IllegalPathException( "Path is too short. Index " + index + "." );
          }
        }
        if ( first && ( c.getRow() != 0 && c.getRow() != this.height - 1 )
                && ( c.getColumn() != 0 && c.getColumn() != this.width - 1 ) ) {
          throw new IllegalPathException( "Path must start at border. Index " + index + ". " + c );
        }
        if ( last && ( c.getRow() != 0 && c.getRow() != this.height - 1 )
                && ( c.getColumn() != 0 && c.getColumn() != this.width - 1 ) ) {
          throw new IllegalPathException( "Path must end at border. Index " + index + ". " + c );
        }
        this.board[ c.getRow() ][ c.getColumn() ] = new Path( c, dir, first, last );
        first = false;
      } else {
        throw new IllegalPathException( "Path must not contain null values." );
      }
    }
  }

  public boolean buildTower( Coord2D coord ) {
    boolean built = false;
    if ( coord.getRow() < this.board.length //
            && coord.getColumn() < this.board[ coord.getRow() ].length //
            && this.board[ coord.getRow() ][ coord.getColumn() ] instanceof Free ) {
      this.board[ coord.getRow() ][ coord.getColumn() ] = new NormalTower( coord );
      built = true;
    }
    return built;
  }

  public Field[][] getBoard() {
    return this.board;
  }

  public int getHeight() {
    return this.height;
  }

  public int getWidth() {
    return this.width;
  }

  public LinkedList< Coord2D > getPath() {
    return this.pathCoordList;
  }

  public void addCreep( Creep creep ) {
    this.creepBacklog.add( creep );
  }

  public boolean isCreepBacklogEmpty() {
    return this.creepBacklog.isEmpty();
  }

  public boolean step() {
    boolean moved = move();
    fire();
    suffer();
    return moved;
  }

  public boolean move() {
    boolean moved = false;

    Iterator< Coord2D > it = this.pathCoordList.descendingIterator();
    if ( it.hasNext() ) {
      Coord2D next = null;
      Coord2D current = it.next();
      while ( it.hasNext() ) {
        next = current;
        current = it.next();
        Path currentPath = ( (Path) this.board[ current.getRow() ][ current.getColumn() ] );
        Iterator< Creep > creepIt = currentPath.getCreepList().iterator();
        while ( creepIt.hasNext() ) {
          Creep creep = creepIt.next();
          Path nextPath = ( (Path) this.board[ next.getRow() ][ next.getColumn() ] );
          if ( creep.isTravelled() && ( !nextPath.isFull() || nextPath.isLast() ) ) {
            creep.resetTravelled();
            nextPath.getCreepList().add( creep );
            creepIt.remove();
            moved = true;
          }
          creep.travel();
        }
        if ( !it.hasNext() && !currentPath.isFull() && !this.creepBacklog.isEmpty() ) {
          Creep c = this.creepBacklog.getFirst();
          c.travel();
          currentPath.getCreepList().add( c );
          this.creepBacklog.removeFirst();
          moved = true;
        }
      }
    }
    return moved;
  }

  public void fire() {
    for ( int r = 0; r < this.board.length; ++r ) {
      for ( int c = 0; c < this.board[ r ].length; ++c ) {
        if ( this.board[ r ][ c ] instanceof Tower ) {
          Tower t = (Tower) this.board[ r ][ c ];
          boolean shot = false;
          for ( int rRange = r - t.getRange(); //
                  !shot //
                          && rRange <= r + t.getRange()//
                          && rRange >= 0 //
                          && rRange < this.board.length; //
                  ++rRange ) {
            for ( int cRange = c - t.getRange(); //
                    !shot //
                            && cRange <= c + t.getRange()//
                            && cRange >= 0 //
                            && cRange < this.board[ rRange ].length; //
                    ++cRange ) {
              if ( this.board[ rRange ][ cRange ] instanceof Path ) {
                Path p = (Path) this.board[ rRange ][ cRange ];
                if ( !p.getCreepList().isEmpty() ) {
                  Creep creep = p.getCreepList().get( 0 );
                  creep.shot( t.getDamage() );
                  shot = true;
                }
              }
            }
          }
        }
      }
    }
  }

  public void suffer() {
    for ( int r = 0; r < this.board.length; ++r ) {
      for ( int c = 0; c < this.board[ r ].length; ++c ) {
        if ( this.board[ r ][ c ] instanceof Path ) {
          Path p = (Path) this.board[ r ][ c ];
          Iterator< Creep > creepIt = p.getCreepList().iterator();
          while ( creepIt.hasNext() ) {
            Creep creep = creepIt.next();
            creep.suffer();
            if ( !creep.isAlive() ) {
              creepIt.remove();
            }
          }
        }
      }
    }
  }

  public boolean isLastPathEmpty() throws BoardInconsistentException {
    boolean empty = true;
    Coord2D lastPathCoord = this.pathCoordList.getLast();
    Field field = this.board[ lastPathCoord.getRow() ][ lastPathCoord.getColumn() ];
    if ( field instanceof Path ) {
      empty = ( (Path) field ).getCreepList().isEmpty();
    } else {
      throw new BoardInconsistentException( "Last coordinate is no path element." );
    }
    return empty;
  }

  public int remainingCreeps() throws BoardInconsistentException {
    int creepCount = this.creepBacklog.size();
    for ( Coord2D pathCoord : this.pathCoordList ) {
      Field field = this.board[ pathCoord.getRow() ][ pathCoord.getColumn() ];
      if ( field instanceof Path ) {
        Path p = (Path) field;
        creepCount += p.getCreepList().size();
      } else {
        throw new BoardInconsistentException( "Coordinate is no path element." );
      }
    }
    return creepCount;
  }

}
