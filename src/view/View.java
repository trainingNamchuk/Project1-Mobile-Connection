package view;

/**
 * This class represents a view in MVC pattern
 * @author Svitlana Namchuk 16.11.16
 * @version 2  16.11.16
 */
import java.util.ArrayList;
import java.util.List;

import model.Tarrif;

public class View {
	// Text's constants
	public static final String MENU = "1. Print list of mobile tarrifs.\n2. Print the total number of clients.\n3. Sort tarrifs by price.\n4. Search tarrifs.\n5. Exit.";
	public static final String WRONG_MENU = "Wrong menu item! Please, try again!";
	public static final String TARRIF_LIST = "List of mobile tarrifs:";
	public static final String TOTAL_NUMBER_CLIENTS = "The total number of clients is:";
	public static final String SORT = "Sorted mobile tarrifs in decreasing order of price:";
	public static final String FOUND_TARRIF = "Tarrif(s) that matches your request is:";
	public static final String MAX_PRICE = "Please, enter the max price of tarrif";
	public static final String SERVICE_NAME = "Please, enter the service name ";
	public static final String WRONG_INPUT = "Wrong input! Please, try again!";
	public static final String NOTHING_FOUND = "Nothing found!";

	/**
	 * Method for printing message
	 * 
	 * @param message
	 */

	public void printMessage(String message) {
		System.out.println(message);
	}

	/**
	 * 
	 * @param message
	 */

	public void printMessage(int message) {
		System.out.println(message);
	}

	/**
	 * Method for printing message
	 * 
	 * @param message
	 */

	public void printMessage(List<Tarrif> tarrifs) {
		tarrifs.forEach(s -> System.out.println(s.getName()));
	}

	/**
	 * Method for printing message
	 * 
	 * @param message
	 */
	public void printMessage(ArrayList<String> tarrifs) {
		tarrifs.forEach(s -> System.out.println(s));
	}
}