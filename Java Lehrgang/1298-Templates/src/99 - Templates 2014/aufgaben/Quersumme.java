public class Quersumme {
	public static void main(String[] args) {
		char[] array = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		long quersumme = 0;
		
		for (int zahl : array) {
			quersumme += zahl - '0';	
		}
		
		System.out.println("Die Quersumme der Zahlen betraegt: " + quersumme);
		
		quersumme = 0;
		
		for (int zahl : array) {
			quersumme += (zahl % 10) + (zahl / 10);	
		}
		
		System.out.println("Die Quersumme der Unicodewerte betraegt: " + quersumme);
	}
}
