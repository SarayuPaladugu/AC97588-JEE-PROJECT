<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD DONOR</title>
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
<form:form action="/addDonor" modelAttribute="command"  method="post">
<h1 align="center">Register As DONOR</h1>
<table>
	<tr>
	<td><label for="">DonorID</label></td>
	<td><form:input path="donorId"/>
	<form:errors path="donorId" cssStyle="color:red;"></form:errors></td>
	</tr>
	<tr>
	<td><label for="">DonorName</label></td>
	<td><form:input path="donorName"/>
	<form:errors path="donorName" cssStyle="color:red;"></form:errors></td>
	</tr>
	<tr>
	<td><label for="">Gender </label></td>
	<td><form:radiobutton path = "gender" value = "Female" />Female 
 	<form:radiobutton path = "gender" value = "Male" />Male </td>
	</tr>
	<tr>
	<td><label for="">Age</label></td>
	<td><form:input path="age"/>
	<form:errors path="age" cssStyle="color:red;"></form:errors></td>
	</tr>
	<tr>
	<td><label for="">BloodGroup</label></td>
	<td><form:select path="bloodGroup" items="${bloodgroup}"></form:select></td>
	</tr>
	<tr>
	<td><label for="">LastBloodDonationDate</label></td>
	<td><form:input type="date" path="lastBloodDonationDate"/></td>
	</tr>
	<tr>
	<td><label for="">Email</label></td>
	<td><form:input path="email"></form:input></td>
	</tr>
	<tr>
	<td><label for="">PhoneNumber</label></td>
	<td><form:input path="phoneNumber"/>
	<form:errors path="phoneNumber" cssStyle="color:red;"></form:errors></td>
	</tr>
	<tr>
	<td><label for="">State</label></td>
	<td><form:input path="state"></form:input></td>
	</tr>
	<tr>
	<td><label for="">City</label></td>
	<td><form:input path="city"></form:input></td>
	</tr>
	<tr>
	<td></td>
	<td><input type="submit" value="Register"></td>
	</tr>
	</table>
</form:form>
</div>
</body>
</html>