public class binaer {
	public static void main(String[] args) {
		System.out.println("Zahl eingeben:");
		long zahl = new java.util.Scanner(System.in).nextLong();
		System.out.println("Basis des Zahlensystems eingeben:");
		int basis = new java.util.Scanner(System.in).nextInt();
		long dezimalzahl = 0;
		
		int i = 0;
		while(zahl > 0) {
			long bit = zahl % 10;
			dezimalzahl = dezimalzahl + bit * (long)Math.pow(basis, i);
			zahl = zahl / 10;
			i++;
		}
		
		System.out.println("Dezimalzahl: " + dezimalzahl);
	}
}
