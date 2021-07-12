package mvc_uebung.point.simple1;



public class Point {
	int x;
	int y;
	
	
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Punkt("+this.x+", "+this.y+")";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void move(int x, int y){
		this.x += x;
		this.y += y;
	}
	
	
}
