package alt.aufgaben.events.snake.v2;


import java.util.Observable;


public class Board extends Observable {
	public static final int WIDTH = 300;    // Breite des Spielfelds
	public static final int HEIGHT = 300;   // Höhe des Spielfelds
	private final int DOT_SIZE = 10;  // Größe der Einzelsegmente
	// Gesamtzahl der Punkte auf dem Spielfeld
	private final int ALL_DOTS = WIDTH / DOT_SIZE * HEIGHT / DOT_SIZE;

	
	//TODO: Kann sicher noch weg!
	//private final int RAND_POS = 29;  // Angabe der Grenze des Feldes
	
	private Snake snake;
	
	private int apple_x;			// X-Koordinate des Apfels
	private int apple_y;			// Y-Koordinate des Apfels


	
	// Spiel noch aktiv?
	private boolean inGame = true;

	public Board() {
		snake = new Snake(ALL_DOTS);		
		locateApple();
	}
	






	public void checkCollision() {

		for (int z = snake.getSegmente(); z > 0; z--) {
			if ((z > 4) && (snake.getX(0) == snake.getX(z)) && (snake.getY(0) == snake.getY(z))) {
				inGame = false;
			}
		}

		if (snake.getY(0) > HEIGHT) {
			inGame = false;
		}

		if (snake.getY(0) < 0) {
			inGame = false;
		}

		if (snake.getX(0) > WIDTH) {
			inGame = false;
		}

		if (snake.getX(0) < 0) {
			inGame = false;
		}
	}

	/** Diese Methode belegt die beiden Klassenvariablen apple_x und apple_y
	 * mit zufälligen Werten. Dadurch wird der Apfel an eine neue Position gelegt.
	 */
	public void locateApple() {
		int r = (int) (Math.random() * WIDTH / DOT_SIZE - 1);
		apple_x = ((r * DOT_SIZE));
		r = (int) (Math.random() * HEIGHT / DOT_SIZE - 1);
		apple_y = ((r * DOT_SIZE));
	}

	public boolean isInGame() {
		return inGame;
	}

	public int getAppleX() {
		return apple_x;
	}

	public int getAppleY() {
		return apple_y;
	}


	
	public void tryMoveLeft() {
		snake.moveLeft(DOT_SIZE);				
	}
	public void tryMoveRight() {
		snake.moveRight(DOT_SIZE);				
	}
	public void tryMoveUp() {
		snake.moveUp(DOT_SIZE);				
	}
	public void tryMoveDown() {
		snake.moveDown(DOT_SIZE);				
	}


	/**
	 * Führt einen Schritt des Spiels durch. Ein Schritt besteht aus
	 * 1. Überprüfung ob man noch im Spiel ist
	 * 2. Prüfen, ob die Schlange des Apfel gegessen hat (und ggf. neue Positionierung des Apfels)
	 * 3. Prüfen, ob die Schlange mit der Wand oder sich selbst kollidiert ist.
	 * 4. Bewegung der Schlange
	 */
	public void gameStep() {
		if (inGame) {
            if (snake.checkApple(apple_x,apple_y)) {
            	locateApple();
            }
            checkCollision();
            snake.move(DOT_SIZE);
        }
		
	}



	/**
	 * @return the snake
	 */
	public Snake getSnake() {
		return snake;
	}

}
