class Schiffchen extends Kopfbedeckung {
	int nr;
	
	public Schiffchen(String f) {
		this.nr = Kopfbedeckung.nummer++;
		this.farbe = f;
	}

	@Override
	public void printFarbe() {
		System.out.println("Das Schiffchen Nr. " + nr + " hat die Farbe " + farbe);
		
	}
	
}
