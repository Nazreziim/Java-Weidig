package baeume.vorlage;

public class TE{
	int key;
	int info;
	
	TE left;
	TE right;
	
	public TE(int key, int info){
		this.key = key;
		this.info = info;
	}
	
	public TE(int key){
		this(key,0);
	}
	
	public void add(int key){
		if(key<=this.key){
			if(this.left == null){
				this.left =  new TE(key);
			}
			else{
				this.left.add(key);
			}
		}
		else{
			if(this.right == null){
				this.right = new TE(key);
			}
			else{
				this.right.add(key);
			}
		}
	}
	
	public void print_io(){
		if(this.left != null){
			this.left.print_io();
		}
		
		System.out.print(this.key + " ");
		
		if(this.right != null){
			this.right.print_io();
		}
	}
	public void print_pre(){
		System.out.print(this.key + " ");
		if(this.left != null){
			this.left.print_pre();
		}		
		if(this.right != null){
			this.right.print_pre();
		}
	}
	public void print_post(){		
		if(this.left != null){
			this.left.print_post();
		}		
		if(this.right != null){
			this.right.print_post();
		}		
		System.out.print(this.key + " ");
	}
	
	public TE delete(int key){
		if(key == this.key){
				if(this.left == null){
					return this.right;
				}
				else if(this.right == null){
					return this.left;
				}		
				else{
					TE vertreter = this.left.hilfDelete();
					this.key = vertreter.key;
					this.info = vertreter.info;
					this.left = this.left.delete(vertreter.key);
					return this;
				}
		}
		if(key < this.key){
			if(this.left != null){
				this.left = this.left.delete(key);
			}
		}
		else{
			if(this.right != null){
				this.right = this.right.delete(key);
			}
		}
		return this;
	}
	
	private TE hilfDelete(){
		if(this.right != null){
			return this.right.hilfDelete();
		}
		else{
			return this;
		}
	}
	
	public int countLeaf(){
		int erg = 0;
		if(this.right == null && this.left == null){
			return 1;
		}
		else{
			if(this.right != null){
				erg = this.right.countLeaf();
			}
			if(this.left != null){
				erg += this.left.countLeaf();
			}
			return  erg; 
		}
	}
	public int countK(){
		int erg = 0;
		if(this.right == null && this.left == null){
			erg = 1;
		}
		else{
			if(this.right != null){
				erg = this.right.countK();
			}
			if(this.left != null){
				erg += this.left.countK();
			}
			erg = erg + 1; 
		}
		return erg;
	}
	

}

