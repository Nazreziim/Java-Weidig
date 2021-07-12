package model.creeps;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import model.CreepEnum;
import model.tower.Damage;

public abstract class Creep {

  private final CreepEnum creepEnum;

  private double travelled;
  private int health;

  private List< Damage > damageList;

  public Creep( CreepEnum creepEnum ) {
    this.creepEnum = creepEnum;
    this.resetTravelled();
    this.health = this.getMaxHealth();
    this.damageList = new LinkedList<>();
  }

  public abstract int getMaxHealth();

  public int getHealth() {
    return this.health;
  }

  public abstract double getSpeed();

  public boolean isTravelled() {
    return this.travelled >= 1.0;
  }

  public void travel() {
    this.travelled += this.getSpeed();
  }

  public void resetTravelled() {
    this.travelled = 0.0;
  }

  public boolean isAlive() {
    return this.health > 0;
  }

  public void shot( Damage damage ) {
    this.damageList.add( damage );
  }

  public void suffer() {
    Iterator< Damage > it = this.damageList.iterator();
    while ( it.hasNext() ) {
      Damage d = it.next();
      this.health -= d.getDamage();
      d.reduceRemainingTime();
      if ( d.getRemainingTime() <= 0 ) {
        it.remove();
      }
    }
  }

  public CreepEnum getCreepEnum() {
    return this.creepEnum;
  }

}
