package aufgaben;
import java.util.Scanner;

public class Aufgabe46 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int zahl;
		int res;

		res = getAnzahlZiffern(2542);
		System.out.printf("46a: Die Zahl 2542 hat eine Länge von %d\n", res);

		res = getZiffernWert(27381, 3);
		System.out.println("46b: " + res);
		res = getZiffernWert(27381, 0);
		System.out.println("46b: " + res);

		res = ersetzeZiffer(24135, 3, 7);
		System.out.println("46c: " + res);
	}

	// Aufg 46A
	public static int getAnzahlZiffern(int zahl) {
		int anzahl = 0;
		if (zahl > 10) {
			anzahl = getAnzahlZiffern(zahl / 10) + 1;
		} else {
			anzahl = 1;
		}
		return anzahl;
	}

	// Aufg 46B
	public static int getZiffernWert(int zahl, int stelle) {
		int wert = 0;
		if (stelle == 0) {
			wert = zahl % 10;
		} else {
			wert = getZiffernWert(zahl / 10, stelle - 1);
		}
		return wert;
	}

	// Aufg 46C
	public static int ersetzeZiffer(int zahl, int stelle, int wert) {
		int newRes = 0;
		if (stelle == 0) {
			newRes = zahl - (zahl % 10) + wert;
		} else {
			newRes = 10 * +ersetzeZiffer(zahl / 10, stelle - 1, wert) + (zahl % 10);
		}
		return newRes;
	}
}