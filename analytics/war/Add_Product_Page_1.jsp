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


<form action="AddProductPageOneServlet" method="post"> 
	<div class="container">


		<div class="row">

			<div class="col-md-12">
			
			<input type="text" name="product_name" id="product_name" placeholder="Product Name">
			
			</div>
		</div>

		<div class="row">

			<div class="col-md-12">
			
			<input type="text" name="primary_url" id="primary_url" placeholder="Primary URL">
			
			</div>

		</div>





		<div class="row">

			<div class="col-md-12">
			
			
			<input type="text" name="previous_url" id="previous_url" placeholder="Previous URL">
			
			</div>

		</div>

		<div class="row">

			<div class="col-md-12">
			
			<input type="text" name="market_spend" id="market_spend" placeholder="Market Spend">
			
			</div>

		</div>

	

	</div>

	<input type="submit" value="Proceed To Step #2" />

</form>

</body>
</html>
