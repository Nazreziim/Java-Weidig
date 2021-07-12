package interrupts.join;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadRun tr1 = new ThreadRun(1);
		tr1.start();
		try {
			tr1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread ist fertig");
	}

}
