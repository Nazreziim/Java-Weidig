package aufgaben;
import java.util.Scanner;

public class Aufgabe45 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int basis;
		int potenz;

		System.out.println("Geben Sie eine Zahl ein");
		basis = sc.nextInt();

		System.out.println("Geben Sie eine Potenz ein");
		potenz = sc.nextInt();

		System.out.println("45a: " + potenzierenA(basis, potenz));
		System.out.println("45b: " + potenzierenB(basis, potenz));
		System.out.println("45c: " + potenzierenC(basis, potenz));
	}

	// Aufg 45 A
	static public int potenzierenA(int basis, int potenz) {
		int res = basis;
		for (int i = 1; i < potenz; i++) {
			res *= basis;
		}
		return res;
	}

	// Aufg 45 B
	static public int potenzierenB(int basis, int potenz) {
		int res = basis;
		int temp = basis;

//		while (res < Math.pow(basis, potenz)) {
//			res += basis;
//		}

		for (int i = 0; i < potenz - 1; i++) {
			for (int j = 0; j < basis - 1; j++) {
				res += temp;
			}
			temp = res;
		}
		return res;
	}

	// Aufg 45 C
	static public int potenzierenC(int basis, int potenz) {
//		int res = 0;
//		while (res < Math.pow(basis, potenz)) {
//			res++;
//		}
//		return res;
//	}
		
		int res = basis;
		int temp = basis;
		for (int i = 0; i < potenz - 1; i++) {
			for (int j = 0; j < basis - 1; j++) {
				for(int k=0; k < temp; ++k) {
					res++;
				}
			}
			temp = res;
		}
		return res;
	}
}