package überschreiben;

public class Equals {

	private int alter;
	private String name;

	// Override als Annotation dafür, dass ich die Methode überschreibe
	@Override
	public boolean equals(Object einObjekt) {
		// Temporäre Variable zum festlegen ob die Wahrheitsprüfung wahr oder falsch ist
		boolean gleich = false;
		// Prüfen ob das übergebene Objekt überhaupt vorhanden ist
		// und ob das einObjekt eine Instanz von Equals überhaupt ist
		if (einObjekt != null && einObjekt instanceof Equals) {
			// Erzeuge ein temporäres Vergleichsobjekt indem ich das übergebene
			// Objekt in meine Klasse zum Vergleichen caste <<
			// --- Casten wird bereits vorher auf Möglichkeit geprüft indem
			// ich prüfe ob es denn überhaupt eine Instanz meiner Klasse ist
			// Instanzen der eigenen Klasse kann ich auch in diese casten
			Equals temporäresVergleichsObjekt = (Equals) einObjekt;
			// ************************************************************
			// HIER WIRD JETZT FESTGELEGT
			// WAS GENAU ALLES ODER NUR
			// VERGLICHEN WERDEN SOLL
			// ************************************************************
			// Hier muss .equals genutzt werden weil es sich um 2 Strings handelt
			// und die equals Methode der Klasse String aufruft
			if (this.name.equals(temporäresVergleichsObjekt.name)) {
				// Sollte dieser Vergleich auch entsprechend richtig sein
				// speichere true in der Temporären Wahrheitsvariable
				gleich = true;
			}
			// Hier kann ich den == Operator nutzen zum Vergleich
			// zweier primitiver Datentypen
			if (this.alter == temporäresVergleichsObjekt.alter) {
				gleich = true;
			}

			// ERGEBNIS: Name ODER Alter müssen gleich sein damit true
			// rauskommt. Wenn ich ein anderes Verhalten möchte muss
			// ich meine Anweisung entsprechend abändern
		}
		// Gebe das Ergebnis der selbst erstellten Wahrheitsprüfung zurück
		return gleich;
	}

			//	//HIER STANDARD EQUALS
			//	@Override
			//	public boolean equals(Object obj) {
			//		// TODO Auto-generated method stub
			//		return super.equals(obj);
			//	}

	// GETTER UND SETTER

	/**
	 * @return the alter
	 */
	public int getAlter() {
		return alter;
	}

	/**
	 * @param alter the alter to set
	 */
	public void setAlter(int alter) {
		this.alter = alter;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
