package gui.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import client.Client;

/**
 * Represents the <code>JPanel</code> which consists of the necessary
 * components to display, book, release and search for contractors.
 * The area is separated in three parts:
 * <ol>
 * <li>The largest area where a table is displayed which contains the
 * contractors loaded from the database. This table is filtered with 
 * the provided search criteria, not ordered and cannot be edited directly.</li>
 * <li>A panel which contains the text fields to enter the search criteria
 * as well as two radio buttons to set the seach mode to either "AND" (both
 * entered values have to match exactly) or "OR" (at least one of the values has
 * to match). If no values are entered here all possible values of an entry 
 * provide a match which is displayed. </li>
 * <li> A small area on the south end which contains necessary buttons
 * which allow the user to perform the possible actions on the displayed
 * data (booking, releasing, searching)</li> 
 * </ol>
 * This class also provides all necessary ActionListeners as private inner classes.
 * 
 * @author Lars Gerhard
 *
 */
class ClientContractorsPanel extends JPanel {

	private static final long serialVersionUID = 9058316471318462464L;
	//Global reference for the JTable due to the fact, that updating its
	//contents happens via a public method 
	private JTable table;
	private TableRowSorter<TableModel> tableSorter;

	// Global references to the TextFields which are needed to perform a search
	private JTextField searchLocation;
	private JTextField searchName;

	// Global references to some buttons to make them accessible in ActionListners
	private JButton searchBtn;
	private JRadioButton andMode;
	private JRadioButton orMode;

	//reference to the controller
	private ClientGUIController controller;

	/**
	 * ActionListener for the handling of events concerning the "book" button
	 * 
	 * @author Lars Gerhard
	 */
	private class BookContractorActionListener implements ActionListener {
		/**
		 * Handles the event of the "Book" button. Displays a DialogBox to get the Customer ID by the user.
		 * If this id is not formatted correctly (8 digit number) an error message is shown otherwise the
		 * booking request is passed to the controller.
		 * 
		 * @param e the event passed when clicking the button
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			int index = table.getSelectedRow();
			if (index >= 0 && index < table.getRowCount()) {
				String[] bookMe = new String[table.getColumnCount()];
				for (int i = 0; i < bookMe.length; i++) {
					bookMe[i] = (String) table.getValueAt(index, i);					
				}
				// Validation of the customer id - has to be an 8 digit number!
				String custID = "";
				custID = (String) JOptionPane.showInputDialog(null, "Enter customer ID:", "Customer ID",JOptionPane.PLAIN_MESSAGE, null,null,"");
				boolean validID = custID!=null && custID.matches("\\d\\d\\d\\d\\d\\d\\d\\d");
				if (!validID) {
					JOptionPane.showMessageDialog(null, "Customer ID has to be a 8 digit number!");
				} else {
					boolean isBooked = controller.bookContractor(bookMe,custID);
					if (!isBooked) {
						JOptionPane.showMessageDialog(null, "Unable to book selected contractor.\n"
								+ "Maybe another client performed an action in the meantime.\nPlease try to refresh.");
					}
					refreshTable();
				}			    									
			}
		}		
	}

	
	
	/**
	 * ActionListener for the handling of events concerning the "book" button
	 * 
	 * @author Lars Gerhard
	 */
	private class AddContractorActionListener implements ActionListener {
		/**
		 * Handles the event of the "Add" button. Displays a DialogBox to get the data of the new contractor by the user.
		 * 
		 * 
		 * 
		 * @param e the event passed when clicking the button
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO: Implement the Listener for handling book events
			
		}		
	}
	
	/**
	 * ActionListener for the handling of events concerning the "release" button
	 * 
	 * @author Lars Gerhard
	 */
	private class ReleaseContractorActionListener implements ActionListener {
		/**
		 * Handles the event of the "release" button. Validates if there is a current owner for the record.
		 * If not a message is shown to the user otherwise the corresponding field is reset.
		 * 
		 * @param e the event passed when clicking the button
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			int index = table.getSelectedRow();
			if (index >= 0 && index < table.getRowCount()) {
				String[] releaseMe = new String[table.getColumnCount()];
				for (int i = 0; i < releaseMe.length; i++) {
					releaseMe[i] = (String) table.getValueAt(index, i);					
				}
				//Validation for empty field
				if (releaseMe[releaseMe.length-1].equals("        ")) {
					JOptionPane.showMessageDialog(null, "Selected record can not be released because it is not booked");
				} else {
					boolean isReleased = controller.releaseContractor(releaseMe);
					if (!isReleased) {
						JOptionPane.showMessageDialog(null, "Unable to remove booking of selected contractor.\n"
								+ "Maybe another client performed an action in the meantime.\nPlease try to refresh.");
					}
					refreshTable();
				}

			}
		}		
	}

	/**
	 * ActionListener for the handling of events fired by the search button
	 * 
	 * @author Lars Gerhard
	 */
	private class SearchContractorsActionListener implements ActionListener {
		/**
		 * Handles the events of the search button by submitting the request to the controller
		 * by applying {@link RowFilter} to the table.
		 * 
		 * @param e the event passed when clicking the button
		 */
		@Override
		public void actionPerformed(ActionEvent e) {			
			List<RowFilter<? super TableModel, ? super Integer>> filterList = new ArrayList<RowFilter<? super TableModel, ? super Integer>>();

			String nameRegEx = searchName.getText() + "(\\s|$)";
			String locRegEx = searchLocation.getText() + "(\\s|$)";
	
			filterList.add(RowFilter.regexFilter(nameRegEx, 0));      //name filter
			filterList.add(RowFilter.regexFilter(locRegEx, 1));       //location filter

			if (andMode.isSelected()) {
				tableSorter.setRowFilter(RowFilter.andFilter(filterList));			
			} else {
				tableSorter.setRowFilter(RowFilter.orFilter(filterList));
			}
		}
	}

	/**
	 * ActionListener for the handling of events fired by the clear button
	 * 
	 * @author Lars Gerhard
	 */
	private class ClearSearchActionListener implements ActionListener {
		/**
		 * Handles the events of the clear button. All search input fields are reset and
		 * the search mode is switched to the default "AND"
		 * @param e the event passed when clicking the button
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			searchLocation.setText("");
			searchName.setText("");
			andMode.setSelected(true);
			refreshTable();			
		}
	}

	/**
	 * ActionListener for the handling of events fired by the refresh button
	 * 
	 * @author Lars Gerhard
	 */
	private class RefreshActionListener implements ActionListener {
		/**
		 * Handles the events of the refresh button. 
		 * 
		 * @param e the event passed when clicking the button
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			refreshTable();			
		}
	}

	/**
	 * Constructs a ClientContractorsPanel which contains the three sections:
	 * <ol>
	 * <li>An area where the JTable containing the current state of database is put into</li>
	 * <li>Input text fields for searching the data in middle of the panel</li>
	 * <li>A button to book the selected record entry of the table on the bottom</li>
	 * </ol>
	 * 
	 * @param controller the instance of the {@link ClientGUIController} is passed so that
	 * occurring user inputs and events can directly be processed to the controller 
	 * which then may call its connected {@link Client} of the database to perform 
	 * the initiated changes.
	 */
	ClientContractorsPanel(ClientGUIController controller) {
		this.controller = controller;
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);

		// Contents of the Top Component of the SplitPane
		table = new JTable();
		table.setToolTipText("Select an entry you want to book / release");
		table.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setAutoCreateRowSorter(true);
		splitPane.setTopComponent(new JScrollPane(table));

		// Contents of the Bottom Component of the SplitPane
		JPanel bottomPanel = new JPanel(new BorderLayout());
		// 1.) Panel for searching constraints
		JPanel searchPanel = createSearchPanel();
		bottomPanel.add(searchPanel,BorderLayout.CENTER);
		// 2.) Panel for buttons
		JPanel buttonPanel = createButtonPanel();
		bottomPanel.add(buttonPanel,BorderLayout.SOUTH);

		splitPane.setBottomComponent(new JScrollPane(bottomPanel));		
		splitPane.setResizeWeight(0.5);
		splitPane.setOneTouchExpandable(true);
		splitPane.setContinuousLayout(true);
		splitPane.setDividerLocation(0.5);
		refreshTable(); // needs to be called after all components are initialized
		this.setLayout(new BorderLayout());
		this.add(splitPane);
	}

	/**
	 * Local helper method which creates a JPanel containing the 
	 * buttons for the {@link ClientContractorsPanel}
	 * 
	 * @return The created JPanel
	 */
	private JPanel createButtonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		searchBtn = new JButton("Search");
		searchBtn.setMnemonic(KeyEvent.VK_S);
		searchBtn.setToolTipText("Search for the given criteria");
		searchBtn.addActionListener(new SearchContractorsActionListener());
		buttonPanel.add(searchBtn);
		JButton clearBtn = new JButton("Clear");
		clearBtn.setMnemonic(KeyEvent.VK_C);
		clearBtn.setToolTipText("Clears the current search criteria");
		clearBtn.addActionListener(new ClearSearchActionListener());
		buttonPanel.add(clearBtn);
//		JButton addBtn = new JButton("Add contractor");
//		addBtn.setMnemonic(KeyEvent.VK_A);
//		addBtn.setToolTipText("Add a new contractor");
//		addBtn.addActionListener(new AddContractorActionListener());
//		buttonPanel.add(addBtn);
		JButton bookBtn = new JButton("Book selected entry");
		bookBtn.setMnemonic(KeyEvent.VK_B);
		bookBtn.setToolTipText("Book the selection of the table above");
		bookBtn.addActionListener(new BookContractorActionListener());
		buttonPanel.add(bookBtn);
		JButton releaseBtn = new JButton("Release booking");
		releaseBtn.setMnemonic(KeyEvent.VK_R);
		releaseBtn.setToolTipText("Delete the current owner of the selected entry");
		releaseBtn.addActionListener(new ReleaseContractorActionListener());
		buttonPanel.add(releaseBtn);
		JButton refreshBtn = new JButton("Refresh");
		refreshBtn.setMnemonic(KeyEvent.VK_F5);
		refreshBtn.setToolTipText("Refresh the tables contents");
		refreshBtn.addActionListener(new RefreshActionListener());
		buttonPanel.add(refreshBtn);
		return buttonPanel;
	}

	/**
	 * Local helper method which creates a JPanel for the search section of the {@link ClientContractorsPanel}
	 * 
	 * @return The created JPanel
	 */
	private JPanel createSearchPanel() {
		JPanel searchPanel = new JPanel();
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(2,2,2,2); // gap between components
		searchPanel.setLayout(gridbag);		
		searchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		JLabel searchLabel = new JLabel("Search criteria:");
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridwidth = 2;
		gridbag.setConstraints(searchLabel, constraints);
		searchPanel.add(searchLabel);

		JLabel searchModeLabel = new JLabel("Mode:");
		constraints.gridwidth = 1;
		gridbag.setConstraints(searchModeLabel,constraints);
		searchPanel.add(searchModeLabel);

		JLabel nameLabel = new JLabel("Name: ");
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.EAST;
		gridbag.setConstraints(nameLabel, constraints);
		searchPanel.add(nameLabel);

		searchName  = new JTextField(40);
		searchName.setToolTipText("Provide an exact value or leave empty to match all names");
		constraints.gridx = 1;
		constraints.gridwidth = 1; //GridBagConstraints.REMAINDER;
		constraints.anchor = GridBagConstraints.EAST;
		gridbag.setConstraints(searchName, constraints);
		searchPanel.add(searchName);

		JLabel locLabel = new JLabel("Location:");
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.EAST;
		gridbag.setConstraints(locLabel, constraints);
		searchPanel.add(locLabel);

		searchLocation  = new JTextField(40);
		searchLocation.setToolTipText("Provide an exact value or leave empty to match all locations");
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridwidth = 1; //GridBagConstraints.REMAINDER;
		gridbag.setConstraints(searchLocation, constraints);
		searchPanel.add(searchLocation);

		andMode = new JRadioButton("AND");
		andMode.setMnemonic(KeyEvent.VK_A);
		andMode.setToolTipText("Both entered values have to match exactly");
		andMode.setSelected(true);
		orMode = new JRadioButton("OR");
		orMode.setMnemonic(KeyEvent.VK_O);
		orMode.setToolTipText("One of the entered values has to match exactly");
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(andMode);
		btnGroup.add(orMode);
		JPanel searchModePanel = new JPanel();
		searchModePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		searchModePanel.setLayout(new GridLayout(0, 1));
		searchModePanel.add(andMode);
		searchModePanel.add(orMode);
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight= 2;
		constraints.anchor = GridBagConstraints.NORTH;
		gridbag.setConstraints(searchModePanel, constraints);
		searchPanel.add(searchModePanel);
		return searchPanel;
	}

	/**
	 * This method provides the <code>JTable</code> with an updated {@link ContractorsTableModel}
	 * which is provided by the {@link ClientGUIController}. Contents of the model are filtered by
	 * eventually given search criteria. The view of the table is automatically updated when 
	 * the model changes.
	 */
	void refreshTable() {		
		// exchange the model
		this.table.setModel(this.controller.getContractorsFromDB());
		
		// sort the table
		List<RowSorter.SortKey> sortKeyList = new ArrayList<RowSorter.SortKey>();
		sortKeyList.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sortKeyList.add(new RowSorter.SortKey(5, SortOrder.ASCENDING));
		sortKeyList.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
		sortKeyList.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
		tableSorter = new TableRowSorter<>(table.getModel());
		tableSorter.setSortKeys(sortKeyList);
		table.setRowSorter(tableSorter);
		
		
		//manually perform all actions connected to the searchButton to maintain possible search results
		for (ActionListener a :  this.searchBtn.getActionListeners()){
			a.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
		}
		
	}

}
