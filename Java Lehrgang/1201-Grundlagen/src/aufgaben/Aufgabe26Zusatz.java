package aufgaben;

import java.util.Scanner;

public class Aufgabe26Zusatz {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		// a)
		// Eingabe
		System.out.println("Zahl:");
		int n = scanner.nextInt();
		int i = 1;

		// Z�hle von 1 bis n
		for (i = 1; i <= n; i++) {

			// Erzeuge einen extra Abstand abh�ngig von n und z�hle von n bis i abw�rts
			for (int abstand = n; abstand >= i; abstand--) {
				System.out.print("  ");
			}

			// Z�hle von 1(zwischenspeicher) bis i und gib es i mal aus
			for (int zwischenspeicher = 1; zwischenspeicher <= i; zwischenspeicher++) {

				// Solange i unter 10 erzeuge einen extra Abstand vor der Zahl
				if (i < 10) {
					System.out.print(" ");
				}
				// Nimm den aktuellen i Wert und gebe diesen mit Abstand aus
				System.out.print(i + "   ");
			}

			// Erzeuge einen Absatz nachdem alle Zahlen ausgegeben wurden
			System.out.println("");
		}

		// b)
		// Eingabe
		System.out.println("\nZahl:");
		i = 1;
		n = scanner.nextInt();

		// Z�hle von 1(i) bis n
		while (i <= n) {
			// initialisiere zwischenspeicher immer mit 1
			int zwischenspeicher = 1;
			int abstand = n;

			// Erzeuge einen extra Abstand abh�ngig von n(in abstand zwischengespeichert)
			while (abstand >= i) {
				// und z�hle von n bis i abw�rts
				abstand--;
				System.out.print("  ");
			}

			// Z�hle von 1(zwischenspeicher) bis i und gib es i mal aus
			while (zwischenspeicher <= i) {
				// Solange i unter 10 erzeuge einen extra Abstand vor der Zahl
				if (i < 10) {
					System.out.print(" ");
				}
				// Nimm den aktuellen i Wert und gebe diesen mit Abstand aus
				System.out.print(i + "   ");

				// Z�hloperator f�r zwischenspeicher-while Schleife
				zwischenspeicher++;
			}

			// Erzeuge einen Absatz nachdem alle Zahlen ausgegeben wurden
			System.out.println("");

			// Z�hloperator f�r f�r 1(i) bis n-while Schleife
			i++;
		}

		// c)
		// Eingabe
		System.out.println("\nZahl:");
		i = 1;
		n = scanner.nextInt();
		// Z�hle von 1(i) bis n (Siehe while Schleife am Ende der Anweisung)
		do {
			// initialisiere zwischenspeicher immer mit 1
			int zwischenspeicher = 1;
			int abstand = n;

			// Erzeuge einen extra Abstand abh�ngig von n(in abstand zwischengespeichert)
			do {
				// und z�hle von n bis i abw�rts
				abstand--;
				System.out.print("  ");
			} while (abstand >= i);

			do {
				// Solange i unter 10 erzeuge einen extra Abstand vor der Zahl
				if (i < 10) {
					System.out.print(" ");
				}
				// Nimm den aktuellen i Wert und gebe diesen mit Abstand aus
				System.out.print(i + "   ");
				// Z�hloperator f�r zwischenspeicher-do-while Schleife
				zwischenspeicher++;
			} while (zwischenspeicher <= i);

			// Erzeuge einen Absatz nachdem alle Zahlen ausgegeben wurden
			System.out.println("");

			// Z�hloperator f�r f�r 1(i) bis n-do-while Schleife
			i++;
		} while (i <= n);
	}
}