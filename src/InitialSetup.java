import javax.swing.JOptionPane;

/**
 *  This class will take in the information on how often the user wants to check deals as well as the deals themselves. 
 *  This class should only have method calls to get data
 */

/**
 * @author matthew
 *
 */
public class InitialSetup {

	/**
	 * @param args
	 */
	int amountOfItems;
	int timeInterval;
	String[] keywords;
	public int getAmountOfItems() {
		amountOfItems = Integer.parseInt(JOptionPane.showInputDialog("Enter The Amount Of Items"));
		return amountOfItems;
	}
	public int getTimeInterval() {
		timeInterval = Integer.parseInt(JOptionPane.showInputDialog("How Often Do You Want To Check For Deals (In Minutes)"));
		return timeInterval;
	}
	public String[] getKeywords() {
		keywords = new String[amountOfItems];
		for(int i = 0; i < amountOfItems; i++) {
			keywords[i] = JOptionPane.showInputDialog("Enter The Item You Want To Find A Deal On (" + (i + 1) + "/" + amountOfItems + ")");
		}
		return keywords;
	}
	

}
