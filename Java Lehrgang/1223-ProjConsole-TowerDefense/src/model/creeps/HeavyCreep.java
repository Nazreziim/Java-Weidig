package model.creeps;

import model.CreepEnum;

public class HeavyCreep extends Creep {

  public HeavyCreep() {
    super( CreepEnum.HEAVY );
  }

  private final int maxHealth = 200;
  private final double speed = 0.25;

  @Override
  public int getMaxHealth() {
    return this.maxHealth;
  }

  public double getSpeed() {
    return this.speed;
  }

}
