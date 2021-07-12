package grundlagen.b7RekursiveMethoden;

public class Template_08_Rekursion
{
	public static void main(String[] args)
	{
		System.out.print("Bitte Wert eingeben, dessen Fakultaet berechnet werden soll: ");
		int zahl = new java.util.Scanner(System.in).nextInt();
		
		System.out.println("Fakultaet von " + zahl + " = " + fak(zahl));
	}
	
	public static int fak(int a)
	{
		 // 1. Ergebnisvariable anlegen
		 int erg = 0;
		 
		 // 3. Berechnung
		 // 3.1. Abbruchkriterium / Rekursionsende festlegen
		 if( a == 1)
		 {
		 	erg = 1;	 
		 }
		 // 3.2. Rekursionsschritt festlegen
		 else
		 {
		 	erg = a * fak(a - 1);	 
		 }
		 
		 
		 // 2. Ergebnisvariable zurückgeben
		 return erg;
	}
}