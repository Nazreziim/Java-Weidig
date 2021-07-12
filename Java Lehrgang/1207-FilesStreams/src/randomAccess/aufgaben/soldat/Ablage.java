package randomAccess.aufgaben.soldat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class Ablage {
	
	public static void speichern(List<Soldat> soldaten, File datei) {
		// Datei ggf. erstellen
		if (!datei.exists()) {
			try {
				datei.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			RandomAccessFile raf = new RandomAccessFile(datei, "rw");
			raf.seek(raf.length());  //Pointer aufs Dateiende setzen
			for (Soldat s : soldaten) {				
				raf.writeUTF(s.getName());
				raf.writeUTF(s.getVorname());
				raf.writeUTF(s.getPk());
				raf.writeUTF(s.getDg());
			}
			raf.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static List<Soldat> laden(File datei) {
		List<Soldat> l = new ArrayList<Soldat>();
		try {
			RandomAccessFile raf = new RandomAccessFile(datei, "r");
			while (raf.getFilePointer() != raf.length()) {
				Soldat s = new Soldat(raf.readUTF(), raf.readUTF(), raf.readUTF(), raf.readUTF());
				l.add(s);
			}
			raf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return l;
	}
}
