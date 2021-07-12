package uebung7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AssemblyLine< T > {
  private Queue< T > list = new LinkedList< T >();
  private ReentrantReadWriteLock lock = new ReentrantReadWriteLock( true );

  public boolean add( T element ) {
    this.lock.writeLock().lock();
    try {
      return list.add( element );
    } finally {
      this.lock.writeLock().unlock();
    }
  }

  public T remove() {
    this.lock.writeLock().lock();
    try {
      return list.remove();
    } finally {
      this.lock.writeLock().unlock();
    }
  }

  public int size() {
    this.lock.readLock().lock();
    try {
      return list.size();
    } finally {
      this.lock.readLock().unlock();
    }
  }

  public T element() {
    this.lock.readLock().lock();
    try {
      return list.element();
    } finally {
      this.lock.readLock().unlock();
    }
  }
}
