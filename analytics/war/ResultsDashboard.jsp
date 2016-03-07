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


	<%
		String user_id = "";
		String emailAddress = "";
		String mobile_no = "";
		String first_name = "";
		String profile_picture = "";

		HashMap overallResultMap = new HashMap();
		try {
			overallResultMap = (HashMap) request.getAttribute("resultMap");
			System.out.println("overallResultMap -->" + overallResultMap);

		} catch (Exception e) {

		}
	%>


	<div class="container">


		<div class="row">

			<div class="col-md-12"><%=overallResultMap.get("gaDataConv")%></div>
		</div>

		<div class="row">

			<div class="col-md-12"><%=overallResultMap.get("gaDataScreenSizes")%></div>

		</div>





		<div class="row">

			<div class="col-md-12"><%=overallResultMap.get("gaDataDevices")%></div>

		</div>

		<div class="row">

			<div class="col-md-12"><%=overallResultMap.get("gaDataTime")%></div>

		</div>




		<div class="row">

			<div class="col-md-12"><%=overallResultMap.get("gaReturningNew")%></div>
		</div>

		<div class="row">

			<div class="col-md-12"><%=overallResultMap.get("gaGeneralData")%></div>

		</div>




		<div class="row">

			<div class="col-md-12"><%=overallResultMap.get("gaReferralData")%></div>

			<div class="col-md-12"></div>

		</div>

	</div>



</body>
</html>
