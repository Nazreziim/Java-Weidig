package alt.components.version5_colorchooser.panels;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import alt.components.version5_colorchooser.models.Model;

public class ComboControlPanel extends JPanel implements Observer {
	private Model m;

	private JComboBox comboRot;
	private JSpinner spinnerGr�n;
	private JSpinner spinnerBlau;
	private boolean actionPerformed;

	public ComboControlPanel(Model model) {
		this.m = model;
		m.addObserver(this);
		this.setLayout(new GridLayout(0, 2));
		this.actionPerformed = true;

		JLabel redL = new JLabel("Red:");
		redL.setHorizontalAlignment(JLabel.CENTER);
		this.add(redL);

		comboRot = new JComboBox();
		for (Integer i = 0; i < 256; i++) {
			comboRot.addItem(i);
		}
		// Man k�nnte auch noch ein ItemListener hinzuf�gen, der reagiert wenn
		// das Auswahlitem ver�ndert wird
		comboRot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (actionPerformed) {
					System.out.println(e);
					m.setRot(((Integer) comboRot.getSelectedItem()).intValue());
				}
			}
		});

		// ComboBox kann Editierbar gemacht werden
		comboRot.setEditable(true);
		// Wieviele Auswahlm�glichkeiten angezeigt werden
		comboRot.setMaximumRowCount(3);

		this.add(comboRot);

		// Spinner for numbers from 0 to 255 in steps of 0.2 SpinnerNumberModel
		// SpinnerModel
		// Ein JSpinner arbeitet auf einem Model vom Typ SpinnerModel,
		// das �hnlich wie ein Iterator den Zugriff auf die Elemente erm�glicht.
		// Ein SpinnerModel wird im Konstruktor von JSpinner gesetzt oder �ber
		// setModel().
		SpinnerNumberModel model1 = new SpinnerNumberModel(0, 0, 255, 1);

		spinnerGr�n = new JSpinner(model1);

		// ChangeListener meldet �nderungen
		spinnerGr�n.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (actionPerformed) {
					m.setGruen(((Integer) spinnerGr�n.getValue()).intValue());
				}

			}
		});

		JLabel greenL = new JLabel("Green:");
		greenL.setHorizontalAlignment(JLabel.CENTER);
		this.add(greenL);

		this.add(spinnerGr�n);

		// SpinnerListModel
		// Ein vorgefertigtes Model ist das SpinnerListModel,
		// das mit einem Feld initialisiert wird.
		LinkedList<Integer> nums = new LinkedList<Integer>();
		for (Integer i = 0; i < 256; i++) {
			nums.add(i);
		}
		SpinnerListModel model2 = new SpinnerListModel(nums);
		spinnerBlau = new JSpinner(model2);

		spinnerBlau.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (actionPerformed) {
					m.setBlau(((Integer) spinnerBlau.getValue()).intValue());
				}

			}
		});

		JLabel blueL = new JLabel("Blue:");
		blueL.setHorizontalAlignment(JLabel.CENTER);
		this.add(blueL);

		this.add(spinnerBlau);

	}

	@Override
	public void update(Observable o, Object arg) {
		this.actionPerformed = false;
		this.comboRot.setSelectedItem(new Integer(m.getRot()));
		this.spinnerBlau.setValue(new Integer(m.getBlau()));
		this.spinnerGr�n.setValue(new Integer(m.getGruen()));
		this.actionPerformed = true;
	}

}
