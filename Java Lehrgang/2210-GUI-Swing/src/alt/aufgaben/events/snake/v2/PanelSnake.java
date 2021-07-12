package alt.aufgaben.events.snake.v2;


import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class PanelSnake extends JPanel implements ActionListener {

	private final int DELAY = 140;
	private Timer timer;
	private FrameSnake root;

    public PanelSnake(FrameSnake root) {
    	this.root = root;
    	timer = new Timer(DELAY, this);
		timer.start();
        addKeyListener(new TAdapter());

        setBackground(Color.black);

//        ImageIcon iid = new ImageIcon(this.getClass().getResource("dot.png"));
//        ball = iid.getImage();
//
//        ImageIcon iia = new ImageIcon(this.getClass().getResource("apple.png"));
//        apple = iia.getImage();
//
//        ImageIcon iih = new ImageIcon(this.getClass().getResource("head.png"));
//        head = iih.getImage();

        setFocusable(true);

    }


    

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Board m = root.getModel();
        if (m.isInGame()) {
        	g.setColor(Color.GREEN);
        	g.fillOval(m.getAppleX(), m.getAppleY(), 10, 10);
           // g.drawImage(apple, apple_x, apple_y, this);

            for (int z = 0; z < m.getSnake().getSegmente(); z++) {
                if (z == 0){
                	g.setColor(Color.RED);
                    //g.drawImage(head, x[z], y[z], this);
                } else { 
                	g.setColor(Color.LIGHT_GRAY);
//                	g.drawImage(ball, x[z], y[z], this);
                }
                g.fillOval(m.getSnake().getX(z), m.getSnake().getY(z), 10, 10);
            }

//            Toolkit.getDefaultToolkit().sync();
//            g.dispose();

        } else {
            gameOver(g);
        }
    }


    public void gameOver(Graphics g) {
        String msg = root.getModel().getSnake().getSegmente() + " Punkte - Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 24);
        FontMetrics metr = this.getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg,(this.getWidth()-metr.stringWidth(msg))/2, this.getHeight()/2);         
    }


    

    public void actionPerformed(ActionEvent e) {
    	root.getModel().gameStep();
        repaint();
    }


    private class TAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT)) {
            	root.getModel().tryMoveLeft();
            }

            if ((key == KeyEvent.VK_RIGHT)) {
            	root.getModel().tryMoveRight();
            }

            if ((key == KeyEvent.VK_UP) ) {
            	root.getModel().tryMoveUp();
            }

            if ((key == KeyEvent.VK_DOWN)) {
            	root.getModel().tryMoveDown();
            }
        }
    }
}