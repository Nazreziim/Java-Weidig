package alt.aufgaben.events.snake.v4.client;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOptions extends JPanel {
	private FrameSnake root;
	
	public PanelOptions(FrameSnake root) {
		this.root = root;
		this.add(new JButton("Bla"));
	}

}
