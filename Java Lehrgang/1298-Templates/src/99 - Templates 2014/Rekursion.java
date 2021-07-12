public class Rekursion {
	public static void main(String[] args) {
		bewege('a', 'b', 'c', 3);
	}
	
	public static int summe(int start, int ende) {
		System.out.println("Hier startet summe() mit start: " + start + "und ende: " + ende);
		int erg = 0;
		if (ende == 0) {
			return erg;
		}else {
			erg = summe(start, ende-1) + ende;
			return erg;
		}
	}
	
	public static boolean istPallindrom(String s) {
		if (s.length() <= 1) return true;
		
		s = s.toLowerCase();
		if (s.charAt(0) == s.charAt(s.length() - 1)) {
			String kurz = s.substring(1, s.length()-1);
			return istPallindrom(kurz);
		}else {
			return false;	
		}
	}
	
	private static void bewege(char a, char b, char c, int n) {
		if (n == 1)
			System.out.println("Lege die oberste Scheibe von Turm " + a + " auf Turm " + c + ".");
		else {
			bewege(a, c, b, n - 1);
			bewege(a, b, c, 1);
			bewege(b, a, c, n - 1);
		}
	}
}
