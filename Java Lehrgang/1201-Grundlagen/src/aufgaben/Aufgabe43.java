package aufgaben;
import java.util.Scanner;

public class Aufgabe43 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input;
		System.out.println("Geben Sie eine Zahl ein, von der Sie die Querumme generieren möchtne:");
		input = sc.nextInt();

		System.out.println("Das Ergebnis ist: " + quer(input));
	}

	public static int quer(int number) {
		int sum = 0;
		while (0 != number) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}
}