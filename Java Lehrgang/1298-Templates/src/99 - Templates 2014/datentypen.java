class Datentypen {
	public static void main (String[] args) {
		
		//CHARACTER
		
		char zeichen = 'A';
		int zahl = zeichen + 5;
		zeichen = (char)zahl;
		
		System.out.println(zeichen);
		
		//KONSTANTEN
		
		final int KONSTANTE_1 = 1;
		final int KONSTANTE_2;
		
		KONSTANTE_2 = 25;
		
		System.out.println(KONSTANTE_1 + KONSTANTE_2);
		
		//WAHRHEITSWERTE
		
		boolean wahr = true;
		boolean falsch = false;
		
		System.out.println(wahr || falsch);
		
		//SICHTBARKEIT/GÜLTIGKEIT
		
		{
			int sichtbar = 5;
			sichtbar = sichtbar + 10;
			sichtbar++;
			++sichtbar;
			
			{
				//int sichtbar = 4;  --> darf nicht erneut deklariert werden, da sie an dieser Stelle bereits bekannt ist
				System.out.println(sichtbar);
			}
			
			System.out.println(sichtbar);
		}
		
		int sichtbar = 10;
		System.out.println(sichtbar);
	}
}
	