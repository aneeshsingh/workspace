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

public class AddProductPageOneServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {  

		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		HttpSession session = request.getSession(false);
		String product_name = (String) request.getParameter("product_name");
		String category = (String) request.getParameter("category");
		String product_url = (String) request.getParameter("product_url");  
		String product_type = (String) request.getParameter("product_type");
		String product_CTA = (String) request.getParameter("product_CTA");
		
		
		
		int success=0;

		try {
			success = AddProductPageOne.insertProductDetailsOne(product_name, category, product_url, product_type, product_CTA);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		System.out.println("success"+success);


		if(success > 0){			
			
				request.setAttribute("success", "true");
				request.setAttribute("product_id", success);
				RequestDispatcher rd=request.getRequestDispatcher("Add_Product_Page_2");  
				rd.forward(request,response); 

		}


		else{
			System.out.print("No results found");  
			request.setAttribute("success", "false");
			RequestDispatcher rd=request.getRequestDispatcher("Add_Product_Page_2");  
			rd.include(request,response); 
		}


		out.close();  
	}  
}  