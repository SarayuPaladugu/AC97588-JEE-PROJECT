<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RegistrationForCamp</title>
<style type="text/css">
table {
border:2px solid blue;
margin-left:auto;
margin-right:auto;
border-collapse:collapse;
}
tr,td,th {
border:2px solid blue;
}
</style>
</head>
<body>
<div>
<form:form action="/registerCamp" modelAttribute="command"  method="post">
<h1 align="center">REGISTER FOR CAMP</h1>
<table>
	<tr>
	<td><label for="">DonorID</label></td>
	<td><form:input path="donorId"/>
	<form:errors path="donorId" cssStyle="color:red;"></form:errors></td>
	</tr>
	<tr>
	<td><label for="">City</label></td>
	<td><form:input path="city"></form:input></td>
	</tr>
	<tr>
	<td><label for="">PhoneNumber</label></td>
	<td><form:input path="phoneNumber"/>
	</tr>
	<tr>
	<td><label for="">CampDate</label></td>
	<td><form:input type="date" path="campDate"/></td>
	</tr>
	<tr>
	<td></td>
	<td><input type="submit" value="Register For Camp"></td>
	</tr>
	</table>
</form:form>
</div>
</body>
</html>