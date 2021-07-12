package synchronisation.locks;

public class CriticalThread extends Thread {
	private CounterSynchronized c;
	
	public CriticalThread(CounterSynchronized c) {
		this.c = c;
	}
	
	public void run() {
		for (int i = 0; i < 20 ; i++) {
			// Auch der folgende Abschnitt darf nicht unterbrochen werden durch
			// den Aufruf von increment() von einem anderen Thread. Achtung! Monitor			
			// Objekt muss dasselbe sein, das auch die increment-Methode schützt 
			c.lock.lock();
			c.increment();
			c.lock.unlock();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread " + this.getId() + " liefert: " + c.value);			

		}
	}
}
