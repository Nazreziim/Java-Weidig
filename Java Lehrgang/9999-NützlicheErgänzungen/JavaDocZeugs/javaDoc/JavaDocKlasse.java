/** Erstelldatum: 27-05-2021 **/

package javaDoc;

/**
 * 
 * Hier ist eine
 * <p>
 * Leerzeile Hier ist einfach nur ein</br>
 * Absatz
 * 
 * <ul>
 * Unsortierte Liste
 * <li>Punkt 1</li>
 * <li>Punkt 2</li>
 * </ul>
 * Ende der unsortierten Liste</br>
 * 
 * Eine andere Klasse : {@link AndereKlasse}</br>
 * Die Methode test: {@link #test(String)}</br>
 * 
 * <h1>Eine �berschrift</h1>
 * <table border ="1">
 * <tr>
 * 		<th>Berlin</th>
 * 		<th>Hamburg</th>
 * 		<th>M�nchen</th>
 * 	</tr>
 * 	<tr>
 * 		<td>Milj�h</td>
 * 		<td>Kiez</td>
 * 		<td>Bierdampf</td>
 * 	</tr>
 * 	<tr>
 * 		<td>Buletten</td>
 * 		<td>Frikadellen</td>
 * 		<td>Fleischpflanzerl</td>
 * 	</tr>
 * </table>
 * Link zu Google: <a href = https://www.google.de> Linktext </a>
 * 
 * @see #test(String)
 * @since 1.0
 * @author 11556836
 * 
 */
public class JavaDocKlasse {
	/**
	 * Das ist die Main Methode
	 * 
	 * @param args : �bergebene Argumente
	 */
	public static void main(String[] args) {
		/*
		 * Ein Kommentar innerhalb der Methode zu einer Funktion hier drin
		 */
		System.out.println("Hello World");
	}

	/**
	 * Die Test Methode tut Dinge
	 * 
	 * @param einString : Ein String der �bergeben wird
	 * @return Gibt den String zur�ck.
	 */
	public String test(String einString) {
		return einString;
	}
}
