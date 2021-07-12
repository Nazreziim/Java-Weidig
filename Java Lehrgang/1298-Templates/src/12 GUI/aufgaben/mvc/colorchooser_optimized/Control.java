/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgaben.mvc.colorchooser_optimized;

import java.util.ArrayList;

/**
 *
 * @author dborkowitz
 */
public class Control implements IControl {

    private IModel m;
    private ArrayList<IView> views = new ArrayList<IView>();
    private boolean isColorControl = true;

    public void addView(IView view) {
        this.views.add(view);
    }

    public Control(IModel m) {
        this.m = m;
    }

    public void incRot() {
        this.m.setRot(this.m.getRot() + 5);
    }

    public void decRot() {
        this.m.setRot(this.m.getRot() - 5);
    }

    public void incGruen() {
        this.m.setGruen(this.m.getGruen() + 5);
    }

    public void decGruen() {
        this.m.setGruen(this.m.getGruen() - 5);
    }

    public void incBlau() {
        this.m.setBlau(this.m.getBlau() + 5);
    }

    public void decBlau() {
        this.m.setBlau(this.m.getBlau() - 5);
    }

    public void changeControl() {
       
            if (isColorControl) {
                for (IView v : this.views) {
                    v.display("punkt");
                }
                this.isColorControl = false;
            } else {
               for (IView v : this.views) {
                    v.display("color");
                }
                this.isColorControl = true;

            }
        
    }

    public void move(String s) {
        if ("Up".equals(s)) {
            this.m.move(0, -5);
        } else if ("Down".equals(s)) {
            this.m.move(0, 5);
        } else if ("Left".equals(s)) {
            this.m.move(-5, 0);
        } else if ("Right".equals(s)) {
            this.m.move(5, 0);
        }
    }

    public void setRot(int parseInt) {
        this.m.setRot(parseInt);
    }

    public void setGruen(int parseInt) {
       this.m.setGruen(parseInt);
    }

    public void setBlau(int parseInt) {
        this.m.setBlau(parseInt);
    }
}
