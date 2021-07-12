public class Nullen {
	public static void main(String[] args) {
		System.out.println("Zahl eingeben!");
		int zahl = new java.util.Scanner(System.in).nextInt();
		
		System.out.println(zahlMitNullen(zahl));
	}
	
	public static int zahlMitNullen (int zahl) {
		if (Math.abs(zahl) < 100) return 0;
		
		int i = 0;
		while (i < 2) {
			zahl /= 10;
			i++;
		}
		
		return zahl * (int)Math.pow(10, i);
	}
}
