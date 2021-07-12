package alt.tree.xml;

import java.util.List;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import org.jdom2.*;
import org.jdom2.input.*;

public class XMLTreeModel implements TreeModel {

	private Document document;

	public XMLTreeModel(String filepath) {
		try {
			this.document = new SAXBuilder().build(filepath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ausgabe des Root-Elementes
	 */
	@Override
	public Object getRoot() {
		// das Root-Element ist einfach zu finden, es kann direkt ausgelesen werden
		Element root = this.document.getRootElement();
		return root;
	}

	/**
	 * Ausgabe eines bestimmten Kindes
	 */
	@Override
	public Object getChild(Object parent, int index) {
		Element elt = (Element) parent;
		List<Content> contentlist = elt.getContent();
		return contentlist.get(index);
	}

	/**
	 * Ausgabe der Anzahl der Kinder
	 */
	@Override
	public int getChildCount(Object parent) {
		Element elt = (Element) parent;
		List<Content> contentlist = elt.getContent();
		return contentlist.size();
	}

	/**
	 * Prüfen, ob das Objekt ein Blatt ist
	 */
	@Override
	public boolean isLeaf(Object node) {
		// Interpretieren als Element
		Element elt;
		try {
			elt = (Element) node;
			
		} catch (ClassCastException e) {
			// Ist der Inhalt kein ELement, ist es garantiert ein Blatt
			return true;
		}
		// Ein Element ohne Kinder ist auch ein Blatt
		int count = elt.getContent().size();
		return count == 0;
	}

	/**
	 * Ermitteln der Nummer eines Kindes
	 */
	@Override
	public int getIndexOfChild(Object parent, Object child) {
		Element elt = (Element) parent;
		return elt.indexOf((Content)child);
	}

	
	/**
	 * wird hier nicht benötigt
	 */
	@Override
	public void addTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub
	}

	/**
	 * wird hier nicht benötigt
	 */
	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub
	}

	/**
	 * wird hier nicht benötigt
	 */
	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		// TODO Auto-generated method stub
	}
}