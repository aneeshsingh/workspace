package com.macquarie.analytics;

import org.json.JSONObject;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;


public class getDashboard {

	public static String getAllProductID() throws ClassNotFoundException, UnsupportedEncodingException, SQLException{
		
		Connection conn = CreateConnection.createConnection();
		ResultSet rs = conn.createStatement().executeQuery("SELECT Product_ID, Previous_Conv, New_Conv, Conv_Diff, Status, Product_Name, Clicks FROM analytics.Main_Dashboard");
		String JSON_Object_String = "";
		
		
		try {
			while(rs.next()){

				String Product_ID = rs.getString(1);
				String Previous_Conv = rs.getString(2);
				String New_Conv = rs.getString(3);
				String Conv_Diff = rs.getString(4);
				String Status = rs.getString(5);
				String Product_Name = rs.getString(6);
				String Clicks = rs.getString(7);
				
				JSON_Object_String = JSON_Object_String + createJSONObject(Product_ID, Previous_Conv, New_Conv, Conv_Diff, Status, Product_Name, Clicks);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JSON_Object_String = createMainJSON(JSON_Object_String).toString();
		JSON_Object_String = JSON_Object_String.replaceAll("\\\\", "");

		
		return JSON_Object_String;
	}
	
	public static JsonObject createJSONObject(String Product_ID, String Previous_Conv, String New_Conv, String Conv_Diff, String Status, String Product_Name, String Clicks ){
		
		JsonObject personObject = Json.createObjectBuilder()
				.add("Product_ID", Product_ID)
				.add("Previous_Conv", Previous_Conv)
				.add("New_Conv", New_Conv)
				.add("Conv_Diff", Conv_Diff)
				.add("Status", Status)
				.add("Product_Name", Product_Name)
				.add("Clicks", Clicks)
				.build();

		return personObject;
	}
	
	public static JsonObject createMainJSON(String JSON_String){
		
		JsonObject personObject = Json.createObjectBuilder()
				.add("Products", JSON_String).build();

		return personObject;
	}

}
//
//	public static void main(String[] args) {
//		JsonObject personObject = Json.createObjectBuilder()
//				.add("name", "Jack")
//				.add("age", 13)
//				.add("isMarried", false)
//				.add("address", 
//						Json.createObjectBuilder().add("street", "Main Street")
//						.add("city", "New York")
//						.add("zipCode", "11111")
//						.build()
//						)
//						.add("phoneNumber", 
//								Json.createArrayBuilder().add("00-000-0000")
//								.add("11-111-1111")
//								.add("11-111-1112")
//								.build()
//								)
//								.build();
//
//		StringWriter stringWriter = new StringWriter();
//		JsonWriter writer = Json.createWriter(stringWriter);
//		writer.writeObject(personObject);
//		writer.close();
//		System.out.println(stringWriter.getBuffer().toString());
//	}



