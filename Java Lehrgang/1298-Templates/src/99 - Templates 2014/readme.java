use HilfsMeth;

class ReadMe {
	public static void main(String[] args) {
		System.out.println("Bitte eine Zahl eingeben");
		HilfsMeth hilfe = new HilfsMeth();
		int zahl_hilf = hilfe.readInt();
		int zahl = new java.util.Scanner(System.in).nextInt();
		if (zahl < 100) {
		}
		else if (zahl < 1000) {
			if (zahl < 500 && zahl >= 400) {
				System.out.println("Was mit 4");
			} else {
				System.out.println("Was ohne 4");				
			}
		} else
			System.out.println("Ist mir zu viel");
	}
}
