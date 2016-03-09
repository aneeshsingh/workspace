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
public class AddProductPageTwo {
	public static String insertProductDetailsOne(String product_id,String Marketing_Spend,String Marketing_Type,String Marketing_Target,String Start_Date,String End_Date) throws ClassNotFoundException, UnsupportedEncodingException {		
		
	String success = product_id;

	Connection conn = null;

	conn = CreateConnection.createConnection();

	try {
		/* Check if this is first time upload */
		
		
		String statement = 
				"INSERT INTO `analytics`.`Product_Details_2` (`Product_ID`, `Marketing_Spend`, `Marketing_Type`, `Target`, `Start_Date`, `End_Date`) VALUES ('"+product_id+"', '"+Marketing_Spend+"', '"+Marketing_Type+"', '"+Marketing_Target+"', '"+Start_Date+"', '"+End_Date+"'); ";
		PreparedStatement stmt = conn.prepareStatement(statement);
			int queryResult = 2;
			queryResult = stmt.executeUpdate();
			if (queryResult == 1) {
				
				System.out.println("Product_Details_2 were inserted");
			} else{
				success ="false";
				System.out.println("There was an error while inserting product_details_2");
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
 