package model.tower;

public class OneTimeDamage implements Damage {

  private int damage;
  private int remainingTime;

  public OneTimeDamage( int damage ) {
    this.damage = damage;
    this.remainingTime = 1;
  }

  @Override
  public int getDamage() {
    return this.damage;
  }

  @Override
  public int getRemainingTime() {
    return this.remainingTime;
  }

  @Override
  public void reduceRemainingTime() {
    this.remainingTime -= 1;
  }

}
