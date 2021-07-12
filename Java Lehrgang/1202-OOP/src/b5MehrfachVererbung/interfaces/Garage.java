package b5MehrfachVererbung.interfaces;

public class Garage extends Raum implements Parkplatz, Hafen{//, Cloneable {
	public static int anzahl = 0;
	public int plaetze = 1;
	public int garagenNr;

	public Garage(){
		this.garagenNr = ++anzahl;
	}
	
	@Override
	public Object clone() {
		Object copy = null;
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			System.err.println("Diese Klasse unterstützt kein Klonen.");
		}
		return copy;
	}

	@Override
	public void parken() {
		System.out.println(Parkplatz.test);
		System.out.println(Garage.test);
		System.out.println(this.test);
		// Garage.test = 101;
		System.out.println(Parkplatz.TEST);
		System.out.println(Garage.TEST);
		System.out.println(this.TEST);
		System.out.println(Parkplatz.KONST);
		System.out.println(Garage.KONST);
		System.out.println(this.KONST);

		System.out.println("Parken in Garage");
	}

}
