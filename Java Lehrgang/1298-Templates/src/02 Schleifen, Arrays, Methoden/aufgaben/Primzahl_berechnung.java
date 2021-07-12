package aufgaben;


public class Primzahl_berechnung {

	/**
	 * Eine ganze Zahl n > 1 heisst Primzahl, falls sie nur durch 1
	 * und sich selbst ohne Rest teilbar ist.
	 * z.B.: zahl 10
	 * 10 % 2 =  Rest 0 => ist teilbar durch 2 und somit keine Primzahl
	 * 
	 * 7  % 2 =  Rest 1 => dann teiler erhoehen
	 * 7  % 3 =  Rest 1 => dann teiler erhoehen
	 * 7  % 4 =  Rest 3 => teiler ist groesser als die Haelfte der Zahl,
	 *                     dann ist keine Teilung ohne Rest mehr moeglich, beenden!  
	 * @param args
	 */
	public static void main(String[] args) {
		boolean istPrimzahl = true;
		int untersuchte_zahl = 0;
		int teiler = 2;
		
		System.out.println("Primzahl-Berechnung");
		untersuchte_zahl = HilfsMeth.readInt("Geben Sie eine positive Zahl ein: ");
			
		while ( teiler <= (untersuchte_zahl/2) && istPrimzahl)
		{			
			if (( untersuchte_zahl % teiler) == 0 ) // teilbar
			{
				istPrimzahl = false;
			}
			else  // nicht teilbar
			{
				teiler++;
			}			
		}	
		
		if (istPrimzahl)
		{
			System.out.printf("Die Zahl: %3d ist eine Primzahl.\n",untersuchte_zahl );
		}
		else
		{
			System.out.printf("Die Zahl: %3d ist k e i n e  Primzahl.\n",untersuchte_zahl );
		}
	}
}
