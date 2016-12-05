package test;

import static org.junit.Assert.*;
import org.junit.Test;
import controller.Controller;
import filler.Filler;
import view.View;

/**
 * This class tests correct work of methods in the controller
 * 
 * @author Svitlana Namchuk 16.11.16
 * @version 2 16.11.16
 */
public class Tester {

	@Test
	public void testCheckMenu() {
		Filler filler = new Filler();
		filler.toFillData();
		View view = new View();
		Controller c = new Controller(view, filler);
		assertTrue("Print tarrif", c.checkMenu("1") == 1);
		assertTrue("Print the total number of clients", c.checkMenu("2") == 2);
		assertTrue("Sort tarrifs by price", c.checkMenu("3") == 3);
		assertTrue("Search tarrifs", c.checkMenu("4") == 4);
		assertTrue("Exit", c.checkMenu("5") == 5);
		assertTrue("Wrong item!", c.checkMenu("6") == 0);
	}

	@Test
	public void testGetNumberClients() {
		Filler filler = new Filler();
		filler.toFillData();
		View view = new View();
		Controller c = new Controller(view, filler);
		assertTrue(c.getNumberClients(filler.getTarrifs()) == 8);
	}

	@Test
	public void testIsTarrifFound() {
		Filler filler = new Filler();
		filler.toFillData();
		View view = new View();
		Controller c = new Controller(view, filler);
		assertTrue(c.isTarrifFound(100, "SMS") == true);
	}
}
