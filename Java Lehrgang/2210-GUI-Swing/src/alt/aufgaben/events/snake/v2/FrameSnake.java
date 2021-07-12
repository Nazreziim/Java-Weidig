package alt.aufgaben.events.snake.v2;


import javax.swing.JFrame;


public class FrameSnake extends JFrame {
	private Board m;
	
    public FrameSnake(Board m ) {
    	this.m = m;
        add(new PanelSnake(this));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 340);
        setLocationRelativeTo(null);
        setTitle("Snake");

        setResizable(false);
        setVisible(true);
    }

    protected Board getModel() {
    	return m;
    }

}