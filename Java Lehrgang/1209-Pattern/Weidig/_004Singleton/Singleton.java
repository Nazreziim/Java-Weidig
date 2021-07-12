package _004Singleton;

public class Singleton {

	public static void main(String[] args) {
		// Funktioniert bei Singletons nicht da der Konstruktor nicht sichtbar ist
		// MichGibtsNurEinmal einmal = new MichGibtsNurEinmal();

		/*
		 * Der Zugriff auf Singletons geht direkt über die Klasse selbst da das Object,
		 * welches ich möchte, in der Klasse selbst definiert und über getInstance
		 * holbar ist.
		 */

		MichGibtsNurEinmal.getInstance(); // So erhalte ich das Objekt
		MichGibtsNurEinmal instanz1 = MichGibtsNurEinmal.getInstance(); // Zwischenspeichern ist dennoch möglich
		MichGibtsNurEinmal instanz2 = MichGibtsNurEinmal.getInstance(); // ACHTUNG

		// Liefert true, da es sich um die selben Objekte handelt
		System.out.println("Sind beides die gleichen Objekte?: " + instanz1.equals(instanz2));

		// liefert auch true da es keine spezielle .equals dafür gibt und die Objekte
		// wirklich identisch sind
		System.out.println("Sind beides die gleichen Objekte?: " + (instanz1 == instanz2));

		/*
		 * Dies bedeutet, dass egal wo und wie ich .getInstance aufrufe IMMER das
		 * gleiche Objekt nutze und ändere
		 */

		System.out.println("Name über instanz2 vor Änderung über instanz1: " + instanz2.getEinzigartigerName());
		
		//Zugriffs auf die Objekte egal über welche erzeugte Zwischeninstanz bewirken bei allen das gleiche
		instanz1.setEinzigartigerName("Frau Einzigartig");

		System.out.println("Name über instanz2 nach Änderung über instanz1: " + instanz2.getEinzigartigerName());
	}

}

class MichGibtsNurEinmal {
	// Die Klasse selbst hält ein Objekt von sich selbst als unveränderliche
	// Klassenvariable. Gem. Namenskonvention bezeichnet man dies als Instanz.
	private final static MichGibtsNurEinmal instance = new MichGibtsNurEinmal();
	private String einzigartigerName = "Herr Einzigartig";

	// DER KONSTRUKTOR IST PRIVATE! Das heißt, dass nur die Klasse selbst in sich
	// Objekte erzeugen kann
	private MichGibtsNurEinmal() {

	}

	// Das Objekt selbst erhält man über diese Methode .getInstance
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
