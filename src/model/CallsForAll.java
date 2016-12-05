package model;

/**
 * This class represents one of the current tariff in the mobile company
 * 
 * @author Svitlana Namchuk 16.11.16
 * @version 2 16.11.16
 */
public class CallsForAll extends Tarrif {
	private Double priceRouming;

	public CallsForAll() {
		super();
	}

	public Double getPriceRouming() {
		return priceRouming;
	}

	public void setPriceRouming(Double priceRouming) {
		this.priceRouming = priceRouming;
	}
}
