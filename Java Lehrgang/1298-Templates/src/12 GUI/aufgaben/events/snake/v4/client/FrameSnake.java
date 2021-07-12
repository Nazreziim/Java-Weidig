package aufgaben.events.snake.v4.client;


import java.awt.FlowLayout;

import javax.swing.JFrame;


public class FrameSnake extends JFrame {

	private static final long serialVersionUID = -7608490458920706239L;
	private MainClient client;
	
    public FrameSnake(MainClient root) {
    	this.client = root;
        this.add(new PanelSnake(this, 10));
        this.add(new PanelOptions(this));
        
        
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(m.getWidth(), m.getHeight());
        this.setLocationRelativeTo(null);
        this.setTitle("Snake");
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    public MainClient getClient() {
		return client;
	}

}