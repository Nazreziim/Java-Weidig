package synchronisation.wait_notify.theke;


public class Kunde extends Thread{
	
	private Theke theke;
	
	public Kunde(Theke theke){
		this.theke=theke;
	}
	
	
	public void run(){
		while(true){
			System.out.println("Kunde "+this+": Versuche auf Bar zuzugreifen");
			synchronized (theke){
				Bier bier = theke.getBier();
				System.out.println("Kunde "+this+": Ich trinke ein Bier " + bier);
				try {
					Thread.sleep( (int)(Math.random()*10000) );
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
