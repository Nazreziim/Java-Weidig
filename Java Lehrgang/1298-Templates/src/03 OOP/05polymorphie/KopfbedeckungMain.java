public class KopfbedeckungMain {
	
	public static void main(String[] args) {
		Kopfbedeckung[] huete = generateHuete();
		
		
		// Kopfbedeckungen anschauen:
		for (Kopfbedeckung k : huete) {
			k.printFarbe();
		}

	}

	
	/**
	 * Ein Kopfbedeckungsgenerator für 100 Hüte!
	 * @return
	 */
	private static Kopfbedeckung[] generateHuete() {
		Kopfbedeckung[] huete = new Kopfbedeckung[100];
		for (int i = 0 ; i < huete.length; i++) {
			if (Math.random() > 0.5 ) {
				huete[i] = new Feldmuetze("gruen");
			} else {
				huete[i] = new Schiffchen("blau");
			}
		}
		return huete;
	}

}
