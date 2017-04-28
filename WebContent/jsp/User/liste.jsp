<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/table.css" rel="stylesheet">

<title>Liste des Utilisateurs </title>
</head>
<body>
<div class="container ">

<h1 >Bonjour <s:property value="#session.nom"/></h1> 
<H2>Liste des Utilisateurs </H2>
<div class="well form-horizontal">

<!-- si un utilisateur est inscrit sur la base de donnée on l'affiche -->

<s:if test="userList.size() > 0">
	<div class="content">
	<table class="responstable table">
	<thead>
		<tr class="even">
			<th>id</th>
			<th>Date de naissance</th>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Type d'utilisateur</th>
			<th>Modifier</th>
			<th>Supprimer</th>
		</tr>
		</thead>
		<tbody>
		<s:iterator value="userList" >
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="birthdate" /></td>
				<td><s:property value="firstname" /></td>
				<td><s:property value="lastname" /></td>
				<td><s:property value="type" /></td>
				<td>
				<s:url namespace="/user" action="listuser" var="mod" > 
				<s:param name="id" value="id" /> </s:url>
				<s:a href="%{mod}"><span class="glyphicon glyphicon-pencil"></span></s:a> 
				</td>
				<td>
				<s:url namespace="/user" action="deluser" var="supp" > 
				<s:param name="id" value="id" /> </s:url>
				<s:a href="%{supp}"><span class="glyphicon glyphicon-trash"></span></s:a> 
				</td>
			</tr>
		</s:iterator></tbody>
	</table>
	</div>
</s:if>
<!-- Pas d'utilisateur -->
<s:else>Il n'y a pas d'utilisateur inscrit pour le moment!!</s:else>

</div>
</div>
<script src="../js/bootstrap.min.js"></script>

</body>
</html>