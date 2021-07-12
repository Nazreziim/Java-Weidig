package alt.aufgaben.events.snake.v3;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;


public class Board extends Observable {
	private int width = 30;    // Breite des Spielfelds
	private int height = 30;   // Höhe des Spielfelds

	
//	private Snake snake;
	private LinkedList<Snake> snakes;
	
	private int apple_x;			// X-Koordinate des Apfels
	private int apple_y;			// Y-Koordinate des Apfels


	
	// Spiel noch aktiv?
	private boolean inGame = true;

	public Board(int width, int height) {
		this.width = width;
		this.height = height;		
//		snake = new Snake(this);
		snakes = new LinkedList<>();
		snakes.add(new Snake(this));
		snakes.add(new Snake(this));			
		locateApple();
	}
	

	public void checkCollision() {
		for (Snake snake : snakes) {
			
		for (int z = snake.getSegmente(); z > 0; z--) {
			if ((z > 4) && (snake.getX(0) == snake.getX(z)) && (snake.getY(0) == snake.getY(z))) {
				inGame = false;
			}
		}

		if (snake.getY(0) > height) {
			inGame = false;
		}

		if (snake.getY(0) < 0) {
			inGame = false;
		}

		if (snake.getX(0) > width) {
			inGame = false;
		}

		if (snake.getX(0) < 0) {
			inGame = false;
		}
		}
	}

	/** Diese Methode belegt die beiden Klassenvariablen apple_x und apple_y
	 * mit zufälligen Werten. Dadurch wird der Apfel an eine neue Position gelegt.
	 */
	public void locateApple() {
		int r = (int) (Math.random() * width - 1);
		apple_x = r;
		r = (int) (Math.random() * height  - 1);
		apple_y = r;
	}

	public boolean isInGame() {
		return inGame;
	}



	public void tryMoveLeft(int nr) {
		snakes.get(nr).turnLeft();				
	}
	public void tryMoveRight(int nr) {
		snakes.get(nr).turnRight();				
	}
	public void tryMoveUp(int nr) {
		snakes.get(nr).turnUp();				
	}
	public void tryMoveDown(int nr) {
		snakes.get(nr).turnDown();				
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
			for (Snake snake : snakes) {
            if (snake.checkApple(apple_x,apple_y)) {
            	locateApple();
            }
            checkCollision();
            snake.move();
        }
		}
		
	}

	public int getAppleX() {
		return apple_x;
	}
	
	public int getAppleY() {
		return apple_y;
	}
	
	/**	 * 
	 * @return the snake
	 */
	public Snake getSnake(int nr) {
		return snakes.get(nr);
	}

	public LinkedList<Snake> getSnakes() {
		return snakes;
	}
	
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

}
