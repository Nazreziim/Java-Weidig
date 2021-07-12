package aufgabe13;

public class Amphibie extends Auto implements Amphibienfahrzeug {

	private Schiff wasserfahrzeug;

	public Amphibie(double gewicht, double tiefgang, int anzahlRaeder) {
		super(anzahlRaeder, gewicht);
		wasserfahrzeug = new Schiff(gewicht, tiefgang);
	}

	@Override
	public double getGewicht() {
		return super.getGewicht();
	}

	@Override
	public double getTiefgang() {
		return wasserfahrzeug.getTiefgang();
	}

	@Override
	public String toString() {
		return String.format("Amphibie:\nGewicht: %s, Anzahl Räder: %s, Tiefgang: %s", getGewicht(), getAnzahlRaeder(),
				getTiefgang());
	}

}
