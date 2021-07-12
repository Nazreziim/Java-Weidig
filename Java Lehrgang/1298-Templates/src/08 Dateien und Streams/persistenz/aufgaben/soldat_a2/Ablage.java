package persistenz.aufgaben.soldat_a2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

public class Ablage {

	/*
	 * Speichert die angegebene Liste von Soldat-Objekten nacheinander in die
	 * benannte Datei. Hierbei wird die Datei im Bedarfsfall erstellt, sollte
	 * sie bereits existieren, werden die neuen Daten hinten angehängt
	 */
	public static void speichern(List<Soldat> soldaten, File datei) {
		ObjectOutputStream oos = null;

		try {
			if (!datei.exists()) {
				datei.createNewFile();
			}
			oos = new ObjectOutputStream(new FileOutputStream(datei));
			oos.writeObject(soldaten);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * Lädt aus der benannten Datei die Daten der gespeicherten Soldat-Objekte
	 * und gibt diese in Form einer Liste zurück. Im Fehlerfall wird eine leere
	 * Liste zurück gegeben
	 */
	public static List<Soldat> laden(File datei) {
		LinkedList<Soldat> ll = new LinkedList<Soldat>();

		if (datei.exists()) {
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream(datei));
				ll.addAll((List<Soldat>) ois.readObject());

			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		return ll;
	}
}
