/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package components.version4_manycomponents;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author dborkowitz
 */
public class ManyComponentsLabel extends JLabel{

    ArrayList<Color> colors = new ArrayList<Color>();
    public void addColor(Color c){
        colors.add(c);
    }
    public ManyComponentsLabel() {
    }

    public ManyComponentsLabel(Icon image) {
        super(image);
    }

    public ManyComponentsLabel(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
    }

    public ManyComponentsLabel(String text) {
        super(text);
    }

    public ManyComponentsLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public ManyComponentsLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
    }

    @Override
    protected void paintComponent(Graphics g) {
        int dx = this.getPreferredSize().width / this.colors.size();
        int x = 0;
        int y = this.getPreferredSize().height;
        for(Color c : this.colors){
            g.setColor(c);
            g.fillRect(x, 0, x, y);
            x += dx;
        }
        super.paintComponent(g);

    }

}
