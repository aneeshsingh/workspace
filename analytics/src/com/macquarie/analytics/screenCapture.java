package com.macquarie.analytics;


import it.grabz.grabzit.GrabzItClient;
import it.grabz.grabzit.enums.BrowserType;
import it.grabz.grabzit.enums.ImageFormat;

import java.io.File;
import java.io.UnsupportedEncodingException;

public class screenCapture {
 public static void main(String[] args) throws Exception{
	 GrabzItClient grabzIt = new GrabzItClient("NjFjMzdjNTg4ZDcxNDc4ZDhkNzc4NTMyNDQ3YTEwZTg=", "P0M/Uj8/P3Y/P1o/Pys/P3hBbD8/PzA/Pz96Pz8/Pz8=");
	 
	// To take a image screenshot
	 
	 
	 String url = "https://www.commbank.com.au/personal/credit-cards.html?pid=45563&sc_psk=10669&sc_crkey=73658353969&gclid=CK_souu_r8sCFYSVvAodDSMBlg&c";
	 String customId = "scw-screenshot-main-mobile.jpg";
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
	 
	 String filepath = "war/images/scw-screenshot-main-mobile.jpg";
	 grabzIt.Save("http://purelyfit.com.au/php/handler.php?filename=scw-screenshot-main-mobile"); 
//	 grabzIt.SaveTo(filepath);
	 
	 customId = "scw-screenshot-main-desktop.jpg";
	 browserWidth = 1920;
	 requestAs = BrowserType.STANDARDBROWSER;
	 
	 grabzIt.SetImageOptions(url, customId, browserWidth, browserHeight, outputWidth, outputHeight, format, delay, targetElement, requestAs, customWaterMarkId);
	 
	 String filepathDesktop = "war/images/scw-screenshot-main-desktop.jpg";
	 grabzIt.Save("http://purelyfit.com.au/php/handler.php"); 
	 
	 
	 customId = "scw-screenshot-main-tablet.jpg";
	 browserWidth = 768;
	 requestAs = BrowserType.STANDARDBROWSER;
	 
	 grabzIt.SetImageOptions(url, customId, browserWidth, browserHeight, outputWidth, outputHeight, format, delay, targetElement, requestAs, customWaterMarkId);
	 
	 String filepathTablet = "war/images/scw-screenshot-main-tablet.jpg";
	 grabzIt.Save("http://purelyfit.com.au/php/handler.php"); 
	 
 }
}