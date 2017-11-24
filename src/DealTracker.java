import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
		dealTracker.dealTimer();
		
		
		

	}
	public void gatherData() {
		InitialSetup setup = new InitialSetup();
		timeInterval = setup.getTimeInterval();
		amountOfItems = setup.getAmountOfItems();
		keywords = setup.getKeywords();
	
	}
	public void findDeals() {
		System.out.println("Called");
		FindDeals deals = new FindDeals();
		for (String keyword:keywords) {
			deals.findDeal(keyword);
		}
	}
	public void dealTimer() { //The test timer right now is only going for 60 seconds 
		Runnable dealRunnable = new Runnable() {
		    public void run() {
		        findDeals();
		    }
		};
		ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
		exec.scheduleAtFixedRate(dealRunnable , 0, timeInterval, TimeUnit.MINUTES);
	}

}
