package baeume;

public class Template01Baum {

	public static void main(String[] args) {
		Baum01 baum = new Baum01();
		
		// Einfuegen von Werten
		baum.einfuegen(38, 'A');
		baum.einfuegen(14, 'B');
		baum.einfuegen(56, 'C');
		baum.einfuegen(45, 'D');
		baum.einfuegen(23, 'E');
		baum.einfuegen( 8, 'F');
		baum.einfuegen(18, 'G');
		baum.einfuegen(82, 'H');
		baum.einfuegen(70, 'I');
		baum.einfuegen(37, 'J');
		
		/****************************************************************************************
		 * Aufgaben
		 */
		// Anzahl Elemente im Baum
		System.out.printf("Es sind %02d Knoten im Baum vorhanden.\n", baum.anzahlKnoten());
		// Anzahl Blaetter im Baum
		System.out.printf("Es sind %02d Blaeter im Baum vorhanden.\n", baum.anzahlBlaetter());
		
		// Tiefe des Baums
		System.out.printf("Die Tiefe des Baums ist %02d.\n", baum.hoehe());
		
		//****************************************************************************************
		
		// Ausgaben Baum
		baum.ausgabeInOrder();
		
		baum.ausgabePreOrder();
		
		baum.ausgabePostOrder();
		
		baum.ausgabeInfo();
		
		// loeschen im Baum
		// 1. Fall: ein Blatt loeschen
		System.out.println("loesche key 8 aus Baum (ein Blatt loeschen)");
		baum.loeschen(8);	
		baum.ausgabePreOrder();
		
		// 2. Fall: linken Sohn entfernen
		System.out.println("loesche key 70 aus Baum (linken Sohn entfernen)");
		baum.loeschen(70);
		baum.ausgabePreOrder();
		
		// 3. Fall: rechter Sohn entfernen
		System.out.println("loesche key 37 aus Baum (rechten Sohn entfernen)");
		baum.loeschen(37);
		baum.ausgabePreOrder();
		
		// 4. Fall: rechter Sohn entfernen
		System.out.println("loesche key 56 aus Baum (besitzt rechten und linken Sohn)");
		baum.loeschen(56);
		baum.ausgabePreOrder();
		
		
		// Anzahl Elemente im Baum
		System.out.printf("Es sind %02d Knoten im Baum vorhanden.\n", baum.anzahlKnoten());

	}

}
