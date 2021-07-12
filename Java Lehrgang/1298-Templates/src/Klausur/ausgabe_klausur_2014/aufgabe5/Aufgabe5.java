package ausgabe_klausur_2014.aufgabe5;
/**
*Name:
*DG:
*/

public class Aufgabe5 {

	public static void main(String[] args) {
		// Teil 1. und 2.
		Torwart neuer = new Torwart("Manuel Neuer",1);
		System.out.println(neuer);
		Feldspieler mertesacker = new Feldspieler("Per Mertesacker", 17);
		Feldspieler lahm = new Feldspieler("Philipp Lahm");
		System.out.println(lahm);
		System.out.println(new Feldspieler("Lukas Podolski", 21, 100));   // der ist wirklich sehr stark!
		
		
		// Teil 3. und 4.
		Weltmeisterschaft wm = new Weltmeisterschaft(); 
		System.out.println(wm);
		
		System.out.println("1. Runde: 32 -> 16 Mannschaften -----------------------------");
		wm.naechsteRunde();
		System.out.println("2. Runde: 16 -> 8 Mannschaften ------------------------------");
		wm.naechsteRunde();
		System.out.println("3. Runde: 8 -> 4 Mannschaften -------------------------------");
		wm.naechsteRunde();
		System.out.println("4. Runde: 4 -> 2 Mannschaften -------------------------------");
		wm.naechsteRunde();
		System.out.println("5. Runde: 2 -> 1 Mannschaften -------------------------------");
		wm.naechsteRunde();
		System.out.println("Sieger ist: " + wm.getTeams()[0].getLand());

	}



}
