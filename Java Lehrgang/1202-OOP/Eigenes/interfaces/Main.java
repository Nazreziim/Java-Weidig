package interfaces;

public class Main {
	public static void main(String[] args) {
		// Nicht zulässig da interface
		// Säugetier säugetier = new Säugetier();
		
		// Nicht zulässig
		// Mensch mensch = new Mensch();
		
		Ich ich = new Ich();
		
		ich.trinken(5);
		
		ich.essen();
		
		ich.bewegen();
		
		
		//Nicht zulässig, da das Alter final ist
		//ich.alter = 5;
		
		//Möglichkeite auf die Variablen direkt zuzugreifen
		//Nur lesen möglich
		//Über ich.lieblingsessen auch möglich jedoch nicht
		//direkt ersichtlich, dass es von Säugetier kommt
		System.out.println(Säugetier.lieblingsessen);
		System.out.println(ich.lieblingsessen);
		System.out.println(Säugetier.lieblingsessen == ich.lieblingsessen);
	}
}
