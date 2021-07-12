package chat.server;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SynchBox< T > {

  private T data;
  private ReentrantReadWriteLock lock;

  public SynchBox( T data ) {
    this.lock = new ReentrantReadWriteLock();
    this.set( data );
  }

  public T get() {
    try {
      this.lock.readLock().lock();
      return data;
    } finally {
      this.lock.readLock().unlock();
    }
  }

  public void set( T data ) {
    try {
      this.lock.writeLock().lock();
      this.data = data;
    } finally {
      this.lock.writeLock().unlock();
    }
  }

}
