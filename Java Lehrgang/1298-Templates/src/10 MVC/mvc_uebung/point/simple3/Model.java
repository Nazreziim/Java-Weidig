package mvc_uebung.point.simple3;

public class Model {

	private Point point;
	
	private int height;
	
	private int width;
	/**
	 * 0 - oben links
	 * 1 - unten links
	 * 2 - oben rechts
	 * 3 - unten rechts
	 */
	private int richtung; 
	
	private Control control;
	
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
			bewegeLinksHoch();			
		}else{
			if(richtung==1){
				bewegeLinksTief();
			}else{
				if(richtung==2){
					bewegeRechtsHoch();	
				}else{
					bewegeRechtsTief();
				}
			}
		}
		this.control.iamReady();
	}

	private void bewegeLinksHoch() {
		
		this.point.move(-1, 1);
		if(point.getX()<1){
			richtung = 2;
		}
		if(point.getY()>=this.height){
			richtung = 1;
		}	
		
	}


	private void bewegeLinksTief() {
		this.point.move(-1, -1);
		if(point.getX()<1){
			richtung = 3;
		}
		if(point.getY()<1){
			richtung = 0;
		}	
		
	}


	//Winkel zwischen renkrechten und Bewegungsrichtung ermitteln
	private void bewegeRechtsTief() {
		this.point.move(1, -1);
		if(point.getX()>=this.width){
			richtung = 1;
		}
		if(point.getY()<1){
			richtung = 2;
		}	
		
	}


	private void bewegeRechtsHoch() {
		this.point.move(1, 1);
		if(point.getX()>=this.width){
			richtung = 0;
		}
		if(point.getY()>=this.height){
			richtung = 3;
		}	
	}


	/**
	 * @return the point
	 */
	public Point getPoint() {
		return point;
	}



	public Control getControl() {
		return control;
	}



	public void setControl(Control control) {
		this.control = control;
	}
}
