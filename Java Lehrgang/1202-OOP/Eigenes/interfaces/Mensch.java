package interfaces;

//Es ist nicht m�glich von Interfaces zu erben
//Abstrakte Klassen sind immer public
abstract class Mensch  implements S�ugetier, Zweibeiner {

	// Abstrakte Klassen k�nnen Konstruktoren haben und nutzen
	public Mensch() {

	}

	/**
	 * Abstrakte Klassen m�ssen die Methoden von Interfaces nicht erst
	 * implementieren.
	 */

	// KANN WEGGELASSEN WERDEN DA DIES AUTOMATISCH
	// IM HINTERGRUND PASSIERT
	@Override
	public abstract void essen();

	/**
	 * Wenn zwei Interfaces mit exakt den gleichen Methoden implementiert werden
	 * muss man die Methode �berschreiben und explizit die gew�nschte Methode �ber
	 * Klasse.super ausw�hlen
	 */
	@Override
	public void bewegen() {
		Zweibeiner.super.bewegen();
	}

}
