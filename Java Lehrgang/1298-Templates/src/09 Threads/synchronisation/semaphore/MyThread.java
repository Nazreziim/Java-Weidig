package synchronisation.semaphore;

public class MyThread extends Thread {

	public void run(){
		while(true){
			try{
				SemaphoreDemo.sem.acquire();
				System.out.println(this.getName() + " darf arbeiten!");
				Thread.sleep((long)Math.random()*10000+5000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			finally{
				System.out.println(this.getName() + " gibt frei!");
				
				SemaphoreDemo.sem.release();
			}
		}
	}
}
