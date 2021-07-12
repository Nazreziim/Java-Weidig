package mvc_uebung.point.simple2;


public class View {
	private Model model;
	
	public View(Model m){
		this.model = m;
	}
	public void update() {
		//System.out.println(this.model.getPoint());
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		for(int i = 0; i <= this.model.getHeight(); i++){
			System.out.println();
			for(int j = 0; j <=this.model.getWidth(); j++){
				
				if(this.model.getPoint().getX() == j && this.model.getPoint().getY() == i){
					System.out.print('X');
				}
				else{
					System.out.print('.');
				}
				
			}
		}
	}

}
