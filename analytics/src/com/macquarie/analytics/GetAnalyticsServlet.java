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


public class GetAnalyticsServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {  

		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		HttpSession session = request.getSession(false);
		String startDate = (String) request.getParameter("startDate");  
		String endDate = (String) request.getParameter("endDate");  
		String url = (String) request.getParameter("url");
		String action = (String) request.getParameter("action");
		String name = (String) request.getParameter("name");
		
		
		System.out.println("startDate"+startDate);
		System.out.println("endDate"+endDate);
		System.out.println("url"+url);
		System.out.println("action"+action);
		System.out.println("name"+name);
		
		
		
		
		HashMap success=new HashMap();

		success = HelloAnalytics.completeGaData(startDate, endDate,url,action);

		System.out.println("success"+success);


		if(!success.isEmpty()){			
			
				request.setAttribute("success", "true");
				request.setAttribute("resultMap", success);
				RequestDispatcher rd=request.getRequestDispatcher("ResultsDashboard");  
				rd.forward(request,response); 

		}


		else{
			System.out.print("No results found");  
			request.setAttribute("success", "false");
			RequestDispatcher rd=request.getRequestDispatcher("ResultsDashboard");  
			rd.include(request,response); 
		}


		out.close();  
	}  
}  