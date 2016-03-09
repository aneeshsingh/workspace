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

public class AddProductPageThreeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {  

		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		HttpSession session = request.getSession(false);
		String product_id = (String) request.getParameter("product_id");

		String cmp_name = (String) request.getParameter("cmp_name");
		String cmp_url = (String) request.getParameter("cmp_url");  
		
		 String[] cmp_name_array = cmp_name.split(",");
		 String[] cmp_url_array = cmp_url.split(",");
		 
		HashMap competitors_name_urls = new HashMap();

		for(int i=0;i<cmp_name_array.length; i++)
		{
			competitors_name_urls.put(cmp_name_array[i], cmp_url_array[i]);
		}

		String success="false";

		try {
			success = AddProductPageThree.insertProductDetailsOne(product_id,competitors_name_urls);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		System.out.println("success"+success);


		if(!success.equalsIgnoreCase("false")){			

			request.setAttribute("success", "true");
			request.setAttribute("product_id", success);
			RequestDispatcher rd=request.getRequestDispatcher("Add_Product_Page_4");  
			rd.forward(request,response); 

		}


		else{
			System.out.print("No results found");  
			request.setAttribute("success", "false");
			RequestDispatcher rd=request.getRequestDispatcher("Add_Product_Page_4");  
			rd.include(request,response); 
		}


		out.close();  
	}  
}  