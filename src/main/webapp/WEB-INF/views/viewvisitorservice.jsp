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


</th>

<th>


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
<th>Id Proof</th><th>Contact Person Name</th>
<th>Status</th>
<th>Edit</th><th>Print</th></tr>  

   <c:forEach var="visitor" items="${list}"> 
   <tr>  
   <td>${visitor.id}</td>  
   <td>${visitor.name}</td> 
   <td>${visitor.email}</td>  
   <td>${visitor.mobileNo}</td> 
     <td>${visitor.address}</td> 
     <td>${visitor.idProof}</td> 
   <td>${visitor.contactPersonName}</td>  
   <td>${visitor.status}</td>  
   <td><a href="/editvisitor/${visitor.id}">Update</a></td>  
  
     <td><a href="/printticket/${visitor.id}">Print</a></td>  
   </tr>  
   </c:forEach> 
   
   
   </table>  
   <br/>
   
  
   </form:form>
</body>
</html>