package b4Polymorphie;

class Feldmuetze extends Kopfbedeckung {
	int nr;
	public Feldmuetze(String f) {
		this.nr = nummer++;
		this.farbe = f;
	}

	@Override
	public void printFarbe() {
		System.out.println("Die Feldmuetze Nr." + nr + " hat die Farbe " + farbe);
		
	}

}
