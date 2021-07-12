package alt.aufgaben.events.snake.v2;

public class Snake {
	private int segmente;	// Anzahl der Segmente einer Schlange
	//TODO: Datenstruktur Queue?
	private int x[];
	private int y[];
	
	// Aktuelle Bewegungsrichtung
	private boolean left = false;
	private boolean right = true;
	private boolean up = false;
	private boolean down = false;
	
	
	
	public Snake(int anzFelder) {
		segmente = 3;
		x = new int[anzFelder];
		y = new int[anzFelder];
		initSchlange();
	}

	// TODO: Startposition zufällig - so dass man nicht direkt crashed?
	/**
	 * Positioniert eine Schlange zufällig und legt außerdem eine zufällige Ausgangsbewegungsrichtung fest.
	 */
	private void initSchlange() {
		double rndm = Math.random()*4;
		if (rndm > 3) {
			left = true;
			right = false;
			up = false;
			down = false;
		}
		
		if (rndm > 2 && rndm <= 3) {
			left = false;
			right = true;
			up = false;
			down = false;
		}
		
		if (rndm > 1 && rndm <= 2) {
			left = false;
			right = false;
			up = true;
			down = false;
		}
		
		if (rndm > 0 && rndm <= 1) {
			left = false;
			right = false;
			up = false;
			down = true;
		}
		
		
		// Startposition der Schlange festlegen
		for (int z = 0; z < getSegmente(); z++) {			
			x[z] = (int)(Math.random() * Board.WIDTH/10)*10 - z * 10;
			y[z] = (int)(Math.random() * Board.WIDTH/10)*10;
		}

	}
	

	
	/** 
	 * Prüft, ob der Apfel gegessen wurde
	 * @param ax Die X-Koordninate des Apfels
	 * @param ay Die Y-Koordninate des Apfels
	 * @return true, falls der Apfel gegessen wurde, false sonst
	 */
	public boolean checkApple(int ax, int ay) {

		if ((x[0] == ax) && (y[0] == ay)) {
			segmente++;
			return true;
		}
		return false;		
	}
	
	/**
	 * Zur Bewegung in die aktuelle Richtung
	 * @param schrittweite 
	 */
	public void move(int schrittweite) {
		for (int z = getSegmente(); z > 0; z--) {
			x[z] = x[(z - 1)];
			y[z] = y[(z - 1)];
		}

		if (left) {
			x[0] -= schrittweite;
		}

		if (right) {
			x[0] += schrittweite;
		}

		if (up) {
			y[0] -= schrittweite;
		}

		if (down) {
			y[0] += schrittweite;
		}
		
	}

	public void moveLeft(int schrittweite) {
		if (!right) {
	        left = true;
	        up = false;
	        down = false;
		}
		move(schrittweite);		
	}
	
	public void moveRight(int schrittweite) {
		if (!left) {
            right = true;
            up = false;
            down = false;
		}
		move(schrittweite);		
	}
	
	public void moveUp(int schrittweite) {
		if (!down) {
            up = true;
            right = false;
            left = false;
		}
		move(schrittweite);		
	}
	
	public void moveDown(int schrittweite) {
		if (!up) {
            down = true;
            right = false;
            left = false;
		}
		move(schrittweite);		
	}
	
		
	public int getSegmente() {
		return segmente;
	}

	public int getY(int i) {
		return y[i];
	}

	public int getX(int i) {
		return x[i];
	}


}
