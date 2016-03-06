package com.macquarie.analytics;

import java.util.HashMap;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;

import com.google.appengine.api.utils.SystemProperty;
import com.mysql.jdbc.*;

public class addURLs {
	public static void addURLs(HashMap urls) throws ClassNotFoundException, UnsupportedEncodingException{
		
	    Connection conn = CreateConnection.createConnection();

		try{

			String statement = "INSERT INTO `analytics`.`urls` (`url`) VALUES (?)";

			
			 Iterator it = urls.entrySet().iterator();
			    while (it.hasNext()) {
			        Map.Entry pair = (Map.Entry)it.next();
			    
			PreparedStatement stmt = conn.prepareStatement(statement);
			stmt.setString(1, (String) pair.getKey());

			int success = 2;
			success = stmt.executeUpdate();



		}
	    }

		catch(SQLException e){
			e.printStackTrace();
		}		

	}

	}

