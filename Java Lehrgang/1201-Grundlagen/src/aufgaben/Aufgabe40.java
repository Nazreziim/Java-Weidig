package aufgaben;
import java.util.Scanner;

public class Aufgabe40 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("40a: " + addieren(1.0, 2.0, 3.0));

		System.out.println("Geben Sie die Zahl n für Cubes ein: ");
		cube(sc.nextInt());

		System.out.println();
		System.out.println("Geben Sie die erste Zahl für GGT ein: ");
		int i = sc.nextInt();
		System.out.println("Geben Sie die zweite Zahl für GGT ein: ");
		int j = sc.nextInt();
		System.out.println("40c: " + ggt(i, j));

		System.out.println("Geben Sie ein Jahr ein: ");
		int year = sc.nextInt();
		System.out.printf("40d: %d ist %s Schaltjahr\n", year, (isLeapYear(year) ? "ein" : "kein"));

		System.out.println("40e: ");
		displayStatus();
	}

	public static double addieren(double a, double b, double c) {
		return a + b + c;
	}

	public static void cube(int n) {
		int res = 0;
		for (int i = 0; i <= n; i++) {
			res += Math.pow(i, 3);
		}
		System.out.println("40b: " + res);
		;
		return;
	}

	public static int ggt(int i, int j) {
		while (j != 0) {
			if (i > j) {
				i = i - j;
			} else {
				j = j - i;
			}
		}
		return i;
	}

	public static boolean isLeapYear(int year) {
		boolean leap = false;
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			leap = true;
		} else {
			leap = false;
		}
		return leap;
	}

	public static void displayStatus() {
		System.out.println("Status 404");
	}
}