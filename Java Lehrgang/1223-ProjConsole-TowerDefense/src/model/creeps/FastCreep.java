package model.creeps;

import model.CreepEnum;

public class FastCreep extends Creep {

  public FastCreep() {
    super( CreepEnum.FAST );
  }

  @Override
  public int getMaxHealth() {
    return 50;
  }

  @Override
  public double getSpeed() {
    return 1;
  }

}
