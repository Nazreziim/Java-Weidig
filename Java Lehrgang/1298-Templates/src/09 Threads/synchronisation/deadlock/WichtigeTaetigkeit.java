package synchronisation.deadlock;

import java.util.concurrent.locks.*;

public class WichtigeTaetigkeit  {
	// Hier gibts jetzt zwei locks
	final Lock lock1 = new ReentrantLock();
	final Lock lock2 = new ReentrantLock();
	
	

	public void tueWasWichtiges() {
		try {// Das soll jetzt einen Moment dauern!
			Thread.sleep((long)(Math.random()*100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Das war total wichtig - ein Glück hab ich das gemacht!");

	}


}
