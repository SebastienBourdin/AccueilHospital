<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saisie du Rendez-vous</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>Bonjour <s:property value="#session.nom"/> 
<s:form action="addRDV">
	<s:textfield name="iduser" label="User Name" />
	<s:textfield name="idpatient" label="User Patient" /> 
	<s:textfield name="date" label="Date du Rendez-vous"/>
	<s:textfield name="Heure" label="Heure du Rendez-vous"/>
	<s:select name="duree" list="{'30 min','45 min','1 heure'}" headerKey=""
		headerValue="15 min" label="Durée" />
	<s:submit value="Enregistrer" />
</s:form>

</body>
</html>