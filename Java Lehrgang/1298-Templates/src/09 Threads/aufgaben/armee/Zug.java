package aufgaben.armee;

import java.util.ArrayList;

public class Zug {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Kantine k = new Kantine();
		ArrayList<Gruppe> gruppen = new ArrayList<Gruppe>();
		gruppen.add(new Gruppe(8,k));
		gruppen.add(new Gruppe(7,k));
		System.out.println("Zugführer: "+ "Auf gehts zum Futtern");
		for(Gruppe g : gruppen){
			g.start();
		}
		for(Gruppe g : gruppen){
			try {
				g.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Zug ist fertig!");
	}

}
