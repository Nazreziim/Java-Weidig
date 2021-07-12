package synchronisation.locks;

public class Main {
	public static void main(String[] args) {
				
		System.out.println("\nJetzt synchronized:");
		CounterSynchronized cs = new CounterSynchronized();
		CriticalThread t5 = new CriticalThread(cs);
		CriticalThread t6 = new CriticalThread(cs);
		
		t5.start();
		t6.start();
		try {
			t5.join();
			t6.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}

}
