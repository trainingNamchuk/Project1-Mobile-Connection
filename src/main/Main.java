package main; 

import controller.Controller;
import filler.Filler;
import view.View;

/**
 * This class runs the controller.
 * 
 * @author Svitlana Namchuk
 * @version 2  16.11.16
 */
public class Main {

	public static void main(String[] args) {
		// Initialization
		View view = new View();
		Filler filler = new Filler();
		// Fill data
		filler.toFillData();
		Controller controller = new Controller(view, filler);
		// Run
		controller.runMenu();
	}
}
