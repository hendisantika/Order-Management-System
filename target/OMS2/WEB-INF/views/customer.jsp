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
<title>Add new Customer</title>
</head>
<body>
<h2>Add new Customer</h2>
<c:url var="addAction" value="/customer/add" ></c:url>
 
<form:form action="${addAction}" commandName="customer">
<%-- 	<form:form method="post" action="customer" commandName="customer"> --%>
		<table>
			<c:if test="${!empty customer.cusFirstname}">
				<tr>
					<td><form:label path="customerId">
							<spring:message text="customerID" />
						</form:label>
					</td>
					<td><form:input path="customerId" readonly="true" size="8"
							disabled="true" /> <form:hidden path="customerId" /></td>
					<td><form:errors path="cusFirstname" cssClass="error" /></td>
				</tr>
			</c:if>
		
			<tr>
				<td><form:label path="cusFirstname">
						<spring:message text="Customer Firstname" />
					</form:label></td>
				<td><form:input path="cusFirstname"/></td>
			</tr>
			<tr>
				<td><form:label path="cusLastname">Customer Lastname :</form:label></td>
				<td><form:input path="cusLastname" /></td>
			</tr>
			<tr>
				<td><form:label path="cusEmail">Customer Email :</form:label></td>
				<td><form:input path="cusEmail" /></td>
			</tr>
			<tr>
				<td><form:label path="cusPhoneNo">Customer PhoneNo :</form:label></td>
				<td><form:input path="cusPhoneNo" /></td>
			</tr>
			<tr>
				<td><form:label path="cusCity">Customer Address :</form:label></td>
				<td><form:input path="cusCity" /></td>
			</tr>
			<tr>
				<td><form:label path="cusProvince">Customer Province :</form:label></td>
				<td><form:input path="cusProvince" /></td>
			</tr>
			<tr>
				<td><form:label path="cusCountry">Customer Country :</form:label></td>
				<td><form:input path="cusCountry" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<c:if test="${!empty customer.cusFirstname}">
						<input type="submit" value="<spring:message text="Edit Customer"/>" />
					</c:if> 
					<c:if test="${empty customer.cusFirstname}">
						<input type="submit" value="<spring:message text="Add Customer" />" />
					</c:if>					
				</td>
			</tr>
		</table>
		
		<!-- <input type="submit" value="Submit" /> -->

	</form:form>
	<br>
	<h3>Customers List</h3>
	<c:if test="${!empty listCustomers}">
		<table class="tg">
			<tr>
				<th width="80">Customer ID</th>
				<th width="120">Customer First Name</th>
				<th width="120">Customer Last Name</th>
				<th width="120">Customer Email</th>
				<th width="80">Customer Phone</th>
				<th width="120">Customer City</th>
				<th width="120">Customer Province</th>
				<th width="120">Customer Country</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listCustomers}" var="customer">
				<tr>
					<td>${customer.customerId}</td>
					<td>${customer.cusFirstname}</td>
					<td>${customer.cusLastname}</td>
					<td>${customer.cusEmail}</td>
					<td>${customer.cusPhoneNo}</td>
					<td>${customer.cusCity}</td>
					<td>${customer.cusProvince}</td>
					<td>${customer.cusCountry}</td>
					<td><a href="<c:url value='/customer/edit/${customer.customerId}' />">Edit</a></td>
					<td><a href="<c:url value='/customer/remove/${customer.customerId}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br>
	<a href="<c:url value='/'/>">Main Menu</a>
</body>
</html>