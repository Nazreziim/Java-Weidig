package synchronisation.locks;

import java.util.concurrent.locks.*;

public class CounterSynchronized  {
	public int value = 0;
	final Lock lock = new ReentrantLock();
	
	
	/**
	 * Version :
	 * Diese Methode synchronisiert den kritischen Abschnitt mit einem Lock
	 */
	public void increment() {

		int erg = this.value; // Lesen		
		erg++;		
		try {// Das soll jetzt einen Moment dauern!
			Thread.sleep((long)(Math.random()*100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		// Hier die Synchonisation mit Lock
		lock.lock();
		this.value = erg;     // Schreiben
		lock.unlock();
	}


}
