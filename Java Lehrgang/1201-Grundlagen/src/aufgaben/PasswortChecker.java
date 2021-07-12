package aufgaben;

// Übung 10 - Aufgabe 3
public class PasswortChecker {

	public static void main(String[] args) {
		char[] passwort1 = {'A','x','B','1','&','a','8','c'};
		char[] passwort2 = {'1','p','a','s','s','w','0','r','t'};
		
		System.out.println(new String(passwort1) + " ist ein gutes Passwort? " + istGutesPasswort(passwort1));
		System.out.println(new String(passwort2) + " ist ein gutes Passwort? " + istGutesPasswort(passwort2));
	}
	
	public static boolean istGutesPasswort(char[] pwd) {
		boolean ist_gut = true;
		
		// a) mindestens 8 Zeichen
		if (pwd.length < 8) {
			ist_gut = false;
		}
		
		// b) mindestens 2 Buchstaben
		int bst_ctr = 0;
		for (char c : pwd) {
			if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
				bst_ctr++;
			}
		}
		if (bst_ctr < 2) {
			ist_gut = false;
		}
		
		// c) mindestens zwei Ziffern
		int zif_ctr = 0;
		for (char c : pwd) {
			if (c >= '0' && c <= '9') {
				zif_ctr++;
			}
		}
		if (zif_ctr < 2) {
			ist_gut = false;
		}
		
		// d) min. ein Groß- und ein Kleinbuchstabe
		int gr_ctr = 0;
		int kl_ctr = 0;
		for (char c : pwd) {
			if (c >= 'A' && c <= 'Z') {
				gr_ctr++;
			}
			if (c >= 'a' && c <= 'z') {
				kl_ctr++;
			}
		}
		if (gr_ctr < 1 || kl_ctr < 1) {
			ist_gut = false;
		}
		
		// e) ein Sonderzeichen
		int sz_ctr = 0;
		for (char c : pwd) {
			if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
				sz_ctr++;
			}			
		}
		if (sz_ctr < 1) {
			ist_gut = false;
		}
		
		
		// f) min. eine Ziffer / Sonderzeichen innerhalb des Passworts
		int zf_ctr = 0;
		int son_ctr = 0;
		for (int i=1; i < pwd.length-1; i++) {
			if (pwd[i] >= '0' && pwd[i] <= '9') {
				zf_ctr++;
			}
			if (!((pwd[i] >= '0' && pwd[i] <= '9') || (pwd[i] >= 'a' && pwd[i] <= 'z') || (pwd[i] >= 'A' && pwd[i] <= 'Z'))) {
				son_ctr++;
			}
		}
		if (zf_ctr < 1 || son_ctr < 1) {
			ist_gut = false;
		}
		
		
		return ist_gut;
	}

}
