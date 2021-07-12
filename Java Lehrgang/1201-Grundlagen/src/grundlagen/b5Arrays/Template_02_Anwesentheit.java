package grundlagen.b5Arrays;

public class Template_02_Anwesentheit {

	enum Wochentage {MONTAG, DIENSTAG, MITTWOCH, DONNERSTAG, FREITAG, SAMSTAG, SONNTAG};
	
	public static void main(String[] args) {
		// Zeile fuer Wochentag
		// Spalte fuer Mitarbeiter
		// Komponente fuer Anwesenheit
		boolean [] [] liste = new boolean [7] [10];
		
		// schreibender und lesender Zugriff
		
		liste [Wochentage.MONTAG.ordinal()] [3] = true;
		
		for ( int tage = Wochentage.MONTAG.ordinal() ; tage < liste.length; tage++ ){
			
			for ( int mitarbeiter = 0; mitarbeiter < liste[tage].length; mitarbeiter++){
				
				if (tage % 3 == 0 && mitarbeiter % 2 == 0){
					liste [tage] [mitarbeiter] = true;
				}
			}
		}
		
		for ( int tage = Wochentage.MONTAG.ordinal() ; tage < liste.length; tage++ ){
			
			for ( int mitarbeiter = 0; mitarbeiter < liste[tage].length; mitarbeiter++){
				
				System.out.print(liste [tage][mitarbeiter]+ " ");
			}
			System.out.println();
		}
	}

}
