package _2tryAndcatch;

public class NumberFormatExceptionThrown {

	public static void main(String[] args) {
		// Steuersatz einlesen (parseInt geht davon aus, dass der übergebene String ein
		// Integer darstellt und "parsed" diesen)
		System.out.println(Integer.parseInt("19"));

		// Die folgende Zeile verursacht eine NumberFormatException
		// Da parseInt davon ausgeht, dass es sich um eine Zahl handelt
		// da aber das % Zeichen auftaucht bricht er ab und sagt "dieser String ist
		// keine Zahl"
		// Integer.parseInt( "19%" );

	}

}
