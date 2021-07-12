package day5.p1b.events.games.snake.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * Simple Game Model for Snake
 * 
 * @author kmoench
 * @version 0.2
 */
public class Game {

  /**
   * Directions to move the snake.
   * 
   * @author kmoench
   *
   */
  public static enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
  }

  private final int HEIGHT;
  private final int WIDTH;
  private final int MIN_X;
  private final int MAX_X;
  private final int MIN_Y;
  private final int MAX_Y;

  private Direction lastDirection = Direction.UP;
  private boolean gameOver = false;

  private LinkedList< SnakeElement > snake;
  private LinkedList< Apple > apples;

  /**
   * Snake Game model with cartesian coordinate system (y-coordinates up / x-coordinates right) <br>
   * <code>^y<br>
  |<br>
  |<br>
  |0   x<br>
  +---->
  </code>
   * 
   * @param height Height of the Game
   * @param width Width of the Game
   */
  public Game( int height, int width ) {
    this.snake = new LinkedList<>();
    this.apples = new LinkedList<>();
    this.HEIGHT = height;
    this.WIDTH = width;
    this.MIN_X = 0;
    this.MAX_X = this.WIDTH - 1;
    this.MIN_Y = 0;
    this.MAX_Y = this.HEIGHT - 1;

    // Populate Snake (Generate first SnakeElement)
    this.snake.add( new SnakeElement( this.MAX_X / 2, this.MAX_Y / 2 ) );
  }

  /**
   * If this Method returns true, the Game is over.
   * 
   * @return true, if the game is over, otherwise false
   */
  public boolean isGameOver() {
    return this.gameOver;
  }

  /**
   * Height of the Game.
   * 
   * @return height
   */
  public int getHeight() {
    return this.HEIGHT;
  }

  /**
   * Width of the Game.
   * 
   * @return width
   */
  public int getWidth() {
    return this.WIDTH;
  }

  /**
   * Current Score of the Game. 1 Point per SnakeElement.
   * 
   * @return Score
   */
  public int getPoints() {
    return this.snake.size();
  }

  /**
   * Move in the last given Direction. For automatic movement.
   */
  public void move() {
    this.move( this.lastDirection );
  }

  /**
   * Main Method to move the Snake
   * 
   * @param direction The direction to move.
   */
  public void move( Direction direction ) {
    switch ( direction ) {
      case UP :
        moveUp();
        break;
      case DOWN :
        moveDown();
        break;
      case LEFT :
        moveLeft();
        break;
      case RIGHT :
        moveRight();
        break;
    }
    this.lastDirection = direction;
    populateApples();
  }

  private void populateApples() {
    if ( this.apples.size() < 2 ) {
      Random random = new Random();
      Position pos;
      do {
        pos = new Position( random.nextInt( this.WIDTH ), random.nextInt( this.HEIGHT ) );
      } while ( this.getApple( pos ) != null && this.getSnake( pos ) != null );
      this.apples.add( new Apple( pos ) );
    }
  }

  /**
   * Moving Up => increasing y-Coordinate
   */
  private void moveUp() {
    SnakeElement head = this.snake.getFirst();
    Position nextPosition;
    if ( head.getPos().getPosY() >= this.MAX_Y ) {
      nextPosition = new Position( head.getPos().getPosX(), this.MIN_Y );
    } else {
      nextPosition = new Position( head.getPos().getPosX(), head.getPos().getPosY() + 1 );
    }
    moveSnake( nextPosition );
  }

  /**
   * Moving Right => increasing x-Coordinate
   */
  private void moveRight() {
    SnakeElement head = this.snake.getFirst();
    Position nextPosition;
    if ( head.getPos().getPosX() >= this.MAX_X ) {
      nextPosition = new Position( this.MIN_X, head.getPos().getPosY() );
    } else {
      nextPosition = new Position( head.getPos().getPosX() + 1, head.getPos().getPosY() );
    }
    moveSnake( nextPosition );
  }

  /**
   * Moving Down => decreasing y-Coordinate
   */
  private void moveDown() {
    SnakeElement head = this.snake.getFirst();
    Position nextPosition;
    if ( head.getPos().getPosY() <= this.MIN_Y ) {
      nextPosition = new Position( head.getPos().getPosX(), this.MAX_Y );
    } else {
      nextPosition = new Position( head.getPos().getPosX(), head.getPos().getPosY() - 1 );
    }
    moveSnake( nextPosition );
  }

  /**
   * Moving Left => decreasing x-Coordinate
   */
  private void moveLeft() {
    SnakeElement head = this.snake.getFirst();
    Position nextPosition;
    if ( head.getPos().getPosX() <= this.MIN_X ) {
      nextPosition = new Position( this.MAX_X, head.getPos().getPosY() );
    } else {
      nextPosition = new Position( head.getPos().getPosX() - 1, head.getPos().getPosY() );
    }
    moveSnake( nextPosition );
  }

  private void moveSnake( Position nextPosition ) {
    Apple apple = this.getApple( nextPosition );
    if ( this.getSnake( nextPosition ) != null ) {
      // Snake bit itself > GameOver
      this.gameOver = true;
    } else if ( apple != null ) {
      System.out.println( "Fresse Apfel" );
      this.apples.remove( apple );
      // create new SnakeElement
      System.out.println( "Neues Element." );
      SnakeElement newSnakeElement = new SnakeElement( new Position( this.snake.getLast().getPos() ) );
      // Move snake
      System.out.println( "Bewege mich" );
      moveSnakeElements( nextPosition );
      // add new SnakeElement
      System.out.println( "Werde länger" );
      this.snake.add( newSnakeElement );
    } else {
      // Move Snake
      moveSnakeElements( nextPosition );
    }
  }

  private void moveSnakeElements( Position nextPosition ) {
    Iterator< SnakeElement > itRev = this.snake.descendingIterator();
    SnakeElement currentElement = itRev.next();
    System.out.println( "Processing: " + currentElement );
    while ( itRev.hasNext() ) {
      SnakeElement nextElement = itRev.next();
      currentElement.setPos( new Position( nextElement.getPos() ) );
      currentElement = nextElement;
    }
    currentElement.setPos( nextPosition );
  }

  /**
   * Returns the Apple at the position.
   * 
   * @param position Given position.
   * @return Apple at the position or null, if no apple exists at the position
   */
  public Apple getApple( Position position ) {
    Apple apple = null;
    Iterator< Apple > it = this.apples.iterator();
    while ( it.hasNext() && apple == null ) {
      Apple current = it.next();
      if ( current.getPos().equals( position ) ) {
        apple = current;
      }
    }
    return apple;
  }

  /**
   * Returns the SnakeElement at the position.
   * 
   * @param position Given position
   * @return SnakeElement at the given position or null, if no SnakeElement exisits at the Position.
   */
  public SnakeElement getSnake( Position position ) {
    SnakeElement snakeElement = null;
    Iterator< SnakeElement > it = this.snake.iterator();
    while ( it.hasNext() && snakeElement == null ) {
      SnakeElement current = it.next();
      if ( current.getPos().equals( position ) ) {
        snakeElement = current;
      }
    }
    return snakeElement;
  }

}
