package synchronisation.deadlock;

public class SecondCriticalThread extends Thread {
	private WichtigeTaetigkeit wt;
	
	public SecondCriticalThread(WichtigeTaetigkeit c) {
		this.wt = c;
	}
	
	public void run() {
		for (int i = 0; i < 20 ; i++) {
			// Zuerst Lock2, dann Lock 1
			wt.lock2.lock();
			wt.lock1.lock();
			wt.tueWasWichtiges();
			wt.lock1.unlock();
			wt.lock2.unlock();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
	}
}
