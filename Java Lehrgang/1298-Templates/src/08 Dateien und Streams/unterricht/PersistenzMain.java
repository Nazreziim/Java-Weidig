package unterricht;

import java.io.*;

public class PersistenzMain {
	public static void main(String[] arg) {
		Person p1 = new Person("Gerhard", "Lars");
		Person p2 = new Person("Lange", "Andreas");
		Hund h1 = new Hund("Waldi", 7);
		Hund h2 = new Hund("Fiffi", 3);
		p1.setHund(h2);
		p2.setHund(h1);
		
		System.out.println("Ausgabe vor der Serialisiserung:");
		System.out.println("--------------------------------");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("\n");
		
		File f = new File("./08 Dateien und Streams/unterricht/persistenz.txt");
		
		// Datei erzugen, falls nicht vorhanden
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// 1.) Ein Objekt KOMPLETT in eine Datei schreiben
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(p1);
			oos.writeObject(p2);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		// 2.) Objekte aus der Datei auslesen
		Person gelesen1 = new Person();
		Person gelesen2 = new Person();
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			gelesen1 = (Person) ois.readObject();
			Object o = ois.readObject();
			//gelesen2 = (Person) ois.readObject();
			if (o instanceof Person) {
				System.out.println("O ist ein Mensch!");
				((Person)o).geheSpazieren();
				gelesen2 = (Person)o;
			}
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
		
		
		System.out.println("\nAusgabe nach der Deserialisiserung:");
		System.out.println("-----------------------------------");
		System.out.println(gelesen1);
		System.out.println(gelesen2);
	}

}
