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
	public static String insertProductDetailsOne(String product_id) throws ClassNotFoundException, UnsupportedEncodingException, SQLException {		
		
	String success ="false";

	fetchScreenShots.createScreenshots(product_id);
	
	
	/**
	 * 
	 * Add current product_id to Overall Dashboard 
	 */
	
	Connection conn = null;

	conn = CreateConnection.createConnection();

	try {
		

	}

	catch (NullPointerException e)
	{
		success ="false";
		e.printStackTrace();
	}

	return success;
}
}
 