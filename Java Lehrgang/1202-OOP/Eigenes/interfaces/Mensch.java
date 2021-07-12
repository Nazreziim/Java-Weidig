package interfaces;

//Es ist nicht möglich von Interfaces zu erben
//Abstrakte Klassen sind immer public
abstract class Mensch  implements Säugetier, Zweibeiner {

	// Abstrakte Klassen können Konstruktoren haben und nutzen
	public Mensch() {

	}

	/**
	 * Abstrakte Klassen müssen die Methoden von Interfaces nicht erst
	 * implementieren.
	 */

	// KANN WEGGELASSEN WERDEN DA DIES AUTOMATISCH
	// IM HINTERGRUND PASSIERT
	@Override
	public abstract void essen();

	/**
	 * Wenn zwei Interfaces mit exakt den gleichen Methoden implementiert werden
	 * muss man die Methode überschreiben und explizit die gewünschte Methode über
	 * Klasse.super auswählen
	 */
	@Override
	public void bewegen() {
		Zweibeiner.super.bewegen();
	}

}
