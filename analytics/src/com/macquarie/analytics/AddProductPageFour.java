package com.macquarie.analytics;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AddProductPageFour {
	public static String insertProductDetailsOne(String product_id, String new_campaign_url_1, 
			String new_campaign_url_2, String new_campaign_url_3, String new_campaign_url_leads_1, 
			String new_campaign_url_leads_2, String new_campaign_url_leads_3) throws ClassNotFoundException, UnsupportedEncodingException {		
		
	String success = product_id;

	Connection conn = null;

	conn = CreateConnection.createConnection();

	try {
		/* Check if this is first time upload */
		
			
		
		String statement = 
				"INSERT INTO `analytics`.`Product_Details_3` (`Product_ID`, `New_Campaign_URL`, `Target_Leads`) VALUES ('"+product_id+"', '"+new_campaign_url_1+"', '"+new_campaign_url_leads_1+"'); "
				+ "INSERT INTO `analytics`.`Product_Details_3` (`Product_ID`, `New_Campaign_URL`, `Target_Leads`) VALUES ('"+product_id+"', '"+new_campaign_url_2+"', '"+new_campaign_url_leads_2+"');"
				+ "INSERT INTO `analytics`.`Product_Details_3` (`Product_ID`, `New_Campaign_URL`, `Target_Leads`) VALUES ('"+product_id+"', '"+new_campaign_url_3+"', '"+new_campaign_url_leads_3+"');";
		PreparedStatement stmt = conn.prepareStatement(statement);
			int queryResult = 2;
			queryResult = stmt.executeUpdate();
			if (queryResult == 1) {
				
				System.out.println("Product_Details_3 were inserted");
			} else{
				success ="false";
				System.out.println("There was an error while inserting product_details_3");
			}
	
		

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
 