package gui.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ConsoleMainMenu {

	private ArrayList<String> mainMenuItems = new ArrayList<>();

	public ConsoleMainMenu() {
		mainMenuItems.add("Main Menu");
		mainMenuItems.add("Show contractors");
		mainMenuItems.add("Filter contractors");
		mainMenuItems.add("Add new contractor");
		mainMenuItems.add("Delete contractor");
		mainMenuItems.add("Book contractor");
		mainMenuItems.add("Release contractors");
		mainMenuItems.add("Exit");
		runUI();
	}
	
	private void runUI() {
		boolean run = true;
		while (run) {
			displayMainMenu();
			int selection = readInt("Please select a menu item: ");
			switch (selection) {
			case 7:
				run = false;
				break;

			default:
				break;
			}

		}		
	}

	/**
	 * Diese Methode fordert den Nutzer mit einer waehlbaren Nachricht und einem folgenden Leerzeichen dazu auf einen
	 * Integer einzugeben und liefert diesen als return-Wert zurueck.
	 * @param message Die auszugebende Meldung
	 * @return Der eingelesene Integer
	 */
	public static int readInt(String message){
		int erg = 0;
		boolean readInOK = false;
		// Die Schleife wird erst verlassen, wenn eine korrekte Antwort eingelesen wurde
		while (!readInOK) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print(message+" ");
				erg = Integer.parseInt(br.readLine());
				readInOK = true;
			} catch (IOException e) {
				
			}
		}
		return erg;
	}
	
	private void displayMainMenu() {
		System.out.println("************************************************************");
		System.out.println("****** Hammer & Nagel GmbH - Contractor Booking System *****");
		System.out.println("************************************************************");
		showList(mainMenuItems);
		
	}

	private void showList(ArrayList<String> listItems) {
		if (!listItems.isEmpty()) {
			// Überschrift ausgeben und unterstreichen
			System.out.println(listItems.get(0));
			for (int i=0; i < listItems.get(0).length(); i++) {
				System.out.print("=");
			}
			System.out.println("");
			
			// Restliche Elemente der Liste mit vorgestellter Nummerierung ausgeben
			for (int i=1; i < listItems.size(); i++) {
				System.out.println(i + " : " + listItems.get(i));
			}			
		}		
		
	}
}
