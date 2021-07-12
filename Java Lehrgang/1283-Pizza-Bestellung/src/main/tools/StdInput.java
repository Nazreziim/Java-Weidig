package tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Jan Macherius
 * @version 1.0
 *
 *          Diese Klasse stellt Methoden zur Verfügung, mit denen
 *          Benutzereingaben von der Konsole entgegen genommen werden können.
 *          Die Rückgabe erfolgt als Werte vom Typ int, double oder String.
 * 
 * @see java.io.BufferedReader
 */
public class StdInput {
    /**
     * 
     * @return liefert eine Zahl vom Typ double
     */
    public static double readDouble() {
	BufferedReader br;
	String inputString;
	double value = 0.0;

	br = new BufferedReader(new InputStreamReader(System.in));

	try {
	    inputString = br.readLine();
	    value = Double.parseDouble(inputString);
	} catch (IOException _uh) {
	    System.out.println("Sie haben keinen double-Wert eingegeben !");
	}

	return value;
    }

    public static double readDouble(String value) {
	System.out.println(value);
	return readDouble();
    }

    /**
     * 
     * @return liefert eine Zahl vom Typ int
     */
    public static int readInt() {
	BufferedReader br;
	String inputString;
	int value = 0;

	br = new BufferedReader(new InputStreamReader(System.in));

	try {
	    inputString = br.readLine();
	    value = Integer.parseInt(inputString);
	} catch (IOException _uh) {
	    System.out.println("Sie haben keinen int-Wert eingegeben !");
	}

	return value;
    }

    public static int readInt(String value) {
	System.out.println(value);
	return readInt();
    }

    /**
     * 
     * @return liefert einen Wert vom Typ String
     */
    public static String readString() {
	BufferedReader br;
	String inputString = "";

	br = new BufferedReader(new InputStreamReader(System.in));

	try {
	    inputString = br.readLine();
	} catch (IOException _uh) {
	    System.out.println("Sie haben keine Zeichenkette eingegeben !");
	}

	return inputString;
    }

    public static String readString(String value) {
	System.out.println(value);
	return readString();
    }
}
