package ifthenelse;

public class Vokale {
	public static void main(String[] args) {
		//int zeichen = HilfsMeth.readChar("Zeichen: ");
		char zeichen = 'i';
		switch (zeichen) {
			case 'a': case 'A':
				System.out.println("Eingabe war A");
			case 'e': case 'E':
				System.out.println("Eingabe war E");
			case 'i':
			case 'I':
				System.out.println("Eingabe war I");
			case 'o': case 'O':
				System.out.println("Eingabe war O");
				break;
			case 'u': case 'U':
				System.out.println("Eingabe war U");
			default : System.out.println("Zeichen war kein Vokal");
		}
	}
}

