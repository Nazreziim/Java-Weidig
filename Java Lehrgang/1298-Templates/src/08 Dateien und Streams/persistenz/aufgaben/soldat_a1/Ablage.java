package persistenz.aufgaben.soldat_a1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
			for (Soldat s : soldaten) {
				oos.writeObject(s.getName());
				oos.writeObject(s.getVorname());
				oos.writeObject(s.getPk());
				oos.writeObject(s.getDienstgrad());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
				boolean eof = false;
				while (!eof) {
					try {
						Soldat s = new Soldat();
						s.setName((String) ois.readObject());
						s.setVorname((String) ois.readObject());
						s.setPk((String) ois.readObject());
						s.setDienstgrad((String) ois.readObject());
						ll.add(s);
					} catch (ClassNotFoundException e) {
						eof = true;
					}
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return ll;
	}
}
