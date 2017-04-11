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
function pageLoad()
{
var x = document.getElementById("date");
x.setAttribute("type", "date");
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification d'un rendez-vous</title>

<link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body onload="pageLoad()">
<div class="container">


<h1 >Bonjour <s:property value="#session.nom"/></h1> 
 
<s:form action="setRDV" theme="simple" cssClass="well form-horizontal">
<fieldset>

	<s:hidden name="id" value="%{id}"/>
<legend >Modification d'un rendez-vous</legend> 
<s:iterator status="rdv" value="rdvList" >
<div class="form-group">
<s:label cssClass="col-md-4 control-label" for="iduser" value="Id user"/>

<span><s:property value="viduser"/></span>
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
	<s:textfield  cssClass="form-control" name="iduser" id="iduser" value="%{iduser}" required="true"/>
    </div>
  </div>
</div>

<div class="form-group">


<s:label cssClass="col-md-4 control-label" for="idpatient" value="Id Patient"/>

<span><s:property value="vidpatient"/></span>
     
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
	<s:textfield cssClass="form-control" name="idpatient" id="idpatient" value="%{idpatient}" />
    </div>
  </div>
</div>

<div class="form-group">
<s:label cssClass="col-md-4 control-label" for="date" value="Date du rendez-vous"/>

<span><s:property value="vdate"/></span>
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
	<s:textfield cssClass="form-control" name="daterdv" id="date" value="%{@com.hopital.utility.DateUtil@getDateS(date)}" />
    </div>
  </div>
</div>	

<div class="form-group">
<s:label cssClass="col-md-4 control-label" for="heure" value="L'heure du rendez-vous"/>

<span><s:property value="vheure"/></span>
  <div class="col-md-4 inputGroupContainer ">
  <div class="input-group">
  <span class="input-group-addon" style="border: 1px solid #ccc; border-radius:4px;"><i class="glyphicon glyphicon-time"></i></span>
	<div class="col-sm-6">
		<s:select cssClass="form-control "  name="hour"  list="#{'08':'08h','09':'09h','10':'10h','11':'11h','12':'12h','13':'13h','14':'14h','15':'15h','16':'16h','17':'17h'}" value="%{@com.hopital.utility.Hour@getHour(heure)}" id="heure"  /> 
	</div>
	<div class="col-sm-6">
		<s:select   cssClass="form-control " name="minute" list="#{'00':'00min',15:'15min',30:'30min',45:'45min'}" value="%{@com.hopital.utility.Hour@getMinute(heure)}" />
	</div>
    </div>
  </div>
</div>	

 <div class="form-group">
<s:label cssClass="col-md-4 control-label" for="duree" value="La durée"/>

<span><s:property value="vduree"/></span>
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon" style="border: 1px solid #ccc; border-radius:4px;"><i class="glyphicon glyphicon-time"></i></span> 
	<s:select cssClass="form-control" name="duree" list="#{15:'15 min',30:'30 min',45:'45 min',60:'1 heure'}" value="%{duree}"  id="duree" />
	
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/bootstrap.min.js"></script>
</body>
</html>