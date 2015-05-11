<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="save" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Main Menu - Order Management System</title>

<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/login-box.css"/>'></link>
</head>

<body>

<!-- <div style="padding: 80px 0 0 100px;"> -->

<div id="login-box">

<H2>Main Menu - Order Management System</H2>
		Hendi Santika - 2015.
<br />

<br />
<div id="login-box-name" style="margin-top:20px;">
	<!-- <h3>
		<a href="products"> Add New Product</a>
	</h3></div><div id="login-box-field" style="margin-top:20px;"></div> -->
<%-- <div id="login-box-name" style="margin-top:20px;"><h3><a href='<c:url value="/customers"/>'> Add New Customer</a></h3></div><div id="login-box-field" style="margin-top:20px;"></div>
<div id="login-box-name" style="margin-top:20px;"><h3><a href='<c:url value="/customers"/>'> Add New Orders</a></h3></div><div id="login-box-field" style="margin-top:20px;"></div>
<div id="login-box-name" style="margin-top:20px;"><h3><a href='<c:url value="/customers"/>'> Add New Order Details</a></h3></div><div id="login-box-field" style="margin-top:20px;"></div>
<div id="login-box-name"><h3><!-- <a href="listProducts.jsp"> Products List</a> --><a href="products"> Products List</a></h3></div><div id="login-box-field"></div>
 --%><br />
<br />
<%-- <a href="#"><img src='<c:url value="/webapp/resources/images/login-btn.png"/>' width="103" height="42" style="margin-left:90px;" /></a> --%>
	<h3>
			<a href="products"> Add New Product</a>
		</h3>
		<h3>
			<a href='<c:url value="customers"/>'> Add New Customer</a>
		</h3>
		<h3>
			<a href='<c:url value="orders"/>'> Add New Orders</a>
		</h3>
		<h3>
			<a href='<c:url value="orderDetails"/>'> Add New Order Details</a>
		</h3>
		<h3><!-- <a href="listProducts.jsp"> Products List</a> -->
			<a href="products"> Products List</a>
		</h3>

</div>

</div>
		
		
</body>
</html>
