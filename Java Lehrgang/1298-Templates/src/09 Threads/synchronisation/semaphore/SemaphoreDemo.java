package synchronisation.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	static Semaphore sem = new Semaphore(2,true);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MyThread().start();
		new MyThread().start();
		new MyThread().start();
		new MyThread().start();
		new MyThread().start();
		new MyThread().start();
	}

}
