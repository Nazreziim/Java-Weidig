package aufgaben;
public class Aufgabe50 {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6 };
		int[] b = { 1, 2, 3, 4, 5, 6 };
		int[] c = { 1, 2, 3 };
		int[] d = { 1, 2, 3, 4, 5, 7 };

		arrayCheck(a, b);
		arrayCheck(a, c);
		arrayCheck(a, d);
	}

	public static void arrayCheck(int[] a, int[] b) {
		if (a.length != b.length) {
			System.out.println("Arrays haben unterschiedliche Längen");
			return;
		} else {
			for (int i = 0; i < a.length; i++) {
				if (a[i] != b[i]) {
					System.out.println("Die Arrays sind unterschiedlich");
					return;
				}
			}
			System.out.println("Die Array sind gleich!");
		}
	}
}
