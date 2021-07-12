package methoden;
class HanoiRek {
	private static void bewege(char a, char b, char c, int n) {
		if (n == 1)
			System.out.println("Lege die oberste Scheibe von " + "Turm " + a
					+ " auf Turm " + c + ".");
		else {
			bewege(a, c, b, n - 1);
			bewege(a, b, c, 1);
			bewege(b, a, c, n - 1);
		}
	}

	public static void main(String[] args) {
		bewege('a', 'b', 'c', 5);
	}

}