package com.macquarie.analytics;

import org.json.JSONObject;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;


public class addToDashboard {

	public static String getAllProductID() throws ClassNotFoundException, UnsupportedEncodingException, SQLException{

		Connection conn = CreateConnection.createConnection();
		String success = "";
		try {
			/* Check if this is first time upload */


			String statement = 
					"INSERT INTO `analytics`.`Main_Dashboard` (`Product_ID`, `Previous_Conv`, `New_Conv`, `Conv_Diff`, `Status`, `Product_Name`, `Clicks`) VALUES ('12', '4.3', '5.2', '.7', 'Active', 'Home Loans', '2121');";
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


	}


}

