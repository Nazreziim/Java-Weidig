/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgaben.mvc.colorchooser_optimized;

import java.util.Observable;

/**
 *
 * @author dborkowitz
 */
public class ViewKonsole implements IView {

    //private Model m;
    private IControl c;
    private boolean isColor = true;

    public ViewKonsole(Model m, IControl c) {
      //  this.m = m;
        this.c = c;
        m.addObserver(this);
        this.c.addView(this);
    }

    public void update(Observable model, Object info) {
        Model myM = (Model) model;
            System.out.println(info);
        if (isColor) {
            System.out.println("Rot:\t" + myM.getRot());
            System.out.println("Gruen:\t" + myM.getGruen());
            System.out.println("Blau:\t" + myM.getBlau());
        } else {
            System.out.println("Punkt: " + myM.getPunkt());
        }
    }

    public void display(String s) {
        if ("color".equals(s)) {
            this.isColor = true;
        } else {
            this.isColor = false;
        }
    }
}
