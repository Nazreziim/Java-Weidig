package mvc_uebung.point.observer_gui;

import java.util.Observable;


public class Model extends Observable{

	private Point point;
	
	private int height;
	
	private int width;
	/**
	 * 0 - oben rechts
	 * 1 - oben links
	 * 2 - unten rechts
	 * 3 - unten links
	 */
	private int richtung; 
	

	public Model( int width,int height){
		point = new Point(width/2,height/2);
		this.height = height;
		this.width = width;
		this.richtung = 0;
	}

	

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}


	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	//bewegt immer um eine Einheit
	public void move() {
		//System.out.println("Richtung "+richtung);
		if(richtung==0){
			moveTopRight();			
		}else{
			if(richtung==1){
				moveTopLeft();
			}else{
				if(richtung==2){
					moveDownRight();	
				}else{
					moveDownLeft();
				}
			}
		}
		this.setChanged();
		this.notifyObservers("Hallo Model");
	}

	private void moveTopLeft() {		
		
		if(point.getX()<0){
			richtung = 0;
			this.move();
		}
		else if(point.getY()>=this.height){
			richtung = 3;
			this.move();
		}	
		else{
			this.point.move(-1, 1);
		}
		
	}


	private void moveDownLeft() {
		
		if(point.getX()<=0){
			richtung = 2;
			this.move();
		}
		else if(point.getY()<=0){
			richtung = 1;
			this.move();
		}	
		else{
			this.point.move(-1, -1);
		}
		
	}


	//Winkel zwischen renkrechten und Bewegungsrichtung ermitteln
	private void moveDownRight() {
		
		if(point.getX()>=this.width){
			richtung = 3;
			move();
		}
		else if(point.getY()<=0){
			richtung = 0;
		}	
		else{
			this.point.move(1, -1);
		}
	}


	private void moveTopRight() {
		
		if(point.getX()>=this.width){
			richtung = 1;
			move();
		}
		else if(point.getY()>=this.height){
			richtung = 2;
			move();
		}	
		else{
			this.point.move(1, 1);
		}
	}


	/**
	 * @return the point
	 */
	public Point getPoint() {
		return point;
	}
	
	
	
}
