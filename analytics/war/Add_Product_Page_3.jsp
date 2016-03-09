<!DOCTYPE html>
<html lang="en">
<%@ page import="com.macquarie.analytics.*"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.sql.Connection"%>
<%@page language="java" session="true"%>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Campaign monitor (PSP) - Add product</title>

<!-- Bootstrap Core CSS -->
<link href="bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

<!-- Timeline CSS -->
<link href="dist/css/timeline.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="bower_components/morrisjs/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<div id="wrapper"> 
	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
			<a class="navbar-brand" href="index.html">Campaign monitor (PSP)</a> </div>
		<!-- /.navbar-header -->
		
		<ul class="nav navbar-top-links navbar-right">
			<li class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i> </a>
				<ul class="dropdown-menu dropdown-alerts">
					<li> <a href="#">
						<div> <i class="fa fa-comment fa-fw"></i> New Comment <span class="pull-right text-muted small">4 minutes ago</span> </div>
						</a> </li>
					<li class="divider"></li>
					<li> <a href="#">
						<div> <i class="fa fa-twitter fa-fw"></i> 3 New Followers <span class="pull-right text-muted small">12 minutes ago</span> </div>
						</a> </li>
					<li class="divider"></li>
					<li> <a href="#">
						<div> <i class="fa fa-envelope fa-fw"></i> Message Sent <span class="pull-right text-muted small">4 minutes ago</span> </div>
						</a> </li>
					<li class="divider"></li>
					<li> <a href="#">
						<div> <i class="fa fa-tasks fa-fw"></i> New Task <span class="pull-right text-muted small">4 minutes ago</span> </div>
						</a> </li>
					<li class="divider"></li>
					<li> <a href="#">
						<div> <i class="fa fa-upload fa-fw"></i> Server Rebooted <span class="pull-right text-muted small">4 minutes ago</span> </div>
						</a> </li>
					<li class="divider"></li>
					<li> <a class="text-center" href="#"> <strong>See All Alerts</strong> <i class="fa fa-angle-right"></i> </a> </li>
				</ul>
				<!-- /.dropdown-alerts --> 
			</li>
			<!-- /.dropdown -->
			<li class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i> </a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a> </li>
					<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a> </li>
					<li class="divider"></li>
					<li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a> </li>
				</ul>
				<!-- /.dropdown-user --> 
			</li>
			<!-- /.dropdown -->
		</ul>
		<!-- /.navbar-top-links -->
		
		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li> <a href="index.html"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a> </li>
					<li> <a href="#"><i class="fa fa-edit fa-fw"></i> Add product<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li> <a href="Add_Product_Page_1.jsp">Page 1</a> </li>
							<li> <a href="Add_Product_Page_2.jsp">Page 2</a> </li>
							<li> <a href="Add_Product_Page_3.jsp">Page 3</a> </li>
							<li> <a href="Add_Product_Page_4.jsp">Page 4</a> </li>
							<li> <a href="Add_Product_Page_5.jsp">Page 5</a> </li>
							<li> <a href="Add_Product_Page_6.jsp">Page 6</a> </li>
						</ul>
						<!-- /.nav-second-level --> 
					</li>
					<li> <a href="Table_Code.jsp"><i class="fa fa-table fa-fw"></i> Campaign status</a> </li>
				</ul>
			</div>
			<!-- /.sidebar-collapse --> 
		</div>
		<!-- /.navbar-static-side --> 
	</nav>
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Step 3 <small>Competitor details</small></h1>
				</div>
				<!-- /.col-lg-12 --> 
			</div>
			<!-- /.row --> 
		</div>
		<!-- /.container -->
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-push-3 col-md-6">
					<div class="alert alert-success hide" role="alert"><%=request.getAttribute("success") %></div>
<!--					<div class="progress">
						<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 75%;"> 75% </div>
					</div>
-->				</div>
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-md-push-3 col-md-6">
					<form action="AddProductPageThreeServlet" method="post">
						<div class="form-group">
							<label for="new_campaign_url_1">New campaign #1</label>
							<input type="text" class="form-control" name="new_campaign_url_1" id="new_campaign_url_1" placeholder="Campaign URL">
							<input type="text" class="form-control" name="new_campaign_url_leads_1" id="new_campaign_url_leads_1" placeholder="Target Leads">
						</div>
						<div class="form-group">
							<label for="new_campaign_url_2">New campaign #2</label>
							<input type="text" class="form-control" name="new_campaign_url_2" id="new_campaign_url_2" placeholder="Campaign URL">
							<input type="text" class="form-control" name="new_campaign_url_leads_2" id="new_campaign_url_leads_2" placeholder="Target Leads">
						</div>
						<div class="form-group">
							<label for="new_campaign_url_3">New campaign #3</label>
							<input type="text" class="form-control" name="new_campaign_url_3" id="new_campaign_url_3" placeholder="Campaign URL">
							<input type="text" class="form-control" name="new_campaign_url_leads_3" id="new_campaign_url_leads_3" placeholder="Target Leads">
						</div>
						<input type="hidden" name="product_id" id="product_id" value="<%=request.getAttribute("product_id")%>"/>
						<button type="submit" class="btn btn-primary btn-block text-right">Proceed To Step #4</button>
					</form>
					<div class="controls">
						<form action="AddProductPageThreeServlet" method="post">
							<div class="add-group col-md-12">
								<div class="entry form-group">
									<label for="mkt_spend">Competitor name</label>
									<input type="text" class="form-control form-group" name="cmp_name" id="cmp_name" placeholder="e.g NAB">
									<label for="mkt_spend">Competitor URL</label>
									<input type="text" class="form-control form-group" name="cmp_url" id="cmp_url" placeholder="e.g. http://www.nab.com.au/sites/personal/home-loans/nab-velocity-frequent-flyer-points-offer">
									<p class="text-right"><small>Add / Remove</small>
										<button class="btn btn-success btn-add btn-circle" type="button"> <span class="glyphicon glyphicon-plus"></span> </button>
									</p>
								</div>
							</div>
							<input type="hidden" name="cmp_name-all" id="cmp_name-all" value="" />
							<input type="hidden" name="cmp_url-all" id="cmp_url-all" value="" />
							<input type="hidden" name="product_id" id="product_id" value="<%=request.getParameter("product_id")%>"/>
							<button type="submit" class="btn btn-primary btn-block text-right" onClick="concatFields('cmp_name');concatFields('cmp_url');">Next step</button>
						</form>
					</div>
				</div>
			</div>
			<!-- /.row --> 
		</div>
		<!-- /.container --> 
	</div>
	<!-- /#page-wrapper --> 
</div>
<!-- /#wrapper --> 

<!-- jQuery --> 
<script src="bower_components/jquery/dist/jquery.min.js"></script> 

<!-- Bootstrap Core JavaScript --> 
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script> 

<!-- Metis Menu Plugin JavaScript --> 
<script src="bower_components/metisMenu/dist/metisMenu.min.js"></script> 

<!-- Morris Charts JavaScript --> 
<script src="bower_components/raphael/raphael-min.js"></script> 
<script src="bower_components/morrisjs/morris.min.js"></script> 
<script src="js/morris-data.js"></script> 

<!-- Custom Theme JavaScript --> 
<script src="dist/js/sb-admin-2.js"></script> 
<script src="dist/js/custom-func.js"></script>
</body>
</html>
