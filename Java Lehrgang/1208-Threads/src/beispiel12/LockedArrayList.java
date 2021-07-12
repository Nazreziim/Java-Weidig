package beispiel12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Thread-sichere Wrapperklasse einer ArrayList mit eingeschränkten Möglichkeiten.
 * 
 * @param <T> Typparameter für die ArrayList.
 */
public class LockedArrayList< T > {
  private List< T > liste = new ArrayList< T >();
  private ReentrantReadWriteLock lock = new ReentrantReadWriteLock( true );

  public void add( T element ) {
    this.lock.writeLock().lock();
    try {
      this.liste.add( element );
    } finally {
      this.lock.writeLock().unlock();
    }
  }

  public T remove( int index ) {
    this.lock.writeLock().lock();
    try {
      return this.liste.remove( index );
    } finally {
      this.lock.writeLock().unlock();
    }
  }

  public T get( int index ) {
    this.lock.readLock().lock();
    try {
      return this.liste.get( index );
    } finally {
      this.lock.readLock().unlock();
    }
  }

  public int length() {
    this.lock.readLock().lock();
    try {
      return this.liste.size();
    } finally {
      this.lock.readLock().unlock();
    }
  }
}
