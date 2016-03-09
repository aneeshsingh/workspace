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
		String file_desktop = (String) request.getParameter("file_desktop");
		String file_tablet = (String) request.getParameter("file_tablet");  
		String file_mobile = (String) request.getParameter("file_mobile");
		String JIRA = (String) request.getParameter("JIRA");


		String success="false";

		try {
			success = AddProductPageFour.insertProductDetailsOne(product_id, file_desktop, file_tablet, file_mobile, JIRA);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		System.out.println("success"+success);


		if(!success.equalsIgnoreCase("false")){			

			request.setAttribute("success", "true");
			request.setAttribute("product_id", success);
			RequestDispatcher rd=request.getRequestDispatcher("Add_Product_Page_6");  
			rd.forward(request,response); 

		}


		else{
			System.out.print("No results found");  
			request.setAttribute("success", "false");
			RequestDispatcher rd=request.getRequestDispatcher("Add_Product_Page_6");  
			rd.include(request,response); 
		}


		out.close();  
	}  
}  