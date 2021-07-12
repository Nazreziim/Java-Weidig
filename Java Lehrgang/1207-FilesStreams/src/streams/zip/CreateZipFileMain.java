package streams.zip;

import java.io.*;
import java.util.zip.*;

// TODO: Ordner in der Zip-Datei funktionieren nicht!

public class CreateZipFileMain {

	public static void main(String args[]) {
//		String zipFile = "d:/zipdemo.zip";
//		String sourceDirectory = "d:/testzip2";
		//zip("d:/testzip","d:/zipdemo.zip");
		zip();

	}

	private static void zip() { //String zipFile, String sourceDirectory) {
		String zipFile = "d:/zipdemo.zip";
		String sourceDirectory = "d:/testzip";
		try {			
			// Senke:
			ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(
					zipFile));

			File dir = new File(sourceDirectory);

			// Pr¸fung ob der Ordner existiert
			if (!dir.isDirectory()) {
				System.out.println(sourceDirectory + " is not a directory");
			} else {
				File[] files = dir.listFiles();
				
				for (File f : files) {
					System.out.println("Adding " + f.getName());
					
					// 	Quelle einlesen:
					FileInputStream fin = new FileInputStream(f);
					
					// a) Neuer Eintrag in der ZIP-Datei:
					zout.putNextEntry(new ZipEntry(f.getName()));
					
					// b) Jetzt den Datei-Inhalt:					
					byte[] buffer = new byte[1024]; // Ein Puffer
					int length;
					while ((length = fin.read(buffer)) > 0) {
						zout.write(buffer, 0, length);
					}
					
					// c) Eintrag schlieﬂen:
					zout.closeEntry();
					fin.close();
					
				}
				zout.flush();
				zout.close();
				System.out.println("Zip file has been created!");
			}

		} catch (IOException ioe) {
			System.out.println("IOException :" + ioe);
		}
	}
}
