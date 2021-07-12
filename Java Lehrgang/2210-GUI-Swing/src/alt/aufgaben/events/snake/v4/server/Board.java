package alt.aufgaben.events.snake.v4.server;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class Board implements Serializable{

	private static final long serialVersionUID = 503906606106101578L;
	private int width = 30; // Breite des Spielfelds
	private int height = 30; // Höhe des Spielfelds

	// private Snake snake;
	private LinkedList<Snake> snakes;

	private int apple_x; // X-Koordinate des Apfels
	private int apple_y; // Y-Koordinate des Apfels

	// Spiel noch aktiv?
	// private boolean inGame = true;

	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		// snake = new Snake(this);
		snakes = new LinkedList<>();
//		snakes.add(new Snake(this));
//		snakes.add(new Snake(this));
		locateApple();
	}

	public int addSnake() {
		Snake s = new Snake(this);
		snakes.add(s);
		return s.getId();
	}
	
	public void checkCollision() {
		Iterator<Snake> it = snakes.iterator();
		while(it.hasNext()) {
			Snake snake = it.next();
			// 1.) Prüfen, ob die Schlange sich selbst berührt
			for (int z = snake.getSegmente(); z > 0; z--) {
				if ((z > 4) && (snake.getX(0) == snake.getX(z))
						&& (snake.getY(0) == snake.getY(z))) {
					snake.die();
				}
			}
			
			// 2.) Prüfen ob die Schlange auf den Rand gelaufen ist
			if (snake.getY(0) > height || snake.getY(0) < 0
					|| snake.getX(0) > width || snake.getX(0) < 0) {
				snake.die();
			}
			
			// 3.) Berührungen mit anderen Schlangen prüfen
			for (Snake s : snakes) {
				// TODO: 
			}
		}
	}

	/**
	 * Diese Methode belegt die beiden Klassenvariablen apple_x und apple_y mit
	 * zufälligen Werten. Dadurch wird der Apfel an eine neue Position gelegt.
	 */
	public void locateApple() {
		int r = (int) (Math.random() * width - 1);
		apple_x = r;
		r = (int) (Math.random() * height - 1);
		apple_y = r;
	}

	/**
	 * Prüft, ob noch aktive Schlangen im Spiel existieren
	 * @return true, falls noch mindestens eine Schlange lebt - false sonst
	 */
	public boolean isInGame() {
		boolean erg = false;
		for (Snake s : snakes) {
			if (s.isAlive()) {
				erg = true;
			}
		}
		return erg;
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
	 * Führt einen Schritt des Spiels durch. Ein Schritt besteht aus 1.
	 * Überprüfung ob man noch im Spiel ist 2. Prüfen, ob die Schlange des Apfel
	 * gegessen hat (und ggf. neue Positionierung des Apfels) 3. Prüfen, ob die
	 * Schlange mit der Wand oder sich selbst kollidiert ist. 4. Bewegung der
	 * Schlange
	 */
	public void gameStep() {

		for (Snake snake : snakes) {
			if (snake.isAlive()) {
				if (snake.checkApple(apple_x, apple_y)) {
					locateApple();
				}
				checkCollision();
				snake.move();
			} else {
				// TODO: gefährlich mit for-each
				snakes.remove(snake);
			}
		}

	}

	public int getAppleX() {
		return apple_x;
	}

	public int getAppleY() {
		return apple_y;
	}

	/**
	 * *
	 * 
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
