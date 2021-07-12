package aufgaben;
import java.util.Scanner;

public class Aufgabe48 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;

		System.out.println("Wie oft soll die Zahlenfolge laufen?");
		n = sc.nextInt();

		System.out.println("Das Ergenis ist: " + folge(0, 1, n));
	}

	public static int folge(int a, int b, int schritt) {
		switch (schritt) {
		case 1: {
			return a;
		}
		case 2: {
			return b;
		}
		case 3: {
			return (a + 1) + (b * 2);
		}
		default: {
			return folge(b, (a + 1) + (b * 2), schritt - 1);
		}
		}
	}
}
