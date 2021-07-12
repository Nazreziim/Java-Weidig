package basic_threading.daemon;

public class NormalerThread extends Thread {


	@Override
	public void run() {
		while (true) {
			System.out.println("Ich bin ganz normal");
		}
		
	}

	

}
