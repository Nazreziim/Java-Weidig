package interfaces;

public class Main {
	public static void main(String[] args) {
		// Nicht zul�ssig da interface
		// S�ugetier s�ugetier = new S�ugetier();
		
		// Nicht zul�ssig
		// Mensch mensch = new Mensch();
		
		Ich ich = new Ich();
		
		ich.trinken(5);
		
		ich.essen();
		
		ich.bewegen();
		
		
		//Nicht zul�ssig, da das Alter final ist
		//ich.alter = 5;
		
		//M�glichkeite auf die Variablen direkt zuzugreifen
		//Nur lesen m�glich
		//�ber ich.lieblingsessen auch m�glich jedoch nicht
		//direkt ersichtlich, dass es von S�ugetier kommt
		System.out.println(S�ugetier.lieblingsessen);
		System.out.println(ich.lieblingsessen);
		System.out.println(S�ugetier.lieblingsessen == ich.lieblingsessen);
	}
}
