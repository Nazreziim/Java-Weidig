package basic.version6;

import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		ZahlEinfach model = new ZahlEinfach();
		ViewDezimal viewDezimal = new ViewDezimal(model);
		ViewStern viewStern = new ViewStern(model);

		List<View> views = new LinkedList<View>();
		views.add(viewDezimal);
		views.add(viewStern);
		
		Controller controller = new Controller(model, views);
		controller.start();

	}

}
