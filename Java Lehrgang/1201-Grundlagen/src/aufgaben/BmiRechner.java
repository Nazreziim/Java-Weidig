package aufgaben;

public class BmiRechner {

	public static void main(String[] args) {
		
		final double MAX_BMI = 25.0; // Obergrenze - exklusiv
		double bmi = 0.0;
		double groesse = 0.0; 	// in Meter
		int gewicht = 0;		// in Kilogramm
		boolean bmiOk = false;
		
		// Programm-Ueberschrift ausgeben
		System.out.println("Berechnung Body-Mass-Index");
		System.out.println("==========================");
		
		// *********************************  Eingabeteil  ***********************************
		gewicht = HilfsMeth.readInt("Geben Sie bitte Ihr Gewicht in Kilogramm ein (Ganzzahlig):");
		groesse = HilfsMeth.readDouble("Geben Sie Ihre Groesse in Meter ein:");
		
		
		// ******************  Verarbeitungsteil  ******************************
		bmi = (double) gewicht / (groesse * groesse);
		
		if ( bmi < MAX_BMI ){
			bmiOk = true;
		}
		// Alternative		
		bmiOk = bmi < MAX_BMI;
		
		// *************************  Ausgabeteil  *****************************
		
		// Nachkomma-Anteil mit Punkt-Darstellung
		System.out.print("Ihr BMI ist: " + bmi);
		// formatierte Ausgabe, Nachkomma-Anteil mit Punkt-Darstellung
		System.out.print(String.format(" => %.2f%n", bmi).replace(',', '.'));
		// Alternative
		// formatierte Ausgabe, Nachkomma-Anteil mit Komma-Darstellung
		// System.out.printf(" => %.2f%n", bmi);
		
		if ( bmiOk ) {
			System.out.println("Ihr BMI ist Ok");
		}
		else{
			System.out.println("Ihr BMI ist NICHT Ok!");
		}

	}

}
