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
<script src="bower_components/jquery/dist/jquery.min.js"></script> 

</head>
<body>


	<%
	
	String product_id  = (String)request.getParameter("product_id");
	
	String imageJSON = getImagePaths.getImagesForID(product_id);
	
	HashMap gaData = getGAData.getGAData(product_id);
	
	String gaDataScreenSizes = gaData.get("gaDataScreenSizes").toString();
	String gaDataDevices = gaData.get("gaDataDevices").toString();
	String gaDataTime = gaData.get("gaDataTime").toString();
	String gaReturningNew = gaData.get("gaReturningNew").toString();
	String gaGeneralData = gaData.get("gaGeneralData").toString();
	String gaReferralData = gaData.get("gaReferralData").toString();
	
	
		%>

	<script>
	

	</script>


	<div class="container">


		<div class="row">

			<div class="col-md-12"><%=imageJSON %></div>
		</div>


		<div class="row">

			<div class="col-md-12"><%=gaDataScreenSizes %></div>
		</div>
		
				<div class="row">

			<div class="col-md-12"><%=gaDataDevices %></div>
		</div>
		
				<div class="row">

			<div class="col-md-12"><%=gaDataTime %></div>
		</div>
		
				<div class="row">

			<div class="col-md-12"><%=gaReturningNew %></div>
		</div>
		
				<div class="row">

			<div class="col-md-12"><%=gaGeneralData %></div>
		</div>
		
						<div class="row">

			<div class="col-md-12"><%=gaReferralData %></div>
		</div>
	</div>



</body>
</html>
