package aufgaben;
import java.util.Arrays;
import java.util.Scanner;

public class Aufgabe41 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length;
		double[] arr;

		System.out.println("Wieviel Zahlen wollen Sie einlesen? (<10)");
		length = sc.nextInt();
		if (length > 10) {
			System.out.println("Falsche Eingabe! \n");
		} else {
			arr = new double[length];
			for (int i = 0; i < length; i++) {
				System.out.println("Geben Sie eine Zahl ein!");
				arr[i] = sc.nextDouble();
			}

			System.out.println("Wollen Sie den kleinsten oder größten Wert im Array sehen?\n1: Min\t2: Max");
			getMinMax(arr, sc.nextInt());
			getAverage(arr);
		}
	}

	public static void getMinMax(double[] array, int i) {
		if (i == 1) {
			System.out.printf("Der Min-Wert ist:\n%.2f\n", Arrays.stream(array).min().getAsDouble());
		} else if (i == 2) {
			System.out.printf("Der Max-Wert ist:\n%.2f\n", Arrays.stream(array).max().getAsDouble());
		} else {
			System.out.printf("Falsche Eingabe!\n");
		}
	}

	public static void getAverage(double[] array) {
		System.out.printf("Der Durchschnitt aller Werte ist:\n%.2f", Arrays.stream(array).average().getAsDouble());
	}
}