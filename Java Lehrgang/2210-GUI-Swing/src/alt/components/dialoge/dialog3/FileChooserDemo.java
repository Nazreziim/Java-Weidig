package alt.components.dialoge.dialog3;

import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class FileChooserDemo {
	public static void main(String[] args) {
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileFilter() {
			@Override
			public boolean accept(File f) {
				return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");
			}

			@Override
			public String getDescription() {
				return "Texte";
			}
		});
		// Art des FileDialogs wählen
		// zum Öffnen
		int state = fc.showOpenDialog(null);
		// zum Speichern
		// Vorher Standardnamen angeben
		// fc.setSelectedFile(new File("test.txt"));
		// int state =fc.showSaveDialog(null);
		if (state == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			System.out.println(file.getName());
		} else
			System.out.println("Auswahl abgebrochen");
		System.exit(0);
	}
}
