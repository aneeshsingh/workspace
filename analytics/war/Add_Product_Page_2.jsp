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
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

</head>
<body>

<div><%=request.getAttribute("success") %></div>

<form action="AddProductPageTwoServlet" method="post"> 
	<div class="container">


		<div class="row">

			<div class="col-md-12">
			
			<input type="text" name="previous_campaign_url_1" id="previous_campaign_url_1" placeholder="Previous Campaign URL #1">
			<input type="text" name="previous_campaign_url_leads_1" id="previous_campaign_url_leads_1" placeholder="Campaign Leads">
			
			</div>
		</div>

		<div class="row">

			<div class="col-md-12">
			
			<input type="text" name="previous_campaign_url_2" id="previous_campaign_url_2" placeholder="Previous Campaign URL #2">
			<input type="text" name="previous_campaign_url_leads_2" id="previous_campaign_url_leads_2" placeholder="Campaign Leads">
			</div>

		</div>





		<div class="row">

			<div class="col-md-12">
			
			
			<input type="text" name="previous_campaign_url_3" id="previous_campaign_url_3" placeholder="Previous Campaign URL #3">
			<input type="text" name="previous_campaign_url_leads_3" id="previous_campaign_url_leads_3" placeholder="Campaign Leads">
			</div>

		</div>

		

<input type="hidden" name="product_id" id="prpduct_id" value="<%=request.getParameter("product_id")%>"/>

	</div>

<input type="submit" value="Proceed To Step #3" />

</form>

</body>
</html>
