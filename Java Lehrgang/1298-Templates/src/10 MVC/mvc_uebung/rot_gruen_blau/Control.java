package mvc_uebung.rot_gruen_blau;

public class Control {

	private Model model;

	public Control(Model model) {
		this.model = model;
	}

	public void letsGo() {
		char abbr;
		do {
			try {
				abbr = HilfsMeth.readChar("Wollen Sie den Rot Wert verändern (j/n)?");
				if (abbr == 'j') {
					this.model.setRot(HilfsMeth
							.readInt("Geben Sie einen Rotwert ein: "));
				}
				abbr = HilfsMeth
						.readChar("Wollen Sie den Grün Wert verändern (j/n)?");
				if (abbr == 'j') {
					this.model.setGrün(HilfsMeth
							.readInt("Geben Sie einen Grünwert ein: "));
				}
				abbr = HilfsMeth
						.readChar("Wollen Sie den Blau Wert verändern (j/n)?");
				if (abbr == 'j') {
					this.model.setBlau(HilfsMeth
							.readInt("Geben Sie einen Blauwert ein: "));
				}
			} catch (NumberFormatException e) {
				System.out.println("Fehler! Geben Sie nur Ganzzahlige Werte an!");
			}
			abbr = HilfsMeth
					.readChar("Wollen Sie weiterhin die Werte verändern(j/n)?");

		} while (abbr != 'n');
	}
}
