package model;

/**
 * This class represents a "factory" of mobile tariffs
 * 
 * @author Svitlana Namchuk 16.11.16
 * @version 2 16.11.16
 */
public class MobileTarrifFactory {
	public Tarrif getMobileTarrif(String tarrifType) {
		if (tarrifType == null) {
			return null;
		}
		if (tarrifType.equalsIgnoreCase("Smart Familly")) {
			return SmartFamilly.getObj();
		}
		if (tarrifType.equalsIgnoreCase("Smartphone 3G")) {
			return Smartphone3G.getObj();
		}
		if (tarrifType.equalsIgnoreCase("Calls for all")) {
			return CallsForAll.getObj();
		}
		return null;
	}
}
