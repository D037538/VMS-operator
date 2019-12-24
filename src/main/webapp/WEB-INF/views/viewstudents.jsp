<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="/css/bootstrap.css"      rel="stylesheet">
	<link href="/css/custom.css"      rel="stylesheet">
	<link href="/css/main.css"      rel="stylesheet">
</head>
<body>
<h1 align="center">Visitor List</h1>
<table id="t02"  cellpadding="2">
<tr>
<th>
<a  href="/visitor"><h2>Home Page: New Visitor</h2></a>

</th>

<th>

<a  align ="right" href="/delete"><h2>Delete All Visitor</h2></a>
</th>
</tr>
</table>
<table >
<tr>




</tr>

</table>
   
<form:form  class="form-horizontal" >
<table id="t01" border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>First Name</th><th>Email</th>
<th>Mobile No</th><th>Address</th>
<th>Country</th><th>State</th><th>City</th>
<th>Id Proof</th><th>Contact tPerson Name</th>
<th>Edit</th><th>Delete</th></tr>  

   <c:forEach var="student" items="${list}"> 
   <tr>  
   <td>${student.id}</td>  
   <td>${student.name}</td> 
   <td>${student.email}</td>  
   <td>${student.mobileNo}</td> 
     <td>${student.address}</td> 
   <td>${student.country}</td>  
   <td>${student.state}</td>  
   <td>${student.city}</td>  
   <td>${student.idProof}</td> 
   <td>${student.contactPersonName}</td>  
   <td><a href="/editstudent/${student.id}">Edit</a></td>  
   <td><a href="/deletestudent/${student.id}">Delete</a></td>  
   </tr>  
   </c:forEach> 
   
   
   </table>  
   <br/>
   
  
   </form:form>
</body>
</html>