package persistenz.v2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialisierungMain {

	public static void main(String[] args) {
		Person p1 = new Person("Gerhard", "Lars", 186);
		Person p2 = new Person("Rolly", "Christian", 175);
		Hund h1 = new Hund("Captain Morgan", 7);
		Hund h2 = new Hund("Captain Abend", 9);
		p1.setHund(h1);
		p2.setHund(h2);
		
		
		System.out.println("Ausgabe vor der Serialisierung:");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.getHund());
		System.out.println(p2.getHund());
		
		// Datei erzeugen
		File f = new File("D:/WorkspaceJava/serialisiert.txt");
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 1.) Serialisierung: Ein Objekt komplett in eine Datei schreiben
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(p1);
			oos.writeObject(p2);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("");
		
		// 2.) Objekte aus einer Datei auslesen
		Person gelesen1 = null;
		Person gelesen2 = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			gelesen1 = (Person)ois.readObject();
			gelesen2 = (Person)ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Ausgabe nach der Deserialisierung:");
		System.out.println(gelesen1);
		System.out.println(gelesen2);
		System.out.println(gelesen1.getHund());
		System.out.println(gelesen2.getHund());
		
		
		// Datei löschen
//		f.delete();

	}

}
