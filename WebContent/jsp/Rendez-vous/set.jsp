<%@page import="com.hopital.utility.Hour"%>
<%@page import="com.hopital.utility.DateUtil"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
<script type="text/javascript">
// function pageLoad()
// {
// var x = document.getElementById("date");
// x.setAttribute("type", "date");
// x.setAttribute("value", "2014-02-09");
// }
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saisie du Rendez-vous</title>
<s:head />
<link href="../../css/bootstrap.min.css" rel="stylesheet">
</head>
<body onload="pageLoad()">


<h1>Bonjour <s:property value="#session.nom"/> </h1>
<s:iterator status="rdv" value="rdvList" >
				
<s:form action="setRDV">
	<s:hidden name="id" value="%{id}"/>
	<s:textfield name="iduser" label="User Name" value="%{iduser}"/>
	<s:property value="heure"  />
	<s:textfield name="idpatient" label="User Patient" value="%{idpatient}" /> 
	<s:textfield name="date" label="Date du Rendez-vous" id="date" value="%{date}" />
	<s:select name="hour"  list="#{'08':'08h','09':'09h','10':'10h','11':'11h','12':'12h','13':'13h','14':'14h','15':'15h','16':'16h','17':'17h'}" 
	value="%{@com.hopital.utility.Hour@getHour(heure)}" label="Heure"  /> 
	<s:select  name="minute" list="#{'00':'00min',15:'15min',30:'30min',45:'45min'}" value="%{@com.hopital.utility.Hour@getMinute(heure)}"  headerKey="" headerValue="00min" />
	<s:select name="duree" list="#{15:'15 min',30:'30 min',45:'45 min',60:'1 heure'}" headerKey=""
		headerValue="15 min" label="Durée" value="%{duree}" />
	<s:submit value="Enregistrer" />
</s:form>
</s:iterator>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../../js/bootstrap.min.js"></script>
</body>
</html>