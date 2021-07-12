package basic_threading.daemon;

public class Main {

	public static void main(String[] args) {
		new DaemonThread().start();
		new NormalerThread().start();

	}

}
