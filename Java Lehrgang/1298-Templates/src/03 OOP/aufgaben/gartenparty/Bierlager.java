package aufgaben.gartenparty;

public class Bierlager {
	private Bierkiste[] kisten;
	private static Bierlager lager;
	
	private Bierlager() {
		int i = (int) (Math.random()*50 + 1);
		kisten = new Bierkiste[i];
		fuelleKisten();
	}
	
	public static Bierlager getBierlager() {
		if (lager == null) {
			lager = new Bierlager();
		} 
		return lager;
	}
	
	public Bierkiste[] getKisten() {
		return kisten;
	}

	private void fuelleKisten() {
		for (int i = 0; i < kisten.length; i++) {
			String name = createRandomString(6, "ernstlab");

			// Zufällige Anzahl Flaschen: Entweder 20 oder 24
			int anz = 0;
			if (Math.random() > 0.5) {
				anz = 20;
			} else {
				anz = 24;
			}
			// Zufälliger Alkoholgehalt zwischen 3 und 7 %
			double alk = ((int)((Math.random() * 4 + 3)*10)) / 10.0;
			kisten[i] = new Bierkiste(name,alk,anz);
		}
		
	}
	
	/**
	 * Diese Methode generiert einen zufälligen String
	 * @param len Die Länge des generierten Strings
	 * @param charSet Die Zeichen, aus denen der String gebildet wird
	 * @return
	 */
	private String createRandomString(int len, String charSet) {
        String result = "";
       
        while (result.length() < len) {
        	// Einen zufälligen char aus dem charSet auswählen
        	char c = charSet.charAt((int) (Math.random() * charSet.length()));
        	result = result + c;
        }
       
        return result;
    }
	
	public String toString() {
		String erg = "Das Bierlager enthaelt folgende Kisten: \n";
		for (Bierkiste k : kisten) {
			erg = erg + k.toString();
		}
		return erg;
	}


}
