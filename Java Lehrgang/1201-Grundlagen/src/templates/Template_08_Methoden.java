package templates;

public class Template_08_Methoden {
	// Aufbau von Methoden:
	// Modifier (Sichtbarkeit) --> public
	// static (optional [mehr bei OOP]) --> static
	// return Wert (void = keine Rückgabe) --> void
	// Bezeichner --> main
	// Parameter --> String[] args

	public static void main(String[] args) {
		int a = 1;
		int b = 2;

		add(a, b);
		System.out.println(addInt(a, b));
		int c = addInt(a, b);

		int start = 0;
		System.out.println(hui(start));

		add(a);

	}

	// Mgl 1: Direkte Ausgabe in der Methode
	public static void add(int zahl1, int zahl2) {
		System.out.println(zahl1 + zahl2);
		int c = zahl1 + zahl2;
		System.out.println(c);
	}

	// Mgl 2: Return einer Methode
	public static int addInt(int a, int b) {
		int c = a + b;
		return c;

	}

	// Mgl 3: Rechnung in der Rückgabe der Methode
	public static int addIntZwei(int a, int b) {
		return a + b;
	}

	// Mgl 4: Rekursion
	public static int hui(int c) {
		c++;
		while (c < 10) {
			hui(c++);
		}

		return c;
	}

	// Mgl 5: Überladung
	public static void add(int a) {
		System.out.println("Methode 'add' erfolgreich überladen! Ausgabe:" + a);
	}
}
