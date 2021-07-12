public class Konto {
	public static void main(String[] args) {
		System.out.print("Bitte eine Seriennummer eingeben: ");
		String seriennummer = new java.util.Scanner(System.in).next();
		char[] sn = new char[seriennummer.length()];
		for (int i = 0; i < seriennummer.length(); i++)
			sn[i] = seriennummer.charAt(i);
		
		System.out.println("Die Pruefziffer betraegt " + getPruefziffer(sn));
		
	}
	
	public static int getPruefziffer(char[] sn) {
		int pos = sn[0] - 'A' + 1;
		int quersumme = (pos % 10) + (pos / 10);
		
		for (int i = 1; i < sn.length - 1; i++)
			quersumme += sn[i] - '0';
		
		int rest = quersumme % 9;
		if (rest == 0)
			return 9;
		else
			return 8 - rest;
	}
}
