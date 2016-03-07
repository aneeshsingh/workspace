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

public class AddProductPageFourServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {  

		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		HttpSession session = request.getSession(false);
		String product_id = (String) request.getParameter("product_id");

		String new_campaign_url_1 = (String) request.getParameter("competitor_primary_url_1");
		String new_campaign_url_leads_1 = (String) request.getParameter("competitor_primary_url_2");  
		String new_campaign_url_2 = (String) request.getParameter("competitor_primary_url_3");
		String new_campaign_url_leads_2 = (String) request.getParameter("competitor_primary_url_4");
		String new_campaign_url_3 = (String) request.getParameter("competitor_primary_url_5");
		String new_campaign_url_leads_3 = (String) request.getParameter("new_campaign_url_leads_3");		





		String success="false";

		try {
			success = AddProductPageFour.insertProductDetailsOne(product_id, new_campaign_url_1, 
					new_campaign_url_2, new_campaign_url_3,new_campaign_url_leads_1, 
					new_campaign_url_leads_2, new_campaign_url_leads_3);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		System.out.println("success"+success);


		if(!success.equalsIgnoreCase("false")){			

			request.setAttribute("success", "true");
			request.setAttribute("product_id", success);
			RequestDispatcher rd=request.getRequestDispatcher("Add_Product_Page_5");  
			rd.forward(request,response); 

		}


		else{
			System.out.print("No results found");  
			request.setAttribute("success", "false");
			RequestDispatcher rd=request.getRequestDispatcher("Add_Product_Page_5");  
			rd.include(request,response); 
		}


		out.close();  
	}  
}  