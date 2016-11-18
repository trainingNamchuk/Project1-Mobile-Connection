package model;

/**
 * 
 * @author Svitlana Namchuk 16.11.16
 *
 */
public class SmartFamilly extends Tarrif {
	public static SmartFamilly obj = new SmartFamilly();
	private Integer numberOfUsers;
	/**
	 * Method return object of class
	 * 
	 * @return
	 */
	public static SmartFamilly getObj() {
		return obj;
	}

	public Double getNumberOfUsers() {
		return numberOfUsers.doubleValue();
	}

	public void setNumberOfUsers(Integer numberOfUsers) {
		this.numberOfUsers = numberOfUsers;
	}
}
