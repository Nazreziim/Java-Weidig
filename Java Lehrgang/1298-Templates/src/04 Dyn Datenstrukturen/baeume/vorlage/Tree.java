package baeume.vorlage;

public class Tree{
	private TE wurzel;

	public Tree(){
		this.wurzel = null;
	}
	
	public void add(int key){
		if(this.wurzel == null){			
			this.wurzel = new TE(key);
		}
		else{
			this.wurzel.add(key);
		}
	}
	
	public void print_io(){
		if(this.wurzel != null){
			this.wurzel.print_io();
		}
	}
	
	public void delete(int key){
		if(this.wurzel != null){
			this.wurzel = this.wurzel.delete(key);
		}
	}	
}

