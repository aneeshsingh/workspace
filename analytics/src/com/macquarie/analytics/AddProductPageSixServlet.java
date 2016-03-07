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

public class AddProductPageSixServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {  

		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		HttpSession session = request.getSession(false);
		String product_name = (String) request.getParameter("product_name");  
		String primary_url = (String) request.getParameter("primary_url");  
		String previous_url = (String) request.getParameter("previous_url");
		String market_spend = (String) request.getParameter("market_spend");
		
		
		
		String success="false";

		try {
			success = AddProductPageSix.insertProductDetailsOne(product_name, primary_url, previous_url, market_spend);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		System.out.println("success"+success);


		if(success.equalsIgnoreCase("true")){			
			
				request.setAttribute("success", "true");
				RequestDispatcher rd=request.getRequestDispatcher("OverallDashboard");  
				rd.forward(request,response); 

		}


		else{
			System.out.print("No results found");  
			request.setAttribute("success", "false");
			RequestDispatcher rd=request.getRequestDispatcher("OverallDashboard");  
			rd.include(request,response); 
		}


		out.close();  
	}  
}  