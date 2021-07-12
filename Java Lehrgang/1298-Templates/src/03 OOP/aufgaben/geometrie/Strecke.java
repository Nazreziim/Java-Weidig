package aufgaben.geometrie;

import java.util.Vector;


/**
 	Strecke ist eine spezialisierte Figur
 */
public class Strecke extends Figur {
	
	/*
		Konstruktor, welcher eine Menge von Punkten enth�lt
		Kontrolle, ob es sich auch wirklich nur um zwei Punkte handelt, entf�llt hier
	*/	
	public Strecke(Vector<Punkt> punkte){
		//Aufruf des Konstruktors der Oberklasse
		super(punkte);
	}
	
	public double getLaenge(){
		return punkte.elementAt(0).getAbstand(punkte.elementAt(1));
	}
	
}
