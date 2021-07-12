/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgaben.zeichnen.color.farbkreis;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 *
 * @author dborkowitz
 */
public class FarbkreisPanel extends JPanel {

    public FarbkreisPanel(int x, int y) {
        super();
        this.setSize(x,y);
    }

    @Override
    /**
     * Das Programm arbeitet in der Weise, dass f�r jeden einzelnen Punkt der Zeichenfl�che
     * berechnet wird, ob dieser in einem der drei Kreise liegt. Ist dies der Fall, so wird die
     * zugeh�rige Farbkomponente auf 255 gesetzt, andernfalls auf 0. 
     * 
     * Die Bestimmung der Kreiszugeh�rigkeit erfolgt mit Hilfe des Satzes von Pythagoras, 
     * nach dem ein Punkt genau dann zu einem Kreis geh�rt, wenn die Summe der Quadrate der Abst�nde 
     * vom x- und y-Wert zum Mittelpunkt kleiner gleich dem Quadrat des Radius ist. Die drei Mittelpunkte
     * werden in unserem Beispiel in den Arrays arx und ary, die Radien der Kreise in arr gespeichert. Die
     * boolesche Variable paintit zeigt an, ob der Punkt in wenigstens einem der drei Kreise liegt
     * und daher �berhaupt eine Ausgabe erforderlich ist.
     */
    protected void paintComponent(Graphics g) {
        int top = 0;
        int left = 0;
        int maxX = getSize().width - left;
        int maxY = getSize().height - top;

        int[] arx = {130, 160, 190}; //Mittelpunkte der Kreise
        int[] ary = {60, 110, 60};   //Mittelpunkte der Kreise
        int[] arr = {50, 50, 50};    // Radien der Kreise
        int[] arcol = {0, 0, 0};
        Color col;
        boolean paintit;
        int dx, dy;


        for (int y = 0; y < maxY; ++y) {
            for (int x = 0; x < maxX; ++x) {
                paintit = false;
                for (int i = 0; i < arcol.length; ++i) {
                    dx = x - arx[i];
                    dy = y - ary[i];
                    arcol[i] = 0;
                    if ((dx * dx + dy * dy) <= arr[i] * arr[i]) { //Pythagoras
                        arcol[i] = 255;
                        paintit = true;
                    }
                }
                
                // Wenn notwendig: Punkt malen!
                if (paintit) {
                    col = new Color(arcol[0], arcol[1], arcol[2]);
                    g.setColor(col);
                    g.drawLine(x + left, y + top, x + left + 1, y + top + 1);
                    
                }
            }
        }

    }
}
