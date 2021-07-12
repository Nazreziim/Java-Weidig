package _1aufzeigen;

//Dies ist ein Error --> Fataler Fehler. Diesen könnte man behandeln aber welchen Sinn hätte dies?
public class Error {
	public static void main(String[] args) {
		rekursionsGedönse(1);
	}

	public static int rekursionsGedönse(int zahl) {
		return zahl * rekursionsGedönse(zahl - 1);
	}
}
