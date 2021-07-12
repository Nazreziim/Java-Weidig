package statisches;

public class Statics{
	private Integer i;
	
	private static int count = 0;
	
	public Statics(int zahl) {
		this.i = zahl;
		count++;
	}
	
	public String toString() {
		return "i: " + this.i + " Counter: " + count;
	}
	
	public static int getCount(){
		return count;
	}

	public static void main(String[] args){
		System.out.println(Statics.getCount());

		Statics k = new Statics(10);
		System.out.println(k);
		
		System.out.println("-----");

		Statics k2 = new Statics(200);
		System.out.println(k);
		System.out.println(k2);
		
		System.out.println(Statics.getCount());
		
		System.out.println(Integer.MAX_VALUE + 1); 
	}
}
