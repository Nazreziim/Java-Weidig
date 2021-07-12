package mvc_uebung.point.observer;

public class View2 implements Observer{
	private Model model;
	
	public View2(Model model){
		this.model = model;
		this.model.addObserver(this);
	}
	
	
	public void update(){
		System.out.println();
		for(int i = 0; i <= this.model.getHeight(); i++){
			System.out.println();
			for(int j = 0; j <= this.model.getWidth(); j++){
				if(this.model.getPoint().x == j &&this.model.getPoint().y == i ){
					System.out.print('o');
				}
				else{
					System.out.print(' ');
				}
			}
		}
		System.out.println();
	}
}
