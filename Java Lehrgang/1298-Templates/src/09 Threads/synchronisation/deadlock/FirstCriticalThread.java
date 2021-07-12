package synchronisation.deadlock;

public class FirstCriticalThread extends Thread {
	private WichtigeTaetigkeit wt;
	
	public FirstCriticalThread(WichtigeTaetigkeit c) {
		this.wt = c;
	}
	
	public void run() {
		for (int i = 0; i < 20 ; i++) {
			//Zuerst Lock1, dann Lock 2
			
			
			
			/*
			 * Das Problem
			 */
			wt.lock1.lock();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			wt.lock2.lock();
			wt.tueWasWichtiges();
			wt.lock2.unlock();
			wt.lock1.unlock();
			
			
			
			/*
			 * Die Lösung 	
			 */
//			if (wt.lock1.tryLock()) {
//				try {
//					Thread.sleep(50);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				if (wt.lock2.tryLock()) {
//					wt.tueWasWichtiges();
//					wt.lock2.unlock();
//				}
//				wt.lock1.unlock();
//			}
			 
			 
			

		}
	}
}
