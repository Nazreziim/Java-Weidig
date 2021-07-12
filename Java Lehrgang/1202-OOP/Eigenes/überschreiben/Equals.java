package �berschreiben;

public class Equals {

	private int alter;
	private String name;

	// Override als Annotation daf�r, dass ich die Methode �berschreibe
	@Override
	public boolean equals(Object einObjekt) {
		// Tempor�re Variable zum festlegen ob die Wahrheitspr�fung wahr oder falsch ist
		boolean gleich = false;
		// Pr�fen ob das �bergebene Objekt �berhaupt vorhanden ist
		// und ob das einObjekt eine Instanz von Equals �berhaupt ist
		if (einObjekt != null && einObjekt instanceof Equals) {
			// Erzeuge ein tempor�res Vergleichsobjekt indem ich das �bergebene
			// Objekt in meine Klasse zum Vergleichen caste <<
			// --- Casten wird bereits vorher auf M�glichkeit gepr�ft indem
			// ich pr�fe ob es denn �berhaupt eine Instanz meiner Klasse ist
			// Instanzen der eigenen Klasse kann ich auch in diese casten
			Equals tempor�resVergleichsObjekt = (Equals) einObjekt;
			// ************************************************************
			// HIER WIRD JETZT FESTGELEGT
			// WAS GENAU ALLES ODER NUR
			// VERGLICHEN WERDEN SOLL
			// ************************************************************
			// Hier muss .equals genutzt werden weil es sich um 2 Strings handelt
			// und die equals Methode der Klasse String aufruft
			if (this.name.equals(tempor�resVergleichsObjekt.name)) {
				// Sollte dieser Vergleich auch entsprechend richtig sein
				// speichere true in der Tempor�ren Wahrheitsvariable
				gleich = true;
			}
			// Hier kann ich den == Operator nutzen zum Vergleich
			// zweier primitiver Datentypen
			if (this.alter == tempor�resVergleichsObjekt.alter) {
				gleich = true;
			}

			// ERGEBNIS: Name ODER Alter m�ssen gleich sein damit true
			// rauskommt. Wenn ich ein anderes Verhalten m�chte muss
			// ich meine Anweisung entsprechend ab�ndern
		}
		// Gebe das Ergebnis der selbst erstellten Wahrheitspr�fung zur�ck
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
