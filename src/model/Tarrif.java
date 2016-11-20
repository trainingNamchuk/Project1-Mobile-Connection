package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This abstract class describes general structure of mobile tariff in the
 * mobile company
 * 
 * @author Svitlana Namchuk 16.11.16
 * @version 2 16.11.16
 */
public abstract class Tarrif {
	private String name;
	private Integer price;
	private Set<String> abonents = new HashSet<>();
	private Map<String, Double> services = new HashMap<>();
	private Double priceSms;
	private Double priceInsideCalls;
	private Double priceOutsideCalls;

	public Double getPriceSms() {
		return priceSms;
	}

	public void setPriceSms(Double priceSms) {
		this.priceSms = priceSms;
	}

	public Double getPriceInsideCalls() {
		return priceInsideCalls;
	}

	public void setPriceInsideCalls(Double priceInsideCalls) {
		this.priceInsideCalls = priceInsideCalls;
	}

	public Double getPriceOutsideCalls() {
		return priceOutsideCalls;
	}

	public void setPriceOutsideCalls(Double priceOutsideCalls) {
		this.priceOutsideCalls = priceOutsideCalls;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public Integer getPrice() {
		return price;
	}

	public Set<String> getAbonents() {
		return abonents;
	}

	/**
	 * Method adds new abonents
	 * 
	 * @param abonents
	 */
	public void addAbonents(List<String> abonents) {
		for (String e : abonents) {
			this.abonents.add(e);
		}
	}

	/**
	 * Method adds new abonent
	 * 
	 * @param abonents
	 */
	public void addAbonents(String abonents) {
		this.abonents.add(abonents);
	}

	/**
	 * Method removes abonent
	 * 
	 * @param abonents
	 */
	public void removeAbonent(String abonent) {
		this.abonents.remove(abonent);
	}

	public Map<String, Double> getServices() {
		return services;
	}

	/**
	 * Method adds services
	 * 
	 * @param key
	 * @param value
	 */
	public void addServices(String key, Double value) {
		this.services.put(key, value);
	}

	/**
	 * Method deletes services
	 * 
	 * @param service
	 */
	public void deleteServices(String service) {
		this.services.remove(service);
	}

}
