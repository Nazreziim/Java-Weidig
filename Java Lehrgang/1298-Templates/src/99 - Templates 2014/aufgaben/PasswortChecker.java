public class PasswortChecker {
	public static void main(String[] args) {
		System.out.print("Bitte ein Passwort eingeben: ");
		String passwort = new java.util.Scanner(System.in).next();
		char[] pass = new char[passwort.length()];
		for (int i = 0; i < passwort.length(); i++)
			pass[i] = passwort.charAt(i);
		
		String ausgabe = (checkPass(pass)) ? "Das Passwort entpricht den Kriterien" : "Das Passwort entspricht nicht den Kriterien";
		
		System.out.println(ausgabe);
	}
	
	public static boolean checkPass(char[] pass) {
		if(pass.length < 8)
			return false;
		
		int ziffern = 0;
		int kleinB = 0;
		int grossB = 0;
		int sonderZ = 0;
		
		for (int zeichen : pass) {
			if (zeichen > 47 && zeichen < 58)
				ziffern++;
			else if (zeichen > 96 && zeichen < 123)
				kleinB++;
			else if (zeichen > 64 && zeichen < 91)
				grossB++;
			else
				sonderZ++;
		}
		
		if (ziffern >= 2 && kleinB >= 1 && grossB >= 1 && sonderZ >= 1)
			return true;
		else
			return false;
	}
}
