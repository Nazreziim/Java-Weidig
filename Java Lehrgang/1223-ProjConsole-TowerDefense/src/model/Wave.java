package model;

import java.util.LinkedList;

public class Wave {

  private LinkedList< CreepEnum > waveCreepList;

  public Wave() {
    this.waveCreepList = new LinkedList<>();
  }

  public Wave( CreepEnum... creepEnums ) {
    this();
    this.addCreeps( creepEnums );
  }

  public Wave( CreepEnum creepEnum, int count ) {
    this();
    this.addCreeps( creepEnum, count );
  }

  public void addCreeps( CreepEnum... creepEnums ) {
    for ( CreepEnum ce : creepEnums ) {
      this.waveCreepList.add( ce );
    }
  }

  public void addCreeps( CreepEnum creepEnum, int count ) {
    for ( int i = 0; i < count; ++i ) {
      this.waveCreepList.add( creepEnum );
    }
  }

  public LinkedList< CreepEnum > getWaveCreepList() {
    return this.waveCreepList;
  }

}
