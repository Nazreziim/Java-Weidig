package aufgaben;

import aufgaben.HilfsMeth;

public class Durchschnitt {
	public static void main(String[] args) {
		int n = HilfsMeth.readInt("Wie viele Zahlen sollen eingelesen werden?");
		System.out.println("Der Durchschnitt betraegt: " + durchschnitt(n));
	}
	
	public static double durchschnitt(int n) {
		double schnitt = 0.0;
		int summe = 0;
		for (int i=1; i <= n; i++) {
			summe += HilfsMeth.readInt("Zahl Nr. " + i + " eingeben: ");			
		}
		
		schnitt = (double)summe / n;
		return schnitt;
	}

}
