<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="ro-RO">
<head profile="http://gmpg.org/xfn/11">
<title>Traffic Custom Error Pages</title>
<meta charset="utf-8" />
<meta http-equiv="Content-Language" content="ro" />
<meta name="robots" content="all,index,follow" />
<meta name="keywords" content="mogoolab, templates, 404 error page" />
<meta name="description"
	content="Traffic HTML Error Pages v 1.0 . Developed by MogooLab - www.mogoolab.com" />
<meta name="publisher" content="mogoolab.com" />
<meta name="author" content="mogoolab.com" />
<meta http-equiv="X-UA-Compatible" content="IE=8">
<link
	href='http://fonts.googleapis.com/css?family=Istok+Web|Chivo|Lekton'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value="/resources/js/impromptu/css.css"/>" />
<link rel="stylesheet" type="text/css" media="all"
	href='<c:url value="/resources/style.css"/>' />

<!--[if lte IE 7]>
<link rel="stylesheet" type="text/css" media="all" href="style_ie7.css" />
<![endif]-->

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/impromptu/jquery-impromptu.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-global.js"/>"></script>

<!--[if IE]>
<script type="text/javascript" src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
</head>

<body>
	<div class="wrapper">
		<div class="mainWrapper">
			<div id="logo">
				<a href="http://mogoolab.com" title="Traffic 404 Custom Error Page">MogooLab</a>
			</div>
			<div class="mainHolder">
				<div class="message">Oooops....we can’t find that page.</div>
				<!-- end .message -->
				<div class="errorNumber">404</div>
				<!-- end .errorNumber -->
				<!-- Search Form -->
				<div class="search">
					<form action="" method="post">
						<div class="searchInput">
							<input type="text" name="search_term" value="Search" />
						</div>
						<div class="searchButton">
							<input type="submit" name="submit" value="" />
						</div>

					</form>
				</div>
				<!-- end .search -->

				<div class="trafficLight">404 Error</div>

			</div>
			<!-- end .mainHolder -->


			<footer>
				<p class="copy">&copy 2015 Traffic Jam 404. All rights reserved.</p>
				<menu>
					<li><a href="<c:url value="/"/>" title="Home">Home</a></li>
					<li><a href="products" title="About Us">Product</a></li>
					<li><a href="customers"	title="Portfolio">Customer</a></li>
					<li><a href="orders" title="Sitemap">Orders</a></li>
					<li><a href="orderDetails" title="Contact">Order Details</a></li>
				</menu>
			</footer>
			<!-- end footer -->
		</div>
		<!-- end .mainWrapper -->

	</div>
	<!-- end .wrapper -->


</body>
</html>