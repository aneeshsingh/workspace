package com.macquarie.analytics;


import it.grabz.grabzit.GrabzItClient;
import it.grabz.grabzit.enums.BrowserType;
import it.grabz.grabzit.enums.ImageFormat;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class fetchScreenShots {
	
	public static void createScreenshots(String product_id) throws ClassNotFoundException, UnsupportedEncodingException, SQLException{
		
		
		Connection conn = CreateConnection.createConnection();
		ResultSet rs_competitor = conn.createStatement().executeQuery("SELECT Competitor_URL, Competitor_Screen_Shot_name_desktop, Competitor_Screen_Shot_name_mobile, Competitor_Screen_Shot_name_tablet FROM analytics.Product_Details_3 where Product_ID='"+product_id+"';");
		
		System.out.println("SELECT Competitor_URL, Competitor_Screen_Shot_name_desktop, Competitor_Screen_Shot_name_mobile, Competitor_Screen_Shot_name_tablet FROM analytics.Product_Details_3 where Product_ID='"+product_id+"';");
		while(rs_competitor.next()){
			
			String url = rs_competitor.getString(1);
			String Competitor_Screen_Shot_name_desktop = rs_competitor.getString(2);
			String Competitor_Screen_Shot_name_mobile = rs_competitor.getString(3);
			String Competitor_Screen_Shot_name_tablet = rs_competitor.getString(4);


			try {
				storeScreenShots(Competitor_Screen_Shot_name_desktop, Competitor_Screen_Shot_name_tablet, Competitor_Screen_Shot_name_mobile, url);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		ResultSet rs_product = conn.createStatement().executeQuery("SELECT Product_URL, Product_Screen_Shot_name_desktop, Product_Screen_Shot_name_mobile, Product_Screen_Shot_name_tablet FROM analytics.Product_Details_1 where ID = '"+product_id+"';");

		System.out.println("SELECT Product_URL, Product_Screen_Shot_name_desktop, Product_Screen_Shot_name_mobile, Product_Screen_Shot_name_tablet FROM analytics.Product_Details_1 where ID = '"+product_id+"';");

		while(rs_product.next()){
			
			String url = rs_product.getString(1);
			String Product_Screen_Shot_name_desktop = rs_product.getString(2);
			String Product_Screen_Shot_name_mobile = rs_product.getString(3);
			String Product_Screen_Shot_name_tablet = rs_product.getString(4);


			try {
				storeScreenShots(Product_Screen_Shot_name_desktop, Product_Screen_Shot_name_tablet, Product_Screen_Shot_name_mobile, url);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		 
		
	}
	
	
 public static void storeScreenShots(String filename_desktop,String filename_tablet,String filename_mobile,String url  ) throws Exception{
	 GrabzItClient grabzIt = new GrabzItClient("NjFjMzdjNTg4ZDcxNDc4ZDhkNzc4NTMyNDQ3YTEwZTg=", "P0M/Uj8/P3Y/P1o/Pys/P3hBbD8/PzA/Pz96Pz8/Pz8=");
	 
	// To take a image screenshot
	 
	 String customId = filename_mobile;
	 int browserWidth = 375;
	 int browserHeight = -1;
	 int outputWidth = -1;
	 int outputHeight = -1;
	 ImageFormat format = ImageFormat.JPG;
	 int delay = 0;
	 String targetElement = "";
	 BrowserType requestAs = BrowserType.STANDARDBROWSER;
	 String customWaterMarkId = "";
	 
	 grabzIt.SetImageOptions(url, customId, browserWidth, browserHeight, outputWidth, outputHeight, format, delay, targetElement, requestAs, customWaterMarkId);
	 
	 grabzIt.Save("http://purelyfit.com.au/php/handler.php?filename=scw-screenshot-main-mobile"); 
	 
	 customId = filename_desktop;
	 browserWidth = 1920;
	 requestAs = BrowserType.STANDARDBROWSER;
	 
	 grabzIt.SetImageOptions(url, customId, browserWidth, browserHeight, outputWidth, outputHeight, format, delay, targetElement, requestAs, customWaterMarkId);
	 
	 grabzIt.Save("http://purelyfit.com.au/php/handler.php?filename=scw-screenshot-main-mobile"); 
	 
	 
	 customId = filename_tablet;
	 browserWidth = 768;
	 requestAs = BrowserType.STANDARDBROWSER;
	 
	 grabzIt.SetImageOptions(url, customId, browserWidth, browserHeight, outputWidth, outputHeight, format, delay, targetElement, requestAs, customWaterMarkId);
	 
	 grabzIt.Save("http://purelyfit.com.au/php/handler.php?filename=scw-screenshot-main-mobile"); 
	 
 }
} 