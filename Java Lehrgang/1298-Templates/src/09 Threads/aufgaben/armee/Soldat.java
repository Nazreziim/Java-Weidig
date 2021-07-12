package aufgaben.armee;

public class Soldat extends Thread {
	private int pk;
	
	public static int count = 1;
	private int zustand = 0;
	public Soldat(){
		super("Soldat-"+count);
		this.pk = count;
		count++;
	}
	public Soldat(Soldat s, int zustand){
		
		this.pk = s.pk;
		this.zustand = zustand;
	}
	
	public void run(){
		if(zustand == 0){
			packen();
		}else{
			essen();
		}
	}
	
	public void packen(){
		System.out.println(this.getName()+ " geht packen"+ " "+ this.toString());
		try {
			Thread.sleep((long) (Math.random()*10000+5000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.getName() + " meldet sich zurück");
		
	}
	public void essen(){
		System.out.println(this.getName()+ " ist beim essen"+ " "+ this.toString());
		try {
			Thread.sleep((long) (Math.random()*10000+5000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.getName() + " ist fertig mit essen");
		
	}

}
