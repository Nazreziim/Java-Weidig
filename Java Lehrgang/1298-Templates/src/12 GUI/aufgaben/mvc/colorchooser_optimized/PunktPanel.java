/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgaben.mvc.colorchooser_optimized;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author dborkowitz
 */
public class PunktPanel extends JPanel implements ActionListener {

    private ViewFrame parent;
    private JButton button;

    public PunktPanel(ViewFrame parent, int width, int height) {
        this.parent = parent;
        this.setMaximumSize(new Dimension(width, height));
      button = new JButton("Colorpanel");
        button.setActionCommand("106");
        button.addActionListener(this);
        
this.addKeyListener(this.parent.getListener());

        Icon oben = new ImageIcon("./bilder/pfeiloben.gif");
        Icon links = new ImageIcon("./bilder/pfeillinks.gif");
        Icon rechts = new ImageIcon("./bilder/pfeilrechts.gif");
        Icon unten = new ImageIcon("./bilder/pfeilunten.gif");
        System.out.println(oben.getIconHeight());
        JButton buttonUnten = new JButton(unten);
       
        buttonUnten.setActionCommand("201");
        JButton buttonOben = new JButton(oben);
        buttonOben.setActionCommand("202");
        JButton buttonLinks = new JButton(links);
        buttonLinks.setActionCommand("203");
        buttonLinks.addKeyListener(this.parent.getListener());
        JButton buttonRechts = new JButton(rechts);
        buttonRechts.setActionCommand("204");
       buttonUnten.addActionListener(this);
        buttonOben.addActionListener(this);
        buttonLinks.addActionListener(this);
        buttonRechts.addActionListener(this);
        
        buttonRechts.setPreferredSize(new Dimension(oben.getIconWidth(),oben.getIconHeight()));
        buttonLinks.setPreferredSize(new Dimension(oben.getIconWidth(),oben.getIconHeight()));
        buttonOben.setPreferredSize(new Dimension(oben.getIconWidth(),oben.getIconHeight()));
        buttonUnten.setPreferredSize(new Dimension(oben.getIconWidth(),oben.getIconHeight()));
        button.setPreferredSize(new Dimension(oben.getIconWidth(),oben.getIconHeight()));

        this.setLayout(new GridLayout(0, 3));
        this.add(new JPanel());
        this.add(buttonOben);
        this.add(new JPanel());
        this.add(buttonLinks);
        this.add(new JPanel());
        this.add(buttonRechts);
        this.add(new JPanel());
        this.add(buttonUnten);
        this.add(new JPanel());
        this.add(new JPanel());
        this.add(button);
        this.add(button);



    }

    public void actionPerformed(ActionEvent e) {
        this.parent.handleButton(Integer.parseInt(e.getActionCommand()));
    }
}
