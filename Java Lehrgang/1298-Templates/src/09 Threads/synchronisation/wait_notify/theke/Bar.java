package synchronisation.wait_notify.theke;


public class Bar extends Thread{
	private Theke theke;
	
	public Bar(Theke theke){
		this.theke = theke;
	}
	
	public void run(){
		while(true){
			System.out.println("Barmann: Versuche auf Bar zuzugreifen");
			synchronized (theke){
				Bier bier = new Bier();
				System.out.println("Barmann: Ich zapfe ein Bier" + bier);
				this.theke.add(bier);
				try {
					Thread.sleep( (int) (Math.random() * 10) );
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
