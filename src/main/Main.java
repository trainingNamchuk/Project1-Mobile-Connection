package main;

import controller.Controller;
import filler.Filler;
import view.View;

/**
 * 
 * @author Svitlana Namchuk 16.11.16
 *
 */
public class Main {

	public static void main(String[] args) {
		// Initialization
		View view = new View();
		Filler filler = new Filler();
		// Fill data
		filler.toFillData();
		Controller controller = new Controller(view,filler);
		// Run
		controller.runMenu();
	}
}
