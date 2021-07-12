package analyse;

public class Analyse02_1 {

	public static void main(String[] args) {

		char[] [] uebersicht = { {'T', 'e', 'i', 'l', 'n', 'e', 'h', 'm', 'e', 'r'},
								 {'U', 'e', 'b', 'e', 'r', 's', 'i', 'c', 'h', 't'},
								 {'V', 'e', 'r', 'f', 'u', 'e', 'g', 'u', 'n', 'g'},
								 {' ', ' ', 'B', 'a', 'd', 'e', 'h', 'o', 's', 'e'},
								 {'F', 'r', 'i', 'e', 'd', 'b', 'e', 'r', 'g', ' '},
								 {'E', 'h', 'e', 'm', 'a', 'n', 'n', ' ', ' ', ' '},
								 {' ', 'G', 'r', 'u', 'n', 'd', 'l', 'a', 'g', 'e'},
								 {'P', 'o', 'l', 'i', 'z', 'i', 's', 't', 'i', 'n'},
								 {' ', 'L', 'e', 'h', 'r', 'g', 'a', 'n', 'g', ' '},
								 {'H', 'u', 'g', 'e', 'n', 'd', 'u', 'b', 'e', 'l'}  };
		
		final char[] suchbegriff = {'B', 'i', 'e', 'r'};
		
		boolean gefunden = false;
		int zeile = 0;
		int suchIndex = 0;
		
		for ( int spalte = 0; spalte < uebersicht[0].length; spalte++){
			suchIndex = 0;
			zeile     = 0;
			
			while ( !gefunden && zeile < uebersicht.length ){
				
				if ( uebersicht [zeile] [spalte] == suchbegriff[suchIndex] ){
					suchIndex++;
				}
				else{
					suchIndex = 0;
				}
				
				if (suchIndex == suchbegriff.length){
					gefunden = true;
				}
				
				zeile++;
			}
		}
		
		System.out.println("Gefunden: " + gefunden);
	}


}
