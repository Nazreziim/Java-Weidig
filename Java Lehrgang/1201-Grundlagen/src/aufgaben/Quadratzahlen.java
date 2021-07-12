package aufgaben;

public class Quadratzahlen{

	public static void main(String[] args){
	
		int eingabeWert = 8;
		int ergebnis = 0;
		
		ausgabeZahlen();
		
		//ausgabeZahlen(5);
		
		//ausgabeZahlen(3);
		
		//ausgabeZahlen(eingabeWert);
		
		ergebnis = quadrat(eingabeWert);
		
		System.out.println(ergebnis);
		
		System.out.println("Quadratzahl: " + quadrat(eingabeWert));
			
	}
	
	public static int quadrat(int zahl)
	{
		int ergebnis = 0;
		
		ergebnis = zahl * zahl;
		
		return ergebnis;
	}
	
	public static void ausgabeZahlen()
	{
		// ausgabeZahlen(10); Alternative
		for( int i = 1; i <= 10; i++)
		{
			System.out.print(i + " ");
		}	
		System.out.println();
	}
	
	public static void ausgabeZahlen(int endWert)
	{
		for( int i = 1; i <= endWert; i++)
		{
			System.out.print(i + " ");
		}	
		System.out.println();
	}
}
