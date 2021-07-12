package aufgaben.bank;

import java.util.*;

public class Bank {
	
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			Vector<Konto> konten = new Vector<Konto>();
			Konto k1 = new Konto(1, 1000);
			Konto k2 = new Konto(2, 2000);
			Konto k3 = new Konto(3, 3000);
			konten.add(k1);
			konten.add(k2);
			konten.add(k3);
			//drucke(konten);
			new Abbuchung(k1, 500).start();
			new Zubuchung(k2, 1000).start();
			Thread t1 = new Umbuchung(k3, k1, 600);
			t1.start();
			
			warten();
			System.out.println(k1.getKontoStand());
		}
		
		
	}
	
	public static void drucke(Vector<Konto> konten) {
		System.out.println();
		for(Konto elem: konten) {
			System.out.println(elem.getKontoNr() + " : " + elem.getKontoStand());
		}
		System.out.println();
	}
	
	public static void warten() {
		while (Thread.activeCount() > 1) {
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
			}
		}
	}
	
	public static void pause() {
		int zz = (int) (Math.random() * 3000);
		try {
			Thread.sleep(zz);
		}
		catch (InterruptedException e) {
		}
	}
	
}

