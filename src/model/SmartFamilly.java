package model;

/**
 * This class represents one of the current tariff in the mobile company
 * 
 * @author Svitlana Namchuk 16.11.16
 * @version 2 16.11.16
 */
public class SmartFamilly extends Tarrif {

	public SmartFamilly() {
		super();
	}

	private Integer numberOfUsers;

	public Double getNumberOfUsers() {
		return numberOfUsers.doubleValue();
	}

	public void setNumberOfUsers(Integer numberOfUsers) {
		this.numberOfUsers = numberOfUsers;
	}
}
