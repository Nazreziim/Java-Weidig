package aufgaben.armee;

import java.util.ArrayList;

public class Gruppe extends Thread{
	public ArrayList<Soldat> soldaten = new ArrayList<Soldat>();
	public final long gruppennummer;
	private Kantine k;
	
	public Gruppe(int staerke, Kantine k){
		 for(int i = 0; i< staerke; i++){
		    	Soldat s = new Soldat();
		    	soldaten.add(s);
		    }
		 gruppennummer = this.getId();
		 this.k = k;
	}
	/**
	 * @param args
	 */
	public  void run() {		
	    
	    System.out.println("Gruppe " + this.gruppennummer+"! Auf gehts, Buam!");
	    for(Thread t : soldaten){
	    	 t.start();
	    }
	    
	    for(Thread t : soldaten){
	    	try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	    
	    System.out.println("Alle Soldaten der Gruppe "+ this.gruppennummer+ "sind vom packen zurück");
	    this.marschieren();
	    this.essen();
	    this.marschieren();
	    System.out.println("Gruppe "+ this.gruppennummer+ " ist vom Essen zurück");  
	}
	
	
	public void marschieren(){
		System.out.println("Alle Soldaten der Gruppe "+ this.gruppennummer+ "marschieren");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("Gruppe "+ this.gruppennummer+ "sind angekommen");
		
	}
	
	public void essen(){
		k.verpflegen(this);
	}

}
