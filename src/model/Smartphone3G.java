package model;

/**
 * This class represents one of the current tariff in the mobile company
 * 
 * @author Svitlana Namchuk 16.11.16
 * @version 2 16.11.16
 */
public class Smartphone3G extends Tarrif {
	public static Smartphone3G obj = new Smartphone3G();
	private Double priceInternet3G;

	/**
	 * Method return object of class
	 * 
	 * @return
	 */
	public static Smartphone3G getObj() {
		return obj;
	}

	public Double getPriceInternet3G() {
		return priceInternet3G;
	}

	public void setPriceInternet3G(Double priceInternet3G) {
		this.priceInternet3G = priceInternet3G;
	}

}
