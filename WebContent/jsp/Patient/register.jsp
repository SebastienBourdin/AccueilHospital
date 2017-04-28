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
<link href="../css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout d'un utilisateur</title>

</head>
<body>
	<div class="container">

		<h1>
			Bonjour
			<s:property value="#session.nom" />
		</h1>

		<s:form action="addPatient" theme="simple"
			cssClass="well form-horizontal">
			<fieldset>

				<legend>Saisie d'un nouvel patient</legend>

				<!-- FIRSTNAME -->
				<div class="form-group">
					<s:label cssClass="col-md-4 control-label" for="firstname"
						value="Prénom" />
					<span><s:property value="vfirstname" /></span>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<s:textfield cssClass="form-control" name="firstname"
								id="firstname" required="true" />
						</div>
					</div>
				</div>

				<!-- LASTNAME -->
				<div class="form-group">
					<s:label cssClass="col-md-4 control-label" for="lastname"
						value="Nom" />
					<span><s:property value="vlastname" /></span>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<s:textfield cssClass="form-control" name="lastname"
								id="lastname" required="true" />
						</div>
					</div>
				</div>


				<!-- BIRTHDATE -->
				<div class="form-group">
					<s:label cssClass="col-md-4 control-label" for="birthdate"
						value="Date de naissance" />
					<span><s:property value="vbirthdate" /></span>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-time"></i></span>
							<s:textfield type="date" cssClass="form-control" name="birthdate"
								id="birthdate" value="01/01/1995" />
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
			</fieldset>
		</s:form>
	</div>

	<script src="../js/bootstrap.min.js"></script>
</body>
</html>