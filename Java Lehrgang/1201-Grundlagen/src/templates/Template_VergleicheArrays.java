package templates;
import java.util.Arrays;

public class Template_VergleicheArrays {

	public static void main(String[] args) {
		//Deklaration und Initialisierung eines mehrdimensionalen Arrays
		int[][] arrEins = { { 1, 2, 3 }, 
							{ 1, 2, 3 }, 
							{ 1, 2, 3 } };

		//Deklaration eines mehrdimensionalen Arrays mit bloßer Längenangabe
		//BEACHTE: Bei primitiven Datentypen wird alle mit dem entsprechenden
		//         Defaultwert belegt (bei double = 0.0)
		double[][] arrZwei = new double[3][4];

		//Deklaration eines eindimensionalen Arrays mit der Länge 4
		double[] arrEinDim = new double[4];
		//Befülle alle Felder des eindimensionalen Arrays mit 20
		Arrays.fill(arrEinDim, 20);

		// Arrays.fill erwartet als übergebenen Parameter ein EINdimensionales Arrays
		// int/double/String o.ä. []
		//Befülle die erste Zeile meines mehrdimensionalen Arrays [entspricht einem
		//eindimensionalen Array] mit 40
		Arrays.fill(arrEins[0], 40);
		
		//DAS IST EIN ABSATZ
		System.out.println();

		//Iteriere von 0 - Länge des Mehrdimensionalen Arrays
		//BEACHTE: Es nimmt hierbei die Länge des ersten Wertes --> int[] <-- [] [Zeilenlänge]
		for (int i = 0; i < arrZwei.length; i++) {
			//Weise der jeweiligen Zeile meines mehrdimensionalen Arrays
			//ein vorher definiertes eindimensionales Array zu
			arrZwei[i] = arrEinDim;
			//Gebe mir jedes Mal die entsprechende Zeile des Arrays aus
			System.out.println(Arrays.toString(arrZwei[i]));
		}
		
		//Weise mir der 2. Zeile der 1. Stelle des mehrdimensionalen Arrays den Wert 40 zu
		//Da alle Zeilen des arrZwei Arrays mit dem "arrEinDim" belegt sind verweist
		//jede Zeilen eben auf dieses eindimensionale Array. Eine Änderung des einzelnen
		//Wertes sorgt somit für eine Änderung in "arrEinDim". Diese Änderung wird für
		//jede Zeile des mehrdimensionalen Arrays arrZwei übernommen, da jede Zeile auf
		//das eindimensionale Array "arrEinDim" verweist.
		arrZwei[1][2] = 40;
		
		//DAS IST EIN ABSATZ
		System.out.println();
		
		//Gibt die 3 Zeilen von arrZwei aus
		System.out.println(Arrays.toString(arrZwei[0]));
		System.out.println(Arrays.toString(arrZwei[1]));
		System.out.println(Arrays.toString(arrZwei[2]));
		
		System.out.println("\nArrayZwei");

		//Gibt die ADRESSWERTE jeder Zeile des mehrdimensionalen Arrays arrZwei aus
		System.out.println(Arrays.toString(arrZwei));
		//Vergleich die ADRESSEN der 1. und der 2. Zeile miteinander
		//--> true, da beide Adressen auf arrEinDim verweisen
		System.out.println(arrZwei[0] == arrZwei[1]);
		//--> true, da beide Adressen auf arrEinDim verweisen
		System.out.println(arrZwei[0].equals(arrZwei[1]));

		System.out.println("\nArrayEins");

		//Gibt die ADRESSWERTE jeder Zeile des mehrdimensionalen Arrays arrEins aus
		System.out.println(Arrays.toString(arrEins));
		//Vergleich die ADRESSEN der 1. und der 2. Zeile miteinander
		//--> false, da zwar die Inhalte der eindimensionalen Arrays
		//    gleich sind jedoch die Adressen unterschiedlich
		System.out.println(arrEins[0] == arrEins[1]);
		//--> false, da zwar die Inhalte der eindimensionalen Arrays
				//    gleich sind jedoch die Adressen unterschiedlich
		System.out.println(arrEins[0].equals(arrEins[1]));

		//DAS IST EIN ABSATZ
		System.out.println();

		//Vergleich zu Strings
		String a = "S";
		String b = "S";
		String c = "D";
		
		//Zwar stecken hinter den primitiven Datentypen auch einzelne Adresssen,
		//jedoch werden diesen bei gleichem Inhalt die gleiche Adresse zugeordnet
		//somit sind bei gleichem Inhalt des entsprechenden Typs die Vergleiche
		//gleich bzw. bei unterschiedlichem Inhalt unterschiedlich da für den
		//unterschiedlichen Inhalt eines bloßen primitiven Datentyps unterschiedliche
		//Speicheradressen belegt werden
		System.out.println(a == b);
		System.out.println(a.equals(b));
		System.out.println(a == c);
		System.out.println(a.equals(c));

	}
}
