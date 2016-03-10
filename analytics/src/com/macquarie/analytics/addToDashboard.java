package com.macquarie.analytics;

import org.json.JSONObject;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.analytics.Analytics;
import com.google.api.services.analytics.AnalyticsScopes;
import com.google.api.services.analytics.model.GaData;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class addToDashboard {

	public static String AddProduct(String product_Id) throws Exception{

		Connection conn = CreateConnection.createConnection();
		String success = "";
		try {
			/* Check if this is first time upload */

			Analytics analytics = HelloAnalytics.initializeAnalytics();
			String profile = HelloAnalytics.getFirstProfileId(analytics);
			String table_id = "ga:"+profile;

			String Product_URL = "";
			String Product_Name = "";
			String Product_CTA = "";

			ResultSet rs = conn.createStatement().executeQuery("SELECT Product_URL,Product_Name, Product_CTA FROM analytics.Product_Details_1 where ID='"+product_Id+"';");


			while(rs.next()){

				Product_URL = rs.getString(1);
				Product_Name = rs.getString(2);
				Product_CTA = rs.getString(3);
			}


			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			System.out.println(dateFormat.format(cal.getTime()));

			cal.add(Calendar.DAY_OF_MONTH, -1);
			String current_period_end_date = dateFormat.format(cal.getTime());
			
			cal.add(Calendar.DAY_OF_MONTH, -7);
			String current_period_start_date = dateFormat.format(cal.getTime());

			cal.add(Calendar.DAY_OF_MONTH, -1);
			String previous_period_end_date = dateFormat.format(cal.getTime());
			
			cal.add(Calendar.DAY_OF_MONTH, -6);
			String previous_period_start_date = dateFormat.format(cal.getTime());
			
			
			
			System.out.println("current_period_end_date -->"+current_period_end_date);
			System.out.println("current_period_start_date -->"+current_period_start_date);
			System.out.println("previous_period_end_date -->"+previous_period_end_date);
			System.out.println("previous_period_start_date -->"+previous_period_start_date);		
			
			System.out.println("Product_URL -->"+Product_URL);
			

			Product_URL = Product_URL.replaceAll("http://www.macquarie.com", "");
			
			System.out.println("Product_URL -->"+Product_URL);
			System.out.println("table_id -->"+table_id);
			System.out.println("Product_CTA -->"+Product_CTA);
			System.out.println("analytics -->"+analytics);
			
			HelloAnalytics.printDataTable(GetConversion.getButtonClicks(analytics, table_id, current_period_start_date, current_period_end_date, Product_URL, Product_CTA));
			
			String newButtonClicks = GetConversion.getButtonClicks(analytics, table_id, current_period_start_date, current_period_end_date, Product_URL, Product_CTA).getRows().get(0).get(3);

			float newConversion = GetConversion.getConversion(analytics, table_id, current_period_start_date, current_period_end_date, Product_URL, Product_CTA);
			
			float oldConversion = GetConversion.getConversion(analytics, table_id, previous_period_start_date, previous_period_end_date, Product_URL, Product_CTA);
			
			float conversionDifference = newConversion - oldConversion;
			
			

			String statement = 
					"INSERT INTO `analytics`.`Main_Dashboard` (`Product_ID`, `Previous_Conv`, `New_Conv`, `Conv_Diff`, `Status`, `Product_Name`, `Clicks`) VALUES ('"+product_Id+"', '"+oldConversion+"', '"+newConversion+"', '"+conversionDifference+"', 'Active', '"+Product_Name+"', '"+newButtonClicks+"');";
			PreparedStatement stmt = conn.prepareStatement(statement);
			int queryResult = 2;
			queryResult = stmt.executeUpdate();
			if (queryResult == 1) {

				System.out.println("Product_Details_2 were inserted");
			} else{
				success ="false";
				System.out.println("There was an error while inserting product_details_2");
			}
			
			fetchScreenShots.createScreenshots(product_Id);



		}

		catch (SQLException e) {
			success ="false";
			e.printStackTrace();
		}
		catch (NullPointerException e)
		{
			success ="false";
			e.printStackTrace();
		}
		return success;


	}




}

