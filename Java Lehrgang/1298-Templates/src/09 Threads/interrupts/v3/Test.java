package interrupts.v3;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadRun tr1 = new ThreadRun(1);
				
		tr1.start();
		try {
				Thread.sleep(2000);
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		//tr1.canceled = true;
		//Mechanismus bereits eingebaut
		tr1.interrupt();
		
		
	}

}
