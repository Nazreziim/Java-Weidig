/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alt.aufgaben.zeichnen.smiley;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author dborkowitz
 */
public class Leinwand_1 extends JPanel {

    Color c = Color.red;
    protected float f = 0;

    public Leinwand_1() {
        initialize();
    }

    private void initialize() {
        Thread t = new Thread() {

            @Override
            public void run() {
                int i = 0;
                while (i < 100000) {
                    f += 0.01;
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Leinwand_1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Leinwand_1.this.repaint();
                    i++;
                }
            }
        };
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        GeneralPath gp = new GeneralPath();
        gp.moveTo(10,10);
        gp.lineTo(100,100);
        gp.lineTo(200,100);
        gp.lineTo(200,150);
        gp.lineTo(100,200);
        gp.lineTo(100,100);
        float[] dash = {10,50};
        BasicStroke stroke = new BasicStroke(3);
        g2.setStroke(stroke);
     //   g2.fill(gp);
        g.drawRect(195, 95, 10, 10);
        AffineTransform trans1 = new AffineTransform();
        trans1.translate(200, 100);
        gp.transform(trans1);

        AffineTransform trans2 = new AffineTransform();
        trans2.rotate(f,200,100);

        gp.transform(trans2);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       
        g2.draw(gp);




    }
}
