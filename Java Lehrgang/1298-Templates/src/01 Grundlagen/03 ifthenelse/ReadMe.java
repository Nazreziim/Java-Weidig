package ifthenelse;

public class ReadMe {
	public static void main(String[] args) {
		int zahl = HilfsMeth.readInt("Zahl");
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

