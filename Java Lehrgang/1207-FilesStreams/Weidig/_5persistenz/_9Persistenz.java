package _5persistenz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Persistenz = Das Bestehenbleiben eines Zustandes über längere Zeit
 * 
 * EDV: Speicherbarkeit eines Objekts
 */
public class _9Persistenz {
	public static void main(String[] arg) {
		/*
		 * 2. SCHRITT Anlegen der Objekte für Person und Hund
		 */
		Person p1 = new Person("Weeg", "Lutz");
		Person p2 = new Person("Eggert", "Stefan");
		Hund h1 = new Hund("Cookie", 3);
		Hund h2 = new Hund("Crispy", 7);
		p1.setHund(h2);
		p2.setHund(h1);

		System.out.println("--------------------------------------");
		System.out.println("1. Ausgabe vor der Serialisiserung:");
		System.out.println("--------------------------------------");
		System.out.println(p1);
		System.out.println(p2);

		File f = new File("Weidig/dateien/Persistenz.txt");

		// Datei erzeugen, falls nicht vorhanden

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// 1.) Ein Objekt KOMPLETT in eine Datei schreiben
		/**
		 * Nach dem Schreiben später beim Anszeigen auskommentieren um zu zeigen, dass
		 * die Informationen ebenfalls zu späteren Zeitpunkt aus den Dateien geholt
		 * werden kann.
		 */
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(p1);
			oos.writeObject(p2);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 2.) Objekte aus der Datei auslesen
		Person gelesen1 = new Person();
		Person gelesen2 = new Person();

		try {
			/* DESERIALISIERUNG = Lesen aus einer Datei und das gelesene wieder zu Objects machen */
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			/*
			 * Möglichkeit 1: Object mit der Annahme, dass es definitiv funktioniert zur
			 * jeweiligen Klasse casten.
			 */
			gelesen1 = (Person) ois.readObject();
			Object o = ois.readObject();

			/*
			 * Möglichkeit 2: Zwischenspeichern des Objects und späteres casten zum späteren
			 * Nutzen des Objects (Methoden etc.)
			 */
			if (o instanceof Person) {
				gelesen2 = (Person) o;
			}

			System.out.println("\n--------------------------------------");
			System.out.println("2. Ausgabe nach der Deserialisiserung:");
			System.out.println("----------------------------------------");
			System.out.println(gelesen1);
			System.out.println(gelesen2);

			gelesen1.geheSpazieren();
			gelesen2.geheSpazieren();

			System.out.println("\n--------------------------------------");
			System.out.println("3. Iterieren:");
			System.out.println("----------------------------------------");
			/* Neuzuweisung von ois um diesen zu "resetten */
			ois.close();

			/* Möglichkeit 3: Iterieren */
			/*
			 * ACHTUNG: Java bietet keine geschickte Möglichkeit einer Iteration von
			 * ObjectInputStreams. Eine Möglichkeit wäre mir das Ende meiner Datei zu
			 * markieren.
			 */

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));

			System.out.println("\n----- Möglichkeit 3.1.: Ende mit null markieren -----");
			/**
			 * Möglichkeit 3.1.: Markieren des Endes mit null ACHTUNG: Sollte mitten in
			 * meiner Datei gewollter Weise null vorkommen macht es keinen Sinn mein Ende
			 * mit null zu bezeichnen.
			 **/
			oos.writeObject(p1);
			oos.writeObject(p2);
			oos.writeObject(null);
			oos.close();

			// Inputstream resetten
			ois = new ObjectInputStream(new FileInputStream(f));

			Object tmpObject = null;
			Person tmpPerson = null;
			// Solange bis ich an der Stelle bin an der null steht [BEACHTE FALLS NULL IN
			// DER MITTE]
			while ((tmpObject = ois.readObject()) != null) {
				if (tmpObject instanceof Person) {
					tmpPerson = (Person) tmpObject;
					System.out.println(tmpPerson);
				}
			}

			System.out.println("\n----- Möglichkeit 3.2.: Ende mit extra EndeKlasse markieren -----");
			/** Möglichkeit 3.2: Markieren des Endes mit einer unabhängigen Klasse **/
			// oos neu deklarieren um diesen zu "resetten"
			oos = new ObjectOutputStream(new FileOutputStream(f));

			// Inputstream resetten
			ois.close();
			ois = new ObjectInputStream(new FileInputStream(f));

			oos.writeObject(p1);
			oos.writeObject(p2);
			oos.writeObject(new StreamEnde());

			while (!((tmpObject = ois.readObject()) instanceof StreamEnde)) {
				if (tmpObject instanceof Person) {
					tmpPerson = (Person) tmpObject;
					System.out.println(tmpPerson);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

//Leere Klasse welche Serializable implementiert (Sonst kann es nicht in einen ObjectStream geschrieben werden) Eine SerialNumber ist nicht von Nöten.
class StreamEnde implements Serializable {
}

/*
 * Möchte ich den Hund mit Teil der Serialisierung machen muss dieser
 * Serializable sein
 */
class Hund implements Serializable {

	private static final long serialVersionUID = -6977431349419804703L;
	private String name;
	private int alter;

	public Hund(String name, int alter) {
		super();
		this.name = name;
		this.alter = alter;
	}

	@Override
	public String toString() {
		return "Hund [name=" + name + ", alter=" + alter + "]";
	}

	public String getName() {
		return name;
	}

	public int getAlter() {
		return alter;
	}

}

/*
 * Objekte die in einem serialisierten Objekt bzw. in der Klasse definiert
 * werden müssen selbst ebenfalls serializable sein
 */
class Person implements Serializable {

	private static final long serialVersionUID = 6689867301834606727L;

	private String name;
	private String vorname;
	private int nr;
	public static int zaehler = 0;
	// Möchte ich etwas explizit aus der Serialisierung ausschließen markiere ich
	// dieses als transient
	private transient Hund hund;

	public Person(String name, String vorname) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.nr = zaehler++;
	}

	public Person() {
	}

	public Hund getHund() {
		return hund;
	}

	public void setHund(Hund hund) {
		this.hund = hund;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", vorname=" + vorname + ", nr= " + nr + ", zaehler=" + zaehler + "]\n" + hund;
	}

	// Einmal zeigen was bei transient und nicht transient passiert durch Einfügen
	// des Hundenamens
	public void geheSpazieren() {
		System.out.println(vorname + " geht mit einem Hund spazieren.");
	}

}
