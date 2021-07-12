package synchronisation.deadlock;

public class Main {
	public static void main(String[] args) {
				
		WichtigeTaetigkeit wt = new WichtigeTaetigkeit();
		FirstCriticalThread t1 = new FirstCriticalThread(wt);
		SecondCriticalThread t2 = new SecondCriticalThread(wt);
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}

}
