package com.macquarie.analytics;

import java.io.IOException;

import com.google.api.services.analytics.Analytics;
import com.google.api.services.analytics.model.GaData;

public class GetEvents {

	  /**
	   * Returns the top 25 organic search keywords and traffic sources by visits. The Core Reporting
	   * API is used to retrieve this data.
	   *
	   * @param analytics the Analytics service object used to access the API.
	   * @param tableId the table ID from which to retrieve data.
	   * @return the response from the API.
	   * @throws IOException if an API error occured.
	   */
	  static GaData executeEventsDataQuery(Analytics analytics, String tableId, String startDate, String endDate, String url) throws IOException {
	    

			  return analytics.data().ga().get(tableId, // Table Id.
			    		startDate, // Start date.
			    		endDate, // End date.
			        "ga:totalEvents,ga:uniqueEvents") // Metrics.
			        .setDimensions("ga:pagePath,ga:eventCategory,ga:eventLabel,ga:eventAction")
			        .setSort("-ga:totalEvents")
			        .setFilters("ga:pagePath=="+url+"")
			        .setMaxResults(25)
			        .execute();
			  
		  
		  	  
	  }
}
