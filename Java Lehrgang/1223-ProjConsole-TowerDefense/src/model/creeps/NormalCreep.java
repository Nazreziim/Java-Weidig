package model.creeps;

import model.CreepEnum;

public class NormalCreep extends Creep {

  private final int maxHealth = 100;
  private final double speed = 0.5;

  public NormalCreep() {
    super( CreepEnum.NORMAL );
  }

  @Override
  public int getMaxHealth() {
    return this.maxHealth;
  }

  public double getSpeed() {
    return this.speed;
  }

}
