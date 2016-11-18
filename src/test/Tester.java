package test;

import static org.junit.Assert.*;
import org.junit.Test;
import controller.Controller;
import filler.Filler;
import view.View;

/**
 * 
 * @author Svitlana Namchuk 16.11.16
 *
 */
public class Tester {

	@Test
	public void testCheckMenu() {
		Filler filler = new Filler();
		filler.toFillData();
		View view = new View();
		Controller c = new Controller(view, filler);
		assertTrue(c.checkMenu("1") == 1);
		assertTrue(c.checkMenu("2") == 2);
		assertTrue(c.checkMenu("3") == 3);
		assertTrue(c.checkMenu("4") == 4);
		assertTrue(c.checkMenu("5") == 5);
		assertTrue(c.checkMenu("6") == 0);
	}

	@Test
	public void testGetNumberClients() {
		Filler filler = new Filler();
		filler.toFillData();
		View view = new View();
		Controller c = new Controller(view, filler);
		assertTrue(c.getNumberClients(c.getTarrifsList()) == 8);
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
