package _1aufzeigen;

//Dies ist ein Error --> Fataler Fehler. Diesen k�nnte man behandeln aber welchen Sinn h�tte dies?
public class Error {
	public static void main(String[] args) {
		rekursionsGed�nse(1);
	}

	public static int rekursionsGed�nse(int zahl) {
		return zahl * rekursionsGed�nse(zahl - 1);
	}
}
