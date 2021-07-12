public class Hanoi {
	public static void main(String[] args) {
		//Einlesen der Anzahl der Scheiben
		int n = Integer.parseInt(args[0]);
		
		//Initialisierung von drei Türmen
		int [][] tuerme = new int[3][n+1];
		// Array zum Mitzählen
		int [] anzahlAufTuermen = {n, 0, 0};
		// Ausgangskonfiguration
		int pS=0; 
		int pos1, pos2;
		// kleinste Scheibe auf Turm 0
		for (int i=0; i<n+1; ++i) tuerme[0][i] = n+1-i;
		
		tuerme[1][0] = n+1; 
		tuerme[2][0] = n+1;
		
		while(tuerme[2][n]!=1) {
			System.out.printf("Kleinste Scheibe von %d nach %d\n", pS, (pS+2)%3);
			//kleinste Scheibe vom Turm 0 nehmen
			tuerme[pS][anzahlAufTuermen[pS]--] = 0;
			//kleinste Scheibe auf Turm 2 legen
			pS = (pS+2)%3;
			tuerme[pS][++anzahlAufTuermen[pS]] = 1;
			
			//Ermitteln, von welchem Turm (pos2) die andere Scheibe verschoben werden muss
			if (tuerme[(pS+1)%3][anzahlAufTuermen[(pS+1)%3]]>tuerme[(pS+2)%3][anzahlAufTuermen[(pS+2)%3]]) {
				pos2 = (pS+2)%3;
			}else {
				pos2 = (pS+1)%3;
			}
			// Verschiebung an die einzig mögliche Position (pos1)
			pos1 = 2*(pS+pos2) % 3;
			if (tuerme[pos1][anzahlAufTuermen[pos1]] != tuerme[pos2][anzahlAufTuermen[pos2]]) {
				System.out.printf("-------> andere Scheibe von %d nach %d\n", pos2, pos1);
				tuerme[pos1][++anzahlAufTuermen[pos1]] = tuerme[pos2][anzahlAufTuermen[pos2]];
				tuerme[pos2][anzahlAufTuermen[pos2]--] = 0;
			}
		}	
	}
}
