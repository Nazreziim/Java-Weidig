package synchronisation.wait_notify.theke;

import java.util.Vector;

public class Theke {
	private Vector<Bier> bier;
	
	
	public Theke(){
		this.bier=new Vector<Bier>();
	}
	
	public void add(Bier b){
		System.out.println("Bier hinzugefuegt");
		bier.add(b);
		if(this.bier.size()>0){
			this.notify();
		}
		System.out.println("Anzahl Bier"+bier.size());
	}
	
	public Bier getBier(){
		Bier b = null;
		if(this.bier.size()==0){
			try {
				System.out.println("Bier ist alle");
				this.wait();
				System.out.println("Wieder mindestens ein Bier da");
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		b=bier.remove(0);
		System.out.println("Ein Bier entnommen");
		System.out.println("Anzahl Bier"+bier.size());
		return b;
	}
}
