package com.macquarie.analytics;

import java.io.IOException;

import com.google.api.services.analytics.Analytics;
import com.google.api.services.analytics.model.GaData;

public class GetConversion {

	  /**
	   * Returns the top 25 organic search keywords and traffic sources by visits. The Core Reporting
	   * API is used to retrieve this data.
	   *
	   * @param analytics the Analytics service object used to access the API.
	   * @param tableId the table ID from which to retrieve data.
	   * @return the response from the API.
	   * @throws IOException if an API error occured.
	   */
	  static GaData executeViewsDataQuery(Analytics analytics, String tableId, String startDate, String endDate, String url, String action) throws IOException {
	    
		  if(action.equalsIgnoreCase("")){
			  return analytics.data().ga().get(tableId, // Table Id.
			    		startDate, // Start date.
			    		endDate, // End date.
			        "ga:pageviews,ga:uniqueEvents") // Metrics.
			        .setDimensions("ga:pagePath,ga:eventAction")
			        .setSort("-ga:pagePath")
			        .setFilters("ga:pagePath=="+url+"")
			        .setMaxResults(25)
			        .execute();
			  
		  }else{
			  return analytics.data().ga().get(tableId, // Table Id.
			    		startDate, // Start date.
			    		endDate, // End date.
			        "ga:pageviews,ga:uniqueEvents") // Metrics.
			        .setDimensions("ga:pagePath,ga:eventAction")
			        .setSort("-ga:pagePath")
			        .setFilters("ga:pagePath=="+url+";ga:eventAction=="+action+"")
			        .setMaxResults(25)
			        .execute();
			  
		  }
		  	  
	  }
	  
	  static GaData getPageViews(Analytics analytics, String tableId, String startDate, String endDate, String url) throws IOException {
		    
			  return analytics.data().ga().get(tableId, // Table Id.
			    		startDate, // Start date.
			    		endDate, // End date.
			        "ga:pageviews") // Metrics.
			        .setDimensions("ga:pagePath")
			        .setSort("-ga:pagePath")
			        .setFilters("ga:pagePath=="+url+"")
			        .setMaxResults(25)
			        .execute();
			  
		  	  
	  }
	  
	  
	  static GaData getButtonClicks(Analytics analytics, String tableId, String startDate, String endDate, String url, String action) throws IOException {
		    
	
			  return analytics.data().ga().get(tableId, // Table Id.
			    		startDate, // Start date.
			    		endDate, // End date.
			        "ga:pageviews,ga:uniqueEvents") // Metrics.
			        .setDimensions("ga:pagePath,ga:eventAction")
			        .setSort("-ga:pagePath")
			        .setFilters("ga:pagePath=="+url+";ga:eventAction=="+action+"")
			        .setMaxResults(25)
			        .execute();
		  	  
	  }
	  
	  static float getConversion(Analytics analytics, String tableId, String startDate, String endDate, String url, String action) throws IOException {
		    
			String getButtonClicks = getButtonClicks(analytics, tableId, startDate, endDate, url, action).getRows().get(0).get(3);
			
			String getPageViews = getPageViews(analytics, tableId, startDate, endDate, url).getRows().get(0).get(1);
			
			System.out.println("getButtonClicks:"+getButtonClicks);
			System.out.println("getPageViews:"+getPageViews);
			
			
			int clicks = Integer.parseInt(getButtonClicks);
			
			System.out.println("clicks:"+clicks);
			
			int views= Integer.parseInt(getPageViews);
			
			System.out.println("views:"+views);
			
			float conv = (float)(clicks*100)/views;
			
			System.out.println("conv:"+conv);
			
			return conv;

	  	  
  }
	  
	   
}
