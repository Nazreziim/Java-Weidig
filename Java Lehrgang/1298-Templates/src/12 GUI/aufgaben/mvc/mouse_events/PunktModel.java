/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgaben.mvc.mouse_events;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

/**
 *
 * @author c-ix-03-08
 */
public class PunktModel extends Observable {

    private ArrayList<Point> punkte = new ArrayList<Point>();

    public PunktModel() {
    }

    public ArrayList<Point> getPunkte() {
        return punkte;
    }

    public void setPunkt(Point punkt) {
        this.punkte.add(punkt);
        this.setChanged();
        this.notifyObservers();
    }

    private void savePoints() throws FileNotFoundException, IOException {
        // do Save
        FileOutputStream f = new FileOutputStream("points.ser");
        ObjectOutputStream os = new ObjectOutputStream(f);
        os.writeObject(punkte);
        os.flush();
        os.close();
        f.close();

    }

    private void loadPoints() throws FileNotFoundException, IOException, ClassNotFoundException {
        File f = new File("points.ser");
        if (f.exists()) {
            FileInputStream fin = new FileInputStream(f);
            ObjectInputStream oin = new ObjectInputStream(fin);
            this.punkte = (ArrayList<Point>) oin.readObject();
            oin.close();
            fin.close();

        }
    }

    void removePunkt(Point p, int toleranz) {
        Iterator<Point> it = this.punkte.iterator();
        while(it.hasNext()){
            Point p1 = it.next();
            if (p.distance(p1) < toleranz){
               it.remove();
            }
        }
        this.setChanged();
        this.notifyObservers();
    }
}
