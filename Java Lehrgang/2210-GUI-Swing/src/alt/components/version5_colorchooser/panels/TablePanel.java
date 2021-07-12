package alt.components.version5_colorchooser.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutionException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingWorker;

import alt.components.version5_colorchooser.models.Model;
import alt.components.version5_colorchooser.models.tablepanel.ColorTableModel;

public class TablePanel extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;

	private Model model;
	private JTable jTable;
	private ColorTableModel colorTableModel;

	public TablePanel(Model model) {
		super();
		this.model = model;

		this.setPreferredSize(new Dimension(300, 300));

		this.setBorder(BorderFactory.createTitledBorder("Table Panel"));

		this.colorTableModel = new ColorTableModel();
		this.jTable = new JTable(this.colorTableModel);
		this.jTable.setFillsViewportHeight(true);
		this.jTable.setAutoCreateRowSorter(true);
		this.jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane jScrollPane = new JScrollPane(this.jTable);

		this.setLayout(new BorderLayout());
		this.add(jScrollPane, BorderLayout.CENTER);
		//this.add(jTable.getTableHeader(), BorderLayout.NORTH);

		JButton selectButton = new JButton("Auswählen");
		selectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color selection = colorTableModel.getColorAtRow(jTable.convertRowIndexToModel(jTable.getSelectedRow()));
				model.setRot(selection.getRed());
				model.setGruen(selection.getGreen());
				model.setBlau(selection.getBlue());
			}
		});

		JButton newEntryButton = new JButton("neuer Eintrag");
		newEntryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowTable = jTable.convertRowIndexToView(colorTableModel.addColor());
				jTable.setRowSelectionInterval(rowTable, rowTable);
				jTable.scrollRectToVisible(jTable.getCellRect(rowTable, 0, true));
			}
		});

		JButton removeEntryButton = new JButton("Eintrag entfernen");
		removeEntryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorTableModel.removeColor(jTable.convertRowIndexToModel(jTable.getSelectedRow()));
			}
		});

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(selectButton);
		buttonPanel.add(newEntryButton);
		buttonPanel.add(removeEntryButton);

		this.add(buttonPanel, BorderLayout.SOUTH);

	}

	@Override
	public void update(Observable o, Object arg) {
		
		SwingWorker<Integer, Void> worker = new SwingWorker<Integer, Void>() {
			@Override
			protected Integer doInBackground() throws Exception {
				System.out.println("doInBackground " + Thread.currentThread().getName());
				return colorTableModel.getRow(model.getRot(), model.getGruen(), model.getBlau());
			}

			@Override
			protected void done() {
				System.out.println("done " + Thread.currentThread().getName());
				int row = -1;
				try {
					row = this.get();
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
				if (row != -1) {
					int rowTable = jTable.convertRowIndexToView(row);
					jTable.setRowSelectionInterval(rowTable, rowTable);
					jTable.scrollRectToVisible(jTable.getCellRect(rowTable, 0, true));
				}
			}
		};
		worker.execute();
	}
}
