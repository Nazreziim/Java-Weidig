package grundlagen.b4Schleifen;

class Prim {
	public static void main(String[]args) {
		int count = 0;
		for(int i = 2; i < 1000000; i++) {
			// Durchlaufen aller möglichen Teiler
			int teiler = (int) Math.pow(i, 0.5);			
			boolean isPrim = true;
			for(int j = 2; j <= teiler; j++) {
				if (i % j == 0) {
					isPrim = false; // wenn ein Teiler zutrifft ist es keien Primzahl mehr
				}				
			}
			if (isPrim) {
				// Anzahl inkrementieren und Zahl ausgeben
				count++;
				System.out.println("ist prim: "+i);
			}
		}
		System.out.printf("Es wurden %d Primzahlen gefunden.",count);
	}
}
