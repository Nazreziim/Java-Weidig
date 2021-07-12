package model.tower;

import model.Coord2D;
import model.board.Field;

public class NormalTower extends Field implements Tower {

  public NormalTower( Coord2D coord ) {
    super( coord );
  }

  @Override
  public int getRange() {
    return 1;
  }

  @Override
  public Damage getDamage() {
    return new OneTimeDamage( 10 );
  }

}
