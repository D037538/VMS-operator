<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Visitor Form</title>
	<link href="css/bootstrap.css"      rel="stylesheet">
	<link href="css/custom.css"      rel="stylesheet">
	<link href="css/main.css"      rel="stylesheet">
</head>
<body>
        
    <form:form modelAttribute="student"  action="save">
       
        <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="name">First Name</label>
				<div class="col-md-7">
					<form:input type="text" path="name" id="name" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="name" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		   <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="email">Email</label>
				<div class="col-md-7">
					<form:input type="text" path="email" id="email" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="email" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		   <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="name">Mobile No.</label>
				<div class="col-md-7">
					<form:input type="text" path="mobileNo" id="mobileNo" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="mobileNo" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		   <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="name">Address</label>
				<div class="col-md-7">
					<form:input type="text" path="address" id="address" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="address" class="help-inline"/>
					</div>
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
					<div class="has-error">
						<form:errors path="country" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		   <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="idProof">Id Proof</label>
				<div class="col-md-7">
					<form:input type="text" path="idProof" id="idProof" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="idProof" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		   <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="contactPersonEmail">Contact Person Email</label>
				<div class="col-md-7">
					<form:input type="text" path="contactPersonEmail" id="contactPersonEmail" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="contactPersonEmail" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		   <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="reference">Reference</label>
				<div class="col-md-7">
					<form:input type="text" path="reference" id="reference" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="reference" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		   <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="reasonForVisit">Reason For Visit</label>
				<div class="col-md-7">
					<form:input type="text" path="reasonForVisit" id="reasonForVisit" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="reasonForVisit" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		   <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="name">Contact Person Mobile</label>
				<div class="col-md-7">
					<form:input type="text" path="contactPersonMobile" id="contactPersonMobile" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="contactPersonMobile" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		   
		<div class="row">
			<div class="form-actions floatRight">
				<input type="submit" value="Register" class="btn btn-primary btn-sm">
			</div>
		</div>
    </form:form>
</body>
</html>
