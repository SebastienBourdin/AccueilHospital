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
				<a class="btn btn-info" href="/Accueil_Hopital/patient/search">Rechercher
					un patient</a> <a class="btn btn-info"
					href="/Accueil_Hopital/user/search">Rechercher un Medecin</a> <a
					class="btn btn-info" href="/Accueil_Hopital/rdv/search">Rechercher
					un Rendez-vous</a>
			</div>
			<div class="col-xs-12 text-center">
				<a class="btn btn-info" href="/Accueil_Hopital/patient/new">Ajouter
					un patient</a> <a class="btn btn-info" href="/Accueil_Hopital/rdv/new">Ajouter
					un Rendez-vous</a>
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