package com.macquarie.analytics;

import java.io.IOException;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
public class scraper {
 
  public static HashMap fetchURLs(String website) {
	  
	  HashMap results = new HashMap();

    try {
      // fetch the document over HTTP

      Document doc = Jsoup.connect(website).get();
      
      // get the page title
      String title = doc.title();
      System.out.println("title: " + title);
      
      // get all links in page
      Elements links = doc.select("a[href]");
     
      
      for (int i=0; i < links.size(); i++) {
    	  
    	  Element link = links.get(i);
        // get the value from the href attribute
        System.out.println("\nlink: " + link.attr("href"));
        System.out.println("text: " + link.text());
        
        results.put(link.attr("href"), link.text());
       
        
      }
      return results;
    } catch (IOException e) {
    e.printStackTrace();
    }
	return results;
  }
}