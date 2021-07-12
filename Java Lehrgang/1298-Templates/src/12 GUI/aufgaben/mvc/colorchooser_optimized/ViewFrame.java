/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgaben.mvc.colorchooser_optimized;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author dborkowitz
 */
public class ViewFrame extends JFrame implements IView {

    private Model m;
    private IControl c;
    private Leinwand l;
    private ColorButtonPanel colorPanel;
    private PunktPanel punktPanel;
    private JPanel panel;
    private JTabbedPane panelRight;
    private MyKeyListener listener;
    private SpinnerPanel spinner;
    public MyKeyListener getListener() {
        return listener;
    }

    private static void setKeyListener(Container c, KeyListener l) {
        for (Component co : c.getComponents()) {
            co.addKeyListener(l);
            if (co instanceof Container) {
                setKeyListener((Container) co, l);
            }
        }

    }

    public ViewFrame(Model m, IControl c, String titel) {
        super(titel);
        this.listener = new MyKeyListener();
        this.addKeyListener(this.listener);
        this.m = m;
        this.m.addObserver(this);
        this.c = c;
        this.c.addView(this);

        this.setSize(500, 300);
        panel = new JPanel();
        l = new Leinwand(200, 300);

        this.panelRight = new JTabbedPane();
        this.panelRight.setPreferredSize(new Dimension(300, 300));


        this.punktPanel = new PunktPanel(this, 300, 300);
        this.colorPanel = new ColorButtonPanel(this, 300, 300);
        this.spinner = new SpinnerPanel(this, 300, 300);
        this.panelRight.add(this.colorPanel, "Color");
        this.panelRight.add(this.punktPanel, "Punkt");
        this.panelRight.add(spinner, "Spinner");
        panel.add(l);
        panel.add(this.panelRight);
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.update(null, null);
        setKeyListener(this, listener);

        this.pack();

    }

    public void update(Observable model,
            Object info) {
        this.l.update(new Color(m.getRot(), m.getGruen(), m.getBlau()), this.m.getPunkt());
        this.spinner.update(m.getRot(), m.getGruen(), m.getBlau());
    }

    public void display(String s) {
        if ("punkt".contains(s)) {
            int index = this.panelRight.indexOfTab("Punkt");
            this.panelRight.setSelectedIndex(index);
        } else {
            this.panelRight.setSelectedIndex(0);
        }
    }

    public void handleButton(int i) {
        switch (i) {
            case 100:
                this.c.incRot();
                break;
            case 101:
                this.c.decRot();
                break;
            case 102:
                this.c.incGruen();
                break;
            case 103:
                this.c.decGruen();
                break;
            case 104:
                this.c.incBlau();
                break;
            case 105:
                this.c.decBlau();
                break;
            case 106:
                this.c.changeControl();
                break;
            case 201:
                this.c.move("Down");
                break;
            case 202:

                this.c.move("Up");
                break;
            case 203:

                this.c.move("Left");
                break;
            case 204:

                this.c.move("Right");
                break;
        }
    }

    void changeColor(String r, String g, String b) {
       this.c.setRot(Integer.parseInt(r));
       this.c.setGruen(Integer.parseInt(g));
       this.c.setBlau(Integer.parseInt(b));
    }

    private class MyKeyListener implements KeyListener {

        public void keyTyped(KeyEvent e) {
        }

        public void keyPressed(KeyEvent e) {
            System.out.println("KeyChar:" + e.getKeyChar());
            System.out.println("KeyCode: " + e.getKeyCode());

            System.out.println("KeyLocation: " + e.getKeyLocation());

            System.out.println("Modifier:" + e.getModifiers());
        }

        public void keyReleased(KeyEvent e) {
        }
    }
}
