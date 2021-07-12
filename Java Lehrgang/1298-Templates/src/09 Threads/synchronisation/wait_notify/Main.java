package synchronisation.wait_notify;

public class Main {

	public static void main(String[] args) {
		SyncStack stack = new SyncStack();
		
		Producer p1 = new Producer(stack);
		Producer p2 = new Producer(stack);
		Consumer c1 = new Consumer(stack);
		Consumer c2 = new Consumer(stack);
		
		Thread tp1 = new Thread(p1);
		Thread tp2 = new Thread(p2);
		Thread tc1 = new Thread(c1);
		Thread tc2 = new Thread(c2);
			
		tp1.start();
		//tp2.start();
		tc1.start();
		tc2.start();

	}

}
