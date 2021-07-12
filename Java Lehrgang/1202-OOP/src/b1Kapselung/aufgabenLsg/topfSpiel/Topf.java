package b1Kapselung.aufgabenLsg.topfSpiel;

public class Topf {
	private static int count = 0;

	private final int SIZE;
	private int coins;
	private int topfNr;

	public Topf(int size) {
		this.SIZE = size;
		this.topfNr = 1 + Topf.count++;
	}

	public boolean isFull() {
		return this.coins >= this.SIZE;
	}

	public void add(int n) {
		if (n > 0) {
			if (this.coins + n > this.SIZE) {
				this.coins = this.SIZE;
			} else {
				this.coins += n;
			}
		}
	}

	public void remove(int n) {
		if (n > 0) {
			if (this.coins - n < 0) {
				this.coins = 0;
			} else {
				this.coins -= n;
			}
		}
	}

	public int getCoins() {
		return this.coins;
	}

	public int getTopfNr() {
		return this.topfNr;
	}

}
