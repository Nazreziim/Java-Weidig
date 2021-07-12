package model.board;

import model.Coord2D;

public class Field {

  private Coord2D coord;

  public Field( Coord2D coord ) {
    this.coord = coord;
  }

  public Coord2D getCoord() {
    return this.coord;
  }

}
