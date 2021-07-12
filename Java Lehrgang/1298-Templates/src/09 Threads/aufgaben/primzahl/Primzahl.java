package aufgaben.primzahl;

public class Primzahl implements Runnable {

	public long zahl;
	public boolean isPrim;
	public final int id;
	public static int count = 0;
	
	public Primzahl(long zahl, int id){
		this.zahl=zahl;
		this.id=id;
		count++;
	}
	
	
	


	public boolean isPrim(){
		for(int i = 2; i<=Math.sqrt(this.zahl); i++) { 
			if(this.zahl%i == 0){
				this.isPrim = false;
				return false;
			}
		}
		this.isPrim= true;
		return true;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep((long) (Math.random()*1000));
		} catch (InterruptedException e) {
			//e.printStackTrace();
		}
		if(this.isPrim()){
			System.out.println("Thread " + this.id + " sagt: "+ this.zahl);
		}

	}

}
