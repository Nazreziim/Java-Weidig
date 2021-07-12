/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aufgaben.mvc.colorchooser_optimized;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import javax.swing.JPanel;

/**
 *
 * @author dborkowitz
 */
public class Leinwand extends JPanel{
    private Color c;
    private Point2D p;
    public Leinwand(int width, int height){
        super(true);
        this.setPreferredSize(new Dimension(width,height));
    }

    public void update(Color color, Point2D p) {
        this.setBackground(color);
        this.c = color;
        this.p = p;      
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(255 - this.c.getBlue(),255 -this.c.getRed(),255 - this.c.getGreen()));
        g.fillRect((int)this.p.getX(), (int)this.p.getY(), 10, 10);
    }


}
