package _004Singleton;

public class Singleton {

	public static void main(String[] args) {
		// Funktioniert bei Singletons nicht da der Konstruktor nicht sichtbar ist
		// MichGibtsNurEinmal einmal = new MichGibtsNurEinmal();

		/*
		 * Der Zugriff auf Singletons geht direkt �ber die Klasse selbst da das Object,
		 * welches ich m�chte, in der Klasse selbst definiert und �ber getInstance
		 * holbar ist.
		 */

		MichGibtsNurEinmal.getInstance(); // So erhalte ich das Objekt
		MichGibtsNurEinmal instanz1 = MichGibtsNurEinmal.getInstance(); // Zwischenspeichern ist dennoch m�glich
		MichGibtsNurEinmal instanz2 = MichGibtsNurEinmal.getInstance(); // ACHTUNG

		// Liefert true, da es sich um die selben Objekte handelt
		System.out.println("Sind beides die gleichen Objekte?: " + instanz1.equals(instanz2));

		// liefert auch true da es keine spezielle .equals daf�r gibt und die Objekte
		// wirklich identisch sind
		System.out.println("Sind beides die gleichen Objekte?: " + (instanz1 == instanz2));

		/*
		 * Dies bedeutet, dass egal wo und wie ich .getInstance aufrufe IMMER das
		 * gleiche Objekt nutze und �ndere
		 */

		System.out.println("Name �ber instanz2 vor �nderung �ber instanz1: " + instanz2.getEinzigartigerName());
		
		//Zugriffs auf die Objekte egal �ber welche erzeugte Zwischeninstanz bewirken bei allen das gleiche
		instanz1.setEinzigartigerName("Frau Einzigartig");

		System.out.println("Name �ber instanz2 nach �nderung �ber instanz1: " + instanz2.getEinzigartigerName());
	}

}

class MichGibtsNurEinmal {
	// Die Klasse selbst h�lt ein Objekt von sich selbst als unver�nderliche
	// Klassenvariable. Gem. Namenskonvention bezeichnet man dies als Instanz.
	private final static MichGibtsNurEinmal instance = new MichGibtsNurEinmal();
	private String einzigartigerName = "Herr Einzigartig";

	// DER KONSTRUKTOR IST PRIVATE! Das hei�t, dass nur die Klasse selbst in sich
	// Objekte erzeugen kann
	private MichGibtsNurEinmal() {

	}

	// Das Objekt selbst erh�lt man �ber diese Methode .getInstance
	public static MichGibtsNurEinmal getInstance() {
		return instance;
	}

	public void setEinzigartigerName(String einzigartigerName) {
		this.einzigartigerName = einzigartigerName;
	}

	public String getEinzigartigerName() {
		return einzigartigerName;
	}
}
