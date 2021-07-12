public class Kontrollstrukturen {
	public static void main (String[] args) {
		
		//WHILE - kopfgesteuert
		int zahl = 10;
		
		while (zahl < 10) {
			System.out.println("Die Zahl ist: " + zahl);
			zahl++;
		}
		
		//WHILE - fußgesteuert
		do {
			System.out.println("Die Zahl ist: " + zahl);
			zahl++;
		}while (zahl < 10);
		
		//FOR-Schleife
		for (int i = 1; i < 10; i++) {
			System.out.println("Die Zahl ist: " + i);
		}
		
		
		//Verzweigung mit IF - ELSE IF - ELSE
		zahl = 50;
		
		if (zahl % 2 == 0 && zahl < 100) {
			System.out.println("Die Zahl ist gerade und kleiner als 100");
		}else if(zahl % 2 == 1 && zahl < 100) {
			System.out.println("Die Zahl ist ungerade und kleiner als 100");
		}else if (zahl % 2 == 0 && zahl >= 100) {
			System.out.println("Die Zahl ist gerade, aber gleich / groesser als 100");
		}else {
			System.out.println("Die Zahl ist ungerade und groesser als 100");
		}
		
		
		//VERZWEIGUNG mit SWITCH - CASE
		int menu = new java.util.Scanner(System.in).nextInt();
		
		switch (menu) {
		case 1:
			System.out.println("Sie moechten einen Benutzer anlegen");
			break;
		case 2:
			System.out.println("Sie moechten einen Benutzer aendern");
			break;
		default:
			System.out.println("Falsche Eingabe");
		}
	}
}
