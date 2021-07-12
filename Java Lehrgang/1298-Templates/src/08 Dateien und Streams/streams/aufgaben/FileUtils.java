package streams.aufgaben;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class FileUtils {
	static void copy(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[0xFFFF];
		for (int len; (len = in.read(buffer)) != -1;)
			out.write(buffer, 0, len);
		
		/*
		boolean eof = false;
		while (!eof) {
			int len = in.read(buffer);
			if (len == -1) {
				eof = true;
			} else {
				out.write(buffer, 0, len);
			}
		}
		*/
	}

	/*
	 * Kopiert die in src angegebene Datei nach dest. Hierzu wird die
	 * Basisfunktionalität der Klassen FileInputStream und FileOutputStream
	 * genutzt.
	 */
	static void copyFile(File src, File dest) {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);

			copy(fis, fos);
			fos.getFD().sync();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
				}
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
				}
		}
	}

	public static void main(String[] args) throws Exception {
		File inputFile = new File("./src/aufgaben/ab3/input.dat");
		if (!inputFile.exists()) {
			inputFile.createNewFile();
			RandomAccessFile raf = new RandomAccessFile(inputFile, "rw");
			raf.setLength(0xFFFFFF);
			raf.close();
		}
		copyFile(inputFile, new File(inputFile.getParentFile() + File.separator
				+ "output.dat"));
	}
}
