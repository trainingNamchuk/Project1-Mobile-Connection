package filler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.CallsForAll;
import model.MobileTarrifFactory;
import model.SmartFamilly;
import model.Smartphone3G;
import model.Tarrif;

/**
 * This class fills initial data to model classes
 * 
 * @author Svitlana Namchuk
 * @version 2 16.11.16
 */

public class Filler {
	private MobileTarrifFactory factory;
	private List<Tarrif> tarrifs;
	private SmartFamilly smartFamilly;
	private Smartphone3G smartPhone;
	private CallsForAll callsAll;

	public List<Tarrif> getTarrifs() {
		return tarrifs;
	}

	public void toFillData() {
		this.factory = new MobileTarrifFactory();
		this.tarrifs = new ArrayList<>(Arrays.asList(factory.getMobileTarrif("Smartphone 3G"),
				factory.getMobileTarrif("Calls for all"), factory.getMobileTarrif("Smart familly")));
		smartFamilly = SmartFamilly.getObj();
		smartFamilly.setName("Smart Familly");
		smartFamilly.setPrice(135);
		smartFamilly.addAbonents(Arrays.asList("+380635478927", "+380635499323", "+380636395312"));
		smartFamilly.setPriceInsideCalls(0.0);
		smartFamilly.setPriceOutsideCalls(0.5);
		smartFamilly.setPriceSms(0.1);
		smartFamilly.setNumberOfUsers(3);
		smartFamilly.addServices("Inside calls", smartFamilly.getPriceInsideCalls());
		smartFamilly.addServices("Outside calls", smartFamilly.getPriceOutsideCalls());
		smartFamilly.addServices("SMS", smartFamilly.getPriceSms());
		smartFamilly.addServices("Number of users", smartFamilly.getNumberOfUsers());
		smartPhone = Smartphone3G.getObj();
		smartPhone.setName("Smart phone 3G");
		smartPhone.setPrice(60);
		smartPhone.addAbonents(Arrays.asList("+380635473927", "+380635473923"));
		smartPhone.setPriceInsideCalls(0.0);
		smartPhone.setPriceOutsideCalls(0.7);
		smartPhone.setPriceSms(0.2);
		smartPhone.setPriceInternet3G(0.15);
		smartPhone.addServices("Inside calls", smartPhone.getPriceInsideCalls());
		smartPhone.addServices("Outside calls", smartPhone.getPriceOutsideCalls());
		smartPhone.addServices("SMS", smartPhone.getPriceSms());
		smartPhone.addServices("Internet 3G", smartPhone.getPriceInternet3G());
		callsAll = CallsForAll.getObj();
		callsAll.setName("Calls for all");
		callsAll.setPrice(20);
		callsAll.addAbonents(Arrays.asList("+380635473444", "+380635423924", "+380638975488"));
		callsAll.setPriceInsideCalls(0.0);
		callsAll.setPriceOutsideCalls(0.7);
		callsAll.setPriceSms(0.2);
		callsAll.setPriceRouming(4.0);
		callsAll.addServices("Inside calls", callsAll.getPriceInsideCalls());
		callsAll.addServices("Outside calls", callsAll.getPriceOutsideCalls());
		callsAll.addServices("SMS", callsAll.getPriceSms());
		callsAll.addServices("Rouming", callsAll.getPriceRouming());
	}
}
