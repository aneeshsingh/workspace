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
public class AddProductPageThree {
	public static String insertProductDetailsOne(String product_id,HashMap competitors_name_urls) throws ClassNotFoundException, UnsupportedEncodingException {		
		
	String success = product_id;

	Connection conn = null;

	conn = CreateConnection.createConnection();

	try {
		/* Check if this is first time upload */
		
			
		 Iterator it = competitors_name_urls.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        
		        String competitors_name = pair.getKey().toString();
		        String competitors_url = pair.getValue().toString();
	
				String screenshot_file_name_desktop = competitors_name+"_"+product_id+"_"+"desktop";
				String screenshot_file_name_tablet = competitors_name+"_"+product_id+"_"+"tablet";
				String screenshot_file_name_mobile = competitors_name+"_"+product_id+"_"+"mobile";
				
				
			String statement = 
					"INSERT INTO `analytics`.`Product_Details_3` (`Product_ID`,`Competitor_Name`, `Competitor_URL`, `Competitor_Screen_Shot_name_desktop`, `Competitor_Screen_Shot_name_mobile`, `Competitor_Screen_Shot_name_tablet`) "
					+ "VALUES('"+product_id+"', '"+competitors_name+"', '"+competitors_url+"', '"+screenshot_file_name_desktop+"', '"+screenshot_file_name_mobile+"', '"+screenshot_file_name_tablet+"'); ";
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
 