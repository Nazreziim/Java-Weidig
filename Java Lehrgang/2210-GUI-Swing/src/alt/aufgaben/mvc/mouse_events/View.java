/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alt.aufgaben.mvc.mouse_events;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 *
 * @author c-ix-03-08
 */
public class View extends JFrame implements Observer {

    Control controll;
    Leinwand leinwand;
    PunktModel punktModel;
    MyPanel panel;
    Action beenden;

    public View(PunktModel punktModel, Control controll) {
        this.punktModel = punktModel;
        this.punktModel.addObserver(this);
        this.controll = controll;
        this.controll.setView(this);

        beenden = new AbstractAction("Beenden") {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        beenden.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F1, KeyEvent.CTRL_MASK));
        beenden.putValue(Action.MNEMONIC_KEY, (int) 'B');
        leinwand = new Leinwand(this, punktModel);
        this.panel = new MyPanel();
        this.add(leinwand);
        this.add(panel, BorderLayout.EAST);

        this.setSize(new Dimension(400, 300));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem item = new JMenuItem(beenden);
        file.add(item);
        menu.add(file);
        this.setJMenuBar(menu);
        pack();
    }

    public void upDate() {
        this.leinwand.upDate();

    }

    public void update(Observable o, Object arg) {
        this.leinwand.upDate();
    }

    void handleMouse(int button, int x, int y) {
        if (button == MouseEvent.BUTTON1) {
            this.controll.addXY(x, y);
        } else if (button == MouseEvent.BUTTON3) {
            this.controll.removeXY(x, y, this.leinwand.getStaerke());
        }
    }

    class MyPanel extends JPanel implements ActionListener {

        JTextField txtFieldX = new JTextField();
        JTextField txtFieldY = new JTextField();
        JLabel lblX = new JLabel(" x:");
        JLabel lblY = new JLabel(" y:");
        JButton btnOK = new JButton("ok");
        JButton btnEnd;
        Dimension textFiledSize = new Dimension(80, 20);
        Dimension buttonSize = new Dimension(80, 30);

        public MyPanel() {
            super();
            btnEnd = new JButton(beenden);
            btnOK.setActionCommand("1");
            this.setPreferredSize(new Dimension(100, 200));
            this.setMaximumSize(new Dimension(100, 200));
            //this.setLayout(new FlowLayout(FlowLayout.LEFT, 3, 3));
            txtFieldX.setPreferredSize(textFiledSize);
            txtFieldY.setPreferredSize(textFiledSize);

            JPanel pnlX = new JPanel();
            JPanel pnlY = new JPanel();
            pnlX.add(lblX);
            pnlX.add(txtFieldX);

            pnlY.add(lblY);
            pnlY.add(txtFieldY);
            add(pnlX);
            add(pnlY);
            this.add(btnOK);
            this.add(btnEnd);
            btnOK.setPreferredSize(buttonSize);
            btnEnd.setPreferredSize(buttonSize);
            btnOK.addActionListener(this);


        }

        public void actionPerformed(ActionEvent e) {

            switch (Integer.parseInt(e.getActionCommand())) {
                case 1:

                    if (pruefeWerte()) {
                        controll.addXY(Integer.valueOf(getXWert()), Integer.valueOf(getYWert()));
                        this.txtFieldX.setText("");
                        this.txtFieldY.setText("");

                    }
                    break;
                case 99:
                    System.exit(0);
                    break;
            }

        }

        private boolean pruefeWerte() {
            boolean erg = false;
            try {
                int i = Integer.parseInt(this.getXWert());
                i = Integer.parseInt(this.getYWert());
                erg = true;
            } catch (Exception e) {
            }
            return erg;
        }

        public String getXWert() {
            return txtFieldX.getText();
        }

        public String getYWert() {
            return txtFieldY.getText();
        }

        public JTextField getTxtFieldX() {
            return txtFieldX;
        }

        public JTextField getTxtFiledY() {
            return txtFieldY;
        }
    }
}
