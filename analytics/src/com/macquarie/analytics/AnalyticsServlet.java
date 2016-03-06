package com.macquarie.analytics;
import java.io.IOException;

import javax.servlet.http.*;

import java.io.IOException;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
@SuppressWarnings("serial")
public class AnalyticsServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		String website = "http://www.macquarie.com/au/personal/expertise";
		HashMap urls = new HashMap();
		urls = scraper.fetchURLs(website);
		PrintHashmap.hashMapPrinter(resp, urls);
		try {
			addURLs.addURLs(urls);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
