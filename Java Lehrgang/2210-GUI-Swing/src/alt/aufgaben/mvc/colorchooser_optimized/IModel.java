/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alt.aufgaben.mvc.colorchooser_optimized;

import java.awt.geom.Point2D;

/**
 *
 * @author dborkowitz
 */
public interface IModel {

    public Point2D getPunkt();

    public void move(int x, int y);

    public int getBlau();

    public void setBlau(int blau);

    public int getGruen();

    public void setGruen(int gruen);

    public int getRot();

    public void setRot(int rot);

 
}
