/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alt.aufgaben.mvc.colorchooser_optimized;

import java.awt.geom.Point2D;
import java.util.Observable;

/**
 *
 * @author dborkowitz
 */
public class Model extends Observable implements IModel {

    private int rot;
    private int gruen;
    private int blau;
    private Point2D punkt = new Point2D.Double(0, 0);

    public Point2D getPunkt() {
        return punkt;
    }

    public void move(int x, int y) {
        if (this.punkt.getX() + x >= 0 && this.punkt.getY() + y >= 0) {
            punkt.setLocation(punkt.getX() + x, punkt.getY() + y);
            this.setChanged();
            this.notifyObservers("Hallo Ihr Observer");
        }
    }

    public int getBlau() {
        return blau;
    }

    public void setBlau(int blau) {
        if (blau > 255) {
            this.blau = 255;
        } else if (blau < 0) {
            this.blau = 0;
        } else {
            this.blau = blau;
        }
        this.setChanged();
        this.notifyObservers("Hallo Ihr Observer");
    }

    public int getGruen() {
        return gruen;
    }

    public void setGruen(int gruen) {
        if (gruen > 255) {
            this.gruen = 255;
        } else if (gruen < 0) {
            this.gruen = 0;
        } else {
            this.gruen = gruen;
        }

        this.setChanged();
        this.notifyObservers("Hallo Ihr Observer");
    }

    public int getRot() {
        return rot;
    }

    public void setRot(int rot) {
        if (rot > 255) {
            this.rot = 255;
        } else if (rot < 0) {
            this.rot = 0;
        } else {
            this.rot = rot;
        }
        this.setChanged();
        this.notifyObservers("Hallo Ihr Observer");
    }
}
