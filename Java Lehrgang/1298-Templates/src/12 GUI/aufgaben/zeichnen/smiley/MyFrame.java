/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgaben.zeichnen.smiley;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.RepaintManager;

/**
 *
 * @author dborkowitz
 */
public class MyFrame extends JFrame implements ActionListener, Printable {
    private Leinwand l;
    public MyFrame(int width, int height, int x, int y, String title) {
        super(title);

        //Build the first menu
//        JMenuBar menuBar = new JMenuBar();
//        JMenu bearbeiten = new JMenu("Bearbeiten");
//        JMenuItem drucken = new JMenuItem("Drucken");
//        drucken.addActionListener(this);
//        bearbeiten.add(drucken);
//        menuBar.add(bearbeiten);
//        this.setJMenuBar(menuBar);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        //Setzen in die Mitte des Bildschirms
        l = new Leinwand();
        this.add(l);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MyFrame f = new MyFrame(600, 600, 2000, 200, "Hallo");
        f.setAlwaysOnTop(true);

    }

    public void actionPerformed(ActionEvent e) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        try {
            if (job.printDialog()) {
                job.print();
            }
        } catch (PrinterException ex) {
            Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        } else {
//            double fx = pageFormat.getWidth() / this.l.getSize().width;
//            double fy = pageFormat.getHeight() / this.l.getSize().height;
//
//            AffineTransform trans = new AffineTransform();
//            trans.scale(fx, fy);
//            ((Graphics2D)graphics).setTransform(trans);
            int x = (int)pageFormat.getImageableX() + 5;
            int y = (int)pageFormat.getImageableY() + 5;
            RepaintManager current = RepaintManager.currentManager(this.l);
            current.setDoubleBufferingEnabled(false);
            graphics.translate(x, y);
            this.l.paint(graphics);
            current.setDoubleBufferingEnabled(true);
            return PAGE_EXISTS;
        }
    }
}
