<!DOCTYPE html>
<html class="no-js" xmlns="http://www.w3.org/1999/xhtml"
	xml:lang="en-US" lang="en-US">

<%@ page import="com.macquarie.analytics.*"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.sql.Connection"%>
<%@page language="java" session="true"%>

<head>

</head>
<body >
<h1>Hi</h1>

	<%
				String user_id = "";
				String emailAddress = "";
				String mobile_no = "";
				String first_name = "";
				String profile_picture = "";

				HashMap overallResultMap = new HashMap();
				System.out.println("I am here");
				try {
					overallResultMap = (HashMap) request.getAttribute("ResultsDashBoard");
					System.out.println("overallResultMap -->"+overallResultMap);

				}catch(Exception e){
					e.printStackTrace();
				}
				
				
					
	%>	

<div>
<%=overallResultMap %>
</div>
</body>
</html>
