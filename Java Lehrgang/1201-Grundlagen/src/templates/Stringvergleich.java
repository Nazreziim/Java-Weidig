package templates;
import java.util.Scanner;

public class Stringvergleich {
	public static void main(String[] args) {
		String a = "a";
		String b = "b";
		//Das System pr�ft ob bereits ein identisches
		//Stringobjekt bereits vorhanden ist.
		//Ist eines vorhanden wird lediglich eine
		//Referenz auf den Speicher in der Variable
		//gespeichert somit zeigen beide auf die
		//gleiche Stelle im Speicher.
		
		Scanner sc = new Scanner(System.in);
		String c = sc.next();
		//Hierbei wird in jedem Fall ein neuer
		//Platz im Speicher belegt, da im Speicher
		//ein neues Stringobjekt erzeugt wird und
		//dieses erst im Anschluss den Scanner
		//durchl�uft und dann belegt wird.
		
		if(a == "a" && b == a) {
			//a und b zeigen beide auf die gleiche Adresse
			//(Referenzdatentypen "gro� geschriebene Variablentypen"
			//sind Objekte einer �bergeordneten Klasse.
			System.out.println("a und b sind gleich.");
			if(a == c && b == c) {
				//a und b haben gleiche Speicheradresse sind somit identisch
				//a/b und c sind verschiedene Objekte mit gleichem Inhalt
				//"2 gleiche Autos auf 2 verschiedenen Parkpl�tzen"
				//Daher ist a / b NICHT c
				System.out.println("a/b sind gleich c.");
			} else {
				System.out.println("a/b sind nicht gleich c.");
				if(a.equals(c) && b.equals(c)) {
					//.equals �berpr�ft den Inhalt des Referenzdatentyps
					//auf "�hnlichkeit" und liefer true wenn dies der Fall ist
					System.out.println("Die enthaltenen Werte sind gleich.");
				}
			}
		} else {
			System.out.println("Nein sind nicht gleich.");
		}
		
		
		sc.close();
	}
}
