package _6NIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

/**
 * Dies ist die Demo Templates Klasse welche zur Einf�hrung des java.nio
 * packages genutzt werden sollte.
 * <p>
 * 
 * <h3>Was sind die Hauptgr�nde f�r nio?</h3>
 * <ol>
 * <li>Non-Blocking / Nicht blockierende I/O Operationen: Dies bedeutet, dass
 * Daten immer gelesen werden k�nnen sobald dies m�glich ist. Parallele Threads
 * k�nnen mit anderen Aufgaben weitermachen und m�ssen nicht auf die Beendigung
 * mancher Operationen warten. Dies erh�ht die Effizienz enorm</li>
 * <li>Buffer-Orientiert: Daten werden in einen Buffer gelegt und gecached.
 * Innerhalb dessen sich vor und zur�ck zu bewegen ist m�glich und gewollt.</li>
 * </ol>
 * 
 * <h3>Warum aber nio STATT io?</h3>
 * <ul>
 * <li>Die alten Module k�nnen nur bedingt mit Verkn�pfungen arbeiten</li>
 * <li>Die alten Module k�nnen nur sehr beschr�nkt die MetaDaten und
 * Effiezienzprobleme herauslesen.</li>
 * <li>Die alten Module sind nicht plattformunabh�ngig.</li>
 * <li>Die alten Module bieten keine Basis M�glichkeiten wie kopieren, bewegen
 * etc. von Dateien</li>
 * </ul>
 * 
 * 
 * <h3>Erl�uterungen:</h3>
 * <ul>
 * <li><b>Blockierter Thread</b> - Ein Thread, der auf eine Bedingung wartet,
 * bevor er die Ausf�hrung fortsetzen kann.</li>
 * 
 * <li><b>Blockieren</b> - Eine Eigenschaft eines Sockets, die dazu f�hrt, dass
 * Aufrufe darauf warten, dass die angeforderte Aktion ausgef�hrt wird, bevor
 * sie zur�ckgegeben wird.</li>
 * 
 * <li><b>Nicht blockierend</b> - Eine Eigenschaft eines Sockets, bei der
 * Aufrufe unverz�glich zur�ckgegeben werden, wenn festgestellt wird, dass die
 * angeforderte Aktion nicht ohne unbekannte Verz�gerung ausgef�hrt werden
 * kann.</li>
 * 
 * <li><b>Synchrone E / A-Operation</b> - Eine E / A-Operation, bei der der
 * anfordernde Thread blockiert wird, bis diese E / A-Operation abgeschlossen
 * ist.</li>
 * 
 * <li><b>Asynchrone E / A-Operation</b> - Eine E / A-Operation, die selbst
 * nicht dazu f�hrt, dass der anfordernde Thread blockiert wird. Dies bedeutet,
 * dass der Thread und die E / A-Operation m�glicherweise gleichzeitig
 * ausgef�hrt werden.</li>
 * </ul>
 * </br>
 * 
 * @see <a href =
 *      "https://docs.oracle.com/javase/tutorial/essential/io/path.html">
 *      Dokumentation </a>
 * @author aweidig
 *
 */
public class _10nioTest {

	public static void main(String[] args) throws IOException {
		System.out.println("-------------------------------------");
		System.out.println("------- 1. Path statt File ----------");
		System.out.println("-------------------------------------");
		// 1.) Statt File hat man jetzt Path Objekte welche �ber Paths.get geholt
		// werden, da Path = Interface

		// Absolute Angabe
		Path pfad1 = Paths.get("D:/Entwicklung");

		// Relative Angabe (funktioniert immer)
		Path pfad2 = Paths.get(".", "Weidig", "dateien", "NIO-Beginn.txt");
		Path pfad3 = Paths.get("Weidig/dateien");

		System.out.println("Dateiname: " + pfad1.getFileName());
		System.out.println("Dateiname: " + pfad2.getFileName());
		System.out.println("Dateiname: " + pfad3.getFileName());

		// Wirft eine Exception wenn die Datei vorhanden ist
		try {
			Files.createFile(pfad2);

			// Eine neue Exception speziell f�r NIO. Das bereits Vorhandensein MUSS
			// abgefangen werden.
		} catch (FileAlreadyExistsException e) {
			System.err.println("Datei existiert schon");
		}

		System.out.println("Pfad: " + pfad1); // Gibt den Pfad direkt aus

		System.out.println("Pfad als URI: " + pfad2.toUri()); // Gibt den Pfad als URI aus
		/*
		 * URI - Uniform Resource Identifier Einheitlicher Bezeichner f�r Ressourcen
		 * verschiedener Typen, welcher zur Identifizierung abstrakter oder phsyischer
		 * Ressourcen dient.
		 */

		// Nutzt den vorhandenen Pfad und erweitert ihn mit einem weiteren UND
		// gibt das Ergebnis als Path zur�ck
		System.out.println("Neuer Pfad: " + pfad1.resolve("repo"));
		Path pNew = pfad1.resolve("repo"); // DIES IST M�GLICH

		System.out.println("Ist lesbar?? " + Files.isReadable(pfad2)); // Datei lesbar?
		System.out.println("Ist versteckt? " + Files.isHidden(pfad2)); // Datei versteckt?
		System.out.println("Sind p1 und p2 die gleichen Pfade?: " + Files.isSameFile(pfad1, pfad2));
		// Pr�ft ob beide auf den gleichen Pfad verweisen

		System.out.println("\n-------------------------------------");
		System.out.println("--- 2. Kopieren/Bewegen/Umbenennen --");
		System.out.println("-------------------------------------");
		// 2.) Kopieren / Bewegen / Umbenennen

		// Pfade neu festlegen
		pfad1 = Paths.get(".", "Weidig", "dateien", "NIO-Kopie.txt");
		pfad2 = Paths.get("./Weidig/dateien/NIO-Original.txt");
		pfad3 = Paths.get("Weidig/NIO-Original.txt");
		try {
			Files.createFile(pfad2);
			Files.createFile(pfad1);
		} catch (IOException e) {
			System.err.println("Datei existiert schon: " + pfad2.getFileName());
		}

		// Schiebt die Datei in den 2. Pfad und benennt diese um falls im Path ein
		// anderer Name angegeben ist
//		System.out.println("Neuer Ort der Originaldatei: "
//				+ (Files.move(pfad2, pfad3, StandardCopyOption.REPLACE_EXISTING)).toAbsolutePath());

		System.out.println(
				"Ort der Kopie: " + (Files.copy(pfad2, pfad1, StandardCopyOption.REPLACE_EXISTING).toAbsolutePath()));

		System.out.println(
				"Ort der Kopie: " + (Files.move(pfad2, Paths.get(".", "Weidig", "dateien", "NIO-Umbenannt.txt"),
						StandardCopyOption.REPLACE_EXISTING)).toAbsolutePath());

		System.out.println("\n-------------------------------------");
		System.out.println("----------- 3. Die Metadaten --------");
		System.out.println("-------------------------------------");
		// 3.) Zugriff auf die Metadaten der Dateien
		System.out.println("Dateiname: " + pfad1.getFileName());
		BasicFileAttributes attr = Files.readAttributes(pfad1, BasicFileAttributes.class);
		System.out.println("Erstellungsdatum: " + attr.creationTime());
		System.out.println("Letzter Zugriff: " + attr.lastAccessTime());
		System.out.println("Letzte Bearbeitung: " + attr.lastModifiedTime());
		System.out.println("Ist es ein Ordner?: " + attr.isDirectory());
		System.out.println("Ist es eine normale Datei?: " + attr.isRegularFile());
		System.out.println("Dateigr��e: " + attr.size());

		System.out.println("\n-------------------------------------");
		System.out.println("-------- 4. Lesen und Schreiben -----");
		System.out.println("-------------------------------------");
		// 4.) Lesen und Schreiben unter Nutzung von nio
		//
		// a) Kleine Dateien = readAllBytes / readAllLines
		// b) Text Dateien = newBufferedReader/Writer (Arbeitet mit java.io zusammen!)
		// c) Ungebufferte Streams = newInput/OutputStream (Arbeitet mit java.io
		// zusammen!)
		// d) Channels = newByteChannel
		// e) Erweiterte M�glichkeiten = FileChannel

		System.out.println("\na) Kleine Dateien: readAllBytes / readAllLines");
		//// a)
		pfad1 = Paths.get(".", "Weidig", "dateien", "NeueNio.txt");
		// ACHTUNG: Keine Umlaute zul�ssig
		String text = "Hallo Poecking";
		byte[] textBytes = text.getBytes();
		Files.write(pfad1, textBytes, StandardOpenOption.APPEND, StandardOpenOption.CREATE);

		System.out.println(Files.readAllLines(pfad1));

		System.out.println("\nb) Text Dateien = newBufferedReader/Writer");
		//// b)
		BufferedReader br = Files.newBufferedReader(pfad1);
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();

		System.out.println("\nc) Ungebufferte Streams = newInput/OutputStream");
		//// c)
		OutputStream os = Files.newOutputStream(pfad1, StandardOpenOption.TRUNCATE_EXISTING);
		os.write("Auch mit Streams kann man in java.nio schreiben. ".getBytes());
		os.close();

		InputStream is = Files.newInputStream(pfad1, StandardOpenOption.TRUNCATE_EXISTING);

		int inhalt = 0;
		String ganzerText = "";

		while ((inhalt = is.read()) != -1) {
			ganzerText += (char) inhalt;
		}

		System.out.println(ganzerText);

		System.out.println("\nd) Channels = newByteChannel");
		/*
		 * d) Channels != Streams : Channels sammeln Daten in einem Buffer. Sie sind
		 * nicht blockierend und k�nnen die Position eines Cursors verwalten.
		 */
		// �ffne einen Channel der seine Position kennt und �ndern kann
		SeekableByteChannel sbc = Files.newByteChannel(pfad1, StandardOpenOption.READ);

		/*
		 * Erzeugt einen ByteBuffer mit angegebener Gr��e indem ich Dinge zur sp�teren
		 * Verwendung ablegen kann ACHTUNG: Gr��e wird fest vorgeschrieben um auch nur
		 * soviel Speicher zu verwenden
		 */
		ByteBuffer buf = ByteBuffer.allocate(100);

		// Liest Bytes und gibt die Anzahl zur�ck die gelesen wurde.
		System.out.println("Menge an gelesenen Bytes: " + sbc.read(buf));
		// JETZT Sind die Daten im Buffer
		// BEACHTEN: Der Pointer im Buffer ist jetzt am Ende

		// Setzt den Pointer wieder an den Anfang
		buf.rewind();

		// Dekodiert die im Buffer (buf) vorhandenen Bytes mittels des angegebenen
		// Charsets [Hier gezeigt 2 M�glichkeiten]
		System.out.println(Charset.forName("UTF-8").decode(buf));

		buf.rewind();

		System.out.println(new String(buf.array(), StandardCharsets.UTF_8));

		System.out.println("\ne) Erweiterte M�glichkeiten");
		// e)
		// �ffnet einen neuen FileChannel, welcher nur lesen kann
		FileChannel fc = FileChannel.open(pfad1, StandardOpenOption.READ);

		// Setzt den Pointer von buf zur Wiederverwendung auf 0
		buf.rewind();

		System.out.println("Menge an gelesenen Bytes: " + fc.read(buf));

		System.out.println(fc);

	}

}
