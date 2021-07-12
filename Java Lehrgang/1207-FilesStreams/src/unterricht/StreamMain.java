package unterricht;

import java.io.*;

public class StreamMain {

	public static void main(String[] args) {
		File datei = new File("./src/unterricht/streams.txt");

		// 1.) Schreiben in einen Stream
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(datei);
			// ACHTUNG: Schreibt Bytes mit int als Übergabeparemeter 
			// 			[Byte -> 0 bis 255 groß]
			fos.write(66);
			fos.write(256);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 2.) Lesen aus einem Stream
		try {
			FileInputStream fis = new FileInputStream(datei);
			System.out.println(fis.read()); // 66
			System.out.println(fis.read()); // 0 da ein Byte bis 255 geht
			System.out.println(fis.read()); // -1, da Dateiende erreicht
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 3.) Streams in Streams - das Decorator-Pattern
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(datei));
			dos.writeUTF("Hallo lieber Datenstrom");
			dos.flush(); // Hier noch nicht nötig!
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			DataInputStream dis = new DataInputStream(new FileInputStream(datei));
			System.out.println(dis.readUTF());
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
