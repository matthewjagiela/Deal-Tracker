import java.io.IOException;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.xml.internal.txw2.Document;

public class FindDeals {
	
	private void findDeal(String keyword) { //This will take in a specific keyword and find the deals associated with it
		String URL = formatURL(keyword); //Format the URL with the keyword we are searching for 
		org.jsoup.nodes.Document doc = null; 
		String dealsFound = ""; //This is to store the deals we find 
		try { //Try Catch for connecting to dealSea
			doc = Jsoup.connect(URL).get(); //Go to the URL and get the HTML Content
			Elements links = doc.select("a[href]"); //Sort it by links
			for(Element link: links) { //For all links in the page...
				if(link.text().contains(keyword)) { //If the link has the keyword....
					dealsFound += "\n" + link.text(); //Add it to the list of found deals
				}
			}
			JOptionPane.showMessageDialog(null,dealsFound);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		
			System.out.println("There are no deals");
		}
	}
	private String formatURL(String keyword) {
		StringBuilder url = new StringBuilder("https://dealsea.com/search?q=&search_mode=Deals");
		url.insert(29, keyword);
		return url.toString();
	}

}
