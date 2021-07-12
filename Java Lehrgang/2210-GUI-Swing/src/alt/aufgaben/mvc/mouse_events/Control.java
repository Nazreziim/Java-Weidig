/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alt.aufgaben.mvc.mouse_events;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Iterator;
import javax.swing.JDialog;

/**
 *
 * @author c-ix-03-08
 */
public class Control {

   PunktModel pModel;
   View view;
   // Point p = new Point(0, 0);
   String message = "Es dürfen nur Zahlen eigegeben werden";

   public Control(PunktModel punktModel) {
      this.pModel = punktModel;

   }

   public void addXY(int x, int y) {
      try {
         Point p = new Point();
         p.x = x;
         p.y = y;
         pModel.setPunkt(p);
      } catch (Exception e) {
         System.out.println("fuck");
      }

   }

   public void setView(View view) {
      this.view = view;
   }

    void removeXY(int x, int y, int toleranz) {
        this.pModel.removePunkt(new Point(x,y),toleranz);
    }
}
