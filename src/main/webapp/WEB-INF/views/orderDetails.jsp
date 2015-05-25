<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<title>Add new Orders</title>
</head>
<body>
<h2>Add new Orders</h2>
<c:url var="addAction" value="/orderDetails/add" ></c:url>
 
<form:form action="${addAction}" commandName="orderDetails" method="POST">
		<table>
			<c:if test="${orderDetails.orderID > 0}">
				<tr>
					<td><form:label path="orderDetailsNo">
							<spring:message text="Order Details No " />
						</form:label>
					</td>
					<td><form:input path="orderDetailsNo" readonly="true" size="8"
							disabled="true" /> <form:hidden path="orderDetailsNo" /></td>
					<td><form:errors path="orderDetailsNo" cssClass="error" /></td>
				</tr>
			</c:if>
		
			<tr>
				<td><form:label path="orderID">Order ID :</form:label></td>
				<td><form:input path="orderID" /></td>
			</tr>
			<tr>
				<td><form:label path="productId">ProductId :</form:label></td>
				<td><form:input path="productId" /></td>
			</tr>
			<tr>
				<td><form:label path="quantity">Quantity :</form:label></td>
				<td><form:input path="quantity" /></td>
			</tr>
			<tr>
				<td><form:label path="subtotal">Sub Total :</form:label></td>
				<td><form:input path="subtotal" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<c:if test="${!empty orderDetails.orderDetailsNo}">
						<input type="submit" value="<spring:message text="Edit Order Details"/>" />
					</c:if> 
					<c:if test="${empty orderDetails.orderDetailsNo}">
						<input type="submit" value="<spring:message text="Add Order Details" />" />
					</c:if>					
				</td>
			</tr>
		</table>
		
		<!-- <input type="submit" value="Submit" /> -->

	</form:form>
	<br>
	<h3>Customers List</h3>
	<c:if test="${!empty listOrderDetails}">
		<table class="tg">
			<tr>
				<th width="80">Order Details No</th>
				<th width="120">Order ID</th>
				<th width="120">Product ID</th>
				<th width="120">Quantity</th>
				<th width="120">Subtotal</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listOrderDetails}" var="listOrderDetails">
				<tr>
					<td>${orderDetails.orderDetailsNo}</td>
					<td>${orderDetails.orderID}</td>
					<td>${orderDetails.productId}</td>
					<td>${orderDetails.quantity}</td>
					<td>${orderDetails.subtotal}</td>
					<td><a href="<c:url value='/orderDetails/edit/${orderDetails.orderDetailsNo}}' />">Edit</a></td>
					<td><a href="<c:url value='/orderDetails/remove/${orderDetails.orderDetailsNo}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br>
	<a href="<c:url value='/'/>">Main Menu</a>
</body>
</html>