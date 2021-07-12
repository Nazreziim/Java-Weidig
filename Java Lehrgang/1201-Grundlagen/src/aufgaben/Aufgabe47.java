package aufgaben;
import java.util.Scanner;

public class Aufgabe47 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		int res;

		System.out.println("Geben Sie zwei Zahlen ein: ");
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.printf("Der GGT von %d und %d ist: %d", a, b, ggt(a, b));

	}

	public static int ggt(int zahl1, int zahl2) {
		if (zahl2 == 0) {
			return zahl1;
		} else if (zahl1 == 0) {
			return zahl2;
		} else if (zahl1 > zahl2) {
			return ggt((zahl1 - zahl2), zahl2);
		} else {
			return ggt(zahl1, (zahl2 - zahl1));
		}
	} 
}