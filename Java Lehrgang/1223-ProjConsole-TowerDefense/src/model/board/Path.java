package model.board;

import java.util.LinkedList;
import java.util.List;

import model.Coord2D;
import model.creeps.Creep;

public class Path extends Field {

  private Direction direction;
  private boolean first;
  private boolean last;
  private List< Creep > creepList;

  public Path( Coord2D coord, Direction direction, boolean first, boolean last ) {
    super( coord );

    this.direction = direction;
    this.first = first;
    this.last = last;
    this.creepList = new LinkedList<>();
  }

  public Direction getDirection() {
    return this.direction;
  }

  public boolean isLast() {
    return this.last;
  }

  public boolean isFirst() {
    return this.first;
  }

  public List< Creep > getCreepList() {
    return this.creepList;
  }

  public boolean isFull() {
    return this.creepList.size() > 3;
  }
}
