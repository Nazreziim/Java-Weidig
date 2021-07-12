package templates;



public class Template06KontrollstrukturIf {

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
		
		int tage = 0;
		int monat = 4;
		
		if ( (monat % 2 == 1 && monat <= 7) || (monat % 2 == 0 && monat >= 8) )
		{
			tage = 31;
		}
		else if (monat == 2)
		{
			tage = 28;
		}
		else
		{
			tage = 30;
		}
		
		System.out.printf("Es sind %d Tage für den Monat %d%n", tage, monat);
		
		// Bedingungsoperator 
		int wert1 = 100;
		int wert2 = 50;
		int maxWert = (wert1 > wert2) ?  wert1 : wert2;
		
		System.out.println("Der max. Wert ist: " + maxWert );
		
		
	}
	
}
