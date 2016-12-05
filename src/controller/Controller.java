package controller;

/**
 * This class represents a controller in MVC pattern
 * @author Svitlana Namchuk 16.11.16
 * @version 2  16.11.16
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.Tarrif;
import filler.Filler;
import view.View;

public class Controller {
	private View view;
	private Filler filler;

	public Controller(View view, Filler filler) {
		this.view = view;
		this.filler = filler;
	}

	public Controller() {
		// TODO Auto-generated constructor stub
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
	enum Choice {
		PRINT_TARRIF, PRINT_TOTAL_NUMBER_CLIENTS, SORT_BY_PRICE, SEARCH_TARRIF, EXIT
	};

	public int checkMenu(String menu) {
		int choice = Character.getNumericValue(menu.charAt(0));
		if (choice > 5 || choice < 1) {
			return 0;
		}
		Choice s = Choice.values()[choice - 1];
		switch (s) {
		case PRINT_TARRIF:
			view.printMessage(View.TARRIF_LIST);
			view.printMessage(filler.getTarrifs());
			runMenu();
			return choice;
		case PRINT_TOTAL_NUMBER_CLIENTS:
			view.printMessage(View.TOTAL_NUMBER_CLIENTS);
			view.printMessage(getNumberClients(filler.getTarrifs()));
			runMenu();
			return choice;
		case SORT_BY_PRICE:
			view.printMessage(View.SORT);
			view.printMessage(sortTarrifs(filler.getTarrifs()));
			runMenu();
			return choice;
		case SEARCH_TARRIF:
			view.printMessage(View.MAX_PRICE);
			int maxPrice = 0;
			while (maxPrice <= 0) {
				maxPrice = setMaxPrice(maxPrice);
			}
			view.printMessage(View.SERVICE_NAME);
			String serviceName = setServiceName();
			if (isTarrifFound(maxPrice, serviceName)) {
				view.printMessage(View.FOUND_TARRIF);
				view.printMessage(searchTarrifs(filler.getTarrifs(), maxPrice, serviceName));
			} else {
				view.printMessage(View.NOTHING_FOUND);
			}
			runMenu();
			return choice;
		case EXIT:
			return choice;
		default:
			return 0;
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
		if (searchTarrifs((filler.getTarrifs()), maxPrice, serviceName).isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}
