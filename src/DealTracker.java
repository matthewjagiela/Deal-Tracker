/**
 * 
 */

/**
 * @author matthew
 * This class will handle the main procedure of the application. 
 */
public class DealTracker {

	/**
	 * @param args
	 */
	int amountOfItems;
	int timeInterval;
	String[] keywords;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DealTracker dealTracker = new DealTracker(); //So we can call non static methods;
		//Do the initial gathering of data:
		dealTracker.gatherData();
		
		

	}
	public void gatherData() {
		InitialSetup setup = new InitialSetup();
		timeInterval = setup.getTimeInterval();
		amountOfItems = setup.getAmountOfItems();
		keywords = setup.getKeywords();
	
	}

}
