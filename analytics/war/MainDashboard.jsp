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
				<h1 class="page-header">Main dashboard <small>Overview</small></h1>
			</div>
			<!-- /.col-lg-12 --> 
		</div>
		<!-- /.row --> 
	</div>
	<!-- /.container -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-push-3 col-md-6"> 
				<!--					<div class="progress">
						<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100" style="width: 25%;"> 25% </div>
					</div>
--> </div>
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>Search keywords</h4>
					</div>
					<div class="panel-body">
						<div id="morris-bar-chart"></div>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>Page visit distribution</h4>
					</div>
					<div class="panel-body">
						<div id="morris-donut-chart"></div>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>Audience</h4>
					</div>
					<div class="panel-body">
						<div id="morris-area-chart"></div>
					</div>
				</div>
			</div>
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>All campaigns</h4>
					</div>
					<table class="table table-hover">
						<thead id="headings">
							<tr>
								<th id="Product_ID"># <span class="fa fa-sort"></span></th>
								<th id="Product_Name">Product <span class="fa fa-sort"></span></th>
								<th id="Conv_Diff">Conversion rate <span class="fa fa-sort"></span></th>
								<th id="Previous_Conv">Previous Conversion <span class="fa fa-sort"></span></th>
								<th id="New_Conv">New Conversion <span class="fa fa-sort"></span></th>
								<th id="Clicks">Clicks <span class="fa fa-sort"></span></th>
								<th id="Status">Status <span class="fa fa-sort"></span></th>
							</tr>
						</thead>
						<tbody id="results">
							<!-- this will be auto-populated -->
						</tbody>
					</table>
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

<!-- Custom Theme JavaScript --> 
<script src="dist/js/sb-admin-2.js"></script> 
<script src="dist/js/custom-func.js"></script> 
<script>
/*<% String main_results_JSON = getDashboard.getAllProductID(); %>*/
/*[{"Product_ID":"1","Previous_Conv":"3.4","New_Conv":"4.2","Conv_Diff":".8","Status":"Active","Product_Name":"Home Loans","Clicks":"2323"},{"Product_ID":"1","Previous_Conv":"3.4","New_Conv":"4.2","Conv_Diff":".8","Status":"Active","Product_Name":"Home Loans","Clicks":"2323"},{"Product_ID":"1","Previous_Conv":"3.4","New_Conv":"4.2","Conv_Diff":".8","Status":"Active","Product_Name":"Home Loans","Clicks":"2323"},{"Product_ID":"1","Previous_Conv":"3.4","New_Conv":"4.2","Conv_Diff":".8","Status":"Active","Product_Name":"Home Loans","Clicks":"2323"},{"Product_ID":"22","Previous_Conv":"3.0092592","New_Conv":"2.0576131","Conv_Diff":"-0.9516461","Status":"Active","Product_Name":"Basic Home Loan","Clicks":"10"},{"Product_ID":"23","Previous_Conv":"3.0092592","New_Conv":"2.0576131","Conv_Diff":"-0.9516461","Status":"Active","Product_Name":"Basic Home Loan","Clicks":"10"},{"Product_ID":"24","Previous_Conv":"3.0092592","New_Conv":"2.0576131","Conv_Diff":"-0.9516461","Status":"Active","Product_Name":"Basic Home Loan","Clicks":"10"},{"Product_ID":"25","Previous_Conv":"3.0092592","New_Conv":"2.0576131","Conv_Diff":"-0.9516461","Status":"Active","Product_Name":"Basic Home Loan","Clicks":"10"},{"Product_ID":"26","Previous_Conv":"3.0092592","New_Conv":"2.0576131","Conv_Diff":"-0.9516461","Status":"Active","Product_Name":"Basic Home Loan","Clicks":"10"}]*/

var jsonResult = <%=main_results_JSON%>;

/*	Desc: Sorting an array of JavaScript objects
/*	Author:	Sean the Bean
/*	Source: http://stackoverflow.com/questions/881510/sorting-json-by-values */		
$(function() {
    $('#headings th').click(function() {
        var id = $(this).attr('id');
        var asc = (!$(this).attr('asc')); // switch the order, true if not set
        
        // set asc="asc" when sorted in ascending order
        $('#headings th').each(function() {
            $(this).removeAttr('asc');
        });
        if (asc) $(this).attr('asc', 'asc');
        
        sortResults(id, asc);
    });
        
    showResults();
});

function sortResults(prop, asc) {
    jsonResult = jsonResult.sort(function(a, b) {
        if (asc) return (a[prop] > b[prop]);
        else return (b[prop] > a[prop]);
    });
    showResults();
}

function showResults () {
	var html = '';
	for (var e in jsonResult) {
		var convIcon = (jsonResult[e].Conv_Diff>0) ? '<span class="fa fa-chevron-up text-success"></span> ' : '<span class="fa fa-chevron-down text-danger"></span> ';
		var statusIcon = (jsonResult[e].Status=="Active") ? '<span class="label label-success">'+jsonResult[e].Status+'</span> ' : '<span class="label label-danger">'+jsonResult[e].Status+'</span> ';
		
		html += '<tr>'
		+'<td>'+jsonResult[e].Product_ID+'</td>'
		+'<td><a href="/ResultsDashboard.jsp?product_id='+jsonResult[e].Product_ID+'" target="_blank">'+jsonResult[e].Product_Name+'</a></td>'
		+'<td>'+convIcon+jsonResult[e].Conv_Diff+'</td>'
		+'<td>'+jsonResult[e].Previous_Conv+'</td>'
		+'<td>'+jsonResult[e].New_Conv+'</td>'
		+'<td>'+jsonResult[e].Clicks+'</td>'
		+'<td>'+statusIcon+'</td>'
		+'</tr>';
	}
	$('#results').html(html);
}

$(function() {
	Morris.Area({
        element: 'morris-area-chart',
        data: [{
            period: '2013 Q1',
            age18to34: 6810,
            age35to54: 1914,
            age55to84: 2293
        }, {
            period: '2014 Q2',
            age18to34: 5670,
            age35to54: 4293,
            age55to84: 1881
        }, {
            period: '2015 Q3',
            age18to34: 4820,
            age35to54: 3795,
            age55to84: 1588
        }, {
            period: '2015 Q4',
            age18to34: 15073,
            age35to54: 5967,
            age55to84: 5175
        }, {
            period: '2016 Q1',
            age18to34: 10687,
            age35to54: 4460,
            age55to84: 2028
        }, {
            period: '2016 Q2',
            age18to34: 8432,
            age35to54: 5713,
            age55to84: 1791
        }],
        xkey: 'period',
        ykeys: ['age18to34', 'age35to54', 'age55to84'],
        labels: ['18 to 34', '35 to 54', '55 +'],
        pointSize: 2,
        hideHover: 'auto',
        resize: true
    });

	Morris.Bar({
        element: 'morris-bar-chart',
        data: [{
            y: 'credit cards',
            a: 100,
            b: 90
        }, {
            y: 'mortgages',
            a: 75,
            b: 65
        }, {
            y: 'loan',
            a: 50,
            b: 40
        }, {
            y: 'borrow',
            a: 75,
            b: 65
        }, {
            y: 'bank',
            a: 50,
            b: 40
        }],
        xkey: 'y',
        ykeys: ['a', 'b'],
        labels: ['This month', 'Last month'],
        hideHover: 'auto',
        resize: true
    });

	Morris.Donut({
		element: 'morris-donut-chart',
		data: [{
			label: "Home loans",
			value: 3339
		}, {
			label: "Credit cards",
			value: 1899
		}, {
			label: "Bank accounts",
			value: 708
		}],
		resize: true
	});
});

</script>
</body>
</html>
