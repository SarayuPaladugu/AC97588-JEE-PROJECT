<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blood Camp</title>
<style>
* {box-sizing: border-box;}

body { 
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.header {
  overflow: hidden;
  background-color: #f1f1f1;
  padding: 20px 10px;
}

.header a {
  float: left;
  color: black;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px; 
  line-height: 25px;
  border-radius: 4px;
}

.header a.logo {
  font-size: 25px;
  font-weight: bold;
}

.header a:hover {
  background-color: dodgerblue;
  color: black;
}

.header a.active {
  background-color: dodgerblue;
  color: white;
}

.header-left {
  float: left;
}

@media screen and (max-width: 500px) {
  .header a {
    float: none;
    display: block;
    text-align: left;
  }
  
}
p {
	font-size: 30px;
	font-style: oblique;
	color: green;
}
table {
border:2px solid red;
margin-left:auto;
margin-right:auto;
border-collapse:collapse;
}
tr,td,th {
border:2px solid red;
}
</style>
</head>
<body>
<div class="header">
<h1 align="center">${majHeading}</h1>
  <div class="header-left">
    <a href="addDonor">RegisterationForDonor</a>
<a href="getAllDonors">ListOfDonors</a>
<a href="registerCamp">RegisterationForCamp</a>
<a href="getAllCampDetails">CampDetails</a>
</div>
</div>
<br>
<br>
<table>
<tr>
<th>SEARCH BY BLOODGROUP</th>
<th>UNREGISTER</th>
<th>SEARCH BY CITY</th>
<th>SEARCH CAMPS BY DATE</th>
<th>UPDATE LAST BLOOD DONATEDDATE</th>
</tr>
<tr>
<td>
<form action="/getBloodGroup">
<a>
<label>Enter BloodGroup : </label>
<input type="text" name="searchbybloodgroup">
<br>
<input type="submit" value="SearchByBloodGroup">
</a>
</form>
</td>
<td>
<form action="/unregister" >
<label for="">Enter DonorId : </label>
<input type="text" name="value">
<br>
<input type="submit" value="Unregister">
</form>
</td>
<td>
<form action="/getByCity">
<a>
<label>Enter City : </label>
<input type="text" name="searchbycity">
<br>
<input type="submit" value="SearchByCity">
</a>
</form>
</td>
<td>
<form action="/getByDate">
<a>
<label>Enter Date : </label>
<input type="date" name="searchbyDate">
<br>
<input type="submit" value="SearchCamps">
</a>
</form>
</td>
<td>
<form action="/updateById">
<a>
<label>Enter DonorId   : </label>
<input type="text" name="id">
<br>
<label>Update DonationDate : </label>
<input type="date" name="updateDate">
<br>
<input type="submit" value="Update">
</a>
</form>
</td>
</tr>
</table>
<br>
<br>
<br>
<br>
<div>
<p align="center">"DONATE THE BLOOD & SAVE LIFE OF PEOPLE"</p>
</div>
</body>
</html>