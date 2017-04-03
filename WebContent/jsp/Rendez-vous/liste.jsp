<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des Rendez-vous </title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>Hello <s:property value="#session.nom"/> 


<s:if test="rdvList.size() > 0">
	<div class="content">
	<table class="userTable" cellpadding="5px">
		<tr class="even">
			<th>id</th>
			<th>User id</th>
			<th>Patient id</th>
			<th>Date du rendez-vous</th>
			<th>L'heure du rendez-vous</th>
			<th>La durée du rendez-vous</th>
		</tr>
		<s:iterator value="rdvList" >
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="iduser" /></td>
				<td><s:property value="idpatient" /></td>
				<td><s:property value="date" /></td>
				<td><s:property value="heure" /></td>
				<td><s:property value="duree" /></td>
				<td>
				
				<s:url namespace="/rdv" action="listRDV" var="mod" > 
				<s:param name="id" value="id" /> </s:url>
				<s:a href="%{mod}">Modifier</s:a> 
				
				<s:url namespace="/rdv" action="delRDV" var="supp" > 
				<s:param name="id" value="id" /> </s:url>
				<s:a href="%{supp}">Supprimer</s:a> 
				</td>
			</tr>
		</s:iterator>
	</table>
	</div>
</s:if><s:else>hii</s:else>
</body>
</html>