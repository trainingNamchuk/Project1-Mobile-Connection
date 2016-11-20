package model;

/**
 * This class represents one of the current tariff in the mobile company
 * 
 * @author Svitlana Namchuk 16.11.16
 * @version 2 16.11.16
 */
public class CallsForAll extends Tarrif {
	public static CallsForAll obj = new CallsForAll();
	private Double priceRouming;

	/**
	 * Method return object of class
	 * 
	 * @return
	 */
	public static CallsForAll getObj() {
		return obj;
	}

	public Double getPriceRouming() {
		return priceRouming;
	}

	public void setPriceRouming(Double priceRouming) {
		this.priceRouming = priceRouming;
	}
}
