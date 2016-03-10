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
	public static String insertProductDetailsOne(String product_id,String file_desktop,String file_tablet,String file_mobile, String JIRA) throws ClassNotFoundException, UnsupportedEncodingException {		

		String success = product_id;

		Connection conn = null;

		conn = CreateConnection.createConnection();



		try {		

			String statement = 
					"INSERT INTO `analytics`.`Product_Details_4` (`Product_ID`,`Desktop_Design`,`Tablet_Design`,`Mobile_Design`, `JIRA`) VALUES ('"+product_id+"','"+file_desktop+"','"+file_tablet+"','"+file_mobile+"','"+JIRA+"');";
			PreparedStatement stmt = conn.prepareStatement(statement);
			int queryResult = 2;
			queryResult = stmt.executeUpdate();
			if (queryResult == 1) {

				System.out.println("Product_Details_4 were inserted");
			} else{
				success ="false";
				System.out.println("There was an error while inserting product_details_4");
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
