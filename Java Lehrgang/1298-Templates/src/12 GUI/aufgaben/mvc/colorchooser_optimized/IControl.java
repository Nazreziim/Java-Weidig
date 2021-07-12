/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aufgaben.mvc.colorchooser_optimized;

/**
 *
 * @author dborkowitz
 */
public interface IControl {

    public void addView(IView view);
    public void incRot();

    public void decRot();
    public void incGruen();

    public void decGruen();

    public void incBlau();

    public void decBlau();

    public void changeControl();

    public void move(String s);

    public void setRot(int parseInt);

    public void setGruen(int parseInt);

    public void setBlau(int parseInt);
}
