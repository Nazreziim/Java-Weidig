/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package layout.gridbag;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author dborkowitz
 */
public class GridBagFrame extends JFrame {
    public GridBagFrame(String titel) {
        super(titel);
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");

        //this.setLayout(new FlowLayout(FlowLayout.LEFT, 30,50));
        //StandardLayout BorderLayout
 //      this.setLayout(new GridLayout(0,2));
//        button1.setPreferredSize(new Dimension(100,100));
//        button2.setPreferredSize(new Dimension(100,100));
        GridBagLayout gbl = new GridBagLayout();
        this.setLayout(gbl);
        addComponent(this, gbl, button1, 0, 0, 2, 2, 1.0, 1.0);
        addComponent(this, gbl, button2, 2, 0, 1,1, 1.0, 1.0);
        addComponent(this, gbl, button3, 2, 1, 1, 1, 1.0, 1.0);
        addComponent(this, gbl, button9,0, 2, 1, 1, 1.0, 1.0);
        addComponent(this, gbl, button4, 1, 2, 2, 1, 0, 0);
        addComponent(this, gbl, button5, 0, 3, 1, 1, 1.0, 1.0);
        addComponent(this, gbl, new JPanel(), 1, 3, 1, 1, 1.0, 1.0);
        addComponent(this, gbl, button6, 0, 4, 2, 1, 0, 1.0);
        addComponent(this, gbl, button7, 2, 3, 1, 2, 0, 0);

        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.pack();
        this.pack();
    }

    private static void addComponent(Container cont, GridBagLayout gbl, 
            Component c, int x, int y, int colspan, int rowspan, 
            double weightW, double weightH){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = colspan;
        gbc.gridheight = rowspan;
        gbc.weightx = weightW;
        gbc.weighty = weightH;        
        gbl.setConstraints(c, gbc);
        cont.add(c);
        
    }

    public static void main(String[] args) {
        GridBagFrame f = new GridBagFrame("Das Fenster zur Welt");

        f.setVisible(true);
    }
}
