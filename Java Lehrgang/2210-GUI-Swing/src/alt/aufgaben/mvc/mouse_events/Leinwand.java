/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alt.aufgaben.mvc.mouse_events;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author c-ix-03-08
 */
public class Leinwand extends JPanel {

   PunktModel punktModel;
   View parent;
   int staerke = 10;
   public Leinwand(View v, PunktModel punktModel) {
      this.punktModel = punktModel;
      this.parent = v;
      this.setPreferredSize(new Dimension(200, 300));
      setBorder(new LineBorder(new Color(0, 0, 0)));
      setBackground(Color.WHITE);
      this.addMouseListener(new MyMouseListener());
      this.upDate();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      for (Point p : punktModel.getPunkte()) {
         g.fillRect(p.x - staerke/2, p.y - staerke/2, staerke, staerke);
         System.out.println(p);
      }

   }

   public void upDate() {
      this.repaint();
   }

    int getStaerke() {
        return this.staerke;
    }
   private class MyMouseListener extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
           parent.handleMouse(e.getButton(), e.getX(),e.getY());
        }


   }
}
