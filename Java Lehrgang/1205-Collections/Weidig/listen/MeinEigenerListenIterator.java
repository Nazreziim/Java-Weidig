package listen;

import java.util.Iterator;
import java.util.List;

public class MeinEigenerListenIterator<E> implements Iterator<E> {

	// Die zu verwendende Liste
	private List<E> l;
	// Der Zeiger meiner Liste
	private int zeiger;

	// Konstruktor benötigt die Liste zu der der Iterator erstellt werden soll
	public MeinEigenerListenIterator(List<E> l) {
		// Setze die erhaltene Liste als Instanz-Liste meiner Klasse
		this.l = l;
		// Setze den Zeiger auf 0
		this.zeiger = 0;
	}

	//Prüft ob ein nächstes Element vorhanden ist
	@Override
	public boolean hasNext() {
		// Solange der Zeiger auf einer Position ist die kleiner der gesamten Größe der
		// Liste ist gibt er true zurück
		return zeiger < l.size();
	}

	//Gibt die Regeln zum Springen auf das nächste Element vor
	@Override
	public E next() {
		//Speichere das generische Element zwischen
		E element;
		//Setze den Wert auf den der Zeiger zeigt in mein Element
		element = l.get(zeiger);
		//Setze den Zeiger auf das nächste Element
		zeiger++;
		//Möglichkeiten:
		// zeiger = zeiger+2; // Springt immer 2 Stellen weiter
		//Gebe mir dann den in element gespeicherten Wert zurück
		return element;
	}
	
	

}
