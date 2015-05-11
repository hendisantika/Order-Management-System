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
<c:url var="addAction" value="/orders/add" ></c:url>
 
<form:form action="${addAction}" commandName="orders">
<%-- 	<form:form method="post" action="customer" commandName="customer"> --%>
		<table>
			<c:if test="${! empty orders.customerId}">
				<tr>
					<td><form:label path="orderID">
							<spring:message text="Order ID" />
						</form:label>
					</td>
					<td><form:input path="orderID" readonly="true" size="8"
							disabled="true" /> <form:hidden path="orderID" /></td>
					<td><form:errors path="orderID" cssClass="error" /></td>
				</tr>
			</c:if>
		
			<tr>
				<td><form:label path="customerId">Customer ID :</form:label></td>
				<td><form:input path="customerId" /></td>
				<%-- <td><form:select path="customerId" items="${customer.customerId}" value="....."/></td> --%>
				<%-- <td>
					<form:select path="customerId" value="....">
						<form:option value="NONE" label="--- Select ---" />
				    	<form:options items="${customerId}" />
				    </form:select>
			    </td> --%>
			</tr>
			<tr>
				<td><form:label path="totalAmount">Total Amount :</form:label></td>
				<td><form:input path="totalAmount" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<c:if test="${!empty orders.orderID}">
						<input type="submit" value="<spring:message text="Edit Orders"/>" />
					</c:if> 
					<c:if test="${empty orders.orderID}">
						<input type="submit" value="<spring:message text="Add Orders" />" />
					</c:if>					
				</td>
			</tr>
		</table>
		
		<!-- <input type="submit" value="Submit" /> -->

	</form:form>
	<br>
	<h3>Customers List</h3>
	<c:if test="${!empty listOrders}">
		<table class="tg">
			<tr>
				<th width="80">Orders ID</th>
				<th width="120">Customer ID</th>
				<th width="120">Total Amount</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listOrders}" var="orders">
				<tr>
					<td>${orders.orderID}</td>
					<td>${orders.customerId}</td>
					<td>${orders.totalAmount}</td>
					<td><a href="<c:url value='/orders/edit/${orders.orderID}' />">Edit</a></td>
					<td><a href="<c:url value='/orders/remove/${orders.orderID}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br>
	<a href="<c:url value='/'/>">Main Menu</a>
</body>
</html>