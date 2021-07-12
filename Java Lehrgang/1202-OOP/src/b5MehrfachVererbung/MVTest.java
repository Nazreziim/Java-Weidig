package b5MehrfachVererbung;

//Interface Schnitt1
interface Schnitt1 {
	/* Konstanten VAR1 und VAR2 */
	public static final int VAR1 = 1;
	public static final int VAR2 = 2;

	/* Methode setWert mit einem Übergabeparameter vom Datentyp int */
	public void setWert(int wert);
}

// Interface Schnitt2
interface Schnitt2 {
	/*
	 * Konstanten VAR1 und VAR3 (VAR1 ist schon im Interface Schnitt1
	 * deklariert)
	 */
	public static final int VAR1 = 3;
	public static final int VAR3 = 4;

	/*
	 * Methode setWert mit einem Übergabeparameter vom Datentyp int (identisch
	 * mit der Methode aus Schnitt1)
	 */
	public void setWert(int wert);
}

/* Startklasse Test, die unsere Interfaces Schnitt1 u. Schnit2 einbindet */
public class MVTest implements Schnitt1, Schnitt2 {
	/* lokal definierte Konstante VAR1 */
	private static final int VAR1 = 10;

	/* implementierte Methode aus dem Interface Schnitt1 und Schnitt2 */
	public void setWert(int wert) {
		/* Anweisungen */
	}

	// main-Methode
	public static void main(String[] args) {
		/* Ausgabe der Konstanten, wie lautet hier die Ausgabe? */
		System.out.println(VAR1);
		System.out.println(VAR2);
		System.out.println(VAR3);
		System.out.println(Schnitt1.VAR1);
		System.out.println(Schnitt2.VAR1);
	}
}
