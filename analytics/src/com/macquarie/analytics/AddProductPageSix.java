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
public class AddProductPageSix {
	public static String insertProductDetailsOne(String product_name, String primary_url, String previous_url, String market_spend) throws ClassNotFoundException, UnsupportedEncodingException {		
		
	String success ="false";

	Connection conn = null;

	conn = CreateConnection.createConnection();

	try {
		/* Check if this is first time upload */
		
			
		
		String statement = "INSERT INTO `analytics`.`Product_Details_1` (`Product_Name`, `Primay_URL`, `Previous_URL`, `Market_Spend`) VALUES ('"+product_name+"','"+primary_url+"', '"+previous_url+"', '"+market_spend+"');";

		PreparedStatement stmt = conn.prepareStatement(statement);
			int queryResult = 2;
			queryResult = stmt.executeUpdate();
			if (queryResult == 1) {
				success = "true";
				System.out.println("Product_Details_1 were inserted");
			} else{
				success ="false";
				System.out.println("There was an error while inserting product_details_1");
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
 