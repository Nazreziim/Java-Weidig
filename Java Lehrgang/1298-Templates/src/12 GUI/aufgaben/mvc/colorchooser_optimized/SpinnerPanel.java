/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgaben.mvc.colorchooser_optimized;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author dborkowitz
 */
public class SpinnerPanel extends JPanel implements ChangeListener {

    private ViewFrame parent;
    private SpinnerModel rotM;
    private SpinnerModel gruenM;
    private SpinnerModel blauM;

    public SpinnerPanel(ViewFrame parent, int width, int height) {
        this.parent = parent;
        this.setMaximumSize(new Dimension(width, height));
        this.setLayout(new GridLayout(0, 1));

        rotM = new SpinnerNumberModel(0,0,255,1);
        gruenM = new SpinnerNumberModel(0,0,255,1);
        blauM = new SpinnerNumberModel(0,0,255,1);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();

      

        JSpinner rotS = new JSpinner(rotM);
        JSpinner gruenS = new JSpinner(gruenM);
        JSpinner blauS = new JSpinner(blauM);
        rotS.addChangeListener(this);
        gruenS.addChangeListener(this);
        blauS.addChangeListener(this);

        

        JLabel rot = new JLabel("Rot : ", JLabel.CENTER);
        JLabel gruen = new JLabel("Gruen:", JLabel.CENTER);
        JLabel blau = new JLabel("Blau : ", JLabel.CENTER);


        p1.add(rot);
        p1.add(rotS);
        p2.add(gruen);
        p2.add(gruenS);
       
        p3.add(blau);
        p3.add(blauS);


        rot.setPreferredSize(new Dimension(100, 30));
        gruen.setPreferredSize(new Dimension(100, 30));
        blau.setPreferredSize(new Dimension(100, 30));

        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);


    }

 

    public void stateChanged(ChangeEvent e) {
        this.parent.changeColor(this.rotM.getValue().toString(),this.gruenM.getValue().toString(),this.blauM.getValue().toString());
    }

    void update(int rot, int gruen, int blau) {
        int rotAlt = Integer.parseInt(this.rotM.getValue().toString());
        int gruenAlt = Integer.parseInt(this.gruenM.getValue().toString());
        int blauAlt = Integer.parseInt(this.blauM.getValue().toString());
        if(rotAlt != rot){
            this.rotM.setValue(rot);
        }
        if(gruenAlt != gruen){
            this.gruenM.setValue(gruen);
        }
        if(blauAlt != blau){
            this.blauM.setValue(blau);
        }
    }
}
