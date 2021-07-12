package mvc_uebung.point.simple1;

public class View {
	private Model model;
	
	public View(Model model){
		this.model = model;
	}
	
	
	public void update(){
		System.out.println();
		for(int i = 0; i <= this.model.getHeight(); i++){
			System.out.println();
			for(int j = 0; j <= this.model.getWidth(); j++){
				if(this.model.getPoint().x == j &&this.model.getPoint().y == i ){
					System.out.print('#');
				}
				else{
					System.out.print('.');
				}
			}
		}
		System.out.println(this.model.getPoint());
	}
}
