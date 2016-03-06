package com.macquarie.analytics;


import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.*;

import com.google.appengine.api.utils.SystemProperty;

public class CreateConnection {
	public static Connection createConnection() throws ClassNotFoundException, UnsupportedEncodingException {	


		String url = null;

		Connection conn = null;
		try {
			if (SystemProperty.environment.value() ==
					SystemProperty.Environment.Value.Production) {
				// Load the class that provides the new "jdbc:google:mysql://" prefix.
				Class.forName("com.mysql.jdbc.GoogleDriver");
				url = "jdbc:google:mysql://keyaccess-pre-launch:maindatabase/keyaccess?user=root";
				try {
					conn = DriverManager.getConnection(url);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				// Local MySQL instance to use during development.
				Class.forName("com.mysql.jdbc.Driver");
				url = "jdbc:mysql://173.194.236.104/keyaccess";
				try {
					conn = DriverManager.getConnection(url,"keyaccess","Kerberos@8562");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Alternatively, connect to a Google Cloud SQL instance using:
				// jdbc:mysql://ip-address-of-google-cloud-sql-instance:3306/guestbook?user=root
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("URL connected to:"+url);

		return conn;

	}
	
	
}