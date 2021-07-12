package aufgaben;
import java.util.Arrays;
import java.util.Scanner;

public class Aufgabe52 {

	public static void main(String[] args) {
		int[] arr = new int[5];

		fillArray(arr);
		printArray(arr);
		getSumme(arr);
		getMAx(arr);
	}

	public static void fillArray(int[] arr) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("Geben Sie den %d. Wert für das Array ein\n", i + 1);
			arr[i] = sc.nextInt();
		}
	}

	public static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static void getSumme(int[] arr) {
		System.out.println("Die Summe aller Elemente ist: " + Arrays.stream(arr).sum());
	}

	public static void getMAx(int[] arr) {
		System.out.println("Das größte Element ist: " + Arrays.stream(arr).max().getAsInt());
	}
}
