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

import com.mysql.jdbc.Statement;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AddProductPageOne {
	public static int insertProductDetailsOne(String product_name, String primary_url, String previous_url, String market_spend) throws ClassNotFoundException, UnsupportedEncodingException {		
		

	Connection conn = null;

	conn = CreateConnection.createConnection();

	int product_id = 2;
	
	try {
		/* Check if this is first time upload */
		
			
		
		String statement = "INSERT INTO `analytics`.`Product_Details_1` (`Product_Name`, `Primay_URL`, `Previous_URL`, `Market_Spend`) VALUES ('"+product_name+"','"+primary_url+"', '"+previous_url+"', '"+market_spend+"');";

		PreparedStatement stmt = conn.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS);
			
			stmt.executeUpdate();
			
			ResultSet keys = stmt.getGeneratedKeys();    
			keys.next();  
			product_id = keys.getInt(1);

				System.out.println("Product_Details_1 were inserted");

	}
	catch (SQLException e) {
		product_id = 0;
		e.printStackTrace();
	}
	catch (NullPointerException e)
	{
		product_id =0;
		e.printStackTrace();
	}

	return product_id;
}
}
 