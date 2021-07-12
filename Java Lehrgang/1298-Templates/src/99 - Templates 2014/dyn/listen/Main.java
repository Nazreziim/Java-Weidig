public class Main {

	public static void main(String[] args) {
		Liste liste1 = new Liste();
		liste1.einfuegen_vorne(0);
		liste1.einfuegen_vorne(1);
		liste1.einfuegen_vorne(2);
		liste1.einfuegen_vorne(3);
		
		Liste liste2 = new Liste();
		/*liste2.einfuegen_hinten(0);
		liste2.einfuegen_hinten(1);
		liste2.einfuegen_hinten(3);
		liste2.einfuegen_hinten(5);
		liste2.einfuegen_hinten(7);
		
		//System.out.println(liste1);
		System.out.println(liste2);
		
		//durchlaufen_iter(liste1);
		//durchlaufen_rek(liste2.getStart());
		
		/*liste2.einfuegen_sort_iter(6);
		
		System.out.println(liste2);
		
		liste2.einfuegen_sort_iter(8);
		
		System.out.println(liste2);
		
		liste2.einfuegen_sort_iter(-1);
		
		System.out.println(liste2);*/
		
		//liste2.einfuegen_sort_iter(5);
		liste2.einfuegen_sort_rek(liste2.getStart(), 6);
		
		System.out.println(liste2);
	}
	
	public static void durchlaufen_iter(Liste liste) {
		if(liste.getStart() == null)
			System.out.println("Leere Liste");
		else {
			ListElem hilfZeiger = liste.getStart();
			System.out.println("1. Wert: " + hilfZeiger.getWert());
			
			int zaehler = 2;
			
			while(hilfZeiger.getNaechster() != null) {
				hilfZeiger = hilfZeiger.getNaechster();
				System.out.println(zaehler + ". Wert: " + hilfZeiger.getWert());
				zaehler++;
			}
		}
	}
	
	public static void durchlaufen_rek(ListElem elem) {
		/*if(elem == null) {
			System.out.println("Leere Liste");
		}else {
			System.out.println("Wert: " + elem.getWert());
			if(elem.getNaechster() != null) {
				durchlaufen_rek(elem.getNaechster());
			}
		}*/
		
		if (elem != null) {
			System.out.println("Wert: " + elem.getWert());
			durchlaufen_rek(elem.getNaechster());
		}
	}
	
	

}
