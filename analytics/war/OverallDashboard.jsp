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


<form action="AddProductPageSixServlet" method="post"> 
	<div class="container">


		<div class="row">

			<div class="col-md-12">
			<span>Upload Desktop Design</span>
			 <input type="file" name="file_desktop" id="file_desktop" /> <br/>		
			</div>
		</div>






		<div class="row">

			<div class="col-md-12">
			
			<span>Tablet Desktop Design</span>
			 <input type="file" name="file_tablet" id="file_tablet" /> <br/>	
			</div>

		</div>

		

		<div class="row">

			<div class="col-md-12">
			
			<span>Mobile Desktop Design</span>
			 <input type="file" name="file_mobile" id="file_mobile" /> <br/>	
			</div>

		</div>
		


	</div>

<input type="submit" value="Complete" />


</form>

</body>
</html>
