<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="/css/bootstrap.css"      rel="stylesheet">
	<link href="/css/custom.css"      rel="stylesheet">
	<link href="/css/main.css"      rel="stylesheet">
</head>

<body>

 	<div class="form-container">
 	
 	<h1>Update Status</h1>
 	
	<form:form method="POST" modelAttribute="visitor"  class="form-horizontal" action="/editsave">

 <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="name">First Name</label>
				<div class="col-md-7">
					<form:input type="text" path="name" id="name" class="form-control input-sm"/>
					
				</div>
			</div>
		</div>
		   <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="email">Email</label>
				<div class="col-md-7">
					<form:input type="text" path="email" id="email" class="form-control input-sm"/>
					
				</div>
			</div>
		</div>
		   <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="name">Mobile No.</label>
				<div class="col-md-7">
					<form:input type="text" path="mobileNo" id="mobileNo" class="form-control input-sm"/>
					
				</div>
			</div>
		</div>
		   <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="name">Address</label>
				<div class="col-md-7">
					<form:input type="text" path="address" id="address" class="form-control input-sm"/>
					
				</div>
			</div>
		</div>
		   <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="country">Country</label>
				<div class="col-md-7">
					<form:select path="country" id="country" class="form-control input-sm">
				        <form:option value="">Select Country</form:option>
			    	    <form:options items="${countries}" />
				    </form:select>
					
				</div>
			</div>
		</div>
		   <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="idProof">Id Proof</label>
				<div class="col-md-7">
					<form:input type="text" path="idProof" id="idProof" class="form-control input-sm"/>
					<
				</div>
			</div>
		</div>
		   <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="contactPersonEmail">Contact Person Name</label>
				<div class="col-md-7">
					<form:input type="text" path="contactPersonName" id="contactPersonName" class="form-control input-sm"/>
					
				</div>
			</div>
		</div>
		   <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="contactPersonEmail">Contact Person Email</label>
				<div class="col-md-7">
					<form:input type="text" path="contactPersonEmail" id="contactPersonEmail" class="form-control input-sm"/>
					
				</div>
			</div>
		</div>
		   <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="reference">Reference</label>
				<div class="col-md-7">
					<form:input type="text" path="reference" id="reference" class="form-control input-sm"/>
					
				</div>
			</div>
		</div>
		   <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="reasonForVisit">Reason For Visit</label>
				<div class="col-md-7">
					<form:input type="text" path="reasonForVisit" id="reasonForVisit" class="form-control input-sm"/>
					
				</div>
			</div>
		</div>
		   <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="name">Contact Person Mobile</label>
				<div class="col-md-7">
					<form:input type="text" path="contactPersonMobile" id="contactPersonMobile" class="form-control input-sm"/>
				
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-actions floatRight">
				<input type="submit" value="Edit" class="btn btn-primary btn-sm">
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>