/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alt.aufgaben.mvc.colorchooser_optimized;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dborkowitz
 */
public class ColorButtonPanel extends JPanel implements ActionListener{
    private ViewFrame parent;
    public ColorButtonPanel( ViewFrame parent,int width, int height) {
        this.parent = parent;
        this.setMaximumSize(new Dimension(width, height));
        this.setLayout(new GridLayout(0, 1));
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();

        JLabel rot = new JLabel("Rot : ", JLabel.CENTER);

        JButton rotP = new JButton(" + ");
        JButton rotM = new JButton(" - ");
        rotP.setActionCommand("100");
        rotP.addActionListener(this);
        rotM.setActionCommand("101");
        rotM.addActionListener(this);

        p1.add(rot);
        p1.add(rotP);
        p1.add(rotM);


        JLabel gruen = new JLabel("Gruen:", JLabel.CENTER);
        JButton gruenP = new JButton(" + ");
        JButton gruenM = new JButton(" - ");
        gruenP.setActionCommand("102");
        gruenP.addActionListener(this);
        gruenM.setActionCommand("103");
        gruenM.addActionListener(this);

        p2.add(gruen);
        p2.add(gruenP);
        p2.add(gruenM);

        JLabel blau = new JLabel("Blau:", JLabel.CENTER);
        JButton blauP = new JButton(" + ");
        JButton blauM = new JButton(" - ");
        blauP.setActionCommand("104");
        blauP.addActionListener(this);
        blauM.setActionCommand("105");
        blauM.addActionListener(this);

        p3.add(blau);
        p3.add(blauP);
        p3.add(blauM);


        rot.setPreferredSize(new Dimension(100, 30));
        gruen.setPreferredSize(new Dimension(100, 30));
        blau.setPreferredSize(new Dimension(100, 30));

        JButton umsch = new JButton("Punktsteuerung");
        umsch.setActionCommand("106");
        umsch.addActionListener(this);
        p4.add(umsch);
        
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);


    }

    public void actionPerformed(ActionEvent e) {
       this.parent.handleButton(Integer.parseInt(e.getActionCommand()));
    }
}
