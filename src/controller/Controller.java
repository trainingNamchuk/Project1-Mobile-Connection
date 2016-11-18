package controller;

/**
 * 
 * @author Svitlana Namchuk 16.11.16
 *
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import filler.Filler;
import model.Tarrif;
import view.View;

public class Controller {
	private View view;
	private List<Tarrif> tarrifs;

	public Controller(View view, Filler filler) {
		this.view = view;
		this.tarrifs = filler.getTarrifs();
	}

	public Controller() {
	
	}

	public List<Tarrif> getTarrifsList() {
		return tarrifs;
	}

	/**
	 * Method for running user`s menu
	 */
	@SuppressWarnings("resource")
	public void runMenu() {
		view.printMessage(View.MENU);
		Scanner scan = new Scanner(System.in);
		String menu = scan.nextLine();
		while (menu.length() != 1 || checkMenu(menu) == 0) {
			view.printMessage(View.WRONG_MENU);
			menu = scan.nextLine();
		}
	}

	/**
	 * Method for checking correct of chosen item
	 * 
	 * @param menu
	 *            chosen item
	 * @return menu item
	 */
	public int checkMenu(String menu) {
		int choice = 0;
		switch (menu.charAt(0)) {
		case '1':
			choice = 1;
			view.printMessage(View.TARRIF_LIST);
			view.printMessage(getTarrifsList());
			runMenu();
			return choice;
		case '2':
			choice = 2;
			view.printMessage(View.TOTAL_NUMBER_CLIENTS);
			view.printMessage(getNumberClients(tarrifs));
			runMenu();
			return choice;
		case '3':
			choice = 3;
			view.printMessage(View.SORT);
			view.printMessage(sortTarrifs(tarrifs));
			runMenu();
			return choice;
		case '4':
			choice = 4;
			view.printMessage(View.MAX_PRICE);
			int maxPrice = 0;
			while(maxPrice<=0){
			maxPrice=setMaxPrice(maxPrice);
			}
			view.printMessage(View.SERVICE_NAME);
			String serviceName = setServiceName();
			if (isTarrifFound(maxPrice, serviceName)) {
				view.printMessage(View.FOUND_TARRIF);
				view.printMessage(searchTarrifs(tarrifs, maxPrice, serviceName));
			} else {
				view.printMessage(View.NOTHING_FOUND);
			}
			runMenu();
			return choice;
		case '5':
			choice = 5;
			return choice;
		default:
			return choice;

		}
	}

	/**
	 * Method counts the total number of clients
	 * 
	 * @param tarrifs
	 * @return the total number of clients
	 */
	public int getNumberClients(List<Tarrif> tarrifs) {
		int number = 0;
		for (Tarrif e : tarrifs) {
			number += e.getAbonents().size();
		}
		return number;
	}

	/**
	 * Method sorts tarrifs
	 * 
	 * @param tarrifs
	 *            - the list of tarrifs
	 * @return the list of sorted tarrifs
	 */
	public List<Tarrif> sortTarrifs(List<Tarrif> tarrifs) {
		Collections.sort(tarrifs, (c1, c2) -> c2.getPrice().compareTo(c1.getPrice()));
		return tarrifs;
	}

	/**
	 * Method searches tarrif(s) on existing criteria
	 * 
	 * @param tarrifs
	 *            - the list of tarrifs
	 * @param maxPrice
	 *            - the max price of tarrif
	 * @param serviceName
	 *            - the name of service
	 * @return the tarrif(s) which match existing criteria
	 */
	public ArrayList<String> searchTarrifs(List<Tarrif> tarrifs, int maxPrice, String serviceName) {
		ArrayList<String> foundTarrif = new ArrayList<>();
		for (Tarrif e : tarrifs) {
			if ((e.getPrice()) <= maxPrice && e.getServices().containsKey(serviceName)) {
				foundTarrif.add(e.getName());
			}
		}
		return foundTarrif;
	}

	/**
	 * Method check input and set max price
	 * 
	 * @param maxPrice
	 * @return max price
	 */
	@SuppressWarnings("resource")
	public int setMaxPrice(int maxPrice) {
		Scanner sc = new Scanner(System.in);
		try {
			maxPrice = sc.nextInt();
		} catch (InputMismatchException e) {
			view.printMessage(View.WRONG_INPUT);
		}
		return maxPrice;
	}

	/**
	 * Method checks input and sets service name
	 * 
	 * @return service name
	 */
	@SuppressWarnings("resource")
	public String setServiceName() {
		Scanner scan = new Scanner(System.in);
		String serviceName = scan.nextLine();
		while (serviceName.length() == 0) {
			view.printMessage(View.WRONG_INPUT);
			serviceName = scan.nextLine();
		}
		return serviceName;
	}

	/**
	 * Method checks if needed tariff is found
	 * 
	 * @param maxPrice
	 * @param serviceName
	 */
	public boolean isTarrifFound(int maxPrice, String serviceName) {
		if (searchTarrifs(tarrifs, maxPrice, serviceName).isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}
