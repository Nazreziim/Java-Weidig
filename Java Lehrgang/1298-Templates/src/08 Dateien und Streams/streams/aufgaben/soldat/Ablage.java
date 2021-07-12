package streams.aufgaben.soldat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Ablage {

	/*
	 * Speichert die angegebene Liste von Soldat-Objekten nacheinander in die
	 * benannte Datei. Hierbei wird die Datei im Bedarfsfall erstellt, sollte
	 * sie bereits existieren, werden die neuen Daten hinten angeh�ngt
	 */
	public static void speichern(List<Soldat> soldaten, File datei) {
		DataOutputStream dos = null;

		try {
			if (!datei.exists()) {
				datei.createNewFile();
			}
			dos = new DataOutputStream(new FileOutputStream(datei));
			for (Soldat s : soldaten) {
				dos.writeUTF(s.getName());
				dos.writeUTF(s.getVorname());
				dos.writeUTF(s.getPk());
				dos.writeUTF(s.getDienstgrad());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * L�dt aus der benannten Datei die Daten der gespeicherten Soldat-Objekte
	 * und gibt diese in Form einer Liste zur�ck. Im Fehlerfall wird eine leere
	 * Liste zur�ck gegeben
	 */
	public static List<Soldat> laden(File datei) {
		LinkedList<Soldat> ll = new LinkedList<Soldat>();

		if (datei.exists()) {
			DataInputStream dis = null;
			try {
				dis = new DataInputStream(new FileInputStream(datei));
				while (dis.available()>0) {
					Soldat s = new Soldat();
					s.setName(dis.readUTF());
					s.setVorname(dis.readUTF());
					s.setPk(dis.readUTF());
					s.setDienstgrad(dis.readUTF());
					ll.add(s);
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
