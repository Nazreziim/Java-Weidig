package components.version4_manycomponents;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.event.CaretEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Enumeration;

import javax.swing.*;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;


public class ManyComponentsFrame extends JFrame {

    private static class MyListRenderer implements ListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Color c = (Color) value;
            JCheckBox box = new JCheckBox("rgb(" + c.getRed() + "," + c.getGreen() + "," + c.getBlue() + ")");
            box.setSelected(isSelected);
            box.setBackground((Color) value);
            box.setForeground(new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue()));
            box.setOpaque(true);
            return box;
        }
    }
    JCheckBox check1;
    JFormattedTextField tf;
    SpinnerNumberModel spinnermodel;
    JSpinner spinner;

    public ManyComponentsFrame(int x, int y) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(x, y);
        this.setLocation(1400, 20);

        JTabbedPane tab = new JTabbedPane(JTabbedPane.BOTTOM, JTabbedPane.SCROLL_TAB_LAYOUT);
        JPanel p1 = new JPanel();
        p1.setBackground(Color.red);
        tab.add(p1, "Panel1");

        JPanel p2 = new JPanel();
        p2.setBackground(Color.blue);
        tab.add(p2, "Panel2");

        JPanel p3 = new JPanel();
        p3.setBackground(Color.green);
        tab.add(p3, "Panel3");

        JPanel p4 = new JPanel();

        p4.setBackground(Color.black);
        tab.addTab("Panel4", new ImageIcon("bilder/trash.gif"), p4, "Panel 4 ist schwarz");


        final JPanel p5 = new JPanel();
        tab.add(p5, "Panel5");
        JPanel p6 = new JPanel();
        tab.add(p6, "Panel6");
        ManyComponentsLabel l = new ManyComponentsLabel("Hallo");
        l.addColor(Color.blue);
        l.addColor(Color.green);
        l.addColor(Color.red);
        l.addColor(Color.yellow);
        l.addColor(Color.black);
        l.addColor(Color.white);
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setPreferredSize(new Dimension(100,100));
        p6.add(l);


        MaskFormatter format;
        try {
            format = new MaskFormatter("0x***");
            tf = new JFormattedTextField(format);

            tf.setHorizontalAlignment(JFormattedTextField.RIGHT);
            tf.setPreferredSize(new Dimension(100, 30));
            tf.addCaretListener(new CaretListener() {

                public void caretUpdate(CaretEvent e) {
                    if (tf.getText() != null) {
                        System.out.println((tf.getText().toString()).charAt(e.getDot() - 1));
                    }
                }
            });
            p4.add(tf);
        } catch (ParseException ex) {
            Logger.getLogger(ManyComponentsFrame.class.getName()).log(Level.SEVERE, null, ex);
        }


        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));



        final DefaultComboBoxModel cbm = new DefaultComboBoxModel();
        cbm.addElement("Goofy");
        cbm.addElement("Donald");
        cbm.addElement("Mickey");
        JComboBox box = new JComboBox(cbm);
        box.setMaximumRowCount(2);
        p3.add(box);
        box.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                System.out.println(cbm.getSelectedItem());
            }
        });

        spinnermodel = new SpinnerNumberModel(5, -255, 255, 2);
        spinner = new JSpinner(spinnermodel);
        spinner.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                System.out.println(spinner.getValue());
                System.out.println(spinnermodel.getNumber());
                cbm.addElement("Hallo");

            }
        });
        p3.add(spinner);

        final JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 255, 5);
        slider.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                System.out.println(slider.getValue());
            }
        });
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        //slider.setPaintTrack(false);
        p3.add(slider);


        check1 = new JCheckBox("Auswahl", true);
        check1.setActionCommand("101");
        check1.setOpaque(false);
        check1.setSelectedIcon(new ImageIcon("bilder/pfeiloben.gif"));
        check1.setIcon(new ImageIcon("bilder/pfeilunten.gif"));
        check1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.println(check1.isSelected());
            }
        });


        p2.add(check1);
        JRadioButton radio1 = new JRadioButton("X");

        JRadioButton radio2 = new JRadioButton("Y");
        JRadioButton radio3 = new JRadioButton("Z");
        JRadioButton radio4 = new JRadioButton("A");

        ButtonGroup bg = new ButtonGroup();
        bg.add(radio1);
        bg.add(radio2);
        bg.add(radio3);
        bg.add(radio4);
        p1.add(radio1);
        p1.add(radio2);
        p1.add(radio3);
        p1.add(radio4);

        Enumeration<AbstractButton> b = bg.getElements();
        while (b.hasMoreElements()) {
            b.nextElement().addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    System.out.println(e.getActionCommand());
                }
            });
        }



        DefaultListModel lmodel = new DefaultListModel();
        lmodel.addElement(Color.red);
        lmodel.addElement(Color.black);
        lmodel.addElement(Color.blue);
        lmodel.addElement(Color.yellow);
        lmodel.addElement(Color.green);
        lmodel.addElement(Color.pink);
        final JList list = new JList(lmodel);
        // list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                Thread t = new Thread() {

                    public void run() {
                        for (Object o : list.getSelectedValues()) {
                            p5.setBackground((Color) o);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(ManyComponentsFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                };
                t.start();
            }
        });
        list.setCellRenderer(new MyListRenderer());

        JScrollPane scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(200, 150));

        p5.add(scroll);


        this.add(tab);
        this.setVisible(true);


    }

    public static void main(String[] args) {
        ManyComponentsFrame of = new ManyComponentsFrame(300, 200);

    }
}
