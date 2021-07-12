package interrupts.v1;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadRun tr1 = new ThreadRun(1);
		tr1.start();	
		
		try {
				(new Thread()).sleep(2000);
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		//stop() unterbricht den Thread sofort.
		//Vorsicht Thread kann gerade in einer Transaktions sein -> gefährlich
		//Deswegen seit jdk 1.2 deprecated
		tr1.stop();
		
		
	}

}
