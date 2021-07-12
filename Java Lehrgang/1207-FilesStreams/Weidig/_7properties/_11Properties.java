/** Erstelldatum: 27-05-2021 **/

package _7properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Die Klasse Properties ist eine Sonderform der Assoziativspeicher, bei der
 * Schlüssel-Werte-Paare immer vom Typ String sind. Da sich die Einträge in
 * einer Datei speichern und wieder auslesen lassen, können auf diese Weise fest
 * verdrahtete Zeichenketten aus dem Programmtext externalisiert werden, sodass
 * sich die Werte auch ohne Neuübersetzung bequem verändern lassen.
 * 
 * @see <a href =
 *      "https://openbook.rheinwerk-verlag.de/javainsel9/javainsel_13_009.htm">
 *      Properties Rheinwerk </a>
 */
public class _11Properties {
	public static void main(String[] args) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("------------- 1. Erzeugen des Property Objekts ----------------");
		System.out.println("---------------------------------------------------------------");
		/* 1.) Erzeugen des Property Objekts */
		// Möglichkeit 1: Normale Erzeugung
		Properties props = new Properties();

		// Möglichkeit 2: Angabe einer "Überproperty". Sollte in props2 nichts gefunden
		// werden unter dem Key sucht es in props
		Properties props2 = new Properties(props);

		props.setProperty("Benutzer", "King Käse");
		props.setProperty("Version", "" + 0.02);

		// Gibt mir King Käse
		System.out.println(props.getProperty("Benutzer"));

		// Sucht nach dem Key Version -> Findet in props2 nicht -> Sucht in props ->
		// Findet und gibt aus
		System.out.println(props2.getProperty("Version"));
		// Hinweis: Hier wird als String quasi ein Double Wert ausgelesen. Diesen könnte
		// ich versuchen zu parsen etc.

		// Gibt null (Nicht NullPointerException) aus
		System.out.println(props.getProperty("Passwort"));
		
		// Gibt einen default Wert, wenn der Key nicht gefunden wurde
		System.out.println(props.getProperty("Passwort", "Nicht gefunden"));
		
		System.out.println("\n---------------------------------------------------------------");
		System.out.println("-- 2. Schreiben/Lesen der Properties in/aus eine/r Datei ------");
		System.out.println("---------------------------------------------------------------");
		/* 2.) Schreiben/Lesen der Properties in/aus eine/r Datei */
		try {
			//System.getProperties() lieft mir die Systemeigenen Properties (Nutzername, Java Version etc.)
			Properties propsSchreiben = new Properties(System.getProperties());
			FileWriter writer = new FileWriter(new File("Weidig/dateien/properties.txt"));
			
			//In Property schreiben
			propsSchreiben.setProperty("Nutzer1", "Lutz Weeg");
			
			//Schreibt über den Writer
			propsSchreiben.store(writer, "Nutzerliste");
			
			//Aus Property lesen
			FileReader reader = new FileReader(new File("Weidig/dateien/properties.txt"));
			Properties propsLesen = new Properties();
			
			//Liest mithilfe des Readers und speichert es im Objekt ab
			propsLesen.load(reader);
			
			//Gibt die Properties als Liste an einen OutputStream weiter
			//System.out = OutputStream -> Bietet sich für Debugging an
			propsLesen.list(System.out);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n---------------------------------------------------------------");
		System.out.println("---------------------- 3. Crazy XML Stuff ---------------------");
		System.out.println("---------------------------------------------------------------");
		/* 3. Crazy XML Stuff */
		
		try {
			//System.getProperties() lieft mir die Systemeigenen Properties (Nutzername, Java Version etc.)
			Properties xmlSchreiben = new Properties(System.getProperties());
			FileOutputStream fos = new FileOutputStream(new File("Weidig/dateien/properties.xml"));
			
			//In Property schreiben
			xmlSchreiben.setProperty("Nutzer1", "Lutz Weeg");
			
			//Speichert über den OutputStream die Properties in eine XML Datei
			xmlSchreiben.storeToXML(fos, "Nutzerliste");
			
			Properties xmlLesen = new Properties(System.getProperties());
			FileInputStream fis = new FileInputStream(new File("Weidig/dateien/properties.xml"));
			xmlLesen.loadFromXML(fis);
			
			System.out.println(xmlLesen.getProperty("Nutzer1"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
