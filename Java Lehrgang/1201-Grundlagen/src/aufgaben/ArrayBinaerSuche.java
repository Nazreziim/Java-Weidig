package aufgaben;

public class ArrayBinaerSuche {

	public static void main(String[] args) {
		int [] reihung = {8, 17, 21, 34, 56, 59, 65, 100, 103, 236};
		int gesuchteZahl = 17;
		
		int linkeGrenze = 0;
		int rechteGrenze = reihung.length - 1;
		int mitte = 0;
		boolean gefunden = false;
		
		if ( gesuchteZahl >= reihung[linkeGrenze] && gesuchteZahl <= reihung[rechteGrenze]){
			
			while ( !gefunden && linkeGrenze <= rechteGrenze){
				
				mitte = (linkeGrenze + rechteGrenze) / 2;
				
				if (reihung[mitte] == gesuchteZahl){
					gefunden = true;
				}
				else{
					
					if (gesuchteZahl < reihung[mitte]){
						rechteGrenze = mitte - 1;
					}
					else{
						linkeGrenze = mitte + 1;
					}
				}
				
			}
			
		}
		
		if (gefunden){
			System.out.printf("Die gesuchte Zahl: %d wurde gefunden.\n", gesuchteZahl);
		}
		else{
			System.out.printf("Die gesuchte Zahl: %d wurde nicht gefunden.\n", gesuchteZahl);
		}
		
	}

}
