package ifthenelse;

public class ZahlenRaten {
	public static void main(String[] args) {
		int zahl = 5;
		int eingabe = HilfsMeth.readInt("Bitte raten Sie: ");
		//boolean richtig = false;
		if (eingabe == zahl) {
			System.out.println("Sie haben richtig geraten");
		} else {
			eingabe = HilfsMeth.readInt("Bitte raten Sie erneut: ");
			if (eingabe == zahl) {
				System.out.println("Sie haben richtig geraten");
			} else {
				eingabe = HilfsMeth.readInt("Bitte raten Sie ein letztes Mal: ");
				if (eingabe == zahl) {
					System.out.println("Sie haben richtig geraten");
				} else {
					System.out.println("Leider nicht gewonnen");
				}
			}
		}
	}
}

