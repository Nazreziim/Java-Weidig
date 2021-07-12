/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alt.aufgaben.zeichnen.smiley;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author dborkowitz
 */
public class Leinwand extends JPanel {

    Color c = Color.yellow;
    private int y = 280;
    private int h = 80;
    private int arcend = -180;
    

    public Leinwand() {
        this.setBackground(Color.white);
        initialize();
    }

    private void initialize() {
        Thread t = new Thread() {

            @Override
            public void run() {
                int i = 0;
                int f = 1;
                int stat = 0;
                while (i < 1000) {
                    try {
                        h -= 2 * f;
                        y += f;
                        if (h == 0) {
                            if (stat == 0) {
                                arcend = 180;
                                stat++;
                            } else {
                                arcend = -180;
                                stat--;
                            }
                            f *= -1;
                        }
                        if (h == 80) {
                            f *= -1;
                        }
                        Leinwand.this.repaint();
                        Thread.sleep(100);
                        i++;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Leinwand.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        this.setBackground(Color.white);
        g.setColor(c);
        
        // Gesicht
        g.fillOval(0, 0, 400, 400);   
        g.setColor(Color.black);

        // Augen
        g.fillOval(100, 100, 50, 50);
        g.fillOval(250, 100, 50, 50);

        // Nase
        g.fillRect(190, 150, 20, 100);

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(20, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));

        // Mund
        g.drawArc(100, y, 200, h, 0, arcend);
        
        // Schriftzug
        Font f = new Font("Courier New", Font.ITALIC, 20);
        try {
           f = Font.createFont(Font.PLAIN, getClass().getResourceAsStream("D:/WorkspaceJava/Java-Lehrgang/12 GUI/res/Hawaii_Killer.ttf"));
            f = f.deriveFont(80.0f);
        } catch (FontFormatException ex) {
            Logger.getLogger(Leinwand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Leinwand.class.getName()).log(Level.SEVERE, null, ex);
        }
        g.setFont(f);
        FontMetrics metrics = g.getFontMetrics();
        g.drawString("Unser Smiley", 50, 500);
        
        g2.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        g.drawLine(50, 502, 50 + metrics.stringWidth("Unser Smiley"), 502);
//        try {
//            BufferedImage img = ImageIO.read(Leinwand.class.getResource("/bilder/cartoon.jpg"));
//            g.drawImage(img, 200, 200, this);
//        } catch (IOException ex) {
//            Logger.getLogger(Leinwand.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        g2.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
//        g.drawLine(0, 480, 500, 180);
//
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2.drawLine(0, 500, 500, 200);
//
//        Shape arc = new Arc2D.Double(100, y , 200, h, 0, arcend, Arc2D.CHORD);
//        g2.fill(arc);
       

    }
}
