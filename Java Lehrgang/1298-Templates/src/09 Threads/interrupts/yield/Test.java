package interrupts.yield;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		ThreadGroup group = new ThreadGroup("meine");
//		ThreadRun tr1 = new ThreadRun(1,group);
//		ThreadRun tr2 = new ThreadRun(2,group);
//		ThreadRun tr3 = new ThreadRun(3,group);
		ThreadRun tr4 = new ThreadRun(4);	
		ThreadRun tr5 = new ThreadRun(5);
		ThreadRun tr6 = new ThreadRun(6);	
		
		//nun hat ThreadRun selbst eine start Methode, natürlich von Thread geerbt
//		tr1.start();
//		tr2.start();
//		tr3.start();
		tr4.start();
		tr5.start();
		tr6.start();
		
		while(ThreadRun.count<200){
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Fehler - existiert nicht mehr
		//tr1.start();
//		System.out.println(tr1.isAlive());
//
//		System.out.println(tr1.isDaemon());
//
//		System.out.println(tr1.isInterrupted());
	}

}
