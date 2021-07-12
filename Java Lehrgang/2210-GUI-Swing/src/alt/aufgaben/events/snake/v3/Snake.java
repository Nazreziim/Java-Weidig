package alt.aufgaben.events.snake.v3;

public class Snake {
	private int segmente;	// Anzahl der Segmente einer Schlange
	//TODO: Datenstruktur Queue?
	private int x[];
	private int y[];
	
	// Bewegungsrichtungen
	public static final int LEFT  = 1;
	public static final int RIGHT = 2;
	public static final int UP    = 3;
	public static final int DOWN  = 4;
	
	
	// Aktuelle Bewegungsrichtung
	private int richtung;
	
	
	private Board spielfeld;
	
	
	public Snake(Board b) {
		this.spielfeld = b;
		segmente = 3;
		x = new int[b.getWidth()];
		y = new int[b.getHeight()];
		initSchlange();
	}

	// TODO: Startposition zuf�llig - so dass man nicht direkt crashed?
	/**
	 * Positioniert eine Schlange zuf�llig und legt au�erdem eine zuf�llige Ausgangsbewegungsrichtung fest.
	 */
	private void initSchlange() {
		double rndm = Math.random()*4;
		if (rndm > 3) {
			 richtung = LEFT;
		}
		
		if (rndm > 2 && rndm <= 3) {
			richtung = RIGHT;
		}
		
		if (rndm > 1 && rndm <= 2) {
			richtung = UP;
		}
		
		if (rndm > 0 && rndm <= 1) {
			richtung = DOWN;
		}
		
		
		// Startposition der Schlange festlegen
		for (int z = 0; z < getSegmente(); z++) {			
			x[z] = (int)(Math.random() * spielfeld.getWidth()) - z;
			y[z] = (int)(Math.random() * spielfeld.getHeight());
		}

	}
	

	
	/** 
	 * Pr�ft, ob der Apfel gegessen wurde
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
	public void move() {
		for (int z = getSegmente(); z > 0; z--) {
			x[z] = x[(z - 1)];
			y[z] = y[(z - 1)];
		}

		if (richtung == LEFT) {
			x[0]--;
		}

		if (richtung == RIGHT) {
			x[0]++;
		}

		if (richtung == UP) {
			y[0]--;
		}

		if (richtung == DOWN) {
			y[0]++;
		}
		
	}

	public void turnLeft() {
		if (richtung != RIGHT) {
	        richtung = LEFT;
		}
	}
	
	public void turnRight() {
		if (richtung != LEFT) {
            richtung = RIGHT;
		}	
	}
	
	public void turnUp() {
		if (richtung != DOWN) {
            richtung = UP;            
		}	
	}
	
	public void turnDown() {
		if (richtung != UP) {
            richtung = DOWN;            
		}	
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
