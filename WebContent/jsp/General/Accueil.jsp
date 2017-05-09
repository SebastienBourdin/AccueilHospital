<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/table.css" rel="stylesheet">

<title>Accueil Hopital</title>
</head>
<body>
	<div class="container ">


		<h1 class="text-center">
			Accueil Hôpital
			<s:property value="#session.nom" />
		</h1>
		<br>
		<br>
		<div class="row">
			<div class="col-xs-12 text-center">
			<s:url namespace="/patient" action="search" var="mod"></s:url>
			 <s:a cssClass="btn btn-info" href="%{mod}"> Rechercher un patient </s:a>
					<s:url namespace="/user" action="search" var="mod"></s:url>
			 <s:a cssClass="btn btn-info" href="%{mod}"> Rechercher un Medecin </s:a>
			 				<s:url namespace="/rdv" action="search" var="mod"></s:url>
			 <s:a cssClass="btn btn-info" href="%{mod}"> Rechercher un Rendez-vous </s:a>
				
			
			</div>
			<div class="col-xs-12 text-center">
					<s:url namespace="/patient" action="new" var="mod"></s:url>
			 <s:a cssClass="btn btn-info" href="%{mod}">Ajouter un patient</s:a>
			 <s:url namespace="/rdv" action="new" var="mod"></s:url>
			 <s:a cssClass="btn btn-info" href="%{mod}">Ajouter un Rendez-vous</s:a>
		
			</div>

			<!-- LISTE PATIENT -->
			<div class="col-xs-6">
				<h2>Liste des patients</h2>
				<div class="well form-horizontal">
					<s:if test="rdvList.size() > 0">
						<div class="content">
							<table class="responstable" cellpadding="5px">
								<thead>
									<tr class="even">
										<th>id</th>
										<th>User id</th>
										<th>Patient id</th>
										<th>Date du rendez-vous</th>
										<th>L'heure du rendez-vous</th>
										<th>La durée du rendez-vous</th>
										<th>Modifier</th>
										<th>Supprimer</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="rdvList">

										<tr>
											<td><s:property value="id" /></td>
											<td><s:property value="iduser" /></td>
											<td><s:property value="idpatient" /></td>
											<td><s:property value="date" /></td>
											<td><s:property value="heure" /></td>
											<td><s:property value="duree" /></td>
											<td><s:url namespace="/rdv" action="listRDV" var="mod">
													<s:param name="id" value="id" />
												</s:url> <s:a href="%{mod}">
													<span class="glyphicon glyphicon-pencil"></span>
												</s:a></td>
											<td><s:url namespace="/rdv" action="delRDV" var="supp">
													<s:param name="id" value="id" />
												</s:url> <s:a href="%{supp}">
													<span class="glyphicon glyphicon-trash"></span>
												</s:a></td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
						</div>
					</s:if>
					<s:else>Aucun Patient n'est encore enregistré</s:else>
				</div>
			</div>


			<!-- LISTE MEDECIN -->
			<div class="col-xs-6">
				<h2>Liste des médecins</h2>


				<div class="well form-horizontal">
					<s:if test="rdvList.size() > 0">
						<div class="content">
							<table class="responstable" cellpadding="5px">
								<thead>
									<tr class="even">
										<th>id</th>
										<th>User id</th>
										<th>Patient id</th>
										<th>Date du rendez-vous</th>
										<th>L'heure du rendez-vous</th>
										<th>La durée du rendez-vous</th>
										<th>Modifier</th>
										<th>Supprimer</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="rdvList">

										<tr>
											<td><s:property value="id" /></td>
											<td><s:property value="iduser" /></td>
											<td><s:property value="idpatient" /></td>
											<td><s:property value="date" /></td>
											<td><s:property value="heure" /></td>
											<td><s:property value="duree" /></td>
											<td><s:url namespace="/rdv" action="listRDV" var="mod">
													<s:param name="id" value="id" />
												</s:url> <s:a href="%{mod}">
													<span class="glyphicon glyphicon-pencil"></span>
												</s:a></td>
											<td><s:url namespace="/rdv" action="delRDV" var="supp">
													<s:param name="id" value="id" />
												</s:url> <s:a href="%{supp}">
													<span class="glyphicon glyphicon-trash"></span>
												</s:a></td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
						</div>
					</s:if>
					<s:else>Aucun Médecin n'est encore enregistré</s:else>
				</div>


			</div>

		</div>
	</div>
	<script src="../js/bootstrap.min.js"></script>

</body>
</html>
