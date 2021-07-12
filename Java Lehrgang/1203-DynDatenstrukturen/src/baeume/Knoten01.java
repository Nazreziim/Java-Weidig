package baeume;

public class Knoten01 {
	// Attribute
	private int key;
	private char info;
	private Knoten01 left;
	private Knoten01 right;
	
	public Knoten01(int key, char info){
		this.key = key;
		this.info = info;
	}

	// Getter- und Setter-Methoden
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public char getInfo() {
		return info;
	}

	public void setInfo(char info) {
		this.info = info;
	}

	public Knoten01 getLeft() {
		return left;
	}

	public void setLeft(Knoten01 left) {
		this.left = left;
	}

	public Knoten01 getRight() {
		return right;
	}

	public void setRight(Knoten01 right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return String.format("Key: %02d, Info: %c", this.key, this.info);
	}

	/*
	 * handelt es sich um ein Blatt
	 */
	public boolean isLeaf(){
		return (this.left == null && this.right == null);
	}
	
	public boolean isLeftSon(){
		return (this.left != null && this.right == null);
	}
	
	public boolean isRightSon(){
		return (this.left == null && this.right != null);
	}
}
