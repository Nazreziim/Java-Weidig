package synchronisation.critical_section;

public class CriticalThread extends Thread {
	private Counter c;
	
	public CriticalThread(Counter c) {
		this.c = c;
	}
	
	public void run() {
		for (int i = 0; i < 20 ; i++) {
			c.increment();
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
