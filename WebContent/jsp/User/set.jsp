<%@page import="com.hopital.utility.Hour"%>
<%@page import="com.hopital.utility.DateUtil"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<script type="text/javascript">
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification d'un utilisateur</title>

<link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1>
			Bonjour
			<s:property value="#session.nom" />
		</h1>

		<s:form action="setUser" theme="simple"
			cssClass="well form-horizontal">
			<fieldset>
				<s:hidden name="id" value="%{id}" />
				<legend>Modification d'un utilisateur</legend>
				<s:iterator status="user" value="userList">

					<div class="form-group">
						<s:label cssClass="col-md-4 control-label" for="firstname"
							value="Prénom" />
						<span><s:property value="vfirstname" /></span>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<s:textfield cssClass="form-control" name="firstname"
									id="firstname" value="%{firstname}" />
							</div>
						</div>
					</div>


					<div class="form-group">
						<s:label cssClass="col-md-4 control-label" for="lastname"
							value="Nom" />
						<span><s:property value="vlastname" /></span>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<s:textfield cssClass="form-control" name="lastname"
									id="lastname" value="%{lastname}" />
							</div>
						</div>
					</div>

					<!-- PASSWORD -->
					<div class="form-group">
						<s:label cssClass="col-md-4 control-label" for="password"
							value="Mot de passe" />
						<span><s:property value="vpassword" /></span>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<s:textfield cssClass="form-control" name="password"
									id="password" value="%{password}" required="true" />
							</div>
						</div>
					</div>


					<div class="form-group">
						<s:label cssClass="col-md-4 control-label" for="birthdate"
							value="Date de naissance" />
						<span><s:property value="vbirthdate" /></span>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-time"></i></span>
								<s:textfield cssClass="form-control" name="birthdate"
									id="birthdatedate"
									value="%{@com.hopital.utility.DateUtil@getDateS(birthdate)}" />
							</div>
						</div>
					</div>


					<div class="form-group">
						<s:label cssClass="col-md-4 control-label" for="type"
							value="Type d'utilisateur" />
						<span><s:property value="vtype" /></span>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<s:select cssClass="form-control" name="type"
									list="#{'medecin':'Medecin','secretaire':'Secrétaire'}"
									value="%{type}" id="type" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<s:label cssClass="col-md-4 control-label" for="admin"
							value="Admin" />
						<span><s:property value="vadmin" /></span>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<s:checkbox name="admin" value="%{admin}" label="Admin ?" />
							</div>
						</div>
					</div>

					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label"></label>
						<div class="col-md-4">
							<s:submit cssClass="btn btn-primary" value="Enregistrer" />
						</div>
					</div>
				</s:iterator>
			</fieldset>
		</s:form>
	</div>



	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>