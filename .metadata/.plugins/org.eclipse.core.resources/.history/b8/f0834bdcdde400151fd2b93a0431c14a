package com.macquarie.analytics;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.analytics.Analytics;
import com.google.api.services.analytics.AnalyticsScopes;
import com.google.api.services.analytics.model.Accounts;
import com.google.api.services.analytics.model.GaData;
import com.google.api.services.analytics.model.Profiles;
import com.google.api.services.analytics.model.Webproperties;
import com.google.api.services.analytics.model.GaData.ColumnHeaders;
import com.google.api.services.analytics.model.GaData.ProfileInfo;
import com.google.api.services.analytics.model.GaData.Query;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple example of how to access the Google Analytics API using a service
 * account.
 */
public class HelloAnalytics {


  private static final String APPLICATION_NAME = "Hello Analytics";
  private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
  private static final String KEY_FILE_LOCATION = "client_secrets.p12";
  private static final String SERVICE_ACCOUNT_EMAIL = "analytics2@analytics-1233.iam.gserviceaccount.com";
  public static HashMap completeGaData(String startDate, String endDate, String url, String action) {
	   HashMap allGAData = new HashMap();
	      
    try {
      Analytics analytics = initializeAnalytics();

      String profile = getFirstProfileId(analytics);
      System.out.println("First Profile Id: "+ profile);
      printResults(getResults(analytics, profile));
      
      String table_id = "ga:"+profile;
      
      GaData gaData = executeDataQuery(analytics, table_id);
      printReportInfo(gaData);
      printProfileInfo(gaData);
      printQueryInfo(gaData);
      printPaginationInfo(gaData);
      printTotalsForAllResults(gaData);
      printColumnHeaders(gaData);
      printDataTable(gaData);
      
      
     
      GaData gaDataConv = GetConversion.executeViewsDataQuery(analytics, table_id, startDate, endDate, url, action);
      printReportInfo(gaDataConv);
      printProfileInfo(gaDataConv);
      printQueryInfo(gaDataConv);
      printPaginationInfo(gaDataConv);
      printTotalsForAllResults(gaDataConv);
      printColumnHeaders(gaDataConv);
      printDataTable(gaDataConv);
      
      
      GaData gaDataScreenSizes = GetScreenSizes.executeScreenSizesDataQuery(analytics, table_id, startDate, endDate, url);
      printDataTable(gaDataScreenSizes);     
 
      GaData gaDataDevices = GetDevices.executeDevicesDataQuery(analytics, table_id, startDate, endDate, url);
      printDataTable(gaDataDevices); 
      
      GaData gaDataTime = GetTime.executeTimeDataQuery(analytics, table_id, startDate, endDate, url);
      printDataTable(gaDataTime);
 
      GaData gaReturningNew = GetReturningNew.executeReturnNewDataQuery(analytics, table_id, startDate, endDate, url);
      printDataTable(gaReturningNew);
            
      GaData gaGeneralData = GetGeneralData.executeGeneralDataDataQuery(analytics, table_id, startDate, endDate, url);
      printDataTable(gaGeneralData);
      
      GaData gaReferralData = GetReferralData.executeReferralDataQuery(analytics, table_id, startDate, endDate, url);
      printDataTable(gaReferralData);
      
   
      allGAData.put("gaDataConv", printHTMLDataTable(gaDataConv));
      allGAData.put("gaDataScreenSizes", printHTMLDataTable(gaDataScreenSizes));
      allGAData.put("gaDataDevices", printHTMLDataTable(gaDataDevices));
      allGAData.put("gaDataTime", printHTMLDataTable(gaDataTime));
      allGAData.put("gaReturningNew", printHTMLDataTable(gaReturningNew));
      allGAData.put("gaGeneralData", printHTMLDataTable(gaGeneralData));
      allGAData.put("gaReferralData", printHTMLDataTable(gaReferralData));
      
      return allGAData;
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
	return allGAData;
  }

  private static Analytics initializeAnalytics() throws Exception {
    // Initializes an authorized analytics service object.

    // Construct a GoogleCredential object with the service account email
    // and p12 file downloaded from the developer console.
    HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
    GoogleCredential credential = new GoogleCredential.Builder()
        .setTransport(httpTransport)
        .setJsonFactory(JSON_FACTORY)
        .setServiceAccountId(SERVICE_ACCOUNT_EMAIL)
        .setServiceAccountPrivateKeyFromP12File(new File(KEY_FILE_LOCATION))
        .setServiceAccountScopes(AnalyticsScopes.all())
        .build();

    // Construct the Analytics service object.
    return new Analytics.Builder(httpTransport, JSON_FACTORY, credential)
        .setApplicationName(APPLICATION_NAME).build();
  }


  private static String getFirstProfileId(Analytics analytics) throws IOException {
    // Get the first view (profile) ID for the authorized user.
    String profileId = null;

    // Query for the list of all accounts associated with the service account.
    Accounts accounts = analytics.management().accounts().list().execute();

    if (accounts.getItems().isEmpty()) {
      System.err.println("No accounts found");
    } else {
      String firstAccountId = accounts.getItems().get(0).getId();

      // Query for the list of properties associated with the first account.
      Webproperties properties = analytics.management().webproperties()
          .list(firstAccountId).execute();

      if (properties.getItems().isEmpty()) {
        System.err.println("No Webproperties found");
      } else {
        String firstWebpropertyId = properties.getItems().get(0).getId();

        // Query for the list views (profiles) associated with the property.
        Profiles profiles = analytics.management().profiles()
            .list(firstAccountId, firstWebpropertyId).execute();

        if (profiles.getItems().isEmpty()) {
          System.err.println("No views (profiles) found");
        } else {
          // Return the first (view) profile associated with the property.
          profileId = profiles.getItems().get(0).getId();
        }
      }
    }
    return profileId;
  }

  private static GaData getResults(Analytics analytics, String profileId) throws IOException {
    // Query the Core Reporting API for the number of sessions
    // in the past seven days.
    return analytics.data().ga()
        .get("ga:" + profileId, "30daysAgo", "today", "ga:pageviews")
        .execute();
  }


  /**
   * Returns the top 25 organic search keywords and traffic sources by visits. The Core Reporting
   * API is used to retrieve this data.
   *
   * @param analytics the Analytics service object used to access the API.
   * @param tableId the table ID from which to retrieve data.
   * @return the response from the API.
   * @throws IOException if an API error occured.
   */
  private static GaData executeDataQuery(Analytics analytics, String tableId) throws IOException {
    return analytics.data().ga().get(tableId, // Table Id.
        "2016-01-01", // Start date.
        "2016-03-01", // End date.
        "ga:visits") // Metrics.
        .setDimensions("ga:source,ga:keyword")
        .setSort("-ga:visits,ga:source")
        .setFilters("ga:medium==organic")
        .setMaxResults(25)
        .execute();
  }
  
  /**
   * Prints general information about this report.
   *
   * @param gaData the data returned from the API.
   */
  private static void printReportInfo(GaData gaData) {
    System.out.println();
    System.out.println("Response:");
    System.out.println("ID:" + gaData.getId());
    System.out.println("Self link: " + gaData.getSelfLink());
    System.out.println("Kind: " + gaData.getKind());
    System.out.println("Contains Sampled Data: " + gaData.getContainsSampledData());
  }

  /**
   * Prints general information about the profile from which this report was accessed.
   *
   * @param gaData the data returned from the API.
   */
  private static void printProfileInfo(GaData gaData) {
    ProfileInfo profileInfo = gaData.getProfileInfo();

    System.out.println("Profile Info");
    System.out.println("Account ID: " + profileInfo.getAccountId());
    System.out.println("Web Property ID: " + profileInfo.getWebPropertyId());
    System.out.println("Internal Web Property ID: " + profileInfo.getInternalWebPropertyId());
    System.out.println("Profile ID: " + profileInfo.getProfileId());
    System.out.println("Profile Name: " + profileInfo.getProfileName());
    System.out.println("Table ID: " + profileInfo.getTableId());
  }

  /**
   * Prints the values of all the parameters that were used to query the API.
   *
   * @param gaData the data returned from the API.
   */
  private static void printQueryInfo(GaData gaData) {
    Query query = gaData.getQuery();

    System.out.println("Query Info:");
    System.out.println("Ids: " + query.getIds());
    System.out.println("Start Date: " + query.getStartDate());
    System.out.println("End Date: " + query.getEndDate());
    System.out.println("Metrics: " + query.getMetrics()); // List
    System.out.println("Dimensions: " + query.getDimensions()); // List
    System.out.println("Sort: " + query.getSort()); // List
    System.out.println("Segment: " + query.getSegment());
    System.out.println("Filters: " + query.getFilters());
    System.out.println("Start Index: " + query.getStartIndex());
    System.out.println("Max Results: " + query.getMaxResults());
  }

  /**
   * Prints common pagination information.
   *
   * @param gaData the data returned from the API.
   */
  private static void printPaginationInfo(GaData gaData) {
    System.out.println("Pagination Info:");
    System.out.println("Previous Link: " + gaData.getPreviousLink());
    System.out.println("Next Link: " + gaData.getNextLink());
    System.out.println("Items Per Page: " + gaData.getItemsPerPage());
    System.out.println("Total Results: " + gaData.getTotalResults());
  }

  /**
   * Prints the total metric value for all rows the query matched.
   *
   * @param gaData the data returned from the API.
   */
  private static void printTotalsForAllResults(GaData gaData) {
    System.out.println("Metric totals over all results:");
    Map<String, String> totalsMap = gaData.getTotalsForAllResults();
    for (Map.Entry<String, String> entry : totalsMap.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }
  }

  /**
   * Prints the information for each column. The reporting data from the API is returned as rows of
   * data. The column headers describe the names and types of each column in rows.
   *
   * @param gaData the data returned from the API.
   */
  private static void printColumnHeaders(GaData gaData) {
    System.out.println("Column Headers:");

    for (ColumnHeaders header : gaData.getColumnHeaders()) {
      System.out.println("Column Name: " + header.getName());
      System.out.println("Column Type: " + header.getColumnType());
      System.out.println("Column Data Type: " + header.getDataType());
    }
  }

  /**
   * Prints all the rows of data returned by the API.
   *
   * @param gaData the data returned from the API.
   */
  private static void printDataTable(GaData gaData) {
    if (gaData.getTotalResults() > 0) {
      System.out.println("Data Table:");

      // Print the column names.
      for (ColumnHeaders header : gaData.getColumnHeaders()) {
        System.out.format("%-32s", header.getName());
      }
      System.out.println();

      // Print the rows of data.
      for (List<String> rowValues : gaData.getRows()) {
        for (String value : rowValues) {
          System.out.format("%-32s", value);
        }
        System.out.println();
      }
    } else {
      System.out.println("No data");
    }
  }
  
  
  /**
   * Prints all the rows of data returned by the API.
   *
   * @param gaData the data returned from the API.
   */
  private static String printHTMLDataTable(GaData gaData) {
	  
	  String HTMLformatted = "<table>";
	 
	  
    if (gaData.getTotalResults() > 0) {
      System.out.println("Data Table:");

      // Print the column names.
      for (ColumnHeaders header : gaData.getColumnHeaders()) {
        System.out.format("%-32s", header.getName());
        
        HTMLformatted = HTMLformatted + "<th>" +header.getName()+"</th>";	          
      }
      System.out.println();

      // Print the rows of data.
      for (List<String> rowValues : gaData.getRows()) {
    	  
    	  HTMLformatted = HTMLformatted + "<tr>";
    	  
        for (String value : rowValues) {
          System.out.format("%-32s", value);
          
          HTMLformatted = HTMLformatted + "<td>"+value+"</td>";
        }
        
        HTMLformatted = HTMLformatted + "</tr>";
        System.out.println();
      }
    } else {
    	  
        HTMLformatted = HTMLformatted + "<tr><td> No Data</td></tr>";
      System.out.println("No data");
    }
    
    HTMLformatted = HTMLformatted + "</table>";
    return HTMLformatted;
  }
  
  
  private static void printResults(GaData results) {
    // Parse the response from the Core Reporting API for
    // the profile name and number of sessions.
    if (results != null && !results.getRows().isEmpty()) {
      System.out.println("View (Profile) Name: "
        + results.getProfileInfo().getProfileName());
      System.out.println("Total Page Views: " + results.getRows().get(0).get(0));
    } else {
      System.out.println("No results found");
    }
  }
}