package aufgaben;
import java.util.Scanner;

public class Aufgabe49 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;

		System.out.println("Bitte n eingeben (n>0): ");
		n = sc.nextInt();
		if (n == 0) {
			System.out.println("Falsche Eingabe!");
		} else {
			System.out.printf("Die %d. FibonacciZahl lautet: %d", n, fibonacci(n));
		}
	}

	public static int fibonacci(int n) {
		int erg = 0;
		if (n == 1 || n == 2) {
			erg = 1;
		} else {
			erg = fibonacci(n - 1) + fibonacci(n - 2);
		}
		return erg;
	}
}
