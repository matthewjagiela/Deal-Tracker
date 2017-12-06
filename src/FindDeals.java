import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FindDeals {
	
	public void findDeal(String keyword) { //This will take in a specific keyword and find the deals associated with it
		String URL = formatURL(keyword); //Format the URL with the keyword we are searching for 
		org.jsoup.nodes.Document doc = null; 
		String dealsFound = ""; //This is to store the deals we find 
		try { //Try Catch for connecting to dealSea
			doc = Jsoup.connect(URL).get(); //Go to the URL and get the HTML Content
			Elements links = doc.select("a[href]"); //Sort it by links
			for(Element link: links) { //For all links in the page...
				if(link.text().toLowerCase().contains(keyword.toLowerCase())) { //If the link has the keyword....
					dealsFound += "\n" + link.text(); //Add it to the list of found deals
				}
			}
			final JDialog dialog = new JDialog(); 
			dialog.setAlwaysOnTop(true);    //This needs to exist or the popup for some reason will not always show on top of all windows
			
			JOptionPane.showMessageDialog(dialog,dealsFound,"Deals Found For: " + keyword +" On Dealsea.com",JOptionPane.INFORMATION_MESSAGE);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		
			System.out.println("There are no deals"); //There was an error....
		}
	}
	private String formatURL(String keyword) {
		keyword = keyword.replaceAll(" ", "+"); //This is simply for efficiency. Instead of having a check and then go back through it will just replace as it checks
		StringBuilder url = new StringBuilder("https://dealsea.com/search?q=&search_mode=Deals"); //Generic URL without search terms
		url.insert(29, keyword); //Always insert at index 29 or the URL will be invalid
		System.out.println(url.toString());
		return url.toString(); //return the formatted URL in the format of string. 
	}

}
