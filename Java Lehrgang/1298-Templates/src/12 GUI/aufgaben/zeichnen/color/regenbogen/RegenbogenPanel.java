package aufgaben.zeichnen.color.regenbogen;

import java.awt.*;
import javax.swing.*;

public class RegenbogenPanel extends JPanel {
	
   private static int SCHRITTWEITE = 3;
   private int r = 0;
   private int width = 0;
   private int height = 0;
   
   
// Konstruktordefinition   
   public RegenbogenPanel(int width, int height, int radius) { 
      this.r = radius;
      this.width = width;
      this.height= height;
   }
   
   
   protected void paintComponent(Graphics g) {

      super.paintComponents(g);
      r=0; // SEHR WICHTIG!
      int i=255, j=0, k=0;
     
      
      //1.) Grün erhöhen
      while (j < 255 - SCHRITTWEITE) {
       	  zeichneBogen(i, j, k, g);
       	  j += SCHRITTWEITE;
      }
      
      //2.) Rot verringern
      while (i > 0 + SCHRITTWEITE) {
    	  zeichneBogen(i, j, k, g);
       	  i -= SCHRITTWEITE;
      }
      
      //3.) Blau erhöhen
      while (k < 255 - SCHRITTWEITE) {
    	  zeichneBogen(i, j, k, g);
       	  k += SCHRITTWEITE;
      }

      //4.)  Grün verringern
      while (j > 0 + SCHRITTWEITE) {
    	  zeichneBogen(i, j, k, g);
    	  j -= SCHRITTWEITE;
      }
      
      //5.) Rot erhöhen
      while (i < 255 - SCHRITTWEITE) {
    	  zeichneBogen(i, j, k, g);
       	  i += SCHRITTWEITE;
      }
      
   //6.) Blau verringern
      while (k > 0 + SCHRITTWEITE) {
    	  zeichneBogen(i, j, k, g);
       	  k -= SCHRITTWEITE;
      }
      
   }
   
   
/**
 * @param i
 * @param j
 * @param k
 * @param g
 */
private void zeichneBogen(int i, int j, int k, Graphics g) {
	Color farbe = new Color(i,j,k);
	  g.setColor(farbe);
	  r = r + 1;
	  int x = width / 2;
	  int y = height;
	  g.drawArc(x-r, y-r, 2*r, 2*r, 0, 180);
} 



}