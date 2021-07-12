package grundlagen.b3Bedingungen;

import java.io.*;

public class HilfsMeth {    
	
	
	public static byte readByte() {
		return readByte("Bitte geben Sie ein byte ein.");
	}

	public static byte readByte(String abfrage) {
		// Die Funktion fordert den Nutzer dazu auf, eine ganze Zahl vom Typ byte
		// �ber die Kommandozeile einzugeben, liest diese ein und gibt
		// sie als Integerwert zur�ck.
	
		try {
			byte a;
			BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(abfrage);
			a = Byte.parseByte(testin.readLine());
			return a;
		}
		catch (IOException e) {return 42;}
	}

	public static short readShort() {
		return readShort("Bitte geben Sie eine ganze Zahl vom Typ short ein");
	}

	public static short readShort(String abfrage) {
		// Die Funktion fordert den Nutzer dazu auf, eine ganze Zahl vom Typ short
		// �ber die Kommandozeile einzugeben, liest diese ein und gibt
		// sie als Integerwert zur�ck.
	
		try {
			short a;
			BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(abfrage);
			a = Short.parseShort(testin.readLine()); 
			return a;
		}
		catch (IOException e) {return 42;}
	}

	
	public static int readInt() {
		return readInt("Bitte geben Sie eine ganze Zahl vom Typ int ein");
	}

	
	public static int readInt(String abfrage)  {
		// Die Funktion fordert den Nutzer dazu auf, eine ganze Zahl vom Typ int
		// �ber die Kommandozeile einzugeben, liest diese ein und gibt
		// sie als Integerwert zur�ck.
		try {
			int a;
			BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(abfrage);
			a = Integer.parseInt(testin.readLine()); 
			return a;
		}
		catch (IOException e) {return 42;}
	}

	public static long readLong() {
		return readLong("Bitte geben Sie eine ganze Zahl vom Typ long ein");
	}
	
	public static long readLong(String abfrage) {
		// Die Funktion fordert den Nutzer dazu auf, eine ganze Zahl vom Typ long
		// �ber die Kommandozeile einzugeben, liest diese ein und gibt
		// sie als long-Integerwert zur�ck.
	
		try {
			long a;
			BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(abfrage);
			a = Long.parseLong(testin.readLine());
			return a;
		}
		catch (IOException e) {return 42;}
	}

	public static float readFloat() {
		return readFloat("Bitte geben Sie eine Zahl vom Typ float ein.");
	}
	
	public static float readFloat(String abfrage) {
		// Die Funktion fordert den Nutzer dazu auf, eine ganze Gleitkommazahl
		// �ber die Kommandozeile einzugeben, liest diese ein und gibt
		// sie als Integerwert zur�ck.
	
		try {
			float a;
			BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(abfrage);
			a = Float.parseFloat(testin.readLine());
			return a;
		}
		catch (IOException e) {return 42.0f;}
	}

	
	public static double readDouble() {
		return readDouble("Bitte geben Sie eine Zahl vom Typ double ein.");
	}
	
	public static double readDouble(String abfrage) {
		// Die Funktion fordert den Nutzer dazu auf, eine ganze Gleitkommazahl
		// �ber die Kommandozeile einzugeben, liest diese ein und gibt
		// sie als Integerwert zur�ck.
	
		try {
			double a;
			BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(abfrage);
			a = Double.parseDouble(testin.readLine());
			return a;
		}
		catch (IOException e) {return 42.0;}
	}

	public static char readChar() {
		return readChar("Bitte geben Sie ein Zeichen ein.");
	}
	
	public static char readChar(String abfrage) {
		// Die Funktion fordert den Nutzer dazu auf, ein Character - Zeichen
		// �ber die Kommandozeile einzugeben, liest diese ein und gibt
		// sie als Integerwert zur�ck.
	
		try {
			char a;
			BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(abfrage);
			a = testin.readLine().charAt(0);
			return a;
		}
		catch (IOException e) {return 'f';}
	}


	public static String readString() {
		return readString("Bitte geben Sie eine Zeichenreihe ein.");
	}
	
	public static String readString(String abfrage) {
		// Die Funktion fordert den Nutzer dazu auf, eine Zeichenreihe
		// �ber die Kommandozeile einzugeben, liest diese ein und gibt
		// sie als Integerwert zur�ck.
	
		try {
			String a;
			BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(abfrage);
			a = testin.readLine();
			return a;
		}
		catch (IOException e) {return "IO-Fehler";}
	}

	public static boolean readBoolean()  {
		return readBoolean("Bitte geben Sie true oder false ein.");
	}
	
	public static boolean readBoolean(String abfrage) {
		// Die Funktion fordert den Nutzer dazu auf, einen Wahrheitswert
		// �ber die Kommandozeile einzugeben, liest diesen ein und gibt
		// ihn als Integerwert zur�ck.
	
		try {
			boolean a;
			BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(abfrage);
			a = Boolean.valueOf(testin.readLine()).booleanValue();
			return a;
		}
		catch (IOException e) {return false;}
	} 
}