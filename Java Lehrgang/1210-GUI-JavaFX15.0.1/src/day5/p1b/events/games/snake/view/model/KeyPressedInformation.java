package day5.p1b.events.games.snake.view.model;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import javafx.scene.input.KeyCode;

public class KeyPressedInformation {

  private ReentrantReadWriteLock lock;
  private KeyCode keyCode;
  private boolean newInformation;

  public KeyPressedInformation() {
    this.lock = new ReentrantReadWriteLock();
    this.keyCode = KeyCode.UNDEFINED;
    this.newInformation = false;
  }

  public boolean hasNewInformation() {
    this.lock.readLock().lock();
    try {
      return this.newInformation;
    } finally {
      this.lock.readLock().unlock();
    }
  }

  public KeyCode getKeyCode() {
    this.lock.readLock().lock();
    try {
      return this.keyCode;
    } finally {
      this.newInformation = false;
      this.lock.readLock().unlock();
    }
  }

  public void setKeyCode( KeyCode keyCode ) {
    this.lock.writeLock().lock();
    if ( !this.hasNewInformation() ) {
      this.keyCode = keyCode;
      this.newInformation = true;
    }
    this.lock.writeLock().unlock();
  }

}
