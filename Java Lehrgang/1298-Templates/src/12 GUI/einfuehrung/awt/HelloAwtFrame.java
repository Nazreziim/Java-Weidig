/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package einfuehrung.awt;

import java.awt.Frame;

/**
 *
 * @author LGerhard
 */
public class HelloAwtFrame {
    public static void main(String[] args) {
        Frame f = new Frame("Das Fenster zur Welt!");
        f.setSize(300,200);
        f.setVisible(true);
        // Dieses Fenster ist so noch nicht schlie�bar!
        // Hier m�ssten selbst Fensterereignisse abgefangen werden
        // Der Swing-JFrame horcht selbstst�ndig auf ein WindowEvent 
    }
}
