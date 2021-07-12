package aufgaben;
import java.util.Scanner;

public class Aufgabe44 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input;

		System.out.println("Geben Sie eine ganze Zahl > 0 ein: ");
		input = sc.nextInt();
		if (input < 0) {
			System.out.println("Falsche Eingabe!\n");
		} else {
			System.out.println("Die Binärzahl lautet: " + decToBin(input));
		}
	}  

	public static String decToBin(int dec) {
		return Integer.toBinaryString(dec);
	}
}