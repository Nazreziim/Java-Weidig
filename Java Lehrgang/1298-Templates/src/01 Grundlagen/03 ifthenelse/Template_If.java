package ifthenelse;

public class Template_If {

	public static void main(String[] args) {
		
		// 1. Beispiel
		boolean istSchoen = false;		
		//  Aufbau: if (Ausdruck, der zu einem boolean-Wert ausgewertet werden kann)		
		if (istSchoen == true) {
			// Das wird gemacht, wenn in der Klammer oben "true" steht
			System.out.println("Das Wetter ist heute super!");
		}
		if (istSchoen == false) {
			// Das wird gemacht, wenn in der Klammer oben "true" steht
			System.out.println("Das Wetter ist heute doof!");
		}
		
		
		
		// 2. Beispiel
		char zeichen = 'X';
		if (zeichen == 'A') {  // zeichen muss hier mit einem anderen char-Wert verglichen werden (Äpfel / Birnen ;-)
							   // sonst kommt kein boolean-Wert bei der Auswertung heraus
			System.out.println("Der Buchstabe ist ein A");  // das wird bei true gemacht!
		} else {  // das wird bei false gemacht
			System.out.println("Kein A - oder auch !A - deswegen setze ich jetzt zeichen auf A");
			zeichen = 'A';
		}
				
		System.out.println(zeichen);
		
		
		// 3. Beispiel
		zeichen = 'O';
		if ( zeichen == 'A' || 
			 zeichen == 'E' || 
		     zeichen == 'I' || 
		     zeichen == 'O' || 
		     zeichen == 'U') {  							
			System.out.println("Der Buchstabe ist ein Vokal");  // das wird bei true gemacht!
		} else {  // das wird bei false gemacht
			System.out.println("Der Buchstabe ist ein Konsonant");			
		}
				
		System.out.println(zeichen);
		
		
		//4. Beispiel
		int zahl = 0;
		if (zahl < 0) {
			System.out.println("Die Zahl ist kleiner als 0");
		} else if (zahl > 0) {
			System.out.println("Die Zahl ist größer als 0");
		} else {
			System.out.println("Die Zahl ist 0");
		}
		
		/* So geht's natürlich auch
		if (zahl < 0) {
		}
		if (zahl > 0) {
		} else { // (zahl == 0) !
			
		}*/
		
	}
	
}
