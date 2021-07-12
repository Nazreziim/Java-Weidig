package mvc_uebung.point.observer_gui;

import java.util.Observable;
import java.util.Observer;

public class View2 implements Observer{

	
	
	@Override
	public void update(Observable o, Object arg) {
		Model model = (Model) o;
		System.out.println();
		for(int i = 0; i <= model.getHeight(); i++){
			System.out.println();
			for(int j = 0; j <= model.getWidth(); j++){
				if(model.getPoint().x == j && model.getPoint().y == i ){
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
