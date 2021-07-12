package lsg.fussball;

public class Mannschaft {
	public Goalie torwart;
	public Verteidiger[] verteidigung = new Verteidiger[4];
	public Angreifer[] angriff = new Angreifer[6];

	public Mannschaft() {
		this.torwart = new Goalie();
		for (int i = 0; i < this.verteidigung.length; ++i) {
			this.verteidigung[i] = new Verteidiger();
		}
		for (int i = 0; i < this.angriff.length; ++i) {
			this.angriff[i] = new Angreifer();
		}
	}

	public void training() {
		torwart.training();
		for (Verteidiger v : verteidigung) {
			v.training();
		}
		for (Angreifer a : angriff) {
			a.training();
		}
	}

	public static void main(String... strings) {
		Mannschaft m = new Mannschaft();
		m.training();
	}
}
