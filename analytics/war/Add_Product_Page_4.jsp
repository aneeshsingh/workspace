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


<form action="AddProductPageFourServlet" method="post"> 
	<div class="container">


		<div class="row">

			<div class="col-md-12">
			<span>Primary URL</span>
			<input type="text" name="competitor_primary_url_1" id="competitor_primary_url_1" placeholder="Competitor URL #1">
			<input type="text" name="competitor_primary_url_2" id="competitor_primary_url_2" placeholder="Competitor URL #2">
			<input type="text" name="competitor_primary_url_3" id="competitor_primary_url_3" placeholder="Competitor URL #3">
			<input type="text" name="competitor_primary_url_4" id="competitor_primary_url_4" placeholder="Competitor URL #4">
			<input type="text" name="competitor_primary_url_5" id="competitor_primary_url_5" placeholder="Competitor URL #5">
			
			</div>
		</div>

		<div class="row">

			<div class="col-md-12">
			
			<span>Campaign URL</span>
			<input type="text" name="competitor_campaign_url_1" id="competitor_campaign_url_1" placeholder="Competitor URL #1">
			<input type="text" name="competitor_campaign_url_2" id="competitor_campaign_url_2" placeholder="Competitor URL #2">
			<input type="text" name="competitor_campaign_url_3" id="competitor_campaign_url_3" placeholder="Competitor URL #3">
			<input type="text" name="competitor_campaign_url_4" id="competitor_campaign_url_4" placeholder="Competitor URL #4">
			<input type="text" name="competitor_campaign_url_5" id="competitor_campaign_url_5" placeholder="Competitor URL #5">
						</div>

		</div>





<input type="hidden" name="product_id" id="prpduct_id" value="<%=request.getParameter("product_id")%>"/>



	</div>

<input type="submit" value="Proceed To Step #5" />

</form>

</body>
</html>
