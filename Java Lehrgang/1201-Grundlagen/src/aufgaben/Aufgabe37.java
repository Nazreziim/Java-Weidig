package aufgaben;
import java.util.Arrays;
import java.util.Scanner;

public class Aufgabe37 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] hexArr;
		int hexCharToInt = 0;
		int res = 0;

		System.out.println("Geben Sie eine Hexadezimalzahl in der Form:\nX'ABC'\nein:");
		hexArr = sc.next().toCharArray();

		if (hexArr[0] != 'X' || hexArr[1] != '\'' || hexArr[hexArr.length - 1] != '\'') {
			System.out.println("Falsche Eingabe");
		} else {

			hexArr = Arrays.copyOfRange(hexArr, 2, hexArr.length - 1);
			for (int i = hexArr.length - 1, j = 0; i >= 0; i--, j++) {

				try {
					hexCharToInt = Integer.parseInt(String.valueOf(hexArr[i]), 16);
				} catch (NumberFormatException e) {
					System.out.println("Falsche Eingabe");
					return;
				}

				res += hexCharToInt * Math.pow(16, j);
			}
			System.out.println("Ergebnis = " + res);
		}
	}
}