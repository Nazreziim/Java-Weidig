package alt.aufgaben.events.snake.v3;


import java.awt.FlowLayout;

import javax.swing.JFrame;


public class FrameSnake extends JFrame {
	private Board m;
	
    public FrameSnake(Board m ) {
    	this.m = m;  
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

    protected Board getModel() {
    	return m;
    }

}