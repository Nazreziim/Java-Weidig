package basic_threading.daemon;

public class DaemonThread extends Thread {
	public DaemonThread() {
		setDaemon(true);
	}


	@Override
	public void run() {
		while (true) { 
			System.out.println("I'm running");
		}
	}

}
